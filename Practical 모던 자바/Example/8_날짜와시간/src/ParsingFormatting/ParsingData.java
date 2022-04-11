package ParsingFormatting;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
* DateTimeFormatter를 이용한 LocalDate 파싱 예제.
* */
public class ParsingData {

    public static void main(String[] args) {
        String year = "2019";
        String month = "03";
        String day = "14";
        String input = year + ' ' + month + ' ' + day;



        try{
            // 문자열을 이용한 날짜 시간 패턴 지정.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");

            // 파싱
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.printf("%s%n", date.toString());



        }catch(DateTimeParseException e){
            e.printStackTrace();
        }
    }

}
