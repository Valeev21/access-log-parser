import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int count = 0;
//        while (true) {
//            String path = sc.nextLine();
//            File file = new File(path);
//            boolean fileExists = file.exists();
//            boolean isDirectory = file.isDirectory();
//            if (!fileExists) {
//                System.out.println("Такого файла нет");
//                continue;
//            }
//            if (isDirectory) {
//                System.out.println("Указана папка, а не файл");
//                continue;
//            }
//            count++;
//            System.out.println("Это файл номер:" + count);
//        }

        BotQueryTask bot = new BotQueryTask();
        bot.execute("D:\\_git\\access-log-parser\\src\\access.log");


    }
}
