package case_study.case_study_validate;

import case_study.case_study_exception.UserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
    public static Date validateBirthday(String birthdayAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date birthday = null;
        try {
            birthday = format.parse(birthdayAsString);
            Date now = new Date();
            if (now.getYear() - birthday.getYear() < 18) {
                throw new UserException(Message.AGE_LESS_THAN_18);
            }

            return birthday;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        }
    }

    public static boolean validateName(String name) throws UserException {
        char begin = name.charAt(0);
        if (begin < 65 || begin > 90) {
            throw new UserException(Message.NAME_INCORRECT);
        }
        return true;
    }

    public static boolean validateGender(String name) throws UserException {
        if (!"male".equals(name.toLowerCase()) && !"female".equals(name.toLowerCase())) {
            throw new UserException(Message.GENDER_INCORRECT);
        }
        return true;
    }

    public static Date validateStartdate(String DateAsString) throws UserException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date startDate = null;
        try {
            Date now = new Date();
            startDate = format.parse(DateAsString);
            if (startDate.compareTo(now) <0) {
                throw new UserException(Message.DATE_BEFORE_NOW);
            }
            return startDate;
        } catch (ParseException e) {
            throw new UserException(Message.DATE_FORMAT);
        }
    }
}
