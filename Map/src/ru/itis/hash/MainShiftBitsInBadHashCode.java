package ru.itis.hash;

/**
 * 29.04.2017
 * MainShiftBitsInBadHashCode
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainShiftBitsInBadHashCode {
    public static void main(String[] args) {
        Double a = 6.0;
        Double b = 7.0;

        int aHashCode = a.hashCode();
        int bHashCode = b.hashCode();

        System.out.println(aHashCode);
        // 1000000000110000000000000000000
        System.out.println(bHashCode);
        // 1000000000111000000000000000000

        int aPosition = aHashCode & (8 - 1);
        int bPosition = bHashCode & (8 - 1);
        System.out.println(aPosition);
        System.out.println(bPosition);

        // Пусть массив имеет размер 8, тогда маска имеет вид
        // 111
        // пока у вас размер массива не 20, у вас всегда маска 0

        // что делать? надо использовать старшие разряды
        // делаем сдвиг левой половины битов
        int newAHashCode = aHashCode >>> 16;
        int newBHashCode = bHashCode >>> 16;
        System.out.println(newAHashCode);
        // 0000000000000000 0100000000011000
        System.out.println(newBHashCode);
        // 0000000000000000 0100000000011100
        aPosition = newAHashCode & (32 - 1);
        bPosition = newBHashCode & (32 - 1);

        System.out.println(aPosition);
        System.out.println(bPosition);

        int xoredAHashCode = newAHashCode ^ aHashCode;
        int xoredBHashCode = newBHashCode ^ bHashCode;

        System.out.println(xoredAHashCode);
        System.out.println(xoredBHashCode);

        aPosition = xoredAHashCode & (32 - 1);
        bPosition = xoredBHashCode & (32 - 1);

        System.out.println(aPosition);
        System.out.println(bPosition);
    }
}