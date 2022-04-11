package Java8_TimeApi;

import java.time.LocalDateTime;
import java.time.Month;

/*
*   LocalDateTime 을 이용한 날짜 시간 처리 예제
* */
public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.printf("현재 : %s%n", localDateTime);


        System.out.printf("생일 : %s%n", LocalDateTime.of(2001, Month.MAY, 29, 16, 33));


        // 날짜 이후, 이전
        System.out.printf("1달 후 : %s%n", localDateTime.plusMonths(6));
        System.out.printf("1달 전 : %s%n", localDateTime.minusMonths(6));
    }

}
