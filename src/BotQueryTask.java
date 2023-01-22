import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BotQueryTask {
    public static final String YANDEX_BOT = "YandexBot";
    public static final String GOOGLE_BOT = "Googlebot";
    public static final int MAX_LINE_LENGTH = 1024;

    public void execute(String path) {
        if(!isCorrectPath(path)){
            System.out.println("Не корректный путь к файлу");
            return;
        }
        int yandexBotCount = 0;
        int googleBotCount = 0;
        int allLineCount = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                int length = line.length();
                if (length > MAX_LINE_LENGTH) {
                    throw new TooLongStringException("Длина строки больше " + MAX_LINE_LENGTH);
                }
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    String fragment = parts[1];
                    String botName = fragment.trim().split("/")[0];
                    if (YANDEX_BOT.equals(botName)) {
                        yandexBotCount++;
                    }
                    if (GOOGLE_BOT.equals(botName)) {
                        googleBotCount++;
                    }
                }

                allLineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All: " + allLineCount);
        System.out.println("Google Bot: " + 1.0 * googleBotCount / allLineCount);
        System.out.println("Yandex Bot: " + 1.0 * yandexBotCount / allLineCount);
    }

    private boolean isCorrectPath(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path) && Files.isRegularFile(path);
    }
}
