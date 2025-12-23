package com.mka.booking.controller;

import com.mka.booking.model.Service;
import com.mka.booking.repository.ServiceRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/services")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Список услуг
    @GetMapping
    public String listServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "services/list";
    }

    // Форма добавления
    @GetMapping("/add")
    public String addServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "services/add";
    }

    // Обработка добавления
    @PostMapping("/add")
    public String addService(@Valid @ModelAttribute("service") Service service,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "services/add";
        }
        serviceRepository.save(service);
        return "redirect:/services";
    }

    // ✅ Форма редактирования
    @GetMapping("/edit/{id}")
    public String editService(@PathVariable Long id, Model model) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID"));

        model.addAttribute("service", service);
        return "services/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateService(@PathVariable Long id,
                                @Valid @ModelAttribute("service") Service formService,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            return "services/edit";
        }

        // Загружаем существующую услугу
        Service existing = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID"));

        // Обновляем только редактируемые поля
        existing.setName(formService.getName());
        existing.setDuration(formService.getDuration());
        existing.setPrice(formService.getPrice());

        // appointments не трогаем
        serviceRepository.save(existing);

        return "redirect:/services";
    }


    // Удаление
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
        return "redirect:/services";
    }
}
