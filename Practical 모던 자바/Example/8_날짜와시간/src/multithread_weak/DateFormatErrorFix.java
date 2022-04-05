package multithread_weak;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/*
* SimpleDateFormat 사용 시 에러가 발생하지 않도록 수정한 예제.
* */
public class DateFormatErrorFix {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 필요할 때 마다 생성한다.
        Callable<Date> task = () -> new SimpleDateFormat("yyyyMMdd").parse("20101022");

        // 스레드 풀 5개 생성
        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Future<Date>> results = new ArrayList<Future<Date>>();


        // 5개의 스레드에서 동시 처리
        for(int i=0; i<100; i++){
            results.add(exec.submit(task));
        }
        exec.shutdown();

        // 정상 처리
        for(Future<Date> result : results){
            System.out.println(result.get());
        }

    }

}
