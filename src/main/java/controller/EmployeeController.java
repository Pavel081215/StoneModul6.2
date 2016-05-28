package controller;
import java.util.Map;

import dao.EmployeeService;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {


    public void setContactService(EmployeeService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    private EmployeeService contactService;


    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("contact", new Employee());
        map.put("contactList", contactService.listEmplyee());

        return "contact";
    }


    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Employee contact,
                             BindingResult result) {

        contactService.addEmplyee(contact);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {

        contactService.removeEmplyee(contactId);

        return "redirect:/index";
    }
}
