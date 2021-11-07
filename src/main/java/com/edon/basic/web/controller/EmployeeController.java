package com.edon.basic.web.controller;

import com.edon.basic.web.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    private List employeeList = new ArrayList<Employee>();

    @GetMapping("new-employee")
    public String getNewEmployeeView(Model model){
        model.addAttribute("employee", new Employee());
        return "newEmployee";
    }

    @PostMapping("new-employee")
    public String submitNewEmployee(@ModelAttribute Employee employee, Model model){
        model.addAttribute("employee", employee);
        this.employeeList.add(employee);
        return "viewEmployee";
    }

    @GetMapping("employee-list")
    public String getEmployeeList(Model model){
        model.addAttribute("employees", this.employeeList);
        return "employeeList";
    }
}
