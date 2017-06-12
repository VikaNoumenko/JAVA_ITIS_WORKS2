package ru.itis.vk.api;

import ru.itis.vk.api.models.Friend;

import java.util.List;

public interface VkApi {
    List<Friend> getUserFriends(int userId, int count, String ... fields);
}
