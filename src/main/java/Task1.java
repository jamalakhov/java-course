import java.util.Scanner;

// Задание 1.
// Вычислить n-ое треугольного число (сумма чисел от 1 до n),
// n! (произведение чисел от 1 до n)
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = scanner.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("n-ое треугольное число: " + triangularNumber);

        long factorial = calculateFactorial(n);
        System.out.println("n-факториал: " + factorial);
    }

    public static int calculateTriangularNumber(int n) {
        return (n * (n + 1)) / 2;
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        return factorial;
    }
}