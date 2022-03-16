package others;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ThreadLocalRandomExample {
    private int high;
    private int low;

    public ThreadLocalRandomExample(int low, int high){
        this.low = low;
        this.high= high;
    }
    // 자바 7일 때 ThreadLocalRandom 사용 방법
    public void generateRandom7(){
        System.out.println("Java 7 방식");
        for(int i=0; i<100; i++){
            System.out.println(ThreadLocalRandom.current().nextInt(low, high));
        }
    }

    // 자바 8 이상일 때 Stream을 이용한 ThreadLocalRandom 사용 방법
    public void generateRandom8(){
        System.out.println("java 8 방식");
        IntStream intStream = ThreadLocalRandom.current().ints(100, low, high);
        intStream.forEach((value -> System.out.println(value)));
    }

    public static void main(String[] args) {
        ThreadLocalRandomExample example = new ThreadLocalRandomExample(100, 1000);
        example.generateRandom7();
        example.generateRandom8();
    }


}
