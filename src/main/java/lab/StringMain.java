package lab;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMain {

    public static void main(String[] args) {

        String names = "Joe John Johnny";

        //rozdzielanie
        String[] namesArray = names.split(" ");
        System.out.println("names array " + Arrays.toString(namesArray));

        StringTokenizer tokenizer = new StringTokenizer(names);

        while(tokenizer.hasMoreTokens()){
            String name = tokenizer.nextToken();
            if(name.equalsIgnoreCase("John")) {
                System.out.println("there is John");
                break;
            }
        }

        // łączenie
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (String name : namesArray) {
            builder.append(name).append(",");
        }

        builder.append("]");
        System.out.println("join= " + builder.toString());

        // regexp
        String patternText ="\\d{2}[-\\s]?\\d{3}"; // szuka kod pocztowy dla "warszawa 00-950, krakow 30123, torun 88 123
        String text ="Warszawa 00-950, Krakow 30123, Torun 88 123";

        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("pattern " + matcher.group() + "found at " + matcher.start() + "-" + matcher.end());
        }

    }
}
