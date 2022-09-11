package exam.exam_validate;

import exam.exam_exception.NotFoundException;
import exam.exam_exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Date validateDate(String dateAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date date = null;
        try {
            date = format.parse(dateAsString);
            return date;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        }
    }

    public static boolean validateIdNote(String idNote) throws UserException {
        final String CLASS_REGEX = "^STK-[0-9]{4}$";
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(idNote);
        System.out.println("Input name of class is: " + matcher.matches());
        if (matcher.matches() == false) {
            throw new UserException(Message.WRONG_ID_NOTE);
        }
        return true;
    }

    public static boolean validateLongTerm(int longTerm) throws UserException {
        if (longTerm != 1 && longTerm != 3 && longTerm != 5 && longTerm != 10) {
            throw new UserException(Message.WRONG_LONG_TERM);
        }
        return true;
    }

    public static boolean validateShortTerm(int shortTerm) throws UserException {
        if (shortTerm != 3 && shortTerm != 6) {
            throw new UserException(Message.WRONG_SHORT_TERM);
        }
        return true;
    }

    public static boolean validateMoney(double money) throws UserException {
        if (money < 1000000) {
            throw new UserException(Message.MONEY_TOO_SMALL);
        }
        return true;
    }

    public static boolean validate() throws NotFoundException {
        if (true) {
            throw new NotFoundException(Message.NOT_FOUND_SAVING_EXCEPTION);
        }
        return true;
    }
}

