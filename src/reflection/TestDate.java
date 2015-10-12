package reflection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: huyti
 * Date: 12.10.15
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss zzz yyyy");
        sdf.parse("18:57:00 EEST 2015");
        System.out.println(date.toString());
    }
}
