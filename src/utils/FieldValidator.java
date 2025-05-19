package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class FieldValidator {

	public static boolean isDecimal(String value) {
		return value != null && value.matches("\\d+(\\.\\d+)?");
	}

	public static boolean isInteger(String value) {
		return value != null && value.matches("\\d+");
	}

	public static boolean isEmpty(String value) {
	    return value == null || value.trim().isEmpty();
	}
	
	public static boolean isNotEmpty(String value) {
		return value != null && !value.trim().isEmpty();
	}

	public static boolean isInDecimalRange(double value, double min, double max) {
		return value >= min && value <= max;
	}
	
	public static boolean isAlphanumeric(String input) {
	    return input != null && input.matches("^[a-zA-Z0-9 ]+$");
	}

	public static boolean isInIntegerRange(int value, int min, int max) {
		return value >= min && value <= max;
	}

	public static boolean isValidDateFormat(String date) {
	    return isValidDate(date, "yyyy-MM-dd");
	}
	
	public static boolean isValidTimeFormat(String time) {
	    if (time == null) return false;

	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    timeFormat.setLenient(false);

	    try {
	        timeFormat.parse(time);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	
	public static boolean isValidEmail(String email) {
	    final Pattern EMAIL_PATTERN = Pattern.compile(
	        "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	        Pattern.CASE_INSENSITIVE
	    );
	    return email != null && EMAIL_PATTERN.matcher(email).matches();
	}
	
	public static boolean isValidDate(String date, String pattern) {
		if (date == null || pattern == null) return false;

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setLenient(false);

		try {
			dateFormat.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isAnyEmpty(String... fields) {
		for (String field : fields) {
			if (field == null || field.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean areAllEmpty(String... fields) {
		for (String field : fields) {
			if (field != null && !field.trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
