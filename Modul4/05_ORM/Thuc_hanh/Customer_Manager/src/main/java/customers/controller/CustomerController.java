package customers.controller;

import customers.entity.Customer;
import customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping({"","/"})
    public String getListCustomer(Model model){
        model.addAttribute("listCustomer",this.customerService.findAll());
        return "list";
    }
    @GetMapping("create")
    public String createCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return"/create";
        }
    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerService.update(customer);
        System.out.println(customer.getName());
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("success", "Removed product success!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }

}
