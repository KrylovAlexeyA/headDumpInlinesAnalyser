import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Filter {

    public List<List<String>> filter(List<String> listOfLines, Set<String> setOfCandidates) {
        listOfLines = listOfLines.stream().filter(s -> containsOne(s, setOfCandidates)).collect(Collectors.toList());
        List<List<String>> classes = new ArrayList<>();
        for (String str : listOfLines) {
            str.trim();
            List<String> splitted = Arrays.asList(str.split("\\s+")).stream().filter(s -> !s.isBlank()).collect(Collectors.toList());
            classes.add(splitted);
        }
        return classes;
    }

    private boolean containsOne(String str, Collection<String> collection) {
        for (String el : collection) {
            if (isContain(str, el)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContain(String source, String subItem) {
        String pattern = "\\b" + subItem + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
    }
}
