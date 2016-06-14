package controller;


import dao.EmployeeService;
import entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
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


    @RequestMapping("/listEmployee")
    public ModelAndView listUsers() {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(employeeService.getAll());
        ModelAndView modelView = new ModelAndView("listEmployee");
        modelView.addObject("listUser", employees);
        return modelView;
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("Employee") Employee employee, BindingResult result) {
        employeeService.addEmployee(employee);
        return "start";
    }

    @RequestMapping("/add")
    public String visitAdd() {
        return "addEmployee";
    }

    @RequestMapping("/search")
    public String visitSearch() {
        return "searchEmployee";
    }

    @RequestMapping("/searchEmployee")
    public ModelAndView searchEmployee(@ModelAttribute("name") String name) {
        Employee employee = new Employee();
        employee = employeeService.getEmployee(name);
        if (employee.getId() != null) {
            ModelAndView modelView = new ModelAndView("searchEmployeeEnter");
            modelView.addObject("Employee", employee);
            return modelView;
        } else {
            ModelAndView modelView = new ModelAndView("searchError");
            return modelView;
        }
    }

    @RequestMapping("/delete")
    public String visitDelete() {
        return "deleteEmployee";
    }



    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@ModelAttribute("name") String name) {

        employeeService.deleteEmployee(name);
        return"removedSuccessfully";
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


