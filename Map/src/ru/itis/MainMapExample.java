package ru.itis;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 29.04.2017
 * MainMapExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainMapExample {

    public static void main(String[] args) {
        Human marsel = new Human(23, "Marsel");
        Human marat = new Human(24, "Marat");
        Human denis = new Human(22, "Denis");
        Human vika = new Human(22, "Vika");
        Human ayaz = new Human(25, "Ayaz");
        Human artur = new Human(25, "Artur");
        Human kirill = new Human(25, "Kirill");
        Human robert = new Human(18, "Robert");

        Map<String, Human> map = new HashMap<>();

        map.put("Marsel", marsel);
        map.put("Marat", marat);
        map.put("Ayaz", ayaz);
        map.put("Vika", vika);
        map.put("Kirill", kirill);
        map.put("Robert", robert);
        map.put("Denis", denis);
        map.put("Artur", artur);

        Human denisFromMap = map.get("Denis");

        Set<String> humanSet = map.keySet();
        Collection<Human> humen = map.values();

        Set<Map.Entry<String, Human>> entries = map.entrySet();

        for (Map.Entry<String, Human> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue().getAge());
        }

    }
}
