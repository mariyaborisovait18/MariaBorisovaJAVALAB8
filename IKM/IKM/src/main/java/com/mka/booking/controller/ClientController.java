package com.mka.booking.controller;

import com.mka.booking.model.Client;
import com.mka.booking.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    // Форма добавления клиента
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("client", new Client()); // форма на той же странице
        return "clients/list";
    }

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



    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable Long id,
                               @Valid @ModelAttribute("client") Client client,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", client);
            return "clients/edit";
        }

        // Загружаем существующего клиента из базы
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));

        // Обновляем только нужные поля
        existing.setName(client.getName());
        existing.setPhone(client.getPhone());
        existing.setEmail(client.getEmail());

        // ppointments НЕ трогаем — Hibernate не ругается
        clientRepository.save(existing);

        return "redirect:/clients";
    }

    // Форма редактирования клиента
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID"));
        model.addAttribute("client", client);
        return "clients/edit";
    }

    // Удаление клиента
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}
