public class TestMyCollection {

    public static void main(String[] args) {

        System.out.println("=== MyCollection (MyArrayList) ===");

        MyCollection<String> list = new MyArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Apple");  
        System.out.println("Size: " + list.size());
        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println("notEmpty: " + list.notEmpty());

        System.out.println("Contains 'Banana': " + list.contains("Banana"));
        System.out.println("Contains 'Mango':  " + list.contains("Mango"));

        System.out.print("Elements: ");
        for (String s : list) System.out.print(s + " ");
        System.out.println();

        list.remove("Apple");  
        System.out.println("After remove 'Apple', size: " + list.size());

        Object[] arr = list.toArray();
        System.out.print("toArray: ");
        for (Object o : arr) System.out.print(o + " ");
        System.out.println();

        MyCollection<String> other = new MyArrayList<>();
        other.add("Banana");
        other.add("Cherry");
        System.out.println("containsAll {Banana,Cherry}: " + list.containsAll(other));

        list.clear();
        System.out.println("After clear, isEmpty: " + list.isEmpty());
    }
}