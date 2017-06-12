package ru.itis.vk.api;


import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itis.vk.api.models.Friend;
import ru.itis.vk.api.models.FriendsResponse;

import java.util.List;

public class VkApiRestTemplateImpl implements VkApi {

    private final String FRIENDS_GET_URL = "https://api.vk.com/method/friends.get";

    private RestTemplate template;

    public VkApiRestTemplateImpl() {
        this.template = new RestTemplate();
    }

    public List<Friend> getUserFriends(int userId, int count, String... fields) {
        StringBuilder fieldsStringBuilder = new StringBuilder();

        for (String field : fields) {
            fieldsStringBuilder.append(field).append(",");
        }

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(FRIENDS_GET_URL)
                .queryParam("user_id", userId)
                .queryParam("count", count)
                .queryParam("fields", fieldsStringBuilder);

        String expandUrl = uriComponentsBuilder.toUriString();

        FriendsResponse response = template.getForObject(expandUrl, FriendsResponse.class);
        return response.getResponse();
    }
}
