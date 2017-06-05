package ru.itis.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Application - класс из JavaFX, наследуясь от него
// вы говорите, что ваш класс является главным "запускателем" приложения JavaFX
public class Main extends Application {
    public static void main(String[] args) {
        // запуск приложения - вызывает определенный ВАМИ метод start
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // объявляем загружатель fxml-файлов
        FXMLLoader loader = new FXMLLoader();
        // загружаем файл
        loader.setLocation(getClass().getResource("/views/mainWindow.fxml"));
        // создаем родительское окно
        Parent root = loader.load();
        // создаем стейдж
        primaryStage.setTitle("Hello");
        // кладем сцену с окном
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/list-view-style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
