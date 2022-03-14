import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InsuranceCalculator {
    public int calculatePrice(Map condition){
        // 기본 가격
        int price = 10000;

        // 보험료 계산하는 로직 대신 10초 대기하는 것으로 대체한다.
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch(Exception e){

        }

        //임의의 가격을 리턴한다.
        return price;
    }

    public static void main(String[] args) {
        InsuranceCalculator cal = new InsuranceCalculator();

        // 5회에 걸쳐 계산한다.
        for(int i=0; i<5; i++){
            System.out.printf("게산 차수 %s : %s\n", (i+1), cal.calculatePrice(null));
        }
    }

}
