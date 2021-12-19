## 동작 파라미터화 코드 전달하기. 

- 동작 파라미터화에서는 메서드 내부적으로 다양한 동작을 수행할 수 있도록 코드를 메서드 인수로 전달한다.
- 동작 파라미터화를 이용하면 변화하는 요구사항에 더 잘 대응할 수 있는 코드를 구현할 수 있으며 나중에 엔지니어링 비용을 줄일 수 있다.
- 자바 API의 많은 메서드는 정렬, 스레드, GUI 처러 등을 포함한 다양한 동작으로 파라미터화 할 수 있다 
- 코드 전달 기법을 이용하면 동작을 메서드의 인수로 전달할 수 있다. 하지만 자바 8 이전에는 코드를 지저분하게 구현해야 했다. 익명 클래스로도 어느 정도 코드를 깔끔하게 만들 수 있지만 자바 8에서는 인터페이스를 상속받아 여러 클래스를 구현해야 하는 수고를 없앨 수 있는 방법을 제공한다.

---

#### 동적 파타미터화를 이용하면 자주 바뀌는 요구사항에 효과적으로 대응할 수 있다. 

- 리스트의 모든 요소에 '어떤 동작'을 수행할 수 있음. 
- 리스트 관련 작업을 끝낸 다음에 '어떤 다른 동작'을 수행할 수 있음. 
- 에러가 발생하면 '정해진 어떤 다른 동작'을 수행할 수 있음. 


---

### 2.1 변화하는 요구사항에 대응하기. 

##### 2.1.1 첫 번째 시도 : 녹색 사과 필터링. 
 ```java
 public static List<Apple> filterGreenApples(List<Apple> inventory){
    List<Apple> result = new ArrayList<>(); 
    for(Apple apple : inventory){
         if("green".equals(apple.getColor()){
            result.add(apple);
         }
    
    }
    return result; 
 }
```


##### 2.1.2 두 번째 시도 : 색을 파라미터화 

```java
 public static List<Apple> filterGreenApples(List<Apple> inventory, String color){
    List<Apple> result = new ArrayList<>(); 
    for(Apple apple : inventory){
         if(apple.getColor().equals(color)){
            result.add(apple);
         }
    
    }
    return result; 
 }
```

##### 2.1.3 세 번째 시도 : 가능한 모든 속성을 필터링.<span style : color =  red> 실전에서 절대 사용하지 말자 </span>

x 다음은 만류에도 불구하고 모든 속성을 메서드 인수로 추가한 모습이다. 

```java
 public static List<Apple> filterGreenApples(List<Apple> inventory, String color, int weight, boolean flag ){
    List<Apple> result = new ArrayList<>(); 
    for(Apple apple : inventory){
         if((flag &&apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
            result.add(apple);
         }
    
    }
    return result; 
 }
```

<br><br>

---

### 2.2 동작 파라미터화 

##### 조건에 따라 filter 메서드가 다르게 동작할 수 있도록 전략 패턴 이용. 

##### 2.2.1 네 번째 시도 : 추상적 조건으로 필터링 
```jav
public interface ApplePredicate {
    boolean test (Apple apple);
}

public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return apple.getWeight() > 150; 
    }
}

public class AppleGreenColorPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return "green".equals(apple.getColor()); 
    }
}



public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p){
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory){
        if(p.test(apple){ // 프레디케이트 객체로 사과 검사 조건을 캡슐화 하였다. 
            result.add(apple);
        }
    }
    return result; 
}
```

<br><br>

### 2.3 복잡한 과정 간소화 

위의 ApplePredicate 인터페이스를 구현하는 여러 클래스를 정의한 다음에 인스턴스화해야 한다. 이는 상당한 번거로운 작업이며 시간 낭비다. 

이번에는 익명 클래스를 이용해보자. 익명 클래스를 이용하면 코드의 양을 줄일 수 있고, 익명 클래스가 모든 것을 해결 하는 것은 아니다. 

##### 2.3.2 다섯 번쨰 시도 : 익명 클래스 사용. 

다음은 익명 클래스를 이용해서 ApplePredicate를 구현하는 객체를 만드는 방법으로 필터링 예제를 다시 구현한 코드다.
```java
List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
    public boolean test(Apple apple){
        return "red".equals(apple.getColor());
    }
});

```

##### 2.3.3 여섯 번째 시도 : 람다 표현식 사용. 
```java
List<Apple> result = filterApples(inventory, (Apple apple) -> "red.equals(apple.getColor()));
```

##### 2.3.4 일곱 번째 시도 : 리스트 형식으로 추상화. 

현재 filterApples 는 Apple과 관련한 동작만 수행한다. 하지만 Apple 이외의 다양한 물건에서 필터링이 작동하도록 리스트 형식을 추상화할 수 있다. 
```java
public interface Predicate<T>{
    boolean test(T t);
}

public static <T> List<T> filter(List<T> list , Predicate<T> p){
    List<T> result = new ArrayList<>();
    for(T e : list){
        if(p.test(e){
        result.add(e);
        }
    }
    return result; 
}
```

```java
List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));

List<Apple> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0); 

```

<br><br>
  
  
> 이와 같은 패턴을 사용하면 자바 API의 많은 메섣를 다양한 동작으로 파라미터화할 수 있다. 또한 이들 메서드를 익명 클래스와 자주 사용하기도 한다. 
  
  
### 2.4 실전 에제. 
  
##### 2.4.1 Comparator 로 정렬하기. 
  
자바 8의 List에는 Sort 메서드가 포함되어 있다.(물론 Collections.sort도 존재한다.)  
```java
// java.util.Comparator
public interface Comparator<T>{
    pbulic int compare(T o1, T o2);
}
```

Comparator를 구현해 sort 메서드의 동작을 다양화할 수 있다.
```java
inventory.sort(new Comparator<Apple>(){
    public int compare(Apple a1, Apple a2){
        return a1.getWeight().compareTo(a2.getWeight());
    }
});
```

아래와 같이 람다 표현식을 사용해서 간단하게 구현할 수도 있다. 
```java
inventory.sort( (Apple a1, Apple a2) -> a2.getWeight().compareTo(a2.getWeight()));
```

##### 2.4.2 Runnable 로 코드 블록 실행하기. 
```java
public interface Runnable {
    public void run();
}

Thread t = new Thread(new Runnable){
    public void run(){
        System.out.println("Hello world");
    }
}


Thead t = new Thread(() -> System.out.println("Hello world"));
```
