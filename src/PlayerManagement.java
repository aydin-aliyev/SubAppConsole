import java.sql.Connection;
import java.util.*;

public class PlayerManagement <T> extends InHouse implements showMenuItems, Line{
    T answer;
    Stack<Player> playerList = new Stack<>();
    Scanner scanner = new Scanner(System.in);

    // MENU
    @Override
    public void showMenuItems() {
        line();
        System.out.println("| MENU |");
        System.out.println("1. Add player");
        System.out.println("2. Delete player");
        System.out.println("3. Show players");
        System.out.println("4. Exit");
        System.out.print("Choose the category: ");
        int answer = scanner.nextInt();
        scanner.nextLine();
        line();


        switch (answer){
            case 1:
                addPlayer();
            case 2:
                deletePlayer();
            case 3:
                showPlayers();
                break;
            default:
                System.out.println("Wrong");
        }
    }



    // SHOW PLAYERS
    void showPlayers(){

        System.out.println("| PLAYERS LIST |");

        //Collection - Iterator Interface
        Iterator<Player> playerIterator = playerList.iterator();
        while(playerIterator.hasNext()){
            Player player = playerIterator.next();
            System.out.println(player);
        }
    }


    //ADD PLAYER
    void addPlayer() {

        while (true) {
            System.out.println("| ADD PLAYER |");

            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastname = scanner.nextLine();

            System.out.print("Belt: ");
            String belt = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // очищение буфера после nextInt


            playerList.push(new Player(id, name, lastname, age, belt));
            System.out.println("Player was added");


            System.out.print("Do you want to add player (y/N)? ");
            String answer = scanner.nextLine();


            switch (answer) {
                case "y":
                    break;
                case "N":
                    System.out.println("Exiting...");
                    showMenuItems();
                default:
                    System.out.println("Wrong");
            }
        }
    }



    // DELETE PLAYER - Stack (LIFO)
    void deletePlayer(){
        int intAnswer;
        String strAnswer;

        System.out.println("| DELETE PLAYER |");

        while(true){
            System.out.print("Do you want to delete a player? (y/N)");
            strAnswer = scanner.nextLine();

            // 1st SWITCH
            switch (strAnswer){
                case "y":
                    System.out.println("1. Search player");
                    System.out.println("2. Delete last value");
                    System.out.print("Choose category: ");
                    intAnswer = scanner.nextInt();


                    // 2nd SWITCH
                    switch(intAnswer){
                        case 1:
                            System.out.print("Search Player by Name: ");
                            String searchName = scanner.nextLine();
                            playerList.search(searchName);

                        case 2:

                            showMenuItems();
                        default:
                            System.out.println("Wrong");
                    }
                    break;
                case "N":
                    showMenuItems();
                default:
                    System.out.println("Error");

            }
        }
    }

    void searchPlayer(){
        showPlayers();

        System.out.print("Search by Name: ");
        String searchByName = scanner.nextLine();
        playerList.search(searchByName);
    }
}