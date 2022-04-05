package Java8_TimeApi;

import java.time.Clock;
import java.time.Month;

/*
* 숫자를 월로 표현하기 위한 예제
* */
public class MonthEnum {
    public static void main(String[] args) {
        System.out.println("Month.FEBRUARY의 값은 " + Month.FEBRUARY);

        // 숫자 2에 해당하는 월 객체를 생성
        Month february = Month.of(2);
        System.out.println("Month.of(2)의 값은 " + february);

        System.out.println("비교 " + february.equals(Month.FEBRUARY));
    }
}
