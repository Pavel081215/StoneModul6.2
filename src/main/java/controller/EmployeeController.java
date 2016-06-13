package controller;


import dao.EmployeeService;
import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller

public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/home")
    public String visitHome() {

        // do something before returning view name

        return "home";
    }

    @RequestMapping("/admin")
    public String visitAdmin() {

        // do something before returning view name
        return "admin";
    }


    @RequestMapping("/listEmployee")
    public ModelAndView listUsers() {
        Employee employee = new Employee();
        List<Employee> employees = new ArrayList<>();
      /*  Employee employee1 = new Employee();

        employee.setId(1);
        employee.setSurname("4");
        employee.setBirthDay("6");
        employee.setName("ggg");
        employee.setPhone(4l);
        employee.setPosition("djdj");
        employee.setSalary(3455);
        employees.add(employee);
        employee1.setId(2);
        employee1.setSurname("ff");
        employee1.setBirthDay("rrrrr");
        employee1.setName("bbbbb");
        employee1.setPhone(4);
        employee1.setPosition("555");
        employee1.setSalary(3);
        employees.add(employee1);*/


        // get user list from DAO...
        employees.addAll(employeeService.getAll());

        ModelAndView modelView = new ModelAndView("listEmployee");
        modelView.addObject("listUser", employees);

        return modelView;
    }








/*    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "4333";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(Locale locale, Model model) {
        return "login";
    }

    /*  @RequestMapping(value = "/home", method = RequestMethod.GET)
      public String login( @Validated Employee user, Model model) {
          model.addAttribute("userName", "ddddddddddddddd");
          return "user";
      }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
               return "home";
    }*/


}


