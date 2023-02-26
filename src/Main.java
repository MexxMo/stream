import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        List<Integer> integerList = List.of(100, 211, -101, 444, 555, 12, 1232, 441, 881, 10,51);
        findMinMax(integerList.stream(),
                Integer::compareTo,
                (x, y) -> System.out.println("Min number: " + x + "\nMax number: " + y));
        System.out.println("\nЗадание 2");
        evenNumbers(integerList);
    }


    private static <T> void findMinMax(Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.sorted(order).toList();
        minMaxConsumer.accept(
                list.stream().min(order).orElse(null),
                list.stream().max(order).orElse(null)
        );

    }

    private static void evenNumbers(List<Integer> integers) {
        System.out.println("Количество четных чисел: " + integers.stream()
                .filter(x -> x % 2 == 0)
                .peek(System.out::println)
                .count());
    }
}