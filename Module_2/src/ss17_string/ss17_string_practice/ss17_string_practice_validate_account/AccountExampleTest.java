package ss17_string.ss17_string_practice.ss17_string_practice_validate_account;

public class AccountExampleTest {
    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
        String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};
        for (String account : validAccount) {
            boolean isValid = accountExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isValid);
        }

        for (String account : invalidAccount) {
            boolean invalid = accountExample.validate(account);
            System.out.println("Account is " + account + "is valid: " + invalid);
        }
    }
}
