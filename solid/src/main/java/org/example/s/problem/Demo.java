package org.example.s.problem;

public class Demo {

    public static void main(String[] args) {
        MailboxSettingsService mailboxSettingsService = new MailboxSettingsService();
        User user = new User();

        mailboxSettingsService.changeSecondaryEmail(user, "toto@gmail.com");

        if(mailboxSettingsService.hasAccess(user)){
            user.sendMoney(new User(), 1000);
        }

    }
}
