import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Task7 {
    private static final String JSON = "src/main/resources/test.json";

    public static void main(String[] args) {
        String jsonString = getJsonFile();
        parseAndPrint(jsonString);
    }

    private static void parseAndPrint(String jsonString) {
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);

            for (Object obj : jsonArray) {
                JSONObject jsonObj = (JSONObject) obj;

                String lastName = (String) jsonObj.get("фамилия");
                long grade = (Long) jsonObj.get("оценка");
                String schoolSubject = (String) jsonObj.get("предмет");

                StringBuilder sb = new StringBuilder();
                sb.append("Студент ").append(lastName)
                        .append(" получил ").append(grade)
                        .append(" по предмету ").append(schoolSubject)
                        .append(".");
                System.out.println(sb);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(JSON));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}