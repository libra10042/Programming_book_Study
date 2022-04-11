package ParsingFormatting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
* 날짜와 시간 객체를 DateTimeFormatter 를 이용해서 문자열로 변환하는 예제
* */
public class FormattingDateTime {

    public static void main(String[] args) {
        try{
            // 현재 날짜와 시간을 구한다.
            LocalDateTime dateTime = LocalDateTime.now();

            // 사용자 정의된 포맷을 정의한다.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatedDate = dateTime.format(formatter);
            System.out.printf("%s%n", formatedDate);
        }catch(DateTimeParseException e){
            e.printStackTrace();
        }
    }

}
