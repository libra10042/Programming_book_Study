package example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Menu_Mapping {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 800, Dish.Type.MEAT),
                new Dish("rice", false, 800, Dish.Type.MEAT),
                new Dish("season", false, 800, Dish.Type.MEAT),
                new Dish("pizza", false, 800, Dish.Type.MEAT),
                new Dish("prawns", false, 800, Dish.Type.MEAT),
                new Dish("salmon", false, 800, Dish.Type.MEAT)
        );

        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());

        System.out.println(dishNames);

        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                                    .map(String::length)
                                    .collect(toList());

        System.out.println(wordLengths);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        System.out.println(dishNameLengths);



        // 스트림 평면화
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);


        // map과 Arrays.stream 활용
        String[] arrayOfWords = {"GoodBye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        streamOfWords
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::println);





        // flatMap 사용
        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        // 제곱근 리스트 반환.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(toList());
        System.out.println(squares);

        // 숫자 쌍의 리스트 반환
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println(pairs);


        // 합이 3으로 나누어떨어지는 쌍만 반환
        List<Integer> numbers3 = Arrays.asList(1,2,3);
        List<Integer> numbers4 = Arrays.asList(3,4);

        List<int[]> pairs2 = numbers3.stream()
                .flatMap(i -> numbers4.stream().filter(j -> (i + j) % 3 ==0).map(j -> new int[]{i, j}))
                .collect(toList());

        System.out.println(pairs2);


    }
}