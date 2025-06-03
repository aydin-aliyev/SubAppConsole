package dao;

import model.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface playerDAO {
    List<Player> findAll() throws SQLException;
    List<Player> findById(int id) throws SQLException;
    Player save(Player player) throws SQLException;
    void update(Player player) throws SQLException;
    boolean deleteById(int id) throws SQLException;
}
