package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCompileEx {
    public static void main(String[] args) {
        String text = "Java is cool";
        String patternText = ".*COOL";
        Pattern pattern = Pattern.compile(patternText, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);
        boolean isMatched = matcher.matches();

        System.out.println(isMatched);
    }
}
