package exercise.email_config_save.service;

import exercise.email_config_save.bean.EmailConfig;
import exercise.email_config_save.repository.IEmailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigService implements IEmailConfigService{
    @Autowired
    private IEmailConfigRepository emailConfigRepository;

    @Override
    public EmailConfig showAll() {
        return emailConfigRepository.showAll();
    }

    @Override
    public EmailConfig update(EmailConfig emailConfig) {
        return emailConfigRepository.update(emailConfig);
    }
}
