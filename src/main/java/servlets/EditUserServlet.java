package servlets;

import model.User;
import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit")
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = UserService.getInstance().selectUserId(Long.parseLong(id));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        UserService.getInstance().updateUser(Long.parseLong(id), name, lastname, email);

        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
