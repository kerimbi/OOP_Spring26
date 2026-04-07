import java.util.Arrays;

public class TestSort {

    public static void main(String[] args) {

        System.out.println("=== Generic Sort ===");

        Chocolate[] chocs = {
            new Chocolate("Twix",    50.0),
            new Chocolate("Snickers", 52.7),
            new Chocolate("KitKat",  41.5),
            new Chocolate("Mars",    51.0),
            new Chocolate("Bounty",  57.0)
        };
        System.out.println("Before: " + Arrays.toString(chocs));
        Sort.bubbleSort(chocs);
        System.out.println("BubbleSort (by weight): " + Arrays.toString(chocs));

        Chocolate[] chocs2 = Arrays.copyOf(chocs, chocs.length);

        Sort.swap(chocs2, 0, 4);
        Sort.swap(chocs2, 1, 3);
        System.out.println("Shuffled: "  + Arrays.toString(chocs2));
        Sort.mergeSort(chocs2);
        System.out.println("MergeSort:  " + Arrays.toString(chocs2));

        System.out.println();

        Time[] times = {
            new Time(14, 30, 0),
            new Time(9,  0,  0),
            new Time(23, 59, 59),
            new Time(0,  0,  1),
            new Time(12, 0,  0)
        };
        System.out.println("Before: " + Arrays.toString(times));
        Sort.bubbleSort(times);
        System.out.println("BubbleSort: " + Arrays.toString(times));
        Sort.swap(times, 0, 4);
        Sort.mergeSort(times);
        System.out.println("MergeSort:  " + Arrays.toString(times));

        System.out.println();

        Employee[] emps = {
            new Employee("Zoe",   80000),
            new Employee("Alice", 60000),
            new Employee("Bob",   75000),
            new Employee("Eve",   55000)
        };
        System.out.println("Before: " + Arrays.toString(emps));
        Sort.bubbleSort(emps);
        System.out.println("BubbleSort (by salary): " + Arrays.toString(emps));
        Sort.swap(emps, 0, 3);
        Sort.mergeSort(emps);
        System.out.println("MergeSort (by salary):  " + Arrays.toString(emps));

        System.out.println();

        System.out.println("--- swap test ---");
        String[] words = { "hello", "world" };
        System.out.println("Before swap: " + Arrays.toString(words));
        Sort.swap(words, 0, 1);
        System.out.println("After swap:  " + Arrays.toString(words));
    }
}