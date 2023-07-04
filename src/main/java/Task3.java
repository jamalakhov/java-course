import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Задание 3.
// Реализовать простой калькулятор
// Добавить логирование
public class Task3 {
    private static final Logger logger = Logger.getLogger(Task3.class.getName());
    private static final String LOG_CALCULATOR = "calculator_log.txt";

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler(LOG_CALCULATOR);
        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double number1 = scanner.nextDouble();
        logger.info("entered number: " + number1);

        System.out.print("Введите второе число: ");
        double number2 = scanner.nextDouble();
        logger.info("entered number: " + number2);

        System.out.print("Выберите операцию (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        logger.info("operator selected: " + operator);

        double result;
        String message;

        switch (operator) {
            case '+':
                result = number1 + number2;
                message = "Результат: " + result;
                System.out.println(message);
                logger.info(message);
                break;

            case '-':
                result = number1 - number2;
                message = "Результат: " + result;
                System.out.println(message);
                logger.info(message);
                break;

            case '*':
                result = number1 * number2;
                message = "Результат: " + result;
                System.out.println(message);
                logger.info(message);
                break;

            case '/':
                if (number2 != 0) {
                    result = number1 / number2;
                    message = "Результат: " + result;
                    System.out.println(message);
                    logger.info(message);
                } else {
                    message = "Деление на ноль невозможно.";
                    System.out.println(message);
                    logger.log(Level.WARNING, message);
                }
                break;

            default:
                message = "Неподдерживаемая операция.";
                System.out.println(message);
                logger.log(Level.WARNING, message);
                break;
        }
    }
}