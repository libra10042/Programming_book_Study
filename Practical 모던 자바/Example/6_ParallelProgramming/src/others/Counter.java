package others;
// 이 소드는 멀티 스레드에서 접근하는 요청에 대한 정합성 확보가 어렵다.
public class Counter {
    private int c = 0;

    public void increment(){
        c++;
    }

    public void decrement(){
        c--;
    }

    public int value(){
        return c;
    }
}
