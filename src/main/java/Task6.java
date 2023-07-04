import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class Task6 {
    private static final Logger logger = Logger.getLogger(Task6.class.getName());
    private static final String LOG_FILE_NAME = "bubble_sort_log.txt";

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler(LOG_FILE_NAME);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int[] array = {5, 3, 8, 1, 2};
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        try {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }

                logger.info("Iteration " + (i + 1) + ": " + Arrays.toString(array));

                if (!swapped) {
                    break;
                }
            }

            System.out.println("Сортировка завершена. Результат сохранен в " + LOG_FILE_NAME);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}