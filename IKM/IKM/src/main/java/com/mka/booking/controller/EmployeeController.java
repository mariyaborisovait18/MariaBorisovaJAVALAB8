package com.mka.booking.controller;

import com.mka.booking.model.Employee;
import com.mka.booking.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления сотрудниками.
 * Обрабатывает операции просмотра, создания, редактирования и удаления сотрудников.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    /**
     * Конструктор с внедрением зависимости.
     *
     * @param employeeRepository репозиторий сотрудников
     */
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Отображает список сотрудников.
     * Также передаёт флаг showMenu для отображения меню на странице.
     *
     * @param model модель представления
     * @return шаблон списка сотрудников
     */
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("showMenu", true);
        return "employees/list";
    }

    /**
     * Отображает форму добавления нового сотрудника.
     *
     * @param model модель представления
     * @return шаблон формы добавления
     */
    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/add";
    }

    /**
     * Обрабатывает отправку формы добавления сотрудника.
     *
     * @param employee объект сотрудника, заполненный пользователем
     * @param result   ошибки валидации
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult result) {

        if (result.hasErrors()) {
            return "employees/add";
        }

        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    /**
     * Отображает форму редактирования сотрудника.
     * Также скрывает меню на странице редактирования.
     *
     * @param id    идентификатор сотрудника
     * @param model модель представления
     * @return шаблон формы редактирования
     */
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        model.addAttribute("employee", employee);
        model.addAttribute("showMenu", false);
        return "employees/edit";
    }

    /**
     * Обрабатывает отправку формы редактирования сотрудника.
     *
     * @param id           идентификатор сотрудника
     * @param formEmployee объект с обновлёнными данными
     * @param result       ошибки валидации
     * @param model        модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute("employee") Employee formEmployee,
                                 BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            return "employees/edit";
        }

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        existing.setName(formEmployee.getName());
        existing.setSpecialization(formEmployee.getSpecialization());

        employeeRepository.save(existing);

        return "redirect:/employees";
    }

    /**
     * Удаляет сотрудника по ID.
     *
     * @param id идентификатор сотрудника
     * @return перенаправление на список сотрудников
     */
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees";
    }
}
