package com.example.case_study.controller;
import com.example.case_study.entity.Employee;
import com.example.case_study.service.DivisionService;
import com.example.case_study.service.EducationDegreeService;
import com.example.case_study.service.EmployeeService;
import com.example.case_study.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee")
    public String getAllEmployee(@PageableDefault(size = 4) Pageable pageable,
                                 @RequestParam Optional<String> searchNameEmployee,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchNameEmployee.isPresent()) {
            model.addAttribute("employeeList", employeeService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameEmployee.get();
            model.addAttribute("employeeList", employeeService.searchEmployee(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "employee/list";
    }

    @GetMapping(value = "employee/create")
    public String showCreateForm(Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping(value = "employee/create")
    public String createEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new Employee().validate(employee,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("divisionList",divisionService.findAll());
            model.addAttribute("positionList",positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "employee/create";
        }else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("successMsg", "Create Employee: " + employee.getEmployeeName() + " success!");
            return "redirect:/employee";
        }
    }

    @GetMapping(value = "/employee/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping(value = "employee/edit")
    public String editEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new Employee().validate(employee,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("divisionList",divisionService.findAll());
            model.addAttribute("positionList",positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            return "employee/edit";
        }else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("successMsg", "Update Employee: " + employee.getEmployeeName() + " success!");
            return "redirect:/employee";
        }
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete";
    }
    @PostMapping(value = "employee/delete")
    public String deleteEmployee(@RequestParam Long id, RedirectAttributes redirect){
        employeeService.remove(id);
        redirect.addFlashAttribute("successMsg", "Delete Employee: "+" success!");
        return "redirect:/employee";
    }
    @GetMapping("employee/view/{id}")
    public String detailEmployee(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/view";
    }
}
