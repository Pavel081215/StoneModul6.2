package controller;

import dao.EmployeeService;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping(value="/account")
public class EmployeeController {

  //  private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();

    @RequestMapping(method=RequestMethod.GET)
    public String getCreateForm(Model model) {
        //	model.addAttribute(new Account());
        return "new";
        //return "account/createForm";
    }


/*
@Controller
@RequestMapping(value = "/")
public class EmployeeController {

    private Map<Long, Employee> accounts = new ConcurrentHashMap<Long, Employee>();
    public void setContactService(EmployeeService contactService) {
        this.contactService = contactService;
    }

    @Autowired
    private EmployeeService contactService;


  //  @RequestMapping(method= RequestMethod.GET)
  //  public String home() {
//
  //      System.out.println("<<<<<<<<<<<");
    //    return "error403";
    //}
  @RequestMapping(method=RequestMethod.GET)
  public String listContacts(Map<String, Object> map) {

      map.put("contact", new Employee());
      map.put("contactList", contactService.listEmplyee());

      return "new";
  }

    @RequestMapping("/admin")
    public String home() {
        return "new";
    }



    @RequestMapping(method=RequestMethod.GET)
    public String getCreateForm(Model model) {
        model.addAttribute(new Employee());
        return "new";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@Valid Employee account, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        this.accounts.put(account.getPhone(), account);
        return "new" ;
    }


  /*   @RequestMapping(method = RequestMethod.GET)
    public String getCreateForm(Model model) {
        model.addAttribute(new Employee());
        return "contact";
    }



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
    }*/
}
