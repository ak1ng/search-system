package com.daimamingong.framework.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 邮件发送类
 *
 * @author robben.qu
 */
public class MailSenderUtils {

    private JavaMailSender mailSender;

    private SimpleMailMessage mailMessage;

    /**
     * 模版所在目录
     */
    private String templatePath;

    /**
     * 默认编码格式
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    /**
     * 发送纯文本邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param text    内容
     */
    public void sendSimpleMail(String to, String subject, String text) {
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailSender.send(mailMessage);
    }

    /**
     * 发送多人纯文本邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param text    内容
     */
    public void sendSimpleMail(String[] to, String subject, String text) {
        for (String t : to) {
            this.sendSimpleMail(t, subject, text);
        }
    }

    /**
     * 发送带附件邮件
     *
     * @param to         接收人
     * @param subject    主题
     * @param text       内容
     * @param attachment 附件文件地址
     */
    public void sendMimeMail(String to, String subject, String text, String attachment) {
        this.sendMimeMail(new String[]{to}, subject, text, new String[]{attachment});
    }

    /**
     * 批量发送带附件邮件
     *
     * @param to         接收人
     * @param subject    主题
     * @param text       内容
     * @param attachment 附件文件地址
     */
    public void sendMimeMail(String[] to, String subject, String text, String attachment) {
        this.sendMimeMail(to, subject, text, new String[]{attachment});
    }

    /**
     * 批量发送带附件邮件
     *
     * @param to          接收人
     * @param subject     主题
     * @param text        内容
     * @param attachments 附件文件地址
     */
    public void sendMimeMail(String to, String subject, String text, String[] attachments) {
        this.sendMimeMail(new String[]{to}, subject, text, attachments);
    }

    /**
     * 批量发送带附件邮件
     *
     * @param to          接收人
     * @param subject     主题
     * @param text        内容
     * @param attachments 附件列表
     */
    public void sendMimeMail(String[] to, String subject, String text, String[] attachments) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true, DEFAULT_CHARSET);
            helper.setFrom(mailMessage.getFrom());
            helper.setSubject(subject);
            helper.setText(text, true);
            helper.setSentDate(new Date());

            // 批量添加附件
            if (null != attachments && attachments.length > 0)
                this.addAttachmentsToEmail(text, attachments, mimeMessage);

            // 不能使用string类型的类型，这样只能发送一个收件人
            List<InternetAddress> list = new ArrayList<InternetAddress>();
            for (String t : to)
                list.add(new InternetAddress(t));

            InternetAddress[] address = list.toArray(new InternetAddress[list.size()]);
            mimeMessage.setRecipients(Message.RecipientType.TO, address);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加附件
     *
     * @param text        邮件内容
     * @param attachments 附件
     * @param mimeMessage MimeMessage
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private void addAttachmentsToEmail(String text, String[] attachments, MimeMessage mimeMessage) throws MessagingException, UnsupportedEncodingException {
        Multipart multipart = new MimeMultipart();
        // 新建一个存放信件内容的BodyPart对象
        BodyPart mdp = new MimeBodyPart();
        // 给BodyPart对象设置内容和格式/编码方式
        mdp.setContent(text, "text/html;charset=UTF-8");
        // 将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
        multipart.addBodyPart(mdp);

        MimeBodyPart filePart;
        FileDataSource filedatasource;
        // 逐个加入附件
        for (String attachment : attachments) {
            filePart = new MimeBodyPart();
            filedatasource = new FileDataSource(attachment);
            filePart.setDataHandler(new DataHandler(filedatasource));
            filePart.setFileName(MimeUtility.encodeText(filedatasource.getName()));
            multipart.addBodyPart(filePart);
        }
        mimeMessage.setContent(multipart);
    }

    /**
     * 批量发送网页邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param html    html内容
     * @throws MessagingException
     */
    public void sendHtmlMail(String[] to, String subject, String html) throws MessagingException {
        for (String to1 : to) {
            this.sendHtmlMail(to1, subject, html);
        }
    }

    /**
     * 发送HTML邮件
     *
     * @param to      接收人
     * @param subject 主题
     * @param html    HTML内容
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String html) throws MessagingException {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(msg, true, DEFAULT_CHARSET);
            helper.setFrom(mailMessage.getFrom());
            helper.setTo(new InternetAddress(to));
            helper.setSubject(subject);
            helper.setText(html, true);
            helper.setSentDate(new Date());
            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量发送模板邮件
     *
     * @param to           邮件接收人
     * @param subject      邮件标题
     * @param templateName 模板名称
     * @param contents     内容
     */
    public void sendTemplateMail(String to, String subject, String templateName, Map<String, String> contents) {
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(msg, true, DEFAULT_CHARSET);
            helper.setFrom(mailMessage.getFrom());
            helper.setTo(new InternetAddress(to));
            helper.setSubject(subject);
            helper.setText(this.loadTemplateText(templateName, contents), true);
            helper.setSentDate(new Date());
            mailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量发送模板邮件
     *
     * @param tos          邮件接收人
     * @param subject      邮件标题
     * @param templateName 模板名称
     * @param contents     内容
     */
    public void sendTemplateMail(String[] tos, String subject, String templateName, Map<String, String> contents) {
        for (String to : tos) {
            this.sendTemplateMail(to, subject, templateName, contents);
        }
    }

    /**
     * 获取模板并将内容输出到模板
     *
     * @param templateName 模板文件名称
     * @param params       参数名称
     * @return String
     */
    private String loadTemplateText(String templateName, Map<String, String> params) throws IOException, TemplateException {
        Configuration freemarkerConfig = new Configuration(Configuration.VERSION_2_3_22);
        freemarkerConfig.setAutoFlush(true);
        freemarkerConfig.setDefaultEncoding("UTF-8");
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");
        Template tpl = freemarkerConfig.getTemplate(templatePath + "/" + templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, params);
    }
}
