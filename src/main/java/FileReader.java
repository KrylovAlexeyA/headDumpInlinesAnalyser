import java.io.BufferedReader;
import java.util.Collection;
import java.util.Collections;

public class FileReader {

    public Collection<String> read(String path, Collection<String> collection) {
        try {
            BufferedReader bufReader = new BufferedReader(new java.io.FileReader(path));
            String line = bufReader.readLine();
            while (line != null) {
                collection.add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
            return collection;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
