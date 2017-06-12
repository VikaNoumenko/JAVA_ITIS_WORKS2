package ru.itis.vk.client.tasks;

import ru.itis.vk.api.models.Friend;
import ru.itis.vk.client.ImagesDownloader;

import java.util.List;

public class LoadImagesTask implements Runnable {

    private String folderName;
    private List<Friend> friends;
    public LoadImagesTask(String folderName, List<Friend> friends) {
        this.folderName = folderName;
        this.friends = friends;
    }

    @Override
    public void run() {
        ImagesDownloader downloader = new ImagesDownloader();
        downloader.downloadAll(folderName, friends);
    }
}
