import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
public class Task11 {

    public static void main(String[] args) {
        Deque<Integer> number1 = new LinkedList<>(Arrays.asList(0, 2, 1));
        Deque<Integer> number2 = new LinkedList<>(Arrays.asList(5, 4, 3));

        Deque<Integer> product = multiplyNumbers(number1, number2);
        System.out.println("Произведение: " + product);

        Deque<Integer> sum = addNumbers(number1, number2);
        System.out.println("Сумма: " + sum);
    }

    private static Deque<Integer> multiplyNumbers(Deque<Integer> number1, Deque<Integer> number2) {
        Deque<Integer> product = new LinkedList<>();
        int size1 = number1.size();
        int size2 = number2.size();

        if (size1 == 0 || size2 == 0) {
            product.addLast(0);
            return product;
        }

        int[] result = new int[size1 + size2];

        int carry;
        int index = 0;

        for (int digit1 : number1) {
            int tempIndex = index;
            carry = 0;

            for (int digit2 : number2) {
                int mul = (digit1 * digit2) + result[tempIndex] + carry;
                carry = mul / 10;
                result[tempIndex] = mul % 10;
                tempIndex++;
            }

            if (carry > 0) {
                result[tempIndex] += carry;
            }

            index++;
        }

        for (int digit : result) {
            product.addFirst(digit);
        }

        while (product.size() > 1 && product.peekFirst() == 0) {
            product.removeFirst();
        }

        return product;
    }

    private static Deque<Integer> addNumbers(Deque<Integer> number1, Deque<Integer> number2) {
        Deque<Integer> sum = new LinkedList<>();
        int carry = 0;
        int sign = 1;

        while (!number1.isEmpty() || !number2.isEmpty() || carry != 0) {
            int digit1 = number1.isEmpty() ? 0 : number1.removeFirst();
            int digit2 = number2.isEmpty() ? 0 : number2.removeFirst();

            int sumDigit = (digit1 * sign) + (digit2 * sign) + carry;
            int remainder = Math.abs(sumDigit) % 10;

            sum.addFirst(remainder);
            carry = sumDigit / 10;

        }

        return sum;
    }
}