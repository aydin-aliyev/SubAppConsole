package dao.impl;

import dao.DatabaseConnection;
import dao.playerDAO;
import model.Player;
import model.PlayerManagement;

import java.awt.dnd.DropTarget;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class playerDAOImpl implements playerDAO {
    PlayerManagement playerManagement;
    Connection connection;
//конструктор с Connection чтобы
    public playerDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Player> findAll() {
        PlayerManagement pm = new PlayerManagement();

        //sql запрос
        String query = "SELECT * FROM players";

        //создаём лист чтобы добавлять туда данные а потом и отобразить
        List<Player> listPlayers = new ArrayList<>();


        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);

            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String lastName = result.getString(3);
                String belt = result.getString(4);
                int age = result.getInt(5);

                //присовить новые значения к player
                var player = new Player(id, name, lastName, belt, age);

                //добавить в лист результаты
                listPlayers.add(player);

            }
            for (Player plyrs : listPlayers)
            System.out.println(plyrs);
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

        String query = "INSERT INTO players (name, last_name, belt, age) VALUES(?,?,?,?)";

        //prepared statement
        try(PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, player.getName());
            statement.setString(2, player.getLastName());
            statement.setString(3, player.getBelt());
            statement.setInt(4, player.getAge());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0){
                System.out.println(player.getName() + ", " + player.getLastName() + ", " + player.getBelt() + ", " + player.getAge() + " was added successfully");
            }
        }
        catch (SQLException e){
            System.out.println("Failed");
            return null;
        }
        return player;
    }



//            while (resultSet.next()){
////                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
//                // Беру значения из колонок
//                String name = resultSet.getString(1);
//                String lastName = resultSet.getString(2);
//                String belt = resultSet.getString(3);
//                int age = resultSet.getInt(4);
//
//                System.out.println(name + " was added successfully"); // Почему-то эту часть код не выводит
//
//            }




    @Override
<<<<<<< Updated upstream
    public void update(Player player) throws SQLException {

=======
    public void update(UpdateClass updateClass) throws SQLException{
        String query = "UPDATE players SET " + updateClass.getColumnValue() + " = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            //❌ нельзя передавать имена столбцов
            //statement.setString(1, updateClass.getColumnValue());

            // Так как были проблемы с setObject, JDBC не понимал setObject, то пошёл таким путём
            if (updateClass.getColumnValue().equals("age")){
                // Определяю тип INTEGER если будет колонка age
                statement.setObject(1, updateClass.getValue(), Types.INTEGER);
            } else {
                statement.setObject(1, updateClass.getValue(), Types.VARCHAR);
            }

            statement.setInt(2, updateClass.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Updated successful");
            }
        } catch (SQLException e){
            System.out.println(e);
        }



























//        String query = "UPDATE players SET" + updateClass.getColValue() + " = ? WHERE id = ?";
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setObject(1, updateClass.getValValue());
//            statement.setInt(2, updateClass.getIdVal());
//
//            int rowsAffected = statement.executeUpdate();
//
//            //если execute больше нуля значит были изменения
//            if (rowsAffected > 0){
//                statement.executeUpdate();
//            }
//            else {
//                System.out.println("null rows affected");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error");
//        }
>>>>>>> Stashed changes
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String query = "DELETE FROM players WHERE id = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
        catch (SQLException e){
            System.out.println("SQL error " + e);
        }
        return true;
    }
}
