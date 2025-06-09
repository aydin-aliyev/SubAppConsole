package model;
import dao.DatabaseConnection;
import dao.impl.playerDAOImpl;

import model.InHouse;
import model.Line;
import model.Player;
import model.showMenuItems;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PlayerManagement extends InHouse implements showMenuItems, Line, menuCRUD {

    Player player;
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
        //Connection
        playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());

        System.out.println("| PLAYERS LIST |");

        //DAO call
        playerDAO.findAll();

        // return MENU
        line();
        menuCRUD();
    }




    //ADD PLAYER
    public void addPlayer() {


        while (true) {
            System.out.println("| ADD PLAYER |");
            playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());


            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastname = scanner.nextLine();

            System.out.print("Belt: ");
            String belt = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // очищение буфера после nextInt


//            playerList.push(new Player(name, lastname, belt, age));
//            System.out.println("Player was added");
        try{
            Player newPLayer = new Player(name, lastname, belt, age);
            playerDAO.save(newPLayer);
//            playerList.add(newPLayer); Логика неправильная, добавляешь в лист который еще не существует


        }
        catch (SQLException e){
            System.out.println("Failed");
        }


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
        Connection connection;

        String yN;
        int intAnswer;


        System.out.println("| DELETE PLAYER |");


        while (true){
            System.out.println("Which player do you want to DELETE?");
            System.out.print("ID of player: ");
            intAnswer = scanner.nextInt();
            scanner.nextLine();


            try{
                playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());

                // boolean to check
                boolean deleted = playerDAO.deleteById(intAnswer);

                if (deleted) {
                    System.out.println("Player with ID " + intAnswer + " was successfully deleted!");
                } else {
                    System.out.println("No player found with ID " + intAnswer + ".");
                }


            }catch (SQLException e){
                System.out.println("Error");
            }
            //LOOP for delete
            System.out.println("Do you want to delete a player? (y/N)");
            yN = scanner.nextLine();
            switch (yN){
                case "y":
                    System.out.print("ID of player: ");
                    intAnswer = scanner.nextInt();
                    scanner.nextLine();
                case "N":
                    // interface - show menu
                   menuCRUD();

            }
        }
    }

<<<<<<< Updated upstream
=======

    // UPDATE CLASS
    public UpdateClass updatePlayer() {
        UpdateClass updateClass = new UpdateClass();

        //Get Connection
        playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());

        // CONSOLE MESSAGE
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to update player? (y/N)");
        answer = scanner.nextLine();
        // CHOOSE
        switch (answer) {
            case "y":
                System.out.print("Type the column: ");
                //updateClass.columnValue = scanner.nextLine();
                //Этот вариант хороший елси не сработает с конструктором
                updateClass.setColumnValue(scanner.nextLine());

                System.out.print("Type the value which you want to set: ");
                //updateClass.value = scanner.nextLine();
                updateClass.setValue(scanner.nextLine());

                System.out.print("Type the id: ");
                //updateClass.id = scanner.nextInt();
                updateClass.setId(scanner.nextInt());
                scanner.nextLine();

                //обновление значений
                try{
                    UpdateClass newUpdate = new UpdateClass(updateClass.getColumnValue(), updateClass.getValue(), updateClass.getId());
                    playerDAO.update(newUpdate);
                }catch (SQLException e){
                    System.out.println(e);
                }

            case "N":
                System.out.println("Exiting...");
                showMenuItems();
                break;
            default:
                System.out.print("Do you want to update player? (y/N)");



        }
        // Передать в PlayerDAO
         return updateClass;


    }












//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Do you want to update a player? (y/N)");
//        String strAnswer = scanner.nextLine();
//        switch (strAnswer){
//            case "y":
//                playerDAOImpl playerDAO = new playerDAOImpl(DatabaseConnection.getConnection());
//                System.out.print("Write a column name: ");
//                updateClass.colValue = scanner.nextLine();
//                System.out.print("Set a value: ");
//                updateClass.valValue = scanner.nextLine();
//                System.out.print("Choose ID: ");
//                updateClass.idVal = scanner.nextInt();
//
//
//            case "N":
//            default:
//        }



>>>>>>> Stashed changes
    void searchPlayer(){
        showPlayers();

        System.out.print("Search by Name: ");
        String searchByName = scanner.nextLine();
        int search = playerList.search(searchByName);
        System.out.println(search);
    }
}

interface menuCRUD extends Line{
    Scanner scanner = new Scanner(System.in);
    PlayerManagement pm = new PlayerManagement();
    default void menuCRUD(){

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
                pm.addPlayer();
                break;
            case 2:
                pm.deletePlayer();
                break;
            case 3:
                pm.showPlayers();
                break;
            default:
                System.out.println("Wrong");
        }
    }
}