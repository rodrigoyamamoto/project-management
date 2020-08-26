package co.pma.controllers;

import co.pma.dao.EmployeeRepository;
import co.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);

        return "redirect:/employees/new";
    }
}
