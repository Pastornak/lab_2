package Models;

import java.util.List;

import Enums.Area;
import Enums.Day;
import Enums.Group;

public class Football extends Workshop {

	private int uniformPrice;

	public int getUniformPrice() {
		return this.uniformPrice;
	}

	public Football(String name, List<Day> day, List<Group> group, List<Area> area, int uniformPrice, int minAge, int maxAge) {
		this.name = name;
		this.day = day;
		this.group = group;
		this.area = area;
		this.uniformPrice = uniformPrice;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	public void advertise() {
		System.out.println("Football team " + this.name + " invites new members " + "to it crew. We are located at "
				+ this.area + " area, training " + "is at " + this.day + ". Only for people from " + this.minAge
				+ " to " + this.maxAge + " years old and from " + this.group + " group. The uniform cost is "
				+ this.uniformPrice);
	}

	public void playFootball() {
		System.out.println("It was a good game, we should do it again later.");
	}

	public void goToChampionship() {
		System.out.println("We lost in the first game, but we had been fighting like lions.");
	}
}