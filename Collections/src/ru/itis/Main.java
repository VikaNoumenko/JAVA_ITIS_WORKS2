package ru.itis;

import ru.itis.lists.LinkedList;
import ru.itis.lists.List;
import ru.itis.models.Human;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        List<Human> humanLinkedList =
                new LinkedList<>();

        Human marsel = new Human(1, "M", 23);
        Human farid = new Human(2, "F", 28);
        Human marat = new Human(3, "M", 24);
        Human ayvar = new Human(4, "A", 24);
        Human victoriya = new Human(5, "V", 22);

        humanLinkedList.add(marsel);
        humanLinkedList.add(farid);
        humanLinkedList.add(marat);
        humanLinkedList.add(ayvar);
        humanLinkedList.add(victoriya);
        humanLinkedList.removeByIndex(3);
        humanLinkedList.delete(victoriya);


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
