package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({ "/admin/create", "/admin/edit", "/admin" })
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("http://localhost:8080/web_project_war_exploded/login");
        }else if (session.getAttribute("user").equals("admin")){
            chain.doFilter(req, resp);
        }else {
            resp.sendRedirect("http://localhost:8080/web_project_war_exploded/user");
        }
    }

    @Override
    public void destroy() {

    }
}
