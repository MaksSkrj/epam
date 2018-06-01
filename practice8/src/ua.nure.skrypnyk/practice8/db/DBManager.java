package ua.nure.skrypnyk.practice8.db;

import ua.nure.skrypnyk.practice8.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    List<User> userList = new ArrayList<>();

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public DBManager() {
    }

    private static final String URL = "jdbc:mysql://localhost:3306/db_users";
    private static final String LOGIN = "maks0n";
    private static final String PASSWORD = "melkiy230898gutter";

    private static final String SQL_INSERT_USER = //"INSERT INTO TABLE `users` `id` = default `login` = ?";
            "INSERT INTO `users`(`id`, `login`) VALUES (default, ?)";

    public static void insertUser(String login) throws SQLException {
        Connection con = getConnection();
        PreparedStatement prtstm = null;
        prtstm = con.prepareStatement(SQL_INSERT_USER);
        prtstm.setString(1, login);
        int update = prtstm.executeUpdate();
        System.out.println(update);
    }


    private static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        // adjust your connection!
        return con;
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
        insertUser("11");
    }
}
