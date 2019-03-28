package com.codegym.module2.Controller;

import com.codegym.module2.Model.Employee;
import com.codegym.module2.Model.Gender;
import com.codegym.module2.Model.Position;
import com.codegym.module2.Service.EmployeeService;
import com.codegym.module2.Service.GenderService;
import com.codegym.module2.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private GenderService genderService;

    @ModelAttribute("position")
    private Iterable<Position> position() {
        return positionService.findAll();
    }

    @ModelAttribute("gender")
    private Iterable<Gender> gender() {
        return genderService.findAll();
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/views/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView updateEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (!bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/views/view");
            employeeService.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "Cập nhật thành công");
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("/views/edit");
            return modelAndView;
        }
    }


    @GetMapping("/create-employee")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/views/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView createEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/views/create");
        if (!bindingResult.hasFieldErrors()) {
            employeeService.save(employee);
            modelAndView.addObject("employee", new Employee());
            return modelAndView;
        }else {
            return modelAndView;
        }
    }
    @GetMapping("/view-employee/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            ModelAndView modelAndView = new ModelAndView("/views/view");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/views/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/delete-employee/{id}")
    public String delete(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            employeeService.remove(employee.getId());
            return "redirect:/";
        } else {
            return "redirect:/error404";
        }
    }

    @GetMapping("/error404")
    public ModelAndView error404() {
        ModelAndView modelAndView = new ModelAndView("/views/error.404)");
        return modelAndView;
    }

}
