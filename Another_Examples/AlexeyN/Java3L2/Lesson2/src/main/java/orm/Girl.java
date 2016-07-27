package orm;

/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public class Girl extends Man {

    private static final String SEX = "female";

    public Girl(String name, int age) {
        super(name, age, SEX);
    }

    public boolean think() {
        return false;
    }
}
