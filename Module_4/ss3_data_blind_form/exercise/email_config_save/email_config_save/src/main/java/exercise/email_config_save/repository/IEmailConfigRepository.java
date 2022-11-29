package exercise.email_config_save.repository;

import exercise.email_config_save.bean.EmailConfig;

public interface IEmailConfigRepository {
    public EmailConfig showAll ();
    public EmailConfig update (EmailConfig emailConfig);
}
