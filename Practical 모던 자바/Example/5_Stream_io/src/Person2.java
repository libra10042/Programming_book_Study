import java.util.Objects;

public class Person2 implements Comparable<Person2> {
    private String name;
    private String age;

    public Person2() {
    }

    public Person2(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        // age속성과 name 속성이 모두 동일해야 같은 값으로 판단한다.
        if(obj instanceof Person){
            Person2 p1 = (Person2)obj;

            if(p1.getName().equals(this.getName()) && p1.getAge() == this.getAge()){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }


    }

    @Override
    public int hashCode() {
        return (name + age).hashCode();
    }

    @Override
    public int compareTo(Person2 o) {
        return (name + age).compareTo(o.getName() + o.getAge());
    }
}
