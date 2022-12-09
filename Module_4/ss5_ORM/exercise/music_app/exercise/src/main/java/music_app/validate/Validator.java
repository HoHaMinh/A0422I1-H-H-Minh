package music_app.validate;

public class Validator {
    public static boolean checkFileType (String fileName) {
        String regexFileName = "^[\\w-\\.]+\\.(mp3|wav|ogg|mp4)$";
        return fileName.matches(regexFileName);
    }
}
