package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin/create", "/admin/edit", "/admin"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else if (user.getRole().equals("admin")) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    public void destroy() {

    }
}
