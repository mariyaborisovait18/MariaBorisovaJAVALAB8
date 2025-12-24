package com.mka.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер главной страницы приложения.
 * Отвечает за отображение стартовой страницы.
 */
@Controller
public class HomeController {

    /**
     * Обрабатывает запрос на корневой URL и возвращает главную страницу.
     *
     * @return шаблон главной страницы
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
