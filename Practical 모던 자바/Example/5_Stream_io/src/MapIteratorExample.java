import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorExample {

    // MAP 인터페이스의 forEach 메서드의 사용 예
    public static void main(String[] args) {
        Map<String, Person2> map = new HashMap<>();
        map.put("1", new Person2("장윤기", "45"));
        map.put("1", new Person2("장윤기", "45"));
        map.put("1", new Person2("장윤기", "45"));
        map.put("1", new Person2("장윤기", "45"));
        map.put("1", new Person2("장윤기", "45"));
        map.put("1", new Person2("장윤기", "45"));


        // Iterator 를 이용해서 처리
        System.out.println("##### Iterator 방식");
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            System.out.println(String.format("Key: %s, Value : %s", key, map.get(key)));
        }

        // Map의 Entry 을 이용해서 처리
        System.out.println("#### Map Entry 방식 ");
        for(Map.Entry<String, Person2>elment : map.entrySet()){
            System.out.println(String.format("key : %s, Value : %s", elment.getKey(), elment.getValue()));
        }


        // Map의 KeySet을 이용해서 처리
        System.out.println("#### Key Set 방식");
        for(String key : map.keySet()){
            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
        }


        // forEach 이용 자바 8이상
        System.out.println("#### forEach 방식");
        map.forEach((key, value) -> {
                String.format("key : %s, Value : %s", key, value);
        });




    }

}
