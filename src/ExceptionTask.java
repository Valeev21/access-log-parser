import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptionTask {
    public static final int MAX_LINE_LENGTH = 1024;
    public void execute(String path) {
        if(!isCorrectPath(path)){
            System.out.println("Не корректный путь к файлу");
            return;
        }
        int allLineCount = 0;
        int shortestLineLength = MAX_LINE_LENGTH;
        int longestLineLength = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                if(length > MAX_LINE_LENGTH){
                    throw new TooLongStringException("Длина строки больше " + MAX_LINE_LENGTH);
                }
                if (length > longestLineLength) {
                    longestLineLength = length;
                }
                if(length < shortestLineLength){
                    shortestLineLength = length;
                }
                allLineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(allLineCount == 0 ? 0 : shortestLineLength);
        System.out.println(longestLineLength);
        System.out.println(allLineCount);

    }

    private boolean isCorrectPath(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path) && Files.isRegularFile(path);
    }
}
