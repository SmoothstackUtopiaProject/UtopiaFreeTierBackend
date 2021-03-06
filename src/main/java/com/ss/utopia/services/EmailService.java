package com.ss.utopia.services;

import com.ss.utopia.models.MailRequest;
import com.ss.utopia.models.MailResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.UnexpectedTypeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class EmailService {

  @Autowired
  private JavaMailSender sender;

  @Autowired
  private Configuration config;

  public MailResponse sendEmail(
    MailRequest request,
    Map<String, Object> model
  ) {
    MailResponse response = new MailResponse();
    MimeMessage message = sender.createMimeMessage();
    try {
      // set mediaType
      MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );

      Template t = config.getTemplate("email-template.ftl");
      String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

      helper.setTo(request.getTo());
      helper.setText(html, true);
      helper.setSubject(request.getSubject());
      helper.setFrom(request.getFrom());
      sender.send(message);

      response.setMessage("mail send to : " + request.getTo());
      response.setStatus(Boolean.TRUE);
    } catch (
      UnexpectedTypeException
      | MessagingException
      | IOException
      | TemplateException e
    ) {
      response.setMessage("Mail Sending failure : " + e.getMessage());
      response.setStatus(Boolean.FALSE);
    }

    return response;
  }
}
