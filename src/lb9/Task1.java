package lb9;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomList(100, -1000, 1000);

        System.out.println("Початковий список: " + numbers);

        rearrangeList(numbers);

        System.out.println("Відсортований список: " + numbers);
    }

    private static List<Integer> generateRandomList(int size, int min, int max) {
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomList.add(random.nextInt(max - min + 1) + min);
        }

        return randomList;
    }

    private static void rearrangeList(List<Integer> list) {
        int positiveIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {

                int temp = list.get(i);
                list.remove(i);
                list.add(temp);
                i--;
            } else {

                list.add(positiveIndex, list.get(i));
                list.remove(i + 1);
                positiveIndex++;
            }
        }
    }
}
