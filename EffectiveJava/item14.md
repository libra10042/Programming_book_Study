### 클래스와 멤버의 접근 권한을 최소화하라. 

--- 

어설프게 설계된 컴포넌트와 잘 설계된 컴포넌트의 가장 큰 차이는 바로 클래스 내부 데이터와 내부 구현 정보를 외부 컴포넌트로부터 얼마나 잘 숨겼느냐다. 
잘 설계된 컴포넌트는 모든 내부 구현을 완벽히 숨겨, 구현과 API를 까끔하게 분리한다.
( 오직 API를 통해서만 다른 컴포넌트와 소통하며 서로의 내부 동작 방식에는 전혀 개의치 않는다. ) 


##### 정보 은닉의 장점. 
- 시스템 개발 속도를 높인다.여러 컴포넌트를 병렬로 개발할 수 있기 떄문이다. 
- 시스템 관리 비용을 낮춘다. 각 컴포넌트를 더 빨리 파악하여 디버깅할 수 있고, 다른 컴포넌트 교체하는 부담도 적기 때문이다.
- 정보 은닉 자체가 성능을 높여주지는 않지만, 성능 최적화에 도움을 준다.
- 소프트웨어 재사용성을 높인다.  외부적에 거의 의존하지 않고 독자적으로 동작할 수 있는 컴포넌트라면 그 컴포넌트와 함께 개발되지 않은 낯선 환경에서도 유용한게 쓰일 가능성이 크다.
-


> 각 요소의 접근성은 그 요소가 선언된 위치와 접근 제한자(private, protected, public) 으로 정해진다. 이 접근 제한자를 제대로 활용하는 것이 정보 은닉의 핵심이다." 


---

길이가 0이 아닌 배열은 모두 변경이 가능하니 주의하자. 따라서 클래스에서 public static final 배열 필드를 두거나 이 필드를 반환하는 접근자 메서드를 제공해서는 안된다.
이런 필드나 접근자를 제공한다면 클라이언트에서 그 배열의 내용을 수정할 수 있게 된다. 
<br> <br><br>
다음 코드에는 보안 허점이 존재한다.

```java
public static final Thing[] VALUES = { ... };
```

해결 방법 2가지  <Br>
첫번째, 코드의 public 배열을 private으로 만들고 public 불변 리스트를 추가하는 것이다. 
```java
private static final Thing[] PRIVATE_VALUES = {...};
public static final List<Things> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
```
두번째, 배열을 private으로 만들고 그 복사본을 반환하는 public 메서드를 추가하는 방법이다.(방어적 복사)

```java
private static final Thing[] PRIVATE_VALUES = {...};
public static final Things[] values(){
    return PRIVATE_VALUES.clone(); 
}
```




---

##### 접근 수준 2가지. 
- public 
- package-private
- protected
- private


접근 보호 방식이 추가된 것 말고도, 모듈은 여러 면에서 자바 프로그래밍에 영향을 준다.사실 모듈의 장점을 제대로 누리려면 해야할 일이 많아. 먼저 
  패키지들을 모듈 단위로 묶고, 모듈 선언에 패키지들의 모든 의존성을 명시한다. 그런 다음 소스 트리를 재배치하고, 모듈 안으로부터 일반 패키지들의 
  모든 의존성을 명시한다.
  
  
  
##### 핵심 정리. 
  프로그램 요소의 접근성은 가능한 최소한으로 하라 꼭 필요한 것만 골라 최소한의 public API를 설계하자. 그 외에는 클래스, 인터페이스, 멤버가 의도치 않게 api로 공개되는 일이 없도록 해야 한다.
  public 클래스는 상수용 public static finla 필드 외에는 어떠한 public 필드도 가져서는 안된다. public static final 필드는 참조하는 객체가 불변인지 확인하라.


