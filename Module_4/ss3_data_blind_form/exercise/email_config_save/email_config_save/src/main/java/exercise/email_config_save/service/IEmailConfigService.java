package exercise.email_config_save.service;

import exercise.email_config_save.bean.EmailConfig;

public interface IEmailConfigService {
    public EmailConfig showAll ();
    public EmailConfig update (EmailConfig emailConfig);
}
