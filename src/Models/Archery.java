package Models;

import java.util.List;

import Enums.Area;
import Enums.Day;
import Enums.Group;

public class Archery extends Workshop {

	private int equipmentPrice;

	public int getEquipmentPrice() {
		return this.equipmentPrice;
	}

	public Archery(String name, List<Day> day, List<Group> group, List<Area> area, int equipmentPrice, int minAge, int maxAge) {
		this.name = name;
		this.day = day;
		this.group = group;
		this.area = area;
		this.equipmentPrice = equipmentPrice;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}

	public void advertise() {
		System.out.println("Archery club " + this.name + " invites new members " + "to it crew. We are located at "
				+ this.area + " area, training " + "is at " + this.day + ". Only for people from " + this.minAge
				+ " to " + this.maxAge + " years old and from " + this.group + " group. The equipment cost is "
				+ this.equipmentPrice);
	}

}