package exercise.music_upload.validate;

public class Validator {
    public static boolean checkFileType (String fileName) {
        String regexFileName = "^[\\w-\\.]+\\.(mp3|wav|ogg|m4p)$";
        return fileName.matches(regexFileName);
    }
}
