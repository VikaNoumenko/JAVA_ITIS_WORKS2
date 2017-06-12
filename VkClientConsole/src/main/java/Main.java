import ru.itis.vk.api.VkApi;
import ru.itis.vk.api.models.Friend;
import ru.itis.vk.client.tasks.LoadImagesTask;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// 176050764
// 4819022
import static ru.itis.vk.api.builders.VkApiBuilder.buildRestTemplate;
public class Main {
    public static void main(String[] args) throws Exception {
        VkApi vkApi = buildRestTemplate();
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            System.out.println("Hello!");
            System.out.println("Menu:");
            System.out.println("1. DownloadFriend");
            System.out.println("2. Exit");
            int command = scanner.nextInt();

            if (command == 2) {
                executorService.shutdownNow();
                return;
            } else if (command == 1) {
                System.out.println("Please enter userId:");
                int userId = scanner.nextInt();
                List<Friend> friends = vkApi.getUserFriends(userId, 1000,"city","photo_200_orig","sex");
                LoadImagesTask task = new LoadImagesTask("images/" + userId, friends);
                executorService.submit(task);
            }
        }
    }
}
