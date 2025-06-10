package com.grepp.spring.infra.mail

import jakarta.mail.Message
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessagePreparator
import org.springframework.stereotype.Component
import org.thymeleaf.TemplateEngine

@Component
class MailTemplate(
    private val javaMailSender: JavaMailSender,
    private val templateEngine: TemplateEngine

) {
    private val properties: MutableMap<String, Any> = java.util.LinkedHashMap()

    private val templatePath: String? = null
    private val to: String? = null

    @Value("\${spring.mail.username}")
    private val from: String? = null
    private val subject: String? = null

    fun setProperties(name: String, value: Any) {
        properties[name] = value
    }

    fun getProperties(name: String): Any? {
        return properties[name]
    }

    @org.springframework.scheduling.annotation.Async
    fun send() {
        javaMailSender.send(MimeMessagePreparator { mimeMessage: MimeMessage ->
            mimeMessage.setFrom(from)
            mimeMessage.addRecipients(Message.RecipientType.TO, to)
            mimeMessage.subject = subject
            mimeMessage.setText(render(), "UTF-8", "html")
        })
    }

    private fun render(): String {
        val context = org.thymeleaf.context.Context()
        context.setVariables(properties)
        return templateEngine.process(templatePath, context)
    }
}
