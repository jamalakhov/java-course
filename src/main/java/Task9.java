import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Пусть дан произвольный список целых чисел.
//
// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение
public class Task9 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        int arraySize = 7;
        List<Integer> arrInt = fillArr(arraySize);

        System.out.println(arrInt);

        int min = findMinimum(arrInt);
        System.out.println("Минимальное значение: " + min);

        int max = findMaximum(arrInt);
        System.out.println("Максимальное значение: " + max);

        double average = calculateAverage(arrInt);
        System.out.printf("Среднее значение: " + "%.2f\n", average);

        removeEvenNumbers(arrInt);

        System.out.println("\nПосле удаления чётных чисел\n" + arrInt);
    }

    private static List<Integer> fillArr(int arrSize) {
        List<Integer> arr = new ArrayList<>(arrSize);

        for (int i = 0; i < arrSize; i++) {
            arr.add(rand.nextInt(arrSize));
        }

        return arr;
    }

    private static void removeEvenNumbers(List<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
    }

    private static int findMinimum(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static int findMaximum(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double calculateAverage(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}