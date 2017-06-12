package ru.itis.controllers.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.services.UsersService;

import java.util.List;

@Controller("usersControllerAnnotation")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/annotation/users/jsp", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView result = new ModelAndView("usersView");
        List<User> users = usersService.getAll();
        result.addObject("usersModel", users);
        return result;
    }

    @RequestMapping(value = "/annotation/users/ftl", method = RequestMethod.GET)
    public String getAll(@ModelAttribute("model")ModelMap model) {
        List<User> users = usersService.getAll();
        model.addAttribute("usersModel", users);
        return "usersView";
    }
}
