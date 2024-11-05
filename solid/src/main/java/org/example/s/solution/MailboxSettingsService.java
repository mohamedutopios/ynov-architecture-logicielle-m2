package org.example.s.solution;

public class MailboxSettingsService {

    private SecurityService securityService;

    {
        securityService = new SecurityService();
    }

    public void changeSecondaryEmail(User user, String newEmail) {
        if(securityService.hasAccess(user)){
            user.setSecondaryEmail(newEmail);
        }

    }

}
