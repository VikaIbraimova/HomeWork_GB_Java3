package orm;

/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public abstract class Man {
    private int uid;
    private String name;
    private String sex;
    private int age;

    public Man(int uid, String name, int age, String sex) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Man(String name, int age, String sex) {
       this(-1,name,age,sex);
    }

    abstract public boolean think();

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUid() {
        return uid;
    }

/*
    public void setUid(int uid) {
        this.uid = uid;
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
