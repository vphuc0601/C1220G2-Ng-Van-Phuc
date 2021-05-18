package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.ClassStudentService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping({"/student", ""})
@SessionAttributes(value = "userLogin")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassStudentService classStudentService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String goListStudent(Model model, @PageableDefault(size = 2) Pageable pageable,
                                @RequestParam Optional<String> keyword) {
//                                @SessionAttribute("userLogin") User user) {

        String keywordOld = "";

        if (keyword.isPresent()) {
            keywordOld = keyword.get();
            model.addAttribute("listStudent", studentService.findByNameContaining(pageable, keywordOld));
        } else {
            model.addAttribute("listStudent", studentService.findAll(pageable));
        }

        model.addAttribute("keywordOld", keywordOld);
//        model.addAttribute("userLogin", user);

        return "list_student";
    }

    @GetMapping("/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model, HttpServletRequest request) throws Exception {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/detail/{idStudent}")
    public String goDetailStudentPathVariable(@PathVariable(value = "idStudent") Integer id,
                                              Model model) throws Exception {
            model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClassStudent", this.classStudentService.findAll());

        return "create_student";
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute Student student, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {

        new Student().validate(student, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("listClassStudent", this.classStudentService.findAll());
            return "create_student";
        }

        this.studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create student NG!");

        return "redirect:/student";
    }

    @GetMapping("/update")
    public String goUpdateStudent(Model model, @RequestParam Integer id) throws Exception {
        model.addAttribute("student", this.studentService.findById(id));
        return "update_student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        this.studentService.save(student);

        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException() {
        return "error_student";
    }
}
