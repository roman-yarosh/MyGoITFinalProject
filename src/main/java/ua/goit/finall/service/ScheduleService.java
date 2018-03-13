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

@Component
public class ScheduleService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmployeeService employeeService;
    private int count;

    //Scheduled : second, minute, hour, day of month, month, day(s) of week
    //@Scheduled(cron = "30 15 1 * * ")
    @Scheduled(cron = "0 0 10 1 * *") // At 10 o'clock at 1 day of a month.
    //@Scheduled(fixedRate = 10000)
    public void passLetter() {
        System.out.println("Email send");
        count++;
        System.out.println("Count" + count);

        //Настя нужно передать месяц и год в расчет зарплаты и подправить алгоритм рассчета
        // Внесу свои 5 копеек. У нас почисовая ставка, нужно отталкиваться отработаного времени. 

        //!!!!!!employeeService.calculateSalary(1, 1);
        //sendMessageWithAttachment();

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
