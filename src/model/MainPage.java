package model;
import dao.impl.playerDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class MainPage implements Line, Welcome{
    @Override
    public void welcome() {
        System.out.println("WELCOME TO SUBMACHINE");
    }

    // MAIN
    public static void main(String[] args) {
        Welcome welcome = new MainPage();
        welcome.welcome();

        //полиморфизм
        Line line = new MainPage();
        line.line();


        //Показать категории
        Menu menu = new Menu();
        menu.showMenuItems();
        menu.chooseCategory();
    }

}


interface Line{

    default void line(){
        System.out.println("*********************");
        System.out.println();
    }
}

interface Welcome{
    public void welcome();
}
