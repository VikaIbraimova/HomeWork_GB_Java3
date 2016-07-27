package orm;

/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public class Boy extends Man {

    private static final String SEX = "male";

    public Boy(String name, int age) {
        super(name, age, SEX);
    }

    public boolean think() {
        return true;
    }
}
