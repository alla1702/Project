package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.entity.FuelType;
import by.itacademy.tsvirko.service.FuelTypeService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fuel-type")
public class FuelTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FuelType> fuelTypes = FuelTypeService.getInstance().findAll();
        req.setAttribute("fuelTypes", fuelTypes);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("fuel-type"))
                .forward(req, resp);
    }
}
