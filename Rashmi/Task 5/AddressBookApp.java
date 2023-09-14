import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress + "\n";
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public List<Contact> searchContact(String keyword) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(contact);
            }
        }
        return results;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email Address: ");
                    String emailAddress = scanner.nextLine();

                    if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
                        Contact newContact = new Contact(name, phoneNumber, emailAddress);
                        addressBook.addContact(newContact);
                        System.out.println("Contact added successfully!\n");
                    } else {
                        System.out.println("All fields are required. Contact not added.\n");
                    }
                    break;

                case 2:
                    // Remove Contact
                    System.out.print("Enter Name to Remove: ");
                    String nameToRemove = scanner.nextLine();
                    addressBook.removeContact(nameToRemove);
                    System.out.println("Contact removed successfully!\n");
                    break;

                case 3:
                    // Search Contact
                    System.out.print("Enter Search Keyword: ");
                    String searchKeyword = scanner.nextLine();
                    List<Contact> searchResults = addressBook.searchContact(searchKeyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No contacts found.\n");
                    } else {
                        System.out.println("Search Results:");
                        for (Contact result : searchResults) {
                            System.out.println(result);
                        }
                    }
                    break;

                case 4:
                    // Display All Contacts
                    List<Contact> allContacts = addressBook.getAllContacts();
                    if (allContacts.isEmpty()) {
                        System.out.println("No contacts in the address book.\n");
                    } else {
                        System.out.println("All Contacts:");
                        for (Contact contact : allContacts) {
                            System.out.println(contact);
                        }
                    }
                    break;

                case 5:
                    // Exit the application
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}