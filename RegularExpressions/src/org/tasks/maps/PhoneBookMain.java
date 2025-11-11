package org.tasks.maps;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookMain {
    public static void main(String[] args) {
        HashMap<Integer, PhoneBook> PhoneBookMap = new HashMap<>();

        String inputText = null;
        int idCounter = 1;
        Scanner scanner = new Scanner(System.in);

        boolean endOfProgramm = true;
        while(endOfProgramm) {


            int validate = 5;
            while (validate > 0) {
                System.out.println("Введите номер, имя или команду: ");
                inputText = scanner.nextLine().trim();


                String regexPhone = "^(?<list>LIST)|(?<end>END)|(?<phone>((8|\\+7|7)?[\\-]?)(\\(?9\\d{2}\\)?[\\-]?)[\\d\\-]{7,10})|(?<name>[A-Za-z]+[-']?[A-Za-z]*)$";

                Pattern pattern = Pattern.compile(regexPhone, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(inputText);


                if (matcher.matches()) {
                    String phone = matcher.group("phone");
                    String list = matcher.group("list");
                    String end = matcher.group("end");
                    String name = matcher.group("name");

                    boolean found = false;
                    boolean isPhone;
                    if (matcher.group("phone") != null) {
                        isPhone = true;
                    } else isPhone = false;
                    //Вывод полного списка контактов
                    if (list != null) {
                        System.out.println("Все контакты:");
                        for (PhoneBook contact : PhoneBookMap.values()) {
                            System.out.println(contact);
                        }
                    }
                    //Выход из программы
                    else if (end != null) {
                        System.out.println("Выходим из программы");
                        endOfProgramm = false;
                        break;
                    }
                    //Поиск по имени или телефону

                    for (PhoneBook contact : PhoneBookMap.values()) {
                        if (contact.getName().equalsIgnoreCase(name)) {
                            System.out.println("Найден контакт: " + contact);
                            found = true;
                            break;
                        } else if (contact.getPhone().equals(phone)) {
                            System.out.println("Этот номер принадлежит: " + contact.getName());
                            found = true;
                            break;
                        }
                    }

                    if (!found && list == null && end == null) {
                        // Новый контакт
                        if (isPhone) {
                            System.out.println("Новый номер. Введите имя для " + inputText + ": ");
                            String nameContact = scanner.nextLine().trim();
                            PhoneBook newContact = new PhoneBook(idCounter++, nameContact, inputText);
                            PhoneBookMap.put(newContact.getId(), newContact);
                            System.out.println("Сохранено: " + newContact);
                        } else {
                            System.out.println("Новое имя. Введите телефон для " + inputText + ": ");
                            String phoneContact = scanner.nextLine().trim();
                            PhoneBook newContact = new PhoneBook(idCounter++, inputText, phoneContact);
                            PhoneBookMap.put(newContact.getId(), newContact);
                            System.out.println("Сохранено: " + newContact);
                        }
                    }

                    /*else if (name != null) {
                        if (!PhoneBookMap.containsValue(name)) {
                            System.out.println("Такого имени в телефонной книге нет");
                            PhoneBookMap.put(name, new PhoneBook(name, phone));
                        }
                    } else if (phone != null) {
                        //s
                    }*/

                } else {
                    validate--;
                    System.out.println("Неверный формат ввода");
                }
                if (validate == 0) System.out.println("Попытки исчерпаны");
            }
        }
    }
}
