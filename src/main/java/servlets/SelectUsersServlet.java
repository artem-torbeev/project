package servlets;

import model.User;
import service.UserService;
import util.ReaderProperty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class SelectUsersServlet extends HttpServlet {

    List<User> listUser;

    @Override
    public void init() throws ServletException {
//        UserService.getInstance().createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TODO таблица при выводе
        listUser = UserService.getInstance().selectAllUsers();
        req.setAttribute("listUser", listUser);
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }
}
