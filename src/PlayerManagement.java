import java.util.*;

public class PlayerManagement extends InHouse{
    List<Player> playerList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    void showPlayers(){

        // Iterator interface
        Iterator<Player> playerIterator = playerList.iterator();
        while(playerIterator.hasNext()){
            System.out.println(playerIterator);

        }
    }

    void addPlayer() {
        System.out.println("add player:");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Last Name: ");
        String lastname = scanner.nextLine();

        System.out.println("Belt: ");
        String belt = scanner.nextLine();

        System.out.println("Age: ");
        int age = scanner.nextInt();


        playerList.add(new Player(name, lastname, age, belt));
        System.out.println("Player was added");
        System.out.println("Heey");


    }


}