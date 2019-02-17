package bloglaptrinh.com.common.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtil {

    public static String covertStringToURL(String str) {
        try {
            String temp = Normalizer.normalize(str.trim(), Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase()
                    .replaceAll("[^\\p{L}\\p{Z}]","")
                    .replaceAll(" ", "-")
                    .replaceAll("đ", "d");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
