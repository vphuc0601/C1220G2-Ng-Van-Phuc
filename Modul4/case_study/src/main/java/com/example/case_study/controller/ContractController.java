package com.example.case_study.controller;
import com.example.case_study.entity.Contract;
import com.example.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachServiceService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @GetMapping("contract")
    public String getAllContract(@PageableDefault(size = 4) Pageable pageable, @RequestParam Optional<String> searchNameContract,
                                 Model model, RedirectAttributes redirectAttributes){
        String stringAfterCheck = "";
        if (!searchNameContract.isPresent()){
            model.addAttribute("contractList", contractService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameContract.get();
            model.addAttribute("contractList", contractService.search(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "/contract/list";
    }
    @GetMapping("contract/create")
    public String createContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("service", serviceService.findAll());
        return "/contract/create";
    }

    @PostMapping("contract/create")
    public String save(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult, Model model) {
        new Contract().validate(contract,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("employee", employeeService.findAll());
            model.addAttribute("customer", customerService.findAll());
            model.addAttribute("service", serviceService.findAll());
            return "/contract/create";
        }else {
            contractService.save(contract);
            return "redirect:/contract";
        }
    }

    @GetMapping("contract/edit/{id}")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("customer", customerService.findAll());
        model.addAttribute("service", serviceService.findAll());
        return "/contract/edit";
    }

    @PostMapping("contract/updateContract")
    public String updateContract(@ModelAttribute Contract contract) {
        contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("contract/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        this.contractService.remove(id);
        return "redirect:/contract";
    }

}
