package orm;

/**
 * Created by vika on 22.07.16.
 */
public abstract class Man {
    private int uid;
    private String name;
    private int sex1;
    private String sex2;
    private int age;

    public Man(int uid, String name,int sex1, String sex2,int age) {
        this.uid = uid;
        this.name = name;
        this.sex1 = sex1;
        this.sex2 = sex2;
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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

    public int getSex1() {
        return sex1;
    }

    public void setSex1(int sex1) {
        this.sex1 = sex1;
    }

    public String getSex2() {
        return sex2;
    }

    public void setSex2(String sex2) {
        this.sex2 = sex2;
    }

    @Override
    public String toString() {
        return "Man{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex2='" + sex2 + '\'' +
                '}';
    }
}
