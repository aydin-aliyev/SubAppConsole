package dao.impl;

import dao.DatabaseConnection;
import dao.playerDAO;
import model.Player;

import java.awt.dnd.DropTarget;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class playerDAOImpl implements playerDAO {
    Connection connection;
//конструктор с Connection чтобы
    public playerDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Player> findAll() {
        //sql запрос
        String query = "SELECT * FROM players";

        //создаём лист чтобы добавлять туда данные а потом и отобразить
        List<Player> listPlayers = new ArrayList<>();


        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                String name = result.getString(2);
                String lastName = result.getString(3);
                String belt = result.getString(4);
                int age = result.getInt(5);

                //присовить новые значения к player
                var player = new Player(name, lastName, belt, age);

                //добавить в лист результаты
                listPlayers.add(player);
                for (Player players : listPlayers){
                    System.out.println(players);
                }
            }
        }

        catch (SQLException e){
            System.out.println("Failed");
        }
        return listPlayers;
    }

    @Override
    public List<Player> findById(int id) throws SQLException {
        return null;
    }

    @Override
    public Player save(Player player) throws SQLException {
        return null;
    }

    @Override
    public void update(Player player) throws SQLException {

    }

    @Override
    public void deleteById(int id) throws SQLException {

    }
}
