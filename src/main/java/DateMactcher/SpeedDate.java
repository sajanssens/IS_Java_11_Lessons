package DateMactcher;

/**
 * This class represents a SpeedDate between two students
 */
public class SpeedDate {

    private static final int STUDENTS_IN_ONE_DATE = 2;
    private Student pair[] = new Student[STUDENTS_IN_ONE_DATE]; // change this into an ArrayList. Make more abstract

    /**
     * The constructor of this class
     * @param first     One of the students to be in this SpeedDate pair
     * @param second    One of the students to be in this SpeedDate pair
     */
    public SpeedDate(Student first, Student second) {
        this.pair[0] = first;
        this.pair[1] = second;
    }

    /**
     * Is the getter for the pair Student array of this student.
     * @return a Student array of size 2;
     */
    public Student[] getPair() {
        return pair;
    }

    /**
     * This method creates a new SpeedDate object with reversed pair values
     * @return
     */
/*    public SpeedDate reversePair() {

        SpeedDate reversed = new SpeedDate(this.getPair()[1], this.getPair()[0]);

        return reversed;
    }*/

    /**
     * This method checks whether the 2 participants in this speed date are the same person .
     * @return  true if the speed date pair contains the same student e.g. Bob paird with Bob.
     *          false if above is not the case e.g. Bob paired with Tom.
     */
    public boolean isSelfDate(){
        return this.pair[0].equals(this.pair[1]);
    }

    /**
     *
     * @return  A user friendly representation of this class
     */
    public String toString(){
        return this.pair[0] + " with " + this.pair[1];
    }

    /**
     *
     * @param speedDate
     * @return
     */
    public boolean isOppositePair(SpeedDate speedDate){

        if(this.pair[0].equals(speedDate.getPair()[1]) && this.pair[1].equals(speedDate.getPair()[0]) ){
            return true;
        }
        return false;
    }
}
