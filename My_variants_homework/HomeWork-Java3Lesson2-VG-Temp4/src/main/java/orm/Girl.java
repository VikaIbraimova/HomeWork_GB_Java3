package orm;

/**
 * Created by vika on 22.07.16.
 */
public class Girl extends Man {

    public Girl(int uid, String name, int sex1, String sex2, int age) {
        super(uid, name, sex1, sex2, age);
    }

    public boolean think() {
        return false;
    }
}
