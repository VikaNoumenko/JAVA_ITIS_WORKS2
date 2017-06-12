package ru.itis.vk.client;

import ru.itis.vk.api.models.Friend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImagesDownloader {

    public void downloadAll(String folderName, List<Friend> friends) {
        try {
            download0(folderName, friends);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void download0(String folderName, List<Friend> friends) throws IOException {
        Files.createDirectory(Paths.get(folderName));
        for (Friend friend : friends) {
            if (!Thread.currentThread().isInterrupted()) {
                URL url = new URL(friend.getPhoto());
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                OutputStream outputStream = new FileOutputStream(folderName + "/" + friend.getUserId() + ".jpg");
                List<Byte> byteList = new ArrayList<>();
                int currentByte = inputStream.read();
                while (currentByte != -1) {
                    byteList.add((byte) currentByte);
                    currentByte = inputStream.read();
                }
                byte[] bytes = new byte[byteList.size()];

                int i = 0;
                for (byte imageByte : byteList) {
                    bytes[i] = imageByte;
                    i++;
                }
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
            }
        }
    }
}
