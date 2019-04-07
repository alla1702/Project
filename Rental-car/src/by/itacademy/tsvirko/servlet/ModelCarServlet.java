package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.entity.ModelCar;
import by.itacademy.tsvirko.service.ModelCarService;
import by.itacademy.tsvirko.util.JspPathUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/model-car")
public class ModelCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ModelCar> modelCars = ModelCarService.getInstance().findAll();
        req.setAttribute("modelCars", modelCars);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("model-car"))
                .forward(req, resp);
    }
}