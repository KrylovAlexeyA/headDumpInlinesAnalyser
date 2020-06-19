import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error, illegal number of arguments");
            return;
        }
        String pathToDump = args[0];
        String pathToCandidates = args[1];

        FileReader reader = new FileReader();
        Set<String> setOfCandidates = (Set<String>) reader.read(pathToCandidates, new HashSet<>());

        List<String> listOfLines = (List<String>) reader.read(pathToDump, new ArrayList<>());
        String total = listOfLines.get(listOfLines.size() - 1);
        Filter filter = new Filter();
        List<List<String>> classes = filter.filter(listOfLines, setOfCandidates);
        Calculator calculator = new Calculator();
        long gain = calculator.calculate(classes, total);
        System.out.println("Memory gain: " + gain + " bytes");
    }
}
