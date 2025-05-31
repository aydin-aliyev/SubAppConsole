package model;
import dao.DatabaseConnection;
import dao.impl.playerDAOImpl;

import model.InHouse;
import model.Line;
import model.Player;
import model.showMenuItems;

import java.util.*;

public class PlayerManagement extends InHouse implements showMenuItems, Line {
    String answer;
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


        switch (answer) {
            case 1:
                addPlayer();
                break;
            case 2:
                deletePlayer();
                break;
            case 3:
                showPlayers();
                break;
            default:
                System.out.println("Wrong");
        }
    }




    // SHOW PLAYERS
    void showPlayers(){

        playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());
        System.out.println("| PLAYERS LIST |");
        playerDAO.findAll();
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


            playerList.push(new Player(name, lastname, belt, age));
            System.out.println("Player was added");



            System.out.print("Do you want to add player (y/N)? ");
            String answer = scanner.nextLine();


            switch (answer) {
                case "y":
                    break;
                case "N":
                    System.out.println("Exiting...");
                    showMenuItems();
                    return;
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
                    // STACK SEARCH
                    switch(intAnswer){
                        case 1:
                            showPlayers();
                            System.out.print("Search by Name: ");
                            var searchByName = scanner.nextLine();
                            int search = playerList.search(searchByName);
                            playerList.remove(search);

                            break;

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
        int search = playerList.search(searchByName);
        System.out.println(search);
    }
}