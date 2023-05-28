import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    //This class and the method below help us to read our .txt files.
    public String[] ReadFile(String path){
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line:Files.readAllLines(Paths.get(path))){
                results[i++]=line;
            }
            return results;                // results is an array which contains all lines in the file.
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
