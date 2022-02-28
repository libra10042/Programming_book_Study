import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Exam1 {

    public static void main(String[] args) {
        Integer[] intArray = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        List numberList = Arrays.asList(intArray);


        // 방법1. index를 이용한 리스트 처리.
        for(int i=0; i<numberList.size(); i++){
            System.out.print(numberList.get(i) + " ");
        }


        // 방법2. Iterator : Iterator 객체를 생성하고 for 루프를 구현해야 하기 때문에 번거롭다.
        for(Iterator iter = numberList.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }


        // 방법3.for each 구문 활용 : 제네릭을 활용하여 list를 출력.
        for(Object intValue : numberList){
            System.out.println(intValue);
        }

        //방법4. 스트림 API
        numberList.forEach(System.out::println);




    }
}
