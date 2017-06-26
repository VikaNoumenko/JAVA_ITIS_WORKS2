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
import ru.itis.models.FriendsResponse;
import ru.itis.models.GroupsResponse;


import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView listViewFriends;

    @FXML
    private Button buttonHello;

    @FXML
    TextField countTextField;

    @FXML
    TextField idTextField;

    @FXML
    public void initialize() {
        buttonHello.setOnAction(event -> {
            RestTemplate template = new RestTemplate();
            List<HttpMessageConverter<?>> converters = new ArrayList<>();
            converters.add(new MappingJackson2HttpMessageConverter());
            template.setMessageConverters(converters);
            String count = countTextField.getText();
            String id = idTextField.getText();
            //CitiesResponse response = template.getForObject("https://api.vk.com/method/database.getCities?country_id="
                          //  + count + "&count=300&need_all=true",
                   // CitiesResponse.class);
            FriendsResponse response = template.getForObject("https://api.vk.com/method/friends.get?user_id="
                     + id +"&count=" + count,
                    FriendsResponse.class);
//            GroupsResponse response = template.getForObject("https://api.vk.com/method/groups.get?id="
//                            + id +"&count=" + count,
//                    GroupsResponse.class);
            listViewFriends.getItems().clear();
//            listViewGroups.getItems().clear();
            for (int i = 0; i < response.getResponse().size(); i++){
                listViewFriends.getItems().addAll(response.getResponse()
                        .get(i).getFirst_name() + " "
                        + response.getResponse().get(i).getLast_name());
            }
        });
    }
}
