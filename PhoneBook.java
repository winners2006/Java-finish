import java.util.*;

public class PhoneBook {
    private HashMap<String, Contact> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (name == null || name.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println("Неверный ввод. Имя и номер телефона не должны быть пустыми.");
            return;
        }

        if (!phoneNumber.matches("\\d+")) {
            System.out.println("Неверный формат телефонного номера. Номер телефона должен содержать только цифры.");
            return;
        }

        Contact contact = contacts.get(name);
        if (contact == null) {
            contact = new Contact(name);
            contacts.put(name, contact);
        }
        contact.addPhoneNumber(phoneNumber);
    }

    public Contact getContact(String name) {
        return contacts.get(name);
    }

    public List<Contact> getAllContactsSortedByPhoneNumbers() {
        List<Contact> sortedContacts = new ArrayList<>(contacts.values());
        sortedContacts.sort((a, b) -> Integer.compare(b.getPhoneNumbers().size(), a.getPhoneNumbers().size()));
        return sortedContacts;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("John", "123456789");
        phoneBook.addContact("John", "987654321");
        phoneBook.addContact("Alice", "111222333");
        phoneBook.addContact("Bob", "999888777");
        phoneBook.addContact("Bob", "777888999");
        
        phoneBook.addContact("", "123456789"); 
        phoneBook.addContact("Mary", "");       
        phoneBook.addContact("Dave", "12a34");  

        System.out.println("Контакты отсортированы по количеству телефонных номеров:");
        List<Contact> sortedContacts = phoneBook.getAllContactsSortedByPhoneNumbers();
        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }
}