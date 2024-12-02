import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {

    public static void main(String[] args) {
        int numOperations = 100000; // Количество операций для тестирования

        testListPerformance(new ArrayList<>(), "ArrayList", numOperations);

        testListPerformance(new LinkedList<>(), "LinkedList", numOperations);
    }

    private static void testListPerformance(List<Integer> list, String listType, int numOperations) {
        long addTime = testAdd(list, numOperations);
        long getTime = testGet(list, numOperations);
        long removeTime = testRemove(list, numOperations);

        System.out.printf("%s Performance:\n", listType);
        System.out.printf("Add operations: %d, Time: %d ms\n", numOperations, addTime);
        System.out.printf("Get operations: %d, Time: %d ms\n", numOperations, getTime);
        System.out.printf("Remove operations: %d, Time: %d ms\n", numOperations, removeTime);
        System.out.println();
    }

    private static long testAdd(List<Integer> list, int numOperations) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testGet(List<Integer> list, int numOperations) {
        // Заполняем список перед тестированием get
        for (int i = 0; i < numOperations; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testRemove(List<Integer> list, int numOperations) {
        // Заполняем список перед тестированием remove
        for (int i = 0; i < numOperations; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            list.remove(0); // Удаляем первый элемент
        }
        return System.currentTimeMillis() - startTime;
    }
}
