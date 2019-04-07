package by.itacademy.tsvirko.servlet;

import by.itacademy.tsvirko.dto.CreateNewCarDto;
import by.itacademy.tsvirko.dto.ViewCarBasicInfoDto;
import by.itacademy.tsvirko.entity.Year;
import by.itacademy.tsvirko.service.CarService;
import by.itacademy.tsvirko.service.FuelTypeService;
import by.itacademy.tsvirko.service.ModelCarService;
import by.itacademy.tsvirko.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save-car")
public class CarSaveServlet extends HttpServlet {

    private CarService carService = CarService.getInstance();
    private ModelCarService modelCarService = ModelCarService.getInstance();
    private FuelTypeService fuelTypeService = FuelTypeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("modelCars", modelCarService.findAll());
        req.setAttribute("fuelTypes", fuelTypeService.findAll());

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("save-car"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CreateNewCarDto createNewCarDto = CreateNewCarDto.builder()
                .modelCarId(Long.parseLong(req.getParameter("modelCar")))
                .fuelTypeId(Long.parseLong(req.getParameter("fuelType")))
                .rentalPrice(Integer.parseInt(req.getParameter("rentalPrice")))
                .year(Year.valueOf(req.getParameter("year")))
                .description(req.getParameter("description"))
                .build();

        ViewCarBasicInfoDto savedCar = carService.save(createNewCarDto);
        resp.sendRedirect("/show-car-details?id=" + savedCar.getId());
    }
}