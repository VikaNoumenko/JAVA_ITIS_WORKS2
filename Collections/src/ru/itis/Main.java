package ru.itis;

import ru.itis.lists.LinkedList;
import ru.itis.lists.List;
import ru.itis.models.Human;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        List<Human> humanLinkedList =
                new LinkedList<>();

        Human marsel = new Human(1, "Marsel", 23);
        Human farid = new Human(2, "Farid", 28);
        Human marat = new Human(3, "Marat", 24);
        Human ayvar = new Human(4, "Ayvar", 24);
        Human victoriya = new Human(5, "Victoriya", 22);

        humanLinkedList.add(marsel);
        humanLinkedList.add(farid);
        humanLinkedList.add(marat);
        humanLinkedList.add(ayvar);
        humanLinkedList.add(victoriya);


//        for (int i = 0; i < humanLinkedList.size(); i++) {
//            System.out.println(humanLinkedList.get(i));
//        }

        Iterator<Human> humanIterator = humanLinkedList.iterator();

        while (humanIterator.hasNext()) {
            System.out.println(humanIterator.next());
        }

//        for (Human human : humanLinkedList) {
//            System.out.println(human);
//        }
    }
}
