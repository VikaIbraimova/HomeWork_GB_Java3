package orm;

import orm.*;
import orm.dao.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav Gasanov on 13.07.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Man> people = new ArrayList<>();
        people.add(new Girl("Anna", 23));
        people.add(new Girl("Masha", 24));
        people.add(new Girl("Kataj", 25));
        people.add(new Girl("Lena", 18));
        people.add(new Boy("Kolja", 22));
        people.add(new Boy("Vasja", 18));
        people.add(new Boy("Misha", 27));

        IDaoFactory iDaoFactory = new MambaDaoFactory();
        try {
            Connection conn = iDaoFactory.getConnection();
            DaoUtil.createScheme(conn);
            IGenericDao<Man> manDao = new ManDaoImpl(conn);
//FILL
            for (Man man:
                 people) {
                manDao.save(man);
            }

            //people.get(0).setAge(24);
            //people.get(3).setSex("male");
            Man someone = manDao.findById(3);
            someone.setName("NE KATYA");
           // someone.setSex("male");
            manDao.update(someone);
           // manDao.remove(people.get(1));

            for (Man man : manDao.findBySex("female")){
                System.out.println(man);
            }

            DaoUtil.closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
