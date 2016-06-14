package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import dao.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/home")
    public String visitHome() {
        return "home";
    }

    @RequestMapping("/admin")
    public String visitAdmin() {
        return "admin";
    }

    @RequestMapping("/staff")
    public String visitStaff() {
        return "staff";
    }



    /*   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

      /**
       * Simply selects the home view to render by returning its name.
       */
/*   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String load(Locale locale, Model model) {
        logger.info("W locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "admin";
    }
*/


}