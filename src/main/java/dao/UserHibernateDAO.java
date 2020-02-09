package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private SessionFactory sessionFactory = DBHelper.getInstance().getConfiguration();

    public UserHibernateDAO() {

    }

    @Override
    public List<User> selectAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User u";
        List<User> allUser = session.createQuery(hql, model.User.class).list();
        transaction.commit();
        session.close();
        return allUser;
    }

    @Override
    public void updateUser(long id, String name, String lastname, String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update User u set u.name =:name, u.lastname =:lastname, u.email =:email where u.id =:id";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        query.setParameter("lastname", lastname);
        query.setParameter("email", email);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void insertUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "delete User u where u.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    /*получить пользователя по Id*/
    public User selectUserId(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User u where u.id = :id";
        Query<User> query = session.createQuery(hql, model.User.class);
        query.setParameter("id", id);
        User user = query.getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    /*проверка клиента*/
    public User verifyUser(String name, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User u where u.name = :name and u.password = :password";
        Query<User> query = session.createQuery(hql, model.User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);
        List<User> userList = query.getResultList();
        transaction.commit();
        session.close();
        return userList.isEmpty() ? null : userList.get(0);
//        return !userList.isEmpty();
    }

    /*очистить таблицу*/
    public void dropTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "delete from User u";
        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
