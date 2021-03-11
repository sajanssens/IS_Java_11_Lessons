package DateMactcher;

import java.util.ArrayList;
import java.util.List;

/**
 * This DateMatcher class matches students into pairs for speed dating. All pairs are unique
 */
public class DateMatcher {

    /**
     * This list contains all speedDates that are valid matched and unique in pairing
     */
    private List<SpeedDate> matchedSpeedDates;

    /**
     * The constructor of this class. It creates a list of matched speed dates upon creation of a DateMatcher object
     * @param studentList : A List of Student objects
     */
    public DateMatcher(List<Student> studentList) {
        this.matchedSpeedDates = new ArrayList<>();
        matchPairs(studentList);
    }

    /**
     * This class generates a user friendly representation of the dateList in this class
     * @return a user friendly representation of the datelist attribute of this class
     */
    public String toString(){

        int dateCount = 0;
        String returnString = "";

        for ( SpeedDate s : this.matchedSpeedDates){
            returnString += "\nDate " + ++dateCount + " : " + s.toString();

        }
        return returnString;
    }

    /**
     * This class matches students in pairs and places those pairs in the matchedSpeedDates list of this object
     * @param studentList a List of Student objects
     */
    public void matchPairs(List<Student> studentList){

        for ( int i = 0; i<studentList.size(); i++ ){
            for ( int j = 1; j<studentList.size(); j++ ){
                SpeedDate speedDate = new SpeedDate(studentList.get(i), studentList.get(j));
                if ( isAlreadyMatched(speedDate) ) {
                    matchedSpeedDates.add(speedDate);
                }

            }
        }
    }

    /**
     *
     * @param speedDate a speedDate object
     * @return a boolean value indicating whether a speedDate is already matched
     */
    public boolean isAlreadyMatched(SpeedDate speedDate){

        if(this.matchedSpeedDates.contains(speedDate)){
            return false;
        }
        else if (containsOppositePairOf(speedDate)){
            return false;
        }
        else if (speedDate.isSelfDate()){
            return false;
        }

        return true;
    }

    /**
     *
     * @param speedDate a speedDate object
     * @return a boolean value indicating whether the reversed pairing of the passed speedDate is already present in the
     *          matchedSpeedDates list
     */
    public boolean containsOppositePairOf(SpeedDate speedDate){

        for ( SpeedDate s : matchedSpeedDates){
            if ( s.isOppositePair(speedDate)){
                return true;
            }
        }
        return false;
    }

}
