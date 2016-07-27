package orm;

import orm.dao.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vika on 22.07.16.
 */
public class Main {
    public static void main(String[] args) {
        List<Man> people = new ArrayList<Man>();
        people.add(new Girl(1, "Anna",-1,"woman",23));
        people.add(new Girl(2, "Masha",-1,"woman",24));
        people.add(new Girl(3, "Kataj",-1,"woman",25));
        people.add(new Girl(4, "Lena",-1,"woman",18));
        people.add(new Boy(5, "Kolja", 1,"man",22));
        people.add(new Boy(6, "Vasja", 1,"man",18));
        people.add(new Boy(7, "Misha", 1,"man",27));


        IDaoFactory iDaoFactory = new MambaDaoFactory();
        try {
            Connection conn = iDaoFactory.getConnection();
            DaoUtil.clearTableMAMBA_CATALOG(conn);
            DaoUtil.createScheme(conn);
            IGenericDao<Man> manDao = new ManDaoImpl(conn);

            for (Man man:
                    people) {
                manDao.save(man);
            }

            people.get(0).setAge(21);
            manDao.update(people.get(0));
            manDao.remove(people.get(1));

            for (Man man : manDao.getAll()){
                System.out.println(man);
            }

            System.out.println("Ищем человека по id");
            for (Man man:
                    people) {
                //manDao.findById(3);
                System.out.println(manDao.findById(3));break;
            }

            DaoUtil.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
