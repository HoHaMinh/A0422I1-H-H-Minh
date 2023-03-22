package Validate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Validator {
    public static boolean isValidDate(String date) {
        boolean check = false;
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            formatDate.setLenient(false);
            Date inputDate = formatDate.parse(date);
            Date now = new Date();
            if ((inputDate.compareTo(now) <0) && (now.getYear() - inputDate.getYear() <150)){
                check = true;
            }
            return check;
        } catch (Exception e) {
            return check;
        }
    }

    public static boolean checkEmail(String email){
        String regexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regexEmail);
    }
//
//    public static boolean validateIdNote(String idNote) throws UserException {
//        final String CLASS_REGEX = "^STK-[0-9]{4}$";
//        Pattern pattern = Pattern.compile(CLASS_REGEX);
//        Matcher matcher = pattern.matcher(idNote);
//        System.out.println("Input name of class is: " + matcher.matches());
//        if (matcher.matches() == false) {
//            throw new UserException(Message.WRONG_ID_NOTE);
//        }
//        return true;
//    }
//
//    public static boolean validateLongTerm(int longTerm) throws UserException {
//        if (longTerm != 1 && longTerm != 3 && longTerm != 5 && longTerm != 10) {
//            throw new UserException(Message.WRONG_LONG_TERM);
//        }
//        return true;
//    }
//
//    public static boolean validateShortTerm(int shortTerm) throws UserException {
//        if (shortTerm != 3 && shortTerm != 6) {
//            throw new UserException(Message.WRONG_SHORT_TERM);
//        }
//        return true;
//    }
//
//    public static boolean validateMoney(double money) throws UserException {
//        if (money < 1000000) {
//            throw new UserException(Message.MONEY_TOO_SMALL);
//        }
//        return true;
//    }
//
//    public static boolean validate() throws NotFoundException {
//        if (true) {
//            throw new NotFoundException(Message.NOT_FOUND_SAVING_EXCEPTION);
//        }
//        return true;
//    }
}
