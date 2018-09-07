package com.briup.day11;

public class PersonTest {
	public static void main(String[] args) {
		Person person = new Person();
		person.setRestDay(Weekday.MON);
		Weekday weekday=person.getRestDay();
		switch (weekday) {
		case MON :
			System.out.println("周一休息");
			break;
		case TUE :
			System.out.println("周二休息");
			break;
		default:
			break;
		}
	}

}
