package com.example.case_study.controller;
import com.example.case_study.entity.Service;
import com.example.case_study.service.RentTypeService;
import com.example.case_study.service.ServiceService;
import com.example.case_study.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceTypeService serviceTypeService;


    @GetMapping("service")
    public String getAllEmployee(@PageableDefault(size = 4) Pageable pageable,
                                 @RequestParam Optional<String> searchNameService,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchNameService.isPresent()) {
            model.addAttribute("serviceList", serviceService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameService.get();
            model.addAttribute("serviceList", serviceService.searchService(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "service/list";
    }

    @GetMapping(value = "service/create")
    public String showCreateForm(Model model) {
//        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("service", new Service());
        return "service/create";
    }

    @PostMapping(value = "service/create")
    public String createService(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("successMsg", "Create Employee: "+service.getName() +" success!");
        return "redirect:/service";
    }

    @GetMapping(value = "service/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("service", serviceService.findById(id));
        return "service/edit";
    }

    @PostMapping(value = "service/edit")
    public String editEmployee(@ModelAttribute Service service, RedirectAttributes redirectAttributes){
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("successMsg", "Update Employee: "+service.getName() +" success!");
        return "redirect:/service";
    }
    @GetMapping("/service/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model) {
//        model.addAttribute("divisionList", divisionService.findAll());
//        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
//        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("service", serviceService.findById(id));
        return "service/delete";
    }
    @PostMapping(value = "service/delete")
    public String deleteEmployee(@RequestParam Long id, RedirectAttributes redirect){
        serviceService.remove(id);
        redirect.addFlashAttribute("successMsg", "Delete Service: "+" success!");
        return "redirect:/service";
    }
    @GetMapping("service/view/{id}")
    public String detailEmployee(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("service", serviceService.findById(id));
        return "service/view";
    }
}

