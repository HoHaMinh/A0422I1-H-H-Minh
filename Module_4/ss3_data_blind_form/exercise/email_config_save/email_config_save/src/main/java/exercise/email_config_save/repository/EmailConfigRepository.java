package exercise.email_config_save.repository;

import exercise.email_config_save.bean.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigRepository implements IEmailConfigRepository{
    static EmailConfig savedEmailConfig = new EmailConfig("English",10,false,"Ho Minh");

    @Override
    public EmailConfig showAll() {
        return savedEmailConfig;
    }

    @Override
    public EmailConfig update(EmailConfig emailConfig) {
        savedEmailConfig.setLanguage(emailConfig.getLanguage());
        savedEmailConfig.setPageSize(emailConfig.getPageSize());
        savedEmailConfig.setAllowSpam(emailConfig.isAllowSpam());
        savedEmailConfig.setSignature(emailConfig.getSignature());
        return savedEmailConfig;
    }
}
