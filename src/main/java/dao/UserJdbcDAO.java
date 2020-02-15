package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private static Connection connection = DBHelper.getInstance().getConnection();

    public UserJdbcDAO() {

    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String lastname = result.getString("lastname");
                String email = result.getString("email");
                User user = new User(id, name, lastname, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void updateUser(long id, String name, String lastname, String email) {
        String sql = "update user set name=? , lastname=?, email=? where id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, lastname);
            stmt.setString(3, email);
            stmt.setLong(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) {
        String sql = "insert into user (name, lastname, email, password, role) values ( ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(long id) {
        String sql = "delete from user where id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*получить пользователя по Id*/
    public User selectUserId(long id) throws SQLException {
        User user = null;
        String sql = "select * from user where id=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet result = stmt.executeQuery();
        while (result.next()) {
            long ids = result.getLong("id");
            String name = result.getString("name");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            user = new User(ids, name, lastname, email);
        }
        result.close();
        stmt.close();
        return user;
    }

    /*проверка клиента*/
    public User verifyUser(String name, String password) {
        String sql = "select * from user where (name=? and password=?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String nameNew = result.getString("name");
                String passwordNew = result.getString("password");
                if (nameNew.equals(name) && passwordNew.equals(password)) {
                    Long id = result.getLong("id");
                    String names = result.getString("name");
                    String lastnames = result.getString("lastname");
                    String emails = result.getString("email");
                    String roles = result.getString("role");
                    return new User(id, names, lastnames, emails, roles);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*создать таблицу*/
    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists user (id bigint auto_increment, " +
                "name varchar(256), lastname varchar(256), email varchar(256), " +
                "password varchar(256), role varchar(256),primary key (id))");
        stmt.close();
    }

    /*удолить таблицу*/
    public void dropTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("delete from user");
        stmt.close();
    }

}
