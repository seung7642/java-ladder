package nextstep.fp;

import java.util.List;
import java.util.function.Predicate;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumAll(numbers, i -> true);
    }

    public static int sumAll(List<Integer> numbers, Predicate<? super Integer> predicate) {
        return numbers.stream()
                .filter(predicate)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAll(numbers, i -> i % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAll(numbers, i -> i > 3);
    }
}
