package test.etc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTest {

	public static void main(String[] args) {
		String date = "2021-03-02T21:37:11.456+0100";

		String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		SimpleDateFormat df = new SimpleDateFormat(dateFormat, Locale.JAPAN);

		try {
			Date d = df.parse(date);

			TimeZone tz;
			tz = TimeZone.getTimeZone("Asia/Tokyo");
			df.setTimeZone(tz);
			System.out.println(tz.getDisplayName() + ":" + df.format(d));

			tz = TimeZone.getTimeZone("America/New_York");
			df.setTimeZone(tz);
			System.out.println(tz.getDisplayName() + ":" + df.format(date));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
