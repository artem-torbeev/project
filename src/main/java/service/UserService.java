package service;

import dao.UserHibernateDAO;
import model.User;

import java.util.List;

public class UserService {

    private UserService() {

    }

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    /*получить всех пользователей*/
    public List<User> selectAllUsers() {
        return new UserHibernateDAO().selectAllUsers();
    }

    /*изменение пользователя*/
    public void updateUser(long id, String name, String lastname, String email) {
        new UserHibernateDAO().updateUser(id, name, lastname, email);
    }

    /*добавить пользователя*/
    public void insertUser(User user) {
        new UserHibernateDAO().insertUser(user);
    }

    /*удалить пользователя*/
    public void deleteUser(long id) {
        new UserHibernateDAO().deleteUser(id);
    }

    /*получить пользователя по Id*/
    public User selectUserId(long id) {
        return new UserHibernateDAO().selectUserId(id);
    }

    /*TODO проверка клиента*/
    public User verifyUser(String name, String password) {
        return new UserHibernateDAO().verifyUser(name, password);
    }
}
