package ru.itis.converter;

import ru.itis.dto.AutoDto;
import ru.itis.dto.UserDto;
import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static UserDto convert(User model) {
        return new UserDto(model.getId(),
                model.getLogin(),
                model.getPassword(),
                model.getName(),
                model.getAge(),
                convertListAuto(model.getAutos()));
    }

    public static List<AutoDto> convertListAuto(List<Auto> autoList) {
        List<AutoDto> autoDtos = new ArrayList<>();
        for (Auto model : autoList) {
            AutoDto dto = new AutoDto(model.getId(),
                    model.getModel(),
                    model.getColor(),
                    model.getCarMileage(),
                    model.getIsUsed());

            autoDtos.add(dto);
        }
        return autoDtos;
    }

    public static List<UserDto> convertListUser(List<User> userList) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User model : userList) {
            UserDto dto = convert(model);
            userDtos.add(dto);
        }
        return userDtos;
    }
}