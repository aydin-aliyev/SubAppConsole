package dao;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//отдельныц класс для connection
public class DatabaseConnection {
    //заранее присваиваем шаблонные значения, чтобы постоянно не писать каждый раз
    // ❓static и final что означает?
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "sub";


    // ❓внутри класса мы не можем выполнять try и catch почему?
    public static Connection getConnection(){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            
            // взаимодействие с базой происходит с помощью Statement
            Statement statement = connection.createStatement();

        }
        catch(SQLException e){
            System.out.println("Connection failed");
        }
        return getConnection();
    }


}
