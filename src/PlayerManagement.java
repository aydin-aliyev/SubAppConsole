import java.sql.Connection;
import java.util.*;

public class PlayerManagement extends InHouse{
    List<Player> playerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    void showPlayers(){

        System.out.print("Do you want to show player list(y/N)? ");
        String answer1  = scanner.nextLine();

        switch (answer1){
            case "y":
                Iterator<Player> playerIterator = playerList.iterator();
                while(playerIterator.hasNext()){
                    Player player = playerIterator.next();
                    System.out.println(player);
                }
                break;
            case "N":
                System.out.println("Exiting");
                return;
            default:
                System.out.println("Wrong");
        }
    }

    void addPlayer() {

        while (true) {
            System.out.println("-add player-");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastname = scanner.nextLine();

            System.out.print("Belt: ");
            String belt = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // очищение буфера после nextInt


            playerList.add(new Player(name, lastname, age, belt));
            System.out.println("Player was added");


            System.out.print("Do you want to add player (y/N)? ");
            String answer = scanner.nextLine();
            System.out.println("-----------------------------------");


            switch (answer) {
                case "y":
                    break;
                case "N":
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Wrong");
            }
        }
    }

}