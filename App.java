import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.io.*;

public class App {
    private static LocalDate date_birthday;
    private static final String pattern = "dd/MM/uuuu";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО в формате: \"Фамилия Имя Отчество\"");
        String fio = scanner.nextLine();

        System.out.println("Введите дату рождения в формате: \"дд.мм.гггг\"");
        String date = scanner.nextLine().replace('.', '/');

        try {
            Person person = App.parseData(fio, date);
            person.defineAge();
            person.defineSex();

            person.printInfo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Person parseData(String fio, String date) {

        String[] namePerson = fio.split(" ");
        if (namePerson.length < 3 | namePerson.length > 4) {
            System.out.println("Неправильные введеные данные: ФИО");
        }
        boolean result = fio.matches("[a-zA-Z]+");
        if(result == true)
        {
            System.out.println("При вводе необходимо использовать только буквы");
        }

        /*Integer day = Integer.parseInt(birthdayPerson[0]);
        Integer month = Integer.parseInt(birthdayPerson[1]);
        Integer year = Integer.parseInt(birthdayPerson[2]);

        if (day < 1 | day > 31 | month < 1 | month > 12) {
            throw new Exception("Неправильные введеные данные: дата рождения!");
        }


        LocalDate date_birthday = LocalDate.of(year, month, day);


        if (LocalDate.now()- date_birthday.get < 0) {
            throw new Exception("Неправильные введеные данные: дата рождения!");
        }*/
        try {
            date_birthday = LocalDate.parse(date, DateTimeFormatter
                    .ofPattern(pattern)
                    .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            System.out.println("Введена неверная дата");
        }



        return new Person(namePerson[1], namePerson[2], namePerson[0], date_birthday);
    }
}
