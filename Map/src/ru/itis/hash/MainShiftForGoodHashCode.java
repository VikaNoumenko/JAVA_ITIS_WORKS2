package ru.itis.hash;

/**
 * 29.04.2017
 * MainShiftForGoodHashCode
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainShiftForGoodHashCode {
    public static void main(String[] args) {
        int hashCode = "Marsel".hashCode();
        System.out.println(hashCode);
        // 10001000111100011001111001011100
        int shiftedHashCode = hashCode >>> 16;
        System.out.println(shiftedHashCode);
        // 00000000000000001000100011110001
        int xoredHashCode = hashCode ^ shiftedHashCode;
        System.out.println(xoredHashCode);
        // 10001000111100010001011010101101
        // что нам дает xor?
        // вернуть старшие биты после сдвига
        // учесть влияние старших битов на позицию
    }
}
