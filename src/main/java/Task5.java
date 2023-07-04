import java.io.File;

// Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
//   1 Расширение файла: txt
//   2 Расширение файла: pdf
//   3 Расширение файла:
//   4 Расширение файла: jpg
public class Task5 {

    public static void main(String[] args) {
        File folder = new File("src/main/resources");
        File[] files = folder.listFiles();

        if (files != null) {
            int count = 1;
            for (File file : files) {
                if (file.isFile()) {
                    String extension = getFileExtension(file.getName());
                    System.out.println(count + " Расширение файла: " + extension);
                    count++;
                }
            }
        }
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1).toLowerCase();
        }
        return "";
    }
}