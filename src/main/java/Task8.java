import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Task8 {
    private static final String STUDENT_JSON = "src/main/resources/student.json";

    public static void main(String[] args) throws ParseException {
        String jsonParams = getJsonFile();
        String whereClause = buildWhereClause(jsonParams);
        System.out.println(whereClause);
    }

    private static String buildWhereClause(String jsonParams) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(jsonParams);
        StringBuilder builder = new StringBuilder();

        for (Object obj : jsonArray) {
            StringBuilder whereClauseBuilder = new StringBuilder("select * from students where ");

            JSONObject jsonObj = (JSONObject) obj;

            for (Object key : jsonObj.keySet()) {
                String param = (String) key;
                var value = jsonObj.get(param);

                if (value != null) {
                    whereClauseBuilder.append(param).append(" = '").append(value).append("' AND ");
                }
            }

            if (whereClauseBuilder.length() > "select * from students where ".length()) {
                whereClauseBuilder.delete(whereClauseBuilder.length() - " AND ".length(), whereClauseBuilder.length());
            }

            builder.append(whereClauseBuilder).append("\n");
        }

        return builder.toString();
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDENT_JSON));
            lines.forEach(builder::append);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}