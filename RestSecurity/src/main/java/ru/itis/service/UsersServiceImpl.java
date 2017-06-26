package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dao.UsersDao;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;
import ru.itis.model.User;
import ru.itis.security.utils.TokenGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.itis.converter.Converter.convert;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private TokenGenerator generator;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDto registerUser(UserDataForRegistrationDto user) {
        // конвертируем Dto в модель, при этом
        // пароль кодируется
        User newUser = convert(user,
                                dto -> new User(dto.getLogin(),
                                encoder.encode(dto.getPassword()),
                                dto.getAge(),
                                dto.getName())
                            );

        // сохраняю пользователя и получаю пользователя
        // с id-ником
        User savedUser = usersDao.save(newUser);

        // конвертирую модель в Dto и возвращаю как результат
        return convert(savedUser,
                model -> new UserDto(model.getId(),
                        model.getAge(),
                        model.getName()));
    }

    @Override
    @Transactional
    public String login(String password, String login) {
        // TODO: проверить, найден ли пользователь
        User registeredUser = usersDao.findByLogin(login);

        if (encoder.matches(password, registeredUser.getHashPassword())) {
            // генерируем токен
            String token = generator.generateToken();
            // обновляем токен пользователя
            usersDao.updateToken(registeredUser.getId(), token);
            // возвращаем токен
            return token;
        } else throw new IllegalArgumentException("Incorrect username or password");
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        usersDao.findAll().forEach(users::add);
        return users;
    }
}
