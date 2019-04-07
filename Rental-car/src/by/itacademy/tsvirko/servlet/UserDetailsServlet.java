package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.service.UserService;
import by.itacademy.tsvirko.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-user-details")
public class UserDetailsServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("user", userService.findById(Long.parseLong(id)));

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("user-info"))
                .forward(req, resp);
    }
}