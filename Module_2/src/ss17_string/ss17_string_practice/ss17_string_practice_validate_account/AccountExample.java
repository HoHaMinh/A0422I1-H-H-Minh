package ss17_string.ss17_string_practice.ss17_string_practice_validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUNT_REGEX = "[_A-Za-z0-9]{6,}$";

    public AccountExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
