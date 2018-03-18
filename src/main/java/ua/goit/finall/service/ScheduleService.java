package ua.goit.finall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.time.LocalDate;

@Component
public class ScheduleService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmployeeService employeeService;

    //Scheduled : second, minute, hour, day of month, month, day(s) of week
    //@Scheduled(cron = "30 15 1 * * ")
//    @Scheduled(cron = "0 0 10 1 * *") // At 10 o'clock at 1 day of a month.
    @Scheduled(fixedRate = 1000)
    public void passLetter() {
        employeeService.calculateSalary(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        //sendMessageWithAttachment();
        System.out.println("Email send");
    }

    public void sendMessageWithAttachment(String to, String subject, String text,
                                          String pathToAttachment) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file
                = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);

        mailSender.send(message);
    }


}
