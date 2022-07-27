package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    //Email simples
    public void sendSimpleMessege() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("rafael.lazzari@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Meu e-mail!");
        emailSender.send(message);
    }

    //Email com anexo
    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo("rafael.lazzari@dbccompany.com.br");
        helper.setSubject("Assunto 1");
        helper.setText("Meu e-mail!");

        // Forma 2
        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

//        System.out.println("F: " + file2.getPath());
//         src/main/resources/imagem.jpg
        emailSender.send(message);
    }

    public void sendEmail(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Adicionando Conta");
            mimeMessageHelper.setText(geContentFromTemplate(pessoaDTO.getNome(), pessoaDTO.getIdPessoa()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate(String nome, Integer id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome);
        dados.put("id", id);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("pessoaCreate.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendUpdateEmail(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Atualizando dados");
            mimeMessageHelper.setText(updateContentFromTemplate(pessoaDTO.getNome()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String updateContentFromTemplate(String nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("pessoaUpdate.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void deleteSendEmail(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Removendo Conta");
            mimeMessageHelper.setText(deleteContentFromTemplate(pessoaDTO.getNome()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String deleteContentFromTemplate(String nome) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", nome);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("pessoaDelete.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendEnderecoEmail(PessoaDTO pessoaDTO, EnderecoDTO enderecoDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Adicionando endereço");
            mimeMessageHelper.setText(getContentFromTemplateEndereco(pessoaDTO.getNome(), enderecoDTO.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplateEndereco(String nome, Integer id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome",nome);
        dados.put(("idEndereco"), id);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("enderecoCreate.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendUpdateEnderecoEmail(PessoaDTO pessoaDTO, EnderecoDTO enderecoDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Atualizando endereço");
            mimeMessageHelper.setText(getContentFromTemplateEnderecoUpdate(pessoaDTO.getNome(), enderecoDTO.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplateEnderecoUpdate(String nome, Integer id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome",nome);
        dados.put(("idEndereco"), id);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("enderecoUpdate.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public void sendDeleteEnderecoEmail(PessoaDTO pessoaDTO, EnderecoDTO enderecoDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Removendo endereço");
            mimeMessageHelper.setText(getContentFromTemplateEnderecoDelete(pessoaDTO.getNome(), enderecoDTO.getIdEndereco()), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplateEnderecoDelete(String nome, Integer id) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome",nome);
        dados.put(("idEndereco"), id);
        dados.put("from", from);

        Template template = fmConfiguration.getTemplate("enderecoDelete.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
