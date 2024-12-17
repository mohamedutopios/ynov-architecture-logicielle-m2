package org.example.behavior.mediateur;

public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
