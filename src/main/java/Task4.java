//Задание 4.
// Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
public class Task4 {
    public static void main(String[] args) {
        solveEquation("2? + ?5 = 69");
    }

    public static void solveEquation(String equation) {
        String[] parts = equation.split(" = ");
        String leftPart = parts[0];
        String rightPart = parts[1];

        for (int q = 0; q <= 9; q++) {
            for (int w = 0; w <= 9; w++) {
                String modifiedLeftPart = replaceQuestionMarks(leftPart, q, w);
                String modifiedRightPart = replaceQuestionMarks(rightPart, q, w);

                int leftResult = evaluateExpression(modifiedLeftPart);
                int rightResult = evaluateExpression(modifiedRightPart);

                if (leftResult == rightResult) {
                    System.out.println("Решение найдено:");
                    System.out.println(modifiedLeftPart + " = " + modifiedRightPart);
                    return;
                }
            }
        }

        System.out.println("Решение не найдено.");
    }

    public static String replaceQuestionMarks(String expression, int q, int w) {
        String modifiedExpression = expression.replaceFirst("\\?", Integer.toString(q));
        modifiedExpression = modifiedExpression.replaceFirst("\\?", Integer.toString(w));
        return modifiedExpression;
    }

    public static int evaluateExpression(String expression) {
        String[] terms = expression.split(" \\+ ");
        int result = 0;

        for (String term : terms) {
            if (term.matches("\\d+")) {
                result += Integer.parseInt(term);
            }
        }

        return result;
    }
}