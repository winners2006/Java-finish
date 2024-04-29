import java.util.*;

class Contact {
    private String name;
    private TreeSet<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public TreeSet<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Numbers: " + phoneNumbers;
    }
}