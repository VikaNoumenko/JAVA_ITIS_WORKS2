package ru.itis;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Human marsel = new Human(23, "Marsel");
        Human marat = new Human(24, "Marat");
        Human denis = new Human(22, "Denis");
        Human vika = new Human(22, "Vika");
        Human ayaz = new Human(25, "Ayaz");
        Human artur = new Human(25, "Artur");
        Human kirill = new Human(25, "Kirill");
        Human robert = new Human(18, "Robert");

        HashMap<String, Human> map = new HashMap<>();

        map.put("Marsel", marsel);
        map.put("Marat", marat);
        map.put("Ayaz", ayaz);
        map.put("Vika", vika);
        map.put("Kirill", kirill);
        map.put("Robert", robert);
        map.put("Denis", denis);
        map.put("Artur", artur);

        int hashCode = "Marsel".hashCode();
        System.out.println(hashCode);
        hashCode = hashCode >>> 16; // делаем число положительным
        System.out.println(hashCode);
        hashCode = "Maratkas".hashCode() ^ hashCode;
        System.out.println(hashCode);
        int position = 100 & hashCode;
        System.out.println(position);
    }
}
