package com.example.zadanie22_0;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(String name, String email, String mailText) {
        sendMailToAdmin(name, mailText, email);
        sendConfirmationMail(email);

    }

    private void sendConfirmationMail(String email) {
        SimpleMailMessage confirmationMail = new SimpleMailMessage();
        confirmationMail.setTo(email);
        confirmationMail.setFrom("noreply@op.pl");
        confirmationMail.setSubject("Potwierdzenie wysłania zapytania");
        confirmationMail.setText("Dziękujemy za wysłanie zapytania. Odpowiemy wkrótce.");
        javaMailSender.send(confirmationMail);
    }

    private void sendMailToAdmin(String name, String mailText, String email) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject("Wiadomość od użytkownika " + name);
        mail.setTo("example1@op.pl");
        mail.setText(mailText);
        mail.setFrom(email);
        mail.setReplyTo(email);
        javaMailSender.send(mail);
    }
}
