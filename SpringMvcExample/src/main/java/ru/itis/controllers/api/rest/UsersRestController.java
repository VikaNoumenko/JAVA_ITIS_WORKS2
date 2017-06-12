package ru.itis.controllers.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.converter.Converter;
import ru.itis.dto.AutoDto;
import ru.itis.models.Auto;
import ru.itis.services.UsersService;

import java.util.List;

@RestController
public class UsersRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/users/{user-id}/autos", params = "filter=used")
    public List<AutoDto> getUnusedAutos(@PathVariable("user-id") int userId,
                                        @RequestParam("used") boolean isUsed) {
        List<Auto> autos = usersService.getUserAutosByUsed(userId, isUsed);
        List<AutoDto> autoDtos = Converter.convertListAuto(autos);
        return autoDtos;
    }
}
