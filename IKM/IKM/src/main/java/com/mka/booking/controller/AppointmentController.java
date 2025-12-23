package com.mka.booking.controller;

import com.mka.booking.model.Appointment;
import com.mka.booking.repository.AppointmentRepository;
import com.mka.booking.repository.ClientRepository;
import com.mka.booking.repository.EmployeeRepository;
import com.mka.booking.repository.ServiceRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;

    public AppointmentController(AppointmentRepository appointmentRepository,
                                 ClientRepository clientRepository,
                                 EmployeeRepository employeeRepository,
                                 ServiceRepository serviceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }

    // ✅ Метод для установки min/max дат
    private void addDateLimits(Model model) {
        LocalDate today = LocalDate.now();
        LocalDate min = today.plusDays(1);      // завтра
        LocalDate max = today.plusWeeks(2);     // через 2 недели

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        model.addAttribute("minDate", min.atTime(9, 0).format(formatter));
        model.addAttribute("maxDate", max.atTime(21, 0).format(formatter));
    }

    // ✅ Список записей
    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments/list";
    }

    // ✅ Форма добавления записи
    @GetMapping("/add")
    public String addAppointmentForm(Model model) {

        model.addAttribute("appointment", new Appointment());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("services", serviceRepository.findAll());

        addDateLimits(model);

        return "appointments/add";
    }

    // ✅ Обработка добавления записи
    @PostMapping("/add")
    public String addAppointment(@Valid @ModelAttribute("appointment") Appointment appointment,
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

    // ✅ Форма редактирования записи
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

    // ✅ Обработка редактирования записи
    @PostMapping("/edit/{id}")
    public String updateAppointment(@PathVariable Long id,
                                    @Valid @ModelAttribute("appointment") Appointment formAppointment,
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

    // ✅ Удаление записи
    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }

    // ✅ Проверка корректности даты и времени
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
