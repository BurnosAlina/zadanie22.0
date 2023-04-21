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
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject("Wiadomość od użytkownika " + name);
        mail.setTo("example1@op.pl");
        mail.setText(mailText);
        mail.setFrom(name);
        mail.setReplyTo(email);
        javaMailSender.send(mail);
        SimpleMailMessage confirmationMail = new SimpleMailMessage();
        confirmationMail.setTo(email);
        confirmationMail.setSubject("Potwierdzenie wysłania zapytania");
        confirmationMail.setText("Dziękujemy za wysłanie zapytania. Odpowiemy wkrótce.");
        javaMailSender.send(confirmationMail);
    }
}
