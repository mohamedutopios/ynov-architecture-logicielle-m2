package org.example.behavior.mediateur;

public class Demo {
    public static void main(String[] args) {
        // Création du médiateur
        ChatMediator chatRoom = new ChatRoom();

        // Création des utilisateurs
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");
        User user4 = new ChatUser(chatRoom, "Diana");

        // Ajout des utilisateurs au médiateur
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        chatRoom.addUser(user4);

        // Communication via le médiateur
        user1.send("Bonjour tout le monde !");
        user3.send("Salut Alice !");
    }
}
