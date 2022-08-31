package ss17_string.ss17_string_practice.ss17_string_practice_validate_email;

public class EmailExampleTest {
    public static void main(String[] args) {
        String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
        String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};
        EmailExample emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
    }
}
