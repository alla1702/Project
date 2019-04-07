package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.service.CarService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cars-list-all")
public class CarsListAllServlet extends HttpServlet {

    private CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", carService.findAllList());

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("cars-list-all"))
                .forward(req, resp);
    }
}