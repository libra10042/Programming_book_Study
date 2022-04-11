package Java8_TimeDateApi;

import java.time.LocalDate;
import java.time.Month;

/*
* LocalDate 클래스 사용 예제
* */
public class LocalDateExample {

    public static void main(String[] args) {
        // 현재 날짜 객체를 생성
        LocalDate today = LocalDate.now();

        // 과거 날짜 객체를 생성
        LocalDate birthday = LocalDate.of(2019, Month.JANUARY, 1);

        // 과거 날짜 객체 정보를 수정
        LocalDate nextBDay = birthday.withYear(today.getYear());

        // 날짜 객체 비교, 생일이 지났는지 여부를 판단
        if(nextBDay.isBefore(today) || nextBDay.isEqual(today)){
            nextBDay = nextBDay.plusYears(1);
        }

    }

}
