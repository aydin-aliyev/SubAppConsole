import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TrainingJournal {
    String date;
    String topic;


    public TrainingJournal(String date, String topic) {
        this.date = date;
        this.topic = topic;
    }



    void showTopic(){

    }
    void addTopic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату: ");
        String date = scanner.nextLine();

        System.out.print("Введите тему занятия: ");
        String topic = scanner.nextLine();

        System.out.println("Добавлена тема: '" + topic + "' на дату: " + date);

        List<TrainingJournal> list = new ArrayList<>();


    }
}


