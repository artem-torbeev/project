package servlets;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = UserService.getInstance().verifyUser(name, password);

        if (user != null) {
            // создаем сессию
            HttpSession session = req.getSession();
            // кладем в атрибуты сессии атрибут user с ролью пользователя
            if (user.getRole().equals("admin")) {
                session.setAttribute("user", user);
//                TODO исправить пути
                resp.sendRedirect(req.getContextPath() + "/admin");
            } else {
                session.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/user");
            }
        } else {
            resp.getWriter().println("Ups");
        }  //            нужна регистрация если нет пользователя в базе
    }
}





//                String url = "http://" + request.getServerName() + ":"
//                        + request.getServerPort() + request.getContextPath()
//                        + "/login.jsp";
//                response.sendRedirect(url);