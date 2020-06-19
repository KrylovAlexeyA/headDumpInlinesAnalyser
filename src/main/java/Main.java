import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        String pathToDump = "/Users/krylovalexey/Desktop/histo2.data";
        String pathToCandidates = "/Users/krylovalexey/Desktop/inlines/candidates.txt";

        FileReader reader = new FileReader();
        Set<String> setOfCandidates = (Set<String>) reader.read(pathToCandidates, new HashSet<>());

        List<String> listOfLines = (List<String>) reader.read(pathToDump, new ArrayList<>());
        String total = listOfLines.get(listOfLines.size() - 1);
        Filter filter = new Filter();
        List<List<String>> classes = filter.filter(listOfLines, setOfCandidates);
        Calculator calculator = new Calculator();
        calculator.calculate(classes, total);
    }
}
