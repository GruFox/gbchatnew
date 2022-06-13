package ru.gb.gbchat.server;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthService implements AuthService {

    private List<UserData> users;

    private class UserData {
        private String login;
        private String password;
        private String nick;

        public UserData(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        for (UserData user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.nick;
            }
        }
        return null;
    }

    @Override
    public void start() {
        users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));

        }

    }

    @Override
    public void close() {
        System.out.println("Сервис аутентификации остановлен");
    }
}
