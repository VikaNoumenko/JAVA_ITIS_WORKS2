package ru.itis.hash;

/**
 * 29.04.2017
 * MainMaskingExample
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainMaskingExample {
    public static void main(String[] args) {
        // Получили на вход определенный хеш
        // по заданному хешу нужно определить место в массиве
        // куда мы положим данный ключ
        String marsel = "Marsel";
        int hashCode = marsel.hashCode();
        System.out.println(hashCode);
        // hashCode = -1997431204
        // теперь задача, по хеш-коду определить позицию в массиве
        // вариант - сделать битовую маску, значение битовой маски - размер "массив минус 1"
        // пусть массив длины 9, тогда маска имеет вид:
        // 9 - 1 = 8, сама маска - 1000
        int n = 9;
        int mask = n - 1;
        int position = hashCode & mask;
        System.out.println(position); // позиция восемь
        // почему? потому что:
        // -1997431204(10) -> 10001000111100011001111001011100(2)
        // 10001000111100011001111001011100
        //                             1000
        //---------------------------------
        //                             1000
        // при маске равной 1000, у нас всегда будет либо 1000, либо 0000
        // это очень плохо!!!
        // поэтому размер массива всегда должен быть степенью двойки
        // потому что тогда маска имеет вид 111..11

        // ВЫВОДЫ!
        // Размер массива - степень двойки
        // определение позиции - через маску и операцию конъюнкции
    }
}
