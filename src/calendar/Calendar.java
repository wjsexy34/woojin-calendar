package calendar;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static int getmaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	/*
	 * - 월을 입력하면 해당월의 달력을 출력한다. - 달력의 모양은 1단계에서 작성한 모양으로 만든다. - 1일은 일요일로 정해도 무방하다. -
	 * -1을 입력받기 전까지 반복 입력받는다. - 프롬포트를 출력한다.
	 */

	public static int getWeekDay(int year, int month, int day) {

		int syear = 1970; // 목요일
		final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getmaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		System.out.println(count);

		int weekday = (count + STANDARD_WEEKDAY) % 7;
		System.out.println(weekday);
		return weekday;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("----------------------");

		// get weekday automatically
		int weekday = getWeekDay(year, month, 1);

		int maxDay = getmaxDaysOfMonth(year, month);
		int count = 7 - weekday;
//		int delim = (count < 7) ? count : 0; // 75라인에서 사용하는데 다른 방법으로 사용해서 사용안함.

		for (int i = 1; i <= weekday; i++) {
			System.out.printf("%3s", " ");
		}

		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
//			if (i % 7 == 0) {
//				System.out.println();
//			}
			if (i == count) {
				System.out.println();
				count += 7; // 이런식의 하드코딩 보다는 변수로 만들어서 하는게 좋다.
			}
		}

//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
//	public static void main(String[] args) {
//		System.out.println(getWeekDay(2017, 3, 1));
//	}
}
