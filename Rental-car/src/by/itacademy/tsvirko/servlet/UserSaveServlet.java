package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.dto.CreateNewUserDto;
import by.itacademy.tsvirko.dto.ViewUserBasicInfoDto;
import by.itacademy.tsvirko.entity.Role;
import by.itacademy.tsvirko.service.UserService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-user")
public class UserSaveServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("save-user"))
                .forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreateNewUserDto createNewUserDto = CreateNewUserDto.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role")))
                .build();

        ViewUserBasicInfoDto savedUser = userService.save(createNewUserDto);
        resp.sendRedirect("/show-user-details?id=" + savedUser.getId());
    }
}