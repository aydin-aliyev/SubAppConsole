import java.util.Scanner;

public class InHouse implements showMenuItems{
    @Override
    public void showMenuItems() {
        System.out.println("1. Announcement");
        System.out.println("2. Grappling session");
        System.out.println("3. Player Management");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                break;

            case 2:
                GrapplingSession grapplingSession = new GrapplingSession();
                break;

            case 3:
                PlayerManagement playerManagement = new PlayerManagement();
                playerManagement.addPlayer();
                break;

            default:
                System.out.println("Неправильно");
        }
    }
}




