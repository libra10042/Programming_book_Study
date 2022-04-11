package ParsingFormatting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/*
* DateTimeFormatter 를 이용한 사용자 지정 패턴 정의 예제
* */
public class CustomDateFormat {

    // 사용자 날짜 패턴 정의
    public static final DateTimeFormatter KR_LOCAL_DATE;

    static {
        KR_LOCAL_DATE = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .toFormatter();
    }

    // 사용자 시간 패턴 정의
    public static final DateTimeFormatter KR_LOCAL_TIME;

    static {
        KR_LOCAL_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(ChronoField.NANO_OF_DAY)
                .appendLiteral(":")
                .appendText(ChronoField.MINUTE_OF_HOUR)
                .appendLiteral(":")
                .appendText(ChronoField.SECOND_OF_MINUTE)
                .toFormatter();
    }

    // 날짜 패턴과 시간 패턴을 조합해서 날짜 시간 패턴 정의
    public static final DateTimeFormatter KR_LOCAL_DATE_TIME;
    static {
        KR_LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(KR_LOCAL_DATE)
                .appendLiteral(' ')
                .append(KR_LOCAL_TIME)
                .toFormatter();
    }

    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.printf("날짜 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_DATE));

        System.out.printf("시간 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_TIME));
        System.out.printf("날짜/시간 : %s\n", currentDateTime.format(CustomDateFormat.KR_LOCAL_DATE_TIME));

    }

}
