package src;

import java.util.Arrays;

public class ExempleExpresiiRegulate {
    public static void main(String[] args) {

        //1)
        // Exemple de utilizare a expresiilor regulate
        System.out.println("Java".matches("[A-Z][a-z]+")); // true
        System.out.println("123456".matches("[0-9]+")); // true
        System.out.println("0721234567".matches("(072|073)[0-9]{7}")); // true

        String s = "Aceasta   este  o  propozitie.".replaceAll("[ ]{2,}", " ");
        System.out.println(s); // "Aceasta este o propozitie."

        s = "Ea are o carte.".replaceAll("\\bare\\b", "avea");
        System.out.println(s); // "Ea avea o carte."

        s = "Hello World".replaceAll("[aeiouAEIOU]", "*");
        System.out.println(s); // "H*ll* W*rld"

        s = "Hello World".replaceFirst("[aeiouAEIOU]", "*");
        System.out.println(s); // "H*llo World"

        s = "Meeting".replaceAll("[aeiouAEIOU]{2,}", "*");
        System.out.println(s); // "M*ting"

        String[] w = "abc".split("");
        System.out.println(Arrays.toString(w)); // [a, b, c]

        w = "Hello, world! How are you?".split("[ .,:;!?]+");
        System.out.println(Arrays.toString(w)); // [Hello, world, How, are, you]

        w = "Text cu numere 123 și 456.".split("[^0-9]+");
        System.out.println(Arrays.toString(w)); // [, 123, 456]


        //2)
        // Operatiile specifice pentru stringul dat
        String text = "Odata creat un sir de caractere cu continutul sau nu mai poate fi modificat.";
        System.out.println(text.length()); // 76
        System.out.println(text.matches("[A-Za-z .]+")); // true
        String[] cuvinte = text.split("[ .,:;!?]+");
        int mijloc = cuvinte.length / 2;
        System.out.println(cuvinte[mijloc - 1]); // "cu"
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb.reverse().toString()); // ".tacifidom if etaop iam un uas lutunitnoc uc eretcarac ed ris nu taerc atadO"
    }
}
