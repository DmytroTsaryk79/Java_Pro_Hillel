package hw.hw11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(new Record("John", "123-456-7890"));
        phonebook.add(new Record("Alice", "987-654-3210"));
        phonebook.add(new Record("John", "555-555-5555"));

        Record foundRecord = phonebook.find("John");
        if (foundRecord != null) {
            System.out.println("Знайдено запис: " + foundRecord.getName() + ", Телефон: " + foundRecord.getPhoneNumber());
        } else {
            System.out.println("Запис не знайдено.");
        }

          List<Record> foundRecords = phonebook.findAll("John");
        if (foundRecords != null) {
            System.out.println("Знайдено записів: " + foundRecords.size());
            for (Record record : foundRecords) {
                System.out.println("Ім'я: " + record.getName() + ", Телефон: " + record.getPhoneNumber());
            }
        } else {
            System.out.println("Записів не знайдено.");
        }
    }
}