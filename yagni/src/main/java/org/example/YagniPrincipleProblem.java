package org.example;

import java.util.ArrayList;
import java.util.List;

public class YagniPrincipleProblem {

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


    public void archiveMessage(String message) {

        System.out.println("Archiving message: " + message);
    }

    public void deleteMessage(String message) {

        System.out.println("Deleting message: " + message);
    }

    public void forwardMessage(String message, String recipient) {

        System.out.println("Forwarding message: " + message + " to " + recipient);
    }
}
