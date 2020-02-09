package dao;

public class UserDaoFactory {

    /*db_type_connection=UserJdbcDAO*/
    public UserDAO createDAO(String type) {
        if ("UserJdbcDAO".equals(type)) {
            return new UserJdbcDAO();
        }
        return new UserHibernateDAO();
    }
}
