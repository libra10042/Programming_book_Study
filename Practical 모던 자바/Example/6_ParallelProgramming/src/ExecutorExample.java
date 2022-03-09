import java.util.concurrent.Executor;

public class ExecutorExample implements Executor {

    // executer 메서드를 구한다.
    @Override
    public void execute(Runnable task){
        // 방법 1. Runnable 인터페이스를 직접 실행한다.
        task.run();

        // 방법 2. Thread를 생생허서 실행한다.
        // new Thread(task).start();
    }

    //Executor를 사용하는 예
    public static void main(String[] args) {
        Executor executor = new ExecutorExample();
        executor.execute(() -> System.out.println("Hello, Executor!!"));
    }


}
