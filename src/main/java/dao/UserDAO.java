package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    /*получить всех пользователей*/
    List<User> selectAllUsers();

    /*изменение пользователя*/
    void updateUser(long id, String name, String lastname, String email);

    /*добавить пользователя*/
    void insertUser(User user);

    /* удалить пользователя*/
    void deleteUser(long id);

}
