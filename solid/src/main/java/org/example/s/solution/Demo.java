package org.example.s.solution;

public class Demo {

    public static void main(String[] args) {
        MailboxSettingsService mailboxSettingsService = new MailboxSettingsService();
        User user = new User();

        mailboxSettingsService.changeSecondaryEmail(user, "toto@gmail.com");

        SecurityService securityService = new SecurityService();
        if(securityService.hasAccess(user)){
            user.sendMoney(new User(), 1000);
        }

    }
}
