### 변경 가능성을 최소화하라. 

--- 

불변 클래스란 간단히 말하면 그 인스턴스의 내부 값을 수정할 수 없는 클래스이다. 불변 인스턴스에 간직된 정보는 고정되어 객체가 파괴되는 순간까지 절대 달라지지 않는다.

불변 클래스는 가변 클래스보다 설계하고 구현하기 쉬우며, 오류가 생길 여지도 적도 훨씬 안전하다. <br>
ex) String, 기본 타입의 박싱된 클래스들, BigInteger, BigDecimal

<BR><br>

##### 클래스를 불변으로 만들기 위한 5가지 규칙. 
1. 객체의 상태를 변경하는 메서드(변경자)를 제공하지 않는다. 
2. 클래스를 확장할 수 없도록 한다.
3. 모든 필드를 final로 선언한다.
4. 모든 필드를 private 으로 선언한다.
5. 자신 외에는 내부의 가변 컴포넌트에 접근할 수 없도록 한다.

<br> 
  
##### 불변 복소수   
```java
public final Class Complex{
     private final double re; 
     private final double im;
  
     public Complex(double re, double im){
        this.re = re;     
        this.im = im;
     }
     
     public double realPart(){ return re; }
     public double imaginaryPart(){ return im; }
  
  
     public Complex plus(Complex c){
        return new Complex(re + c.re, im + c.im);
     }
     public Complex minus(Complex c){
        return new Complex(re - c.re, im - c.im);
     }
     public Complex dividedBy(Complex c){
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
     }
     public Complex dividedBy(Complex c){
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / temp);
     }
  
  
     @Override public boolean equals(Object o){
        if(o == this)
            return true; 
        if(!(o instanceof Complex))
           return false; 
        Complex c = (Complex) o;
  
  
        return Double.compare(c.re, re) == 0 
          && Double.compare(c.im, im) == 0; 
     } 
  
     @Override public int hashCode(){
        return 31 * Double.hashCode(re) + Double.hasCode(im);
     }
    
}
```
  
위의 사칙연산 메서드들이 인스턴스 자신은 수정하지 않고 새로운 Complex 인스턴스를 만들어 반환해준다.<br>
이처럼 피연산자에 함수를 적용해 그 결과를 반환하지만, 피연산자 자체는 그대로인 프로그래밍 패턴을 함수형 프로그래밍이라고 한다.
  
  
  
> 불변 객체는 근복적으로 스레드 안전하여 따로 동기화할 필요가 없다. 불변객체는 안심하고 공유할 수 있다. <br>
> 불변 객체는 자유롭게 공유할 수 있음은 물론, 불변 객체끼리는 내부 데이터를 공유할 수 있다. 

  
  
<br>
  
##### 생성자 대신 정적 팩터를 사용한 불변 클래스

```java
public class Complex {
    private final double re; 
    private final double im; 
  
    private Complex(double re, double im){
        this.re = re; 
        this.im = im; 
    }
  
    public static Complex valueOf(double re, double im){
      return new Complex(re, im);
    }
    ...
  
}
```
  
  
불변으로 만들 수 없는 클래스라도 변경할 수 있는 부분을 최소한으로 줄이자. 다른 합당한 이유가 없다면 모든 필드는 private final 이어야 한다.<br>
생성자는 불변식 설정이 모두 완료된, 초기화가 완벽히 끝난 상태의 객체를 생성해야 한다.
  
