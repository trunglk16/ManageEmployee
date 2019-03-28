package com.codegym.module2.Controller;

import com.codegym.module2.Model.Employee;
import com.codegym.module2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@Controller
public class HomeController {
    @Autowired
    private EmployeeService employeeSerivce;

    @GetMapping("/")
    public ModelAndView list(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Employee> employee;
        ModelAndView modelAndView = new ModelAndView("/views/index");

        if (s.isPresent()) {
            employee = employeeSerivce.findAllByNameContainingOrIndContaining(s.get(), s.get(), new PageRequest(pageable.getPageNumber(), 5));
            modelAndView.addObject("search", s.get());
        } else {
            employee = printPage(pageable);
            modelAndView.addObject("search", "");
        }

        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    private Page<Employee> printPage(Pageable pageable) {
        return employeeSerivce.findAll(new PageRequest(pageable.getPageNumber(), 5));
    }

}
