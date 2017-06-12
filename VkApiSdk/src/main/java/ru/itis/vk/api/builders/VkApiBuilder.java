package ru.itis.vk.api.builders;


import ru.itis.vk.api.VkApi;
import ru.itis.vk.api.VkApiRestTemplateImpl;

public class VkApiBuilder {
    public static VkApi buildRestTemplate() {
        return new VkApiRestTemplateImpl();
    }
}
