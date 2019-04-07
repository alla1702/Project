package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.service.CarService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/show-car-details")
public class CarDetailsServlet extends HttpServlet {

    private CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("car", carService.findById(Long.parseLong(id)));

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("car-info"))
                .forward(req, resp);
    }
}