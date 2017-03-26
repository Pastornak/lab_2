package Models;

import java.util.List;

import Enums.Area;
import Enums.Day;
import Enums.Group;

public abstract class Workshop {

	protected String name;
	protected List<Day> day = null;
	protected List<Area> area = null;
	protected List<Group> group = null;
	protected int minAge;
	protected int maxAge;

	public abstract void advertise();

	public String getName() {
		return this.name;
	}

	public List<Day> getDay() {
		return this.day;
	}

	public List<Area> getArea() {
		return this.area;
	}

	public List<Group> getGroup() {
		return this.group;
	}

	public int getMinAge() {
		return this.minAge;
	}

	public int getMaxAge() {
		return this.maxAge;
	}
	
	public boolean findAge(int minAge, int maxAge){
		boolean result = false;
		if ((this.minAge <= minAge) && (this.maxAge >= maxAge))
			result = true;
		return result;
	}
}
