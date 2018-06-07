package ua.nure.skrypnyk.practice8;

import ua.nure.skrypnyk.practice8.entity.Group;
import ua.nure.skrypnyk.practice8.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String MY_SQL_URL = "jdbc:mysql://localhost:3306/db_users1";
    private static final String USER = "maks0n";
    private static final String PASSWORD = "melkiy230898gutter";

    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_FIND_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_INSERT_USER = "INSERT INTO users VALUES (NULL, ?)";
    private static final String SQL_INSERT_GROUP = "INSERT INTO groups VALUES (NULL, ?)";
    private static final String SQL_GET_USER = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_GET_GROUP = "SELECT * FROM groups WHERE name = ?";
    private static final String SQL_SET_GROUP = "INSERT INTO user_groups (user_id, group_id) VALUES(?, ?)";
    private static final String SQL_DELETE_GROUP = "DELETE FROM groups WHERE id = ?";
    private static final String SQL_UPDATE_GROUP = "UPDATE groups SET name = ? WHERE id = ?";
    private static final String SQL_GET_USER_GROUPS = "SELECT id, name FROM groups INNER JOIN user_groups ON " +
            "id = group_id where user_id = ?";

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null)
            instance = new DBManager();
        return instance;
    }

    private DBManager() {
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(MY_SQL_URL, USER, PASSWORD);
    }

    public void insertUser(User user) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            if (preparedStatement.executeUpdate() > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DBException("Cannot insert user", e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }

    public List<User> findAllUsers() throws DBException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL_USERS);
            while (resultSet.next()) {
                User user = extractUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DBException("Cannot find all users", e);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return users;
    }

    private User extractUser(ResultSet rs) throws DBException {
        User user = new User();
        try {
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
        } catch (SQLException e) {
            throw new DBException("Cannot extract user", e);
        }
        return user;
    }

    public void insertGroup(Group group) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_GROUP, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, group.getName());
            if (preparedStatement.executeUpdate() > 0) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    group.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DBException("Cannot insert group", e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }

    public List<Group> findAllGroups() throws DBException {
        List<Group> groups = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_FIND_ALL_GROUPS);
            while (resultSet.next()) {
                Group group = extractGroup(resultSet);
                groups.add(group);
            }
        } catch (SQLException e) {
            throw new DBException("Cannot find all groups", e);
        } finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return groups;
    }

    private Group extractGroup(ResultSet resultSet) throws DBException {
        Group group = new Group();
        try {
            group.setId(resultSet.getInt("id"));
            group.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            throw new DBException("Cannot extract group", e);
        }
        return group;
    }

    public User getUser(String login) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_USER);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            User user = new User();
            user.setLogin(login);
            if (resultSet.next())
                user.setId(resultSet.getInt(1));
            return user;
        } catch (SQLException e) {
            throw new DBException("Cannot get user", e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }

    public void setGroupsForUser(User user, Group... groups) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_SET_GROUP);
            preparedStatement.setInt(1, user.getId());

            for (Group group : groups) {
                preparedStatement.setInt(2, group.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            try {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e1) {
                throw new DBException("Cannot rollback transaction", e1);
            }
            throw new DBException("Cannot set groups for user", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public List<Group> getUserGroups(User user) throws DBException {
        List<Group> groups = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_USER_GROUPS);
            preparedStatement.setInt(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Group group = extractGroup(resultSet);
                groups.add(group);
            }
        } catch (SQLException e) {
            throw new DBException("Cannot get user groups", e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return groups;
    }

    public Group getGroup(String name) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_GROUP);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            Group group = new Group();
            group.setName(name);
            if (resultSet.next())
                group.setId(resultSet.getInt(1));
            return group;
        } catch (SQLException e) {
            throw new DBException("Cannot get group", e);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }

    public void deleteGroup(Group group) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_GROUP);
            preparedStatement.setInt(1, group.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Cannot delete group", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    public void updateGroup(Group group) throws DBException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_GROUP);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, group.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Cannot update group", e);
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }


    private void close(Connection connection) throws DBException {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new DBException("Cannot close connection", e);
        }
    }

    private void close(Statement statement) throws DBException {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            throw new DBException("Cannot close statement", e);
        }
    }

    private void close(ResultSet resultSet) throws DBException {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            throw new DBException("Cannot close result set", e);
        }
    }
}
