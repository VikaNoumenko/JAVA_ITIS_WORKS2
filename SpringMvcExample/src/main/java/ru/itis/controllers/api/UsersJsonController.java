package ru.itis.controllers.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.converter.Converter;
import ru.itis.dao.UsersDao;
import ru.itis.dto.UserDto;
import ru.itis.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersJsonController {

    @Autowired
    private UsersDao usersDao;

    /*
    @RequestMapping(value = "/annotation/users/json", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getAllUsers() {
        List<User> users = usersDao.findAll();
        // конвертирует объекты в json
        ObjectMapper mapper = new ObjectMapper();
        try {
            // получаю JSON из списка пользователей
            return mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
    */

    @RequestMapping(value = "/annotation/users/json", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<UserDto> getAllUsers() {
        List<User> users = usersDao.findAll();
        List<UserDto> userDtos = Converter.convertListUser(users);
        return userDtos;
    }
}
