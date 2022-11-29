package exercise.email_config_save.bean;

public class EmailConfig {
    private String language;
    private Integer pageSize;
    private boolean isAllowSpam;
    private String signature;

    public EmailConfig() {
    }

    public EmailConfig(String language, Integer pageSize, boolean isAllowSpam, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.isAllowSpam = isAllowSpam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAllowSpam() {
        return isAllowSpam;
    }

    public void setAllowSpam(boolean allowSpam) {
        isAllowSpam = allowSpam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
