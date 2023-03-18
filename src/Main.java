import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(8);
        testList.add(6);
        testList.add(20);
        testList.add(5);
        testList.add(11);

        Stream<Integer> testStream = testList.stream();

        Comparator<Integer> testComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        BiConsumer<Integer, Integer> minMaxConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                if (integer == null || integer2 == null) {
                    System.out.println("Стрим не содержит значений");
                } else {
                    System.out.println("Минимальное значение = " + integer + ", максимальное значение = "+integer2);
                }
            }
        };

        findMinMax(testStream, testComparator, minMaxConsumer);

        // Задание 2

        evenNumbers(testList);

    }

    public static<T> void findMinMax(Stream <? extends T> stream,
                                     Comparator <? super T> order,
                                     BiConsumer <? super T, ? super T> minMaxConsumer)
    {
        List<T> list = stream.collect(Collectors.toList());
        list.sort(order);
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void evenNumbers(List<Integer> num) {
        Predicate<Integer> evenNum = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2 == 0;
            }
        };
        num.stream().filter(evenNum).forEach(System.out::println);
    }

}