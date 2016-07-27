package orm;

import orm.Man;

/**
 * Created by vika on 22.07.16.
 */
public class Boy extends Man {

    public Boy(int uid, String name, int sex1, String sex2, int age) {
        super(uid, name, sex1, sex2, age);
    }

    public boolean think() {
        return true;
    }
}
