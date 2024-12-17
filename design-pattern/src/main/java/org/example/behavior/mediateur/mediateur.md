### **Design Pattern : Médiateur (Mediator)**

Le **pattern Médiateur** est un patron comportemental qui permet de réduire les dépendances directes entre objets en introduisant un objet central appelé **médiateur**. Ce médiateur gère la communication et les interactions entre les objets, favorisant ainsi une **faible couplage** et une meilleure modularité.

---

### **Définition**
- Le Médiateur agit comme un intermédiaire pour coordonner les interactions entre les objets participants (appelés **collègues**).
- Les objets ne se communiquent pas directement entre eux mais passent toujours par le Médiateur, ce qui simplifie leurs relations.

---

### **Concept**
Imaginez un système où plusieurs objets doivent interagir entre eux :
- Sans médiateur : Chaque objet communique directement avec les autres, créant un réseau complexe de dépendances.
- Avec un médiateur : Les objets délèguent toutes leurs interactions à un seul point central, ce qui simplifie leur gestion.

---

### **Exemple concret : Chatroom**
Considérons une application de messagerie (chatroom) :
- Plusieurs utilisateurs peuvent envoyer des messages.
- Au lieu de gérer la communication directement entre les utilisateurs, un **médiateur (Chatroom)** coordonne l'envoi et la réception des messages.

---

### **Code en Java**

#### 1. **Interface du Médiateur**
```java
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
```

#### 2. **Implémentation du Médiateur**
```java
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
```

#### 3. **Classe abstraite pour les "collègues"**
```java
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
```

#### 4. **Implémentation d'un utilisateur concret**
```java
public class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " envoie : " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " reçoit : " + message);
    }
}
```

#### 5. **Utilisation**
```java
public class MediatorPatternDemo {
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
```

#### **Sortie du programme**
```
Alice envoie : Bonjour tout le monde !
Bob reçoit : Bonjour tout le monde !
Charlie reçoit : Bonjour tout le monde !
Diana reçoit : Bonjour tout le monde !
Charlie envoie : Salut Alice !
Alice reçoit : Salut Alice !
Bob reçoit : Salut Alice !
Diana reçoit : Salut Alice !
```

---

### **Avantages**
1. **Réduction des dépendances** : Les objets communiquent via le médiateur, évitant les relations enchevêtrées.
2. **Facilité de maintenance** : Vous pouvez modifier ou étendre le médiateur sans affecter les objets participants.
3. **Amélioration de la lisibilité** : Les interactions complexes sont centralisées dans un seul composant.

---

### **Inconvénients**
1. **Complexité accrue** : Le Médiateur peut devenir une classe volumineuse et difficile à maintenir si trop de logique y est centralisée.
2. **Dépendance au Médiateur** : Les objets dépendent fortement du Médiateur, ce qui peut poser problème si ce dernier devient un goulot d'étranglement.

---

### **Quand utiliser le pattern Médiateur ?**
- Lorsque plusieurs objets doivent interagir entre eux de manière complexe.
- Lorsque vous voulez **réduire les dépendances** directes entre objets.
- Lorsque vous voulez **centraliser la logique d'interaction** dans un composant unique. 

Ce pattern est souvent utilisé dans :
- Les systèmes de chat.
- Les systèmes de gestion de trafic (coordination de signaux).
- Les frameworks d'interfaces utilisateur (gestionnaires d'événements).