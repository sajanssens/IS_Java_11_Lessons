package DateMatcher;

/**
 * This class represents a Student Object which has a name.
 */
public class Student {

    /**
     * The name of a Student
     */
    private String name;

    /**
     *
     * @param name The name string that should be appointed to this Student Object
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     *
     * @return this Student objects name
     */
    public String getName() {
        return name;
    }
}
