package servlets;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/create")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role;

        if (name.equals("admin")) {
            role = "admin";
        }else {
            role = "user";
        }

        UserService.getInstance().insertUser(new User(name, lastname, email, password, role));

        resp.sendRedirect("http://localhost:8080/web_project_war_exploded/admin");
    }
}
/*req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
* resp.sendRedirect(req.getContextPath() + "/login");*/