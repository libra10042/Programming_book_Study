import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    // ExecutorService 사용 예
    public static void main(String[] args) {
        // ExcutorService 객체를 생성한다.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Thread를 생헝하고 실행시킨다.
        executorService.execute(new MyTask("TODO 1"));
        executorService.execute(new MyTask("TODO 2"));
        executorService.execute(new MyTask("TODO 3"));
        // ExecutorService를 종료시킨다.
        executorService.shutdown();
    }


    // Runnable 을 상송한 태스크를 정의한다.
    static class MyTask implements Runnable {
        private String id;

        @Override
        public void run(){
            for(int i=0; i<5; i++){
                System.out.println("Task ID : " + id +  ", running... " + i);

                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        public MyTask(String id) {
            this.id = id;
        }
    }

}
