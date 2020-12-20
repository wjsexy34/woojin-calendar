package calendar;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
	 */
	public int parsDay(String week) {
		if (week == "su")
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return 0;
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2017;
//		int weekday = 0; // 요일을 자동으로 계산하기 때문에 이제 필요없음.

		while (true) {
			System.out.println("출력할 년도를 입력해주세요.(exit: -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();

			if (year == -1) {
				break;
			}
			System.out.println("출력할 월을 입력해주세요.(exit: -1)");
			System.out.print("MONTH> ");
			month = scanner.nextInt();

			if (month == -1) {
				break;
			}

			if (month > 12 || month < 1) {
				System.err.println("잘못된 입력입니다");
				continue;
			}

			cal.printCalendar(year, month);
			System.out.println("\n");
		}
		System.out.println("Bye");
		scanner.close();
	}

	public static void main(String[] args) {
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
