package labs.h7;

import org.junit.Test;

class PersonTest {

    @Test
    void testPerson(){
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday();
        System.out.println(p.getAge());
        System.out.println(Person.numberOfPossibleGenders());
    }
}