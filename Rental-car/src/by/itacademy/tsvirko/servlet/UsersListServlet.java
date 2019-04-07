package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.service.UserService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users-list")
public class UsersListServlet extends HttpServlet{

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.findAll());

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("users-list"))
                .forward(req, resp);
    }
}
