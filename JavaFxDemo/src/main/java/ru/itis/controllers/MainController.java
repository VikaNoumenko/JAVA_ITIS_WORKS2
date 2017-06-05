package ru.itis.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.itis.models.CitiesResponse;


import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView listViewCities;

    @FXML
    private Button buttonHello;

    @FXML
    TextField countTextField;

    @FXML
    public void initialize() {
        buttonHello.setOnAction(event -> {
            RestTemplate template = new RestTemplate();
            List<HttpMessageConverter<?>> converters = new ArrayList<>();
            converters.add(new MappingJackson2HttpMessageConverter());
            template.setMessageConverters(converters);
            String count = countTextField.getText();
            CitiesResponse response = template.getForObject("https://api.vk.com/method/database.getCities?country_id="
                            + count + "&count=300&need_all=true",
                    CitiesResponse.class);
            listViewCities.getItems().clear();
            for (int i = 0; i < response.getResponse().size(); i++){
                listViewCities.getItems().addAll(response.getResponse().get(i).getTitle());
            }
        });
    }
}
