import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы
public class Task10 {
    private static final Random rand = new Random();
    private static final List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");

    public static void main(String[] args) {
        int countPlanets = 12;
        List<String> randPlanets = getRandPlanets(countPlanets);

        System.out.println(randPlanets);

        int[] planetCount = planetsCounter(randPlanets);
        for (int i = 0; i < planetCount.length; i++) {
            System.out.printf("\n%s - %s", listPlanets.get(i), planetCount[i]);
        }

        deleteDuplicatePlanets(randPlanets, planetCount);
        System.out.println("\n\n" + randPlanets);
    }

    private static List<String> getRandPlanets(int countPlanets) {
        List<String> randPlanets = new ArrayList<>(countPlanets);

        for (int i = 0; i < countPlanets; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
        }

        return randPlanets;
    }

    private static int[] planetsCounter(List<String> planets) {
        int[] counts = new int[listPlanets.size()];

        for (String planet : planets) {
            counts[listPlanets.indexOf(planet)]++;
        }

        return counts;
    }

    private static void deleteDuplicatePlanets(List<String> planets, int[] planetCount) {
        for (int i = 0; i < planetCount.length; i++) {
            int count = planetCount[i];

            if (count > 1) {
                String planet = listPlanets.get(i);

                for (int j = 0; j < count - 1; j++) {
                    planets.remove(planet);
                }
            }
        }
    }
}