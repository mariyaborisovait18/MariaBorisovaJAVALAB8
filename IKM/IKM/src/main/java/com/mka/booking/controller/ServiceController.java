package com.mka.booking.controller;

import com.mka.booking.model.Service;
import com.mka.booking.repository.ServiceRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления услугами.
 * Обрабатывает операции просмотра, создания, редактирования и удаления услуг.
 */
@Controller
@RequestMapping("/services")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    /**
     * Конструктор с внедрением зависимости.
     *
     * @param serviceRepository репозиторий услуг
     */
    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    /**
     * Отображает список всех услуг.
     *
     * @param model модель представления
     * @return шаблон списка услуг
     */
    @GetMapping
    public String listServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "services/list";
    }

    /**
     * Отображает форму добавления новой услуги.
     *
     * @param model модель представления
     * @return шаблон формы добавления
     */
    @GetMapping("/add")
    public String addServiceForm(Model model) {
        model.addAttribute("service", new Service());
        return "services/add";
    }

    /**
     * Обрабатывает отправку формы добавления услуги.
     *
     * @param service объект услуги, заполненный пользователем
     * @param result  ошибки валидации
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/add")
    public String addService(@Valid @ModelAttribute("service") Service service,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "services/add";
        }

        serviceRepository.save(service);
        return "redirect:/services";
    }

    /**
     * Отображает форму редактирования услуги.
     *
     * @param id    идентификатор услуги
     * @param model модель представления
     * @return шаблон формы редактирования
     */
    @GetMapping("/edit/{id}")
    public String editService(@PathVariable Long id, Model model) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID"));

        model.addAttribute("service", service);
        return "services/edit";
    }

    /**
     * Обрабатывает отправку формы редактирования услуги.
     *
     * @param id          идентификатор услуги
     * @param formService объект с обновлёнными данными
     * @param result      ошибки валидации
     * @param model       модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/edit/{id}")
    public String updateService(@PathVariable Long id,
                                @Valid @ModelAttribute("service") Service formService,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            return "services/edit";
        }

        Service existing = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid service ID"));

        existing.setName(formService.getName());
        existing.setDuration(formService.getDuration());
        existing.setPrice(formService.getPrice());

        serviceRepository.save(existing);

        return "redirect:/services";
    }

    /**
     * Удаляет услугу по ID.
     *
     * @param id идентификатор услуги
     * @return перенаправление на список услуг
     */
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceRepository.deleteById(id);
        return "redirect:/services";
    }
}
