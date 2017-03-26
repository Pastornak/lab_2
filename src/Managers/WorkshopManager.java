package Managers;

import java.util.ArrayList;
import java.util.List;
import Enums.Area;
import Enums.Day;
import Enums.Group;
import Models.Archery;
import Models.Chess;
import Models.Football;
import Models.Workshop;

public class WorkshopManager {

	private List<Football> footballList = new ArrayList<>();
	private List<Archery> archeryList = new ArrayList<>();
	private List<Chess> chessList = new ArrayList<>();

	public WorkshopManager() {

	}

	public void createFootballList(String name, List<Day> day, List<Group> group, List<Area> area,
			int uniformPrice, int minAge, int maxAge) {
		Football football = new Football(name, day, group, area, uniformPrice, minAge, maxAge);
		footballList.add(football);
	}

	public void createArcheryList(String name, List<Day> day, List<Group> group, List<Area> area,
			int equipmentPrice, int minAge, int maxAge) {
		Archery archery = new Archery(name, day, group, area, equipmentPrice, minAge, maxAge);
		archeryList.add(archery);
	}

	public void createChessList(String name, List<Day> day, List<Group> group, List<Area> area,
			int minAge, int maxAge) {
		Chess chess = new Chess(name, day, group, area, minAge, maxAge);
		chessList.add(chess);
	}

	public List<Football> getFootballList() {
		return this.footballList;
	}

	public List<Archery> getArcheryList() {
		return this.archeryList;
	}

	public List<Chess> getChessList() {
		return this.chessList;
	}
	
	private boolean iteratorFindArea(Workshop workshop, Area area) {
		boolean result = false;
		List<Area> fArea = workshop.getArea();
		for (Area i : fArea) {
			if (i == area)
				result = true;
		}
		return result;
	}
	
	private boolean iteratorFindDay(Workshop workshop, Day day) {
		boolean result = false;
		List<Day> fDay = workshop.getDay();
		for (Day i : fDay) {
			if (i == day)
				result = true;
		}
		return result;
	}
	
	private boolean iteratorFindGroup(Workshop workshop, Group group) {
		boolean result = false;
		List<Group> fGroup = workshop.getGroup();
		for (Group i : fGroup) {
			if (i == group)
				result = true;
		}
		return result;
	}
	
	//
	//
	//FOOTBALL SEARCHING
	//
	//
	
	public List<Football> findFootball(Area area) {
		List<Football> result = new ArrayList<>();
		

		for (Football i : footballList) {
			if (iteratorFindArea(i, area))
				result.add(i);
		}
		
		System.out.println(printFootballTeams(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Football> findFootball(Day day) {
		List<Football> result = new ArrayList<>();
		

		for (Football i : footballList) {
			if (iteratorFindDay(i, day))
				result.add(i);
		}
		
		System.out.println(printFootballTeams(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Football> findFootball(Group group) {
		List<Football> result = new ArrayList<>();
		

		for (Football i : footballList) {
			if (iteratorFindGroup(i, group))
				result.add(i);
		}
		
		System.out.println(printFootballTeams(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Football> findFootball(int uniformPrice){
		List<Football> result = new ArrayList<>();
		

		for (Football i : footballList) {
			if (i.getUniformPrice() <= uniformPrice)
				result.add(i);
		}
		
		System.out.println(printFootballTeams(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Football> findFootball(int minAge, int maxAge){
		List<Football> result = new ArrayList<>();
		

		for (Football i : footballList) {
			if(i.findAge(minAge, maxAge))
				result.add(i);
		}
		
		System.out.println(printFootballTeams(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	private String printFootballTeams(List<Football> input){
		String resultString = "Found! Your team is ";
		
		if (input.isEmpty()) {
			resultString = "There is no such team.";
			return resultString;
		}
		
		if (input.size() > 1)
			resultString = "Found! Your teams are ";
		for (Football i : input)
			resultString += i.getName() + " ";
		return resultString;
	}
	
	//
	//
	//ARCHERY SEARCHING
	//
	//
	
	public List<Archery> findArchery(Area area) {
		List<Archery> result = new ArrayList<>();
		

		for (Archery i : archeryList) {
			if (iteratorFindArea(i, area))
				result.add(i);
		}
		
		System.out.println(printArcheryClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Archery> findArchery(Day day) {
		List<Archery> result = new ArrayList<>();
		

		for (Archery i : archeryList) {
			if (iteratorFindDay(i, day))
				result.add(i);
		}
		
		System.out.println(printArcheryClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Archery> findArchery(Group group) {
		List<Archery> result = new ArrayList<>();
		

		for (Archery i : archeryList) {
			if (iteratorFindGroup(i, group))
				result.add(i);
		}
		
		System.out.println(printArcheryClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Archery> findArchery(int equipmentPrice){
		List<Archery> result = new ArrayList<>();
		

		for (Archery i : archeryList) {
			if (i.getEquipmentPrice() <= equipmentPrice)
				result.add(i);
		}
		
		System.out.println(printArcheryClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Archery> findArchery(int minAge, int maxAge){
		List<Archery> result = new ArrayList<>();
		

		for (Archery i : archeryList) {
			if (i.findAge (minAge, maxAge))
				result.add(i);
		}
		
		System.out.println(printArcheryClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	private String printArcheryClubs(List<Archery> input){
		String resultString = "Found! Your archery club is ";
		
		if (input.isEmpty()) {
			resultString = "There is no such archery club.";
			return resultString;
		}
		
		if (input.size() > 1)
			resultString = "Found! Your archery clubs are ";
		for (Archery i : input)
			resultString += i.getName() + " ";
		return resultString;
	}
	
	//
	//
	//CHESS SEARCHING
	//
	//
	
	public List<Chess> findChess(Area area) {
		List<Chess> result = new ArrayList<>();
		

		for (Chess i : chessList) {
			if (iteratorFindArea(i, area))
				result.add(i);
		}
		
		System.out.println(printChessClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Chess> findChess(Day day) {
		List<Chess> result = new ArrayList<>();
		
		//chessList.stream().filter(a -> a.getDay().equals(day)).collect(result);

		for (Chess i : chessList) {
			if (iteratorFindDay(i, day))
				result.add(i);
		}
		
		System.out.println(printChessClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Chess> findChess(Group group) {
		List<Chess> result = new ArrayList<>();
		

		for (Chess i : chessList) {
			if (iteratorFindGroup(i, group))
				result.add(i);
		}
		
		System.out.println(printChessClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public List<Chess> findChess(int minAge, int maxAge) {
		List<Chess> result = new ArrayList<>();
		

		for (Chess i : chessList) {
			if (i.findAge(minAge, maxAge))
				result.add(i);
		}
		
		System.out.println(printChessClubs(result));

		if (result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	private String printChessClubs(List<Chess> input){
		String resultString = "Found! Your chess club is ";
		
		if (input.isEmpty()) {
			resultString = "There is no such chess club.";
			return resultString;
		}
		
		if (input.size() > 1)
			resultString = "Found! Your chess clubs are ";
		for (Chess i : input)
			resultString += i.getName() + " ";
		return resultString;
	}
}
