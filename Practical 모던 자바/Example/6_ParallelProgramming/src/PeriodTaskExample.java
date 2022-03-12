import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodTaskExample {

    // 일정 시간 간격으로 스레드를 실행하는 예
    public static void main(String[] args) {
        // ScheduledExecutorService 객체 생성
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        // 5초 후에 실행, 종료 후 10초 대기 반복 후 실행.
//        executorService.scheduleWithFixedDelay(new ExecutorServiceExample.MyTask("Delayed 1"), 5, 10, TimeUnit.SECONDS);

//        // 5초 후에 실행, 10초 주기로 반복 실행.
//        executorService.scheduleAtFixedRate(new ExecutorServiceExample.MyTask("Rate 1"), 5,10, TimeUnit.SECONDS);

//        // 5초 후에 실행, 10초 주기로 반복 실행.
        executorService.scheduleAtFixedRate(new ExecutorServiceExample.MyTask("RAate 2"), 5, 10, TimeUnit.SECONDS);


}
