package ru.itis.vk.api.models;

import java.util.List;

public class FriendsResponse {
    private List<Friend> response;

    public FriendsResponse() {
    }

    public List<Friend> getResponse() {
        return response;
    }

    public void setResponse(List<Friend> response) {
        this.response = response;
    }
}
