import java.util.Scanner;

public class Menu implements showMenuItems{
    public void showMenuItems(){
        System.out.println("Меню");
        System.out.print("1.Team🤼 | ");
        System.out.print("2.Schedule⌚ | ");
        System.out.print("3.News📰 | ");
        System.out.println("4.InHouse🛖");


    }

    void chooseCategory(){

        System.out.println("Выбери категорию: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                Team team = new Team();
                team.showMenuItems();
                break;

            case 2:
                Schedule schedule = new Schedule();
                schedule.schedule();
                break;

            case 3:
                break;

            case 4:
                InHouse inHouse = new InHouse();
                inHouse.showMenuItems();
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }
}

interface showMenuItems{
    void showMenuItems();
}
