package com.mka.booking.controller;

import com.mka.booking.model.Appointment;
import com.mka.booking.repository.AppointmentRepository;
import com.mka.booking.repository.ClientRepository;
import com.mka.booking.repository.EmployeeRepository;
import com.mka.booking.repository.ServiceRepository;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления записями (Appointment).
 * Обрабатывает операции просмотра, создания, редактирования и удаления записей.
 */
@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;

    /**
     * Конструктор с внедрением зависимостей.
     *
     * @param appointmentRepository репозиторий записей
     * @param clientRepository      репозиторий клиентов
     * @param employeeRepository    репозиторий сотрудников
     * @param serviceRepository     репозиторий услуг
     */
    public AppointmentController(AppointmentRepository appointmentRepository,
                                 ClientRepository clientRepository,
                                 EmployeeRepository employeeRepository,
                                 ServiceRepository serviceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }

    /**
     * Добавляет в модель ограничения по дате:
     * — запись возможна только с завтрашнего дня
     * — максимум на 2 недели вперёд
     * — время с 09:00 до 21:00
     *
     * @param model модель представления
     */
    private void addDateLimits(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate min = today.plusDays(1);
        LocalDate max = today.plusWeeks(2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        model.addAttribute("minDate", min.atTime(9, 0).format(formatter));
        model.addAttribute("maxDate", max.atTime(21, 0).format(formatter));
    }

    /**
     * Отображает список всех записей.
     *
     * @param model модель представления
     * @return шаблон списка записей
     */
    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments/list";
    }

    /**
     * Отображает форму создания новой записи.
     *
     * @param model модель представления
     * @return шаблон формы добавления
     */
    @GetMapping("/add")
    public String addAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        addDateLimits(model);
        return "appointments/add";
    }

    /**
     * Обрабатывает отправку формы создания записи.
     *
     * @param appointment объект записи, заполненный пользователем
     * @param result      ошибки валидации
     * @param model       модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/add")
    public String addAppointment(@ModelAttribute("appointment") @Valid Appointment appointment,
                                 BindingResult result,
                                 Model model) {

        validateDateTime(appointment.getDateTime(), result);

        if (result.hasErrors()) {
            model.addAttribute("clients", clientRepository.findAll());
            model.addAttribute("employees", employeeRepository.findAll());
            model.addAttribute("services", serviceRepository.findAll());
            addDateLimits(model);
            return "appointments/add";
        }

        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    /**
     * Отображает форму редактирования существующей записи.
     *
     * @param id    идентификатор записи
     * @param model модель представления
     * @return шаблон формы редактирования
     */
    @GetMapping("/edit/{id}")
    public String editAppointment(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTime = appointment.getDateTime().format(formatter);

        model.addAttribute("appointment", appointment);
        model.addAttribute("formattedDateTime", formattedDateTime);
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());
        addDateLimits(model);

        return "appointments/edit";
    }

    /**
     * Обрабатывает отправку формы редактирования записи.
     *
     * @param id             идентификатор редактируемой записи
     * @param formAppointment объект с обновлёнными данными
     * @param result         ошибки валидации
     * @param model          модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/edit/{id}")
    public String updateAppointment(@PathVariable Long id,
                                    @ModelAttribute("appointment") @Valid Appointment formAppointment,
                                    BindingResult result,
                                    Model model) {

        validateDateTime(formAppointment.getDateTime(), result);

        if (result.hasErrors()) {
            model.addAttribute("clients", clientRepository.findAll());
            model.addAttribute("employees", employeeRepository.findAll());
            model.addAttribute("services", serviceRepository.findAll());
            addDateLimits(model);
            return "appointments/edit";
        }

        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID"));

        existing.setClient(formAppointment.getClient());
        existing.setEmployee(formAppointment.getEmployee());
        existing.setService(formAppointment.getService());
        existing.setDateTime(formAppointment.getDateTime());

        appointmentRepository.save(existing);

        return "redirect:/appointments";
    }

    /**
     * Удаляет запись по ID.
     *
     * @param id идентификатор записи
     * @return перенаправление на список записей
     */
    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

    /**
     * Проверяет корректность даты и времени записи.
     * — дата должна быть в пределах 2 недель
     * — запись возможна только с 09:00 до 21:00
     *
     * @param dt     дата и время записи
     * @param result объект для добавления ошибок валидации
     */
    private void validateDateTime(LocalDateTime dt, BindingResult result) {
        LocalDateTime min = LocalDate.now().plusDays(1).atTime(9, 0);
        LocalDateTime max = LocalDate.now().plusWeeks(2).atTime(21, 0);

        if (dt.isBefore(min) || dt.isAfter(max)) {
            result.rejectValue("dateTime", "invalidDate",
                    "Дата должна быть в течение двух недель, начиная с завтрашнего дня, с 09:00 до 21:00");
        }

        int hour = dt.getHour();
        if (hour < 9 || hour > 21) {
            result.rejectValue("dateTime", "invalidTime",
                    "Запись возможна только с 09:00 до 21:00");
        }
    }
}
