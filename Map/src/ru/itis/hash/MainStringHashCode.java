package ru.itis.hash;

/**
 * 29.04.2017
 * MainStringHashCode
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainStringHashCode {
    public static int hashCode(String string) {
        char value[] = string.toCharArray();
        int h = 0;

        /*
        h1 = value[0]
        h2 = value[0] * 31 + value[1]
        h3 = (value[0] * 31 + value[1]) * 31 + value[2]
        h4 = ((value[0] * 31 +value[1]) * 31 + value[2])*31 + value[3]


        h4 = (value[0] * 31 * 31 + value[1] * 31 + value[2]) * 31 + value[3] = value[0] * 31 * 31 * 31 + value[1] * 31 * 31 + value[2]*31 + value[3] =

        value[0] * 31^3 + value[1] * 31^2 + value[2]*31^1 + value[3]*31^0
        SUM value[i] * 31 ^ (n - 1 - i)
         */

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + value[i];
        }
        return h;
    }

    public static void main(String[] args) {
        String marsel = "Marsel";

        int h = hashCode(marsel);
    }
}
