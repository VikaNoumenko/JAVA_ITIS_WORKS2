package ru.itis.controllers.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.models.Auto;
import ru.itis.services.AutoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AutosController implements Controller {

    @Autowired
    private AutoService autoService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        if (httpServletRequest.getMethod().equals("GET")) {
            ModelAndView result = new ModelAndView("autosView");
            List<Auto> autos = autoService.getAllAuto();
            result.addObject("autos", autos);
            return result;
        } throw new IllegalArgumentException("BAD REQUEST");
    }
}
