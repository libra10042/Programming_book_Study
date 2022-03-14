package stream_spliterator;

import java.util.ArrayList;
import java.util.List;

public class HelloPerson {
    private String firstName;
    private String lastName;
    private String country;

    public HelloPerson(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "HelloPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


    public static List<HelloPerson> getSampleDate(){
        // List 객체를 생성한다.
        List<HelloPerson> person = new ArrayList<HelloPerson>();

        // 테스트 데이터를 추가한다.
        person.add(new HelloPerson("윤기", "장", "대한민국"));

        person.add(new HelloPerson("윤기", "장", "대한민국"));
        person.add(new HelloPerson("윤기", "장", "대한민국"));
        person.add(new HelloPerson("윤기", "장", "대한민국"));
        person.add(new HelloPerson("윤기", "장", "대한민국"));
        person.add(new HelloPerson("윤기", "장", "대한민국"));
        return person;
    }
}
