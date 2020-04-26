package business;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import com.sendgrid.SendGrid;

@Service
@Transactional
public class SendGridService {

    private static String APIKey;
    @Autowired
    SendGridService(@Value("${spring.sendgrid.api-key}") final String APIKey) {
        SendGridService.APIKey = APIKey;
    }



    public static IOException sendTestMail() throws IOException {
        Email from = new Email("christian.ledgard@utec.edu.pe");
        String subject = "HOLA";
        Email to = new Email("christian.ledgard@utec.edu.pe");
        Content content = new Content("text/plain", "Hola carlitos");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(APIKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
        return null;
    }
}