package tweets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomag on 14.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        MyDB myDB = new MyDB();

        // Добавить данные из файлов
        List<String> query = new ArrayList<>();
        query.addAll(myDB.stringFromFile("create.sql"));
        query.addAll(myDB.stringFromFile("insert_followers.sql"));
        query.addAll(myDB.stringFromFile("insert_tweets.sql"));
        query.addAll(myDB.stringFromFile("insert_users.sql"));
        myDB.voidQuery(query);

        String username = "aruizca";

        // Вывести имена (username) тех пользователей, на которых подписан aruizca
        System.out.println(username+" подписан на:");
        for (String s : myDB.getUsersByFollower(username)
             ) {
            System.out.println(s);
        }

        // Кол-во пользователей в БД
        System.out.println("\nКоличество пользователей: "+myDB.getUserCount());

        //Твиты пользователей на которых подписан aruizca
        System.out.println("\nТвиты пользователей на которые подписан "+username+":");
        for (String s : myDB.getSubTweetsByUser("aruizca")
                ){
            System.out.println(s);
        }

        //Количество подписчиков у пользоавтелей
        System.out.println("\nКоличество подписчиков у пользователей:");
        for (String s : myDB.getSubscriptionsCount()
             ) {
            System.out.println(s);
        }
    }
}
