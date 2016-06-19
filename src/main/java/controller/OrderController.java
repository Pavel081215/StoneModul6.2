package controller;

import dao.EmployeeService;
import entity.Employee;
import entity.OrderName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

 /*   private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/viewOrders")
    public ModelAndView listOrders() {
        List<OrderName> orderNames = new ArrayList<>();
        orderNames.addAll(employeeService.getAllOrders());
        ModelAndView modelView = new ModelAndView("viewOrders");
        modelView.addObject("listOrders", orderNames);
        return modelView;

*/

}
