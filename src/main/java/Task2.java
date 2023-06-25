// Задание 2.
// Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000:");
        for (int number = 2; number <= 1000; number++) {
            if (isPrime(number)) {
                System.out.print(number + "\n");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}