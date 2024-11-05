package org.example.s.problem;

public class MailboxSettingsService {

    public void changeSecondaryEmail(User user, String newEmail) {
        if(hasAccess(user)){
            user.setSecondaryEmail(newEmail);
        }

    }

    public boolean hasAccess(User user){
        return user.getRole() == Role.ADMIN;
    }



}
