package labs.h7;

import labs.h7.person.Gender;
import labs.h7.person.Person;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson(){
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday();
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders());
    }
}