package Java8_TimeApi;

import java.time.LocalTime;

/*
* LocalTime 사용 예제
* */
public class LocalTimeExample {
    public static void main(String[] args) {
        // 현재 기준으로 시간 정보를 생성한다.
        LocalTime localTime = LocalTime.now();
        System.out.println("현재 시간 : " + localTime);


        // 시간 추가
        System.out.println("시 추가 : " + localTime.plusHours(1));
        System.out.println("분 추가 : " + localTime.plusMinutes(1));
        System.out.println("초 추가 : " + localTime.plusSeconds(1));
        System.out.println("나노 추가 : " + localTime.plusNanos(1));


        // 시간 제거
        System.out.println("시 제거 : " + localTime.minusHours(1));
        System.out.println("분 제거 : " + localTime.minusMinutes(1));
        System.out.println("초 제거 : " + localTime.minusSeconds(1));
        System.out.println("나노 제거 : " + localTime.minusNanos(1));
    }

}
