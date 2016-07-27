package c.finmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tomag on 11.07.2016.
 */
public class Control {

    private static boolean RUNNING = true;
    private static boolean AUTHORIZED = false;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Manager manager = new Manager();

    public void ask() throws IOException {

        System.out.println("-> \"reguser\" or \"auth\"\n-> \"q\" for exit");

        while (RUNNING) {
            String input = bufferedReader.readLine();

            switch (input) {
                case "q" : RUNNING = false; break;
                case "reguser" : regUser(); break;
                case "auth" : auth(); break;
            }
        }
    }

    private void auth() throws IOException {
        String login, password;
        while (RUNNING) {
            System.out.print("-> Enter login: ");
            login = bufferedReader.readLine().replaceAll("\\s", "");
            if (manager.getUserNames().contains(login)) {
                User user = manager.getUser(login);
                System.out.print("-> Enter password: ");
                password = bufferedReader.readLine().replaceAll("\\s", "");
                if (user.getPassword().equals(password)) {
                    AUTHORIZED = true;
                    System.out.println("-> Successfully authorized!");
                    RUNNING = false;
                }
            } else {
                System.out.println("\n-> input error"); }
        }
        go();
    }

    private void regUser() throws IOException {
        String login, password;
        while (RUNNING) {
            System.out.print("-> Enter login ( 5&more symbols ): ");
            login = bufferedReader.readLine().replaceAll("\\s", "");
            System.out.print("-> Enter password ( 5&more symbols ): ");
            password = bufferedReader.readLine().replaceAll("\\s", "");
            if (login.length() >= 5 && password.length() >= 5) {
                manager.regUser(login, password);
                System.out.println("-> New user " + login + " added. Password: " + password);
                RUNNING = false;
            } else {
                System.out.println("\n-> input error"); }
        }
        go();
    }

    private void go() {
        RUNNING = true;
    }
}
