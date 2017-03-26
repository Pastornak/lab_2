package Models;

import java.util.List;

import Enums.Area;
import Enums.Day;
import Enums.Group;

public class Chess extends Workshop {

	public Chess(String name, List<Day> day, List<Group> group, List<Area> area, int minAge, int maxAge) {
		this.name = name;
		this.day = day;
		this.group = group;
		this.area = area;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	public void advertise() {
		System.out.println("Chess club " + this.name + " invites new members " + "to it crew. We are located at "
				+ this.area + " area, games " + "are at " + this.day + ". Only for people from " + this.minAge + " to "
				+ this.maxAge + " years old and from " + this.group + " group. Free enter");
	}

	public void playChess() {
		System.out.println("You have good knowledge of chess, but little experience. You lose.");
	}

}