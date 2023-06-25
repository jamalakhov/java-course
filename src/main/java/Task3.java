import java.util.Scanner;

// Задание 3.
// Реализовать простой калькулятор
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double number1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double number2 = scanner.nextDouble();

        System.out.print("Выберите операцию (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = number1 + number2;
                System.out.println("Результат: " + result);
                break;

            case '-':
                result = number1 - number2;
                System.out.println("Результат: " + result);
                break;

            case '*':
                result = number1 * number2;
                System.out.println("Результат: " + result);
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Деление на ноль невозможно.");
                }
                break;

            default:
                System.out.println("Неподдерживаемая операция.");
                break;
        }
    }
}