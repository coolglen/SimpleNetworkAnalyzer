package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHandler {

    public static List<String> findAll(String string, String pattern){
        List<String> matches= new ArrayList<>();
        Matcher m = Pattern.compile("(?=(" + pattern + "))").matcher(string);
        while (m.find()){
            matches.add(m.group(1));
        }
        return matches;
    }
}
