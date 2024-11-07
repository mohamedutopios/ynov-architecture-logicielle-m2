package org.example;

import java.util.ArrayList;
import java.util.List;

public class YagniPrincipleSolution {

    private List<String> messages = new ArrayList<>();


    public void sendMessage(String message) {
        messages.add(message);
        System.out.println("Message sent: " + message);
    }

    public void receiveMessage() {
        if (!messages.isEmpty()) {
            String message = messages.remove(0);
            System.out.println("Message received: " + message);
        } else {
            System.out.println("No messages to receive.");
        }
    }


}
