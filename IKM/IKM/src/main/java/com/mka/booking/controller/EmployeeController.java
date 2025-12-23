package com.mka.booking.controller;

import com.mka.booking.model.Employee;
import com.mka.booking.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Список сотрудников
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("showMenu", true); // ✅ включаем меню
        return "employees/list";
    }

    // Форма добавления
    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add";
    }

    // Обработка добавления
    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "employees/add";
        }
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        model.addAttribute("employee", employee);
        model.addAttribute("showMenu", false); // ✅ скрываем меню
        return "employees/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute("employee") Employee formEmployee,
                                 BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            return "employees/edit";
        }

        // ✅ Загружаем существующего сотрудника из базы
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        // ✅ Обновляем только редактируемые поля
        existing.setName(formEmployee.getName());
        existing.setSpecialization(formEmployee.getSpecialization());

        // ✅ appointments НЕ трогаем — Hibernate не будет ругаться
        employeeRepository.save(existing);

        return "redirect:/employees";
    }

    // Удаление
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
