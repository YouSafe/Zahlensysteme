package at.yousif.numbersystems.utils;

import java.math.BigInteger;

/**
 * Created by YouSafe on 11.10.2016.
 */
public class Utils {

    /**
     * @param number in decimal system
     * @param basis  basis
     * @return number in basis system
     */
    public static String convertNumberSystem(BigInteger number, BigInteger basis) {
        String result = "";
        while (!number.toString().equals("0")) {
            result += Long.toHexString(number.mod(basis).longValue());
            number = number.divide(basis);
        }
        result = new StringBuilder(")" + result + "(").reverse().toString().toUpperCase() + subscript(basis.toString());
        return result;
    }

    /**
     * @param number inputnumber
     * @param basis  basis
     * @return calculation process
     */
    public static String outputString(BigInteger number, BigInteger basis) {
        StringBuilder builder = new StringBuilder();
        while (!number.toString().equals("0")) {
            long remainder = number.mod(basis).longValue();
            builder.append(number + ":" + basis + "\t\t" + "Rest " + remainder + "\n");
            number = number.divide(basis);
        }
        return builder.toString();
    }

    /**
     * @param str inputstring
     * @return subscript
     */

    private static String subscript(String str) {
        str = str.replaceAll("0", "₀");
        str = str.replaceAll("1", "₁");
        str = str.replaceAll("2", "₂");
        str = str.replaceAll("3", "₃");
        str = str.replaceAll("4", "₄");
        str = str.replaceAll("5", "₅");
        str = str.replaceAll("6", "₆");
        str = str.replaceAll("7", "₇");
        str = str.replaceAll("8", "₈");
        str = str.replaceAll("9", "₉");
        return str;
    }

}
