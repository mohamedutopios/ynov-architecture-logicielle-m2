package org.example.behavior.mediateur;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Ne pas envoyer le message à l'expéditeur
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}
