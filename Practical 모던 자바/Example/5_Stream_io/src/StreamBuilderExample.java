import java.util.stream.Stream;

public class StreamBuilderExample {

    // 스트림 빌더를 이용해서 스트림 객체를 생성하는 예
    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();

        builder.accept("1");
        builder.accept("2");
        builder.accept("3");
        builder.accept("4");
        builder.accept("5");
        builder.accept("6");
        builder.accept("7");
        builder.accept("8");
        builder.accept("9");
        builder.accept("0");
        builder.build().forEach(System.out::println);


        System.out.println("add   vs   accept");

        Stream.Builder<String> builder2  = Stream.builder();
        builder2.add("1")
                .add("2")
                .add("3")
                .add("4")
                .add("5")
                .add("6")
                .add("7")
                .add("8")
                .add("9")
                .add("0")
                .build()
                .forEach(System.out::println);



    }

}
