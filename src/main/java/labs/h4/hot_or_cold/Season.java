package labs.h4.hot_or_cold;

/**
 * Represents seasons of the year. A season can be warm or cold
 */
public enum Season {

    SPRING("warm"),SUMMER("warm"),AUTUMN("cold"),WINTER("cold");

    private String warmOrCold;

    Season(String hotOrCold){
        this.warmOrCold = hotOrCold;
    }

    public String toString(){
        return warmOrCold;
    }
}
