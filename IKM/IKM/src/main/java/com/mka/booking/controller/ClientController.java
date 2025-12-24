package com.mka.booking.controller;

import com.mka.booking.model.Client;
import com.mka.booking.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления клиентами.
 * Обрабатывает операции просмотра, создания, редактирования и удаления клиентов.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    /**
     * Конструктор с внедрением зависимости.
     *
     * @param clientRepository репозиторий клиентов
     */
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Отображает список клиентов и форму добавления нового клиента.
     *
     * @param model модель представления
     * @return шаблон списка клиентов
     */
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("client", new Client());
        return "clients/list";
    }

    /**
     * Обрабатывает отправку формы добавления клиента.
     *
     * @param client объект клиента, заполненный пользователем
     * @param result ошибки валидации
     * @param model  модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/add")
    public String addClient(@Valid @ModelAttribute("client") Client client,
                            BindingResult result,
                            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", client);
            model.addAttribute("clients", clientRepository.findAll());
            return "clients/list";
        }

        clientRepository.save(client);
        return "redirect:/clients";
    }

    /**
     * Обрабатывает отправку формы редактирования клиента.
     *
     * @param id     идентификатор клиента
     * @param client объект с обновлёнными данными
     * @param result ошибки валидации
     * @param model  модель представления
     * @return перенаправление на список или возврат формы при ошибке
     */
    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id,
                               @Valid @ModelAttribute("client") Client client,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", client);
            return "clients/edit";
        }

        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        existing.setName(client.getName());
        existing.setPhone(client.getPhone());
        existing.setEmail(client.getEmail());

        clientRepository.save(existing);

        return "redirect:/clients";
    }

    /**
     * Отображает форму редактирования клиента.
     *
     * @param id    идентификатор клиента
     * @param model модель представления
     * @return шаблон формы редактирования
     */
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        model.addAttribute("client", client);
        return "clients/edit";
    }

    /**
     * Удаляет клиента по ID.
     *
     * @param id идентификатор клиента
     * @return перенаправление на список клиентов
     */
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}
