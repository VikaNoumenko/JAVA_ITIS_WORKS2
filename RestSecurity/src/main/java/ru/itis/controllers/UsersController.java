package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.model.User;
import ru.itis.service.UsersService;

import java.util.List;

/**
 * 25.01.17
 * UsersController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

/**
 * Краткий экскурс в историю:
 * HTTP-запрос:
 * 1) Метод запроса - GET, POST, DELETE, PUT и т.д
 * 2) URL-запроса - доменное имя + путь, например GET www.vk.com/api/friends
 * 3) Параметры запроса - ?age=23&color=nigga
 * 4) Тело запроса: plain text, html, json, xml ...
 * 5) Заголовки: Content-Type
 *
 * В Java обработать запрос:
 * 1 - method = RequestMethod.POST, либо @PostMapping
 * 2 - в скобках mapping, данные оттуда можно вытащить с помощью
 * \@PathVariable("user-id") int id) для /users/{user-id}/friends
 * 3 - @RequestParam("color") String color) для /users?color=nigga
 * 4 - @RequestBody
 * 5 - @RequestHeader("Content-type") String type)
 *
 * HTTP-ответ
 * 1 - статус - 200, 400, 403, 405, 500 ...
 * 2 - заголовки
 * 3 - тело ответа
 * Чтобы с Java отправить все и сразу ResponseEntity
 */
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * Регистрация пользователя
     * @param user данные для регистрации
     * @return базовая информация о пользователе
     */
    @PostMapping("/users")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDataForRegistrationDto user) {
        return new ResponseEntity<>(usersService.registerUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader("password") String password,
                                         @RequestHeader("login") String login) {
        String token = usersService.login(password, login);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", token);
        return new ResponseEntity<>(null, headers, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.ACCEPTED);
    }
}
