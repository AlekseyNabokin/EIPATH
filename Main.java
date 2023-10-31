import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите данные в формате 'Фамилия Имя Отчество ДатаРождения НомерТелефона Пол': ");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.err.println("Неверное количество данных");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String dob = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            String fileName = surname + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);

            String record = surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n";
            fileWriter.write(record);

            fileWriter.close();
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты рождения");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}