package calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		System.out.printf("Hello, Calendar");
		System.out.println();
		System.out.println(" 일 월  화  수 목  금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();

		int[] maxDays = new int[12];
//		lastday[0] = 31;       
//		lastday[1] = 30;       
//		lastday[2] = 31;       
//		lastday[3] = 30;       
//		lastday[4] = 31;       
//		lastday[5] = 30;       
//		lastday[6] = 31;       
//		lastday[7] = 31;       
//		lastday[8] = 30;       
//		lastday[9] = 31;       
//		lastday[10] = 30;      
//		lastday[11] = 31;      

		for (int i = 0; i < maxDays.length; i++) {
			if (i % 2 == 0) {
				if (i >= 8) {
					maxDays[i] = 30;
				} else if (i < 8) {
					maxDays[i] = 31;
				}
			} else if (i % 2 == 1) {
				if (i >= 7) {
					maxDays[i] = 31;
				} else if (i < 7) {
					maxDays[i] = 30;
				}  
			}
		}
		for (int i = 1; i <= 12; i++) {
			if (i == month) {
				System.out.printf("%d월은 %d일까지 있습니다.", month, maxDays[i - 1]);
			}
		}

		scanner.close();
	}
}
