package Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Enums.Area;
import Enums.Day;
import Enums.Group;
import Managers.WorkshopManager;
import Models.Archery;
import Models.Chess;
import Models.Football;


public class WorkshopManagerTest {
	
	private WorkshopManager workshopManager = new WorkshopManager();
	
	@Before
	public void setUpWorkshopManager(){
		List<Day> daysForFootball1 = new ArrayList<>();
		List<Area> areasForFootball1 = new ArrayList<>();
		List<Group> groupsForFootball1 = new ArrayList<>();
		daysForFootball1.add(Day.FRIDAY);
		areasForFootball1.add(Area.«¿À≤«Õ»◊Õ»…);
		areasForFootball1.add(Area.√¿À»÷‹ »…);
		groupsForFootball1.add(Group.NORMAL);
		
		List<Day> daysForFootball2 = new ArrayList<>();
		List<Area> areasForFootball2 = new ArrayList<>();
		List<Group> groupsForFootball2 = new ArrayList<>();
		daysForFootball2.add(Day.MONDAY);
		areasForFootball2.add(Area.—»’≤¬—‹ »…);
		areasForFootball2.add(Area.√¿À»÷‹ »…);
		groupsForFootball2.add(Group.SPECIAL);
		
		workshopManager.createFootballList("Lokomotiv", daysForFootball1, groupsForFootball1, areasForFootball1, 300, 5, 30);
		workshopManager.createFootballList("FK Lviv", daysForFootball2, groupsForFootball2, areasForFootball2, 6400, 3, 10);
		workshopManager.createFootballList("Aleks", daysForFootball1, groupsForFootball1, areasForFootball1, 400, 11, 14);
		
		
		List<Day> daysForArchery1 = new ArrayList<>();
		List<Area> areasForArchery1 = new ArrayList<>();
		List<Group> groupsForArchery1 = new ArrayList<>();
		daysForArchery1.add(Day.SATURDAY);
		daysForArchery1.add(Day.SUNDAY);
		areasForArchery1.add(Area.À»◊¿ ≤¬—‹ »…);
		areasForArchery1.add(Area.‘–¿Õ ≤¬—‹ »…);
		groupsForArchery1.add(Group.PREPARATORY);
		
		List<Day> daysForArchery2 = new ArrayList<>();
		List<Area> areasForArchery2 = new ArrayList<>();
		List<Group> groupsForArchery2 = new ArrayList<>();
		daysForArchery2.add(Day.THURSDAY);
		areasForArchery2.add(Area.ÿ≈¬◊≈Õ ≤¬—‹ »…);
		groupsForArchery2.add(Group.NORMAL);
		
		workshopManager.createArcheryList("Fire", daysForArchery1, groupsForArchery1, areasForArchery1, 3000, 6, 16);
		workshopManager.createArcheryList("Sokil", daysForArchery2, groupsForArchery2, areasForArchery2, 2500, 12, 20);
		
		
		List<Day> daysForChess1 = new ArrayList<>();
		List<Area> areasForChess1 = new ArrayList<>();
		List<Group> groupsForChess1 = new ArrayList<>();
		daysForChess1.add(Day.WEDNESDAY);
		daysForChess1.add(Day.TUESDAY);
		areasForChess1.add(Area.À»◊¿ ≤¬—‹ »…);
		areasForChess1.add(Area.—»’≤¬—‹ »…);
		areasForChess1.add(Area.‘–¿Õ ≤¬—‹ »…);
		groupsForChess1.add(Group.NORMAL);
		groupsForChess1.add(Group.SPECIAL);
		
		List<Day> daysForChess2 = new ArrayList<>();
		List<Area> areasForChess2 = new ArrayList<>();
		List<Group> groupsForChess2 = new ArrayList<>();
		daysForChess2.add(Day.SATURDAY);
		daysForChess2.add(Day.MONDAY);
		daysForChess2.add(Day.TUESDAY);
		areasForChess2.add(Area.«¿À≤«Õ»◊Õ»…);
		areasForChess2.add(Area.ÿ≈¬◊≈Õ ≤¬—‹ »…);
		areasForChess2.add(Area.‘–¿Õ ≤¬—‹ »…);
		groupsForChess2.add(Group.SPECIAL);
		
		workshopManager.createChessList("Chess for all", daysForChess1, groupsForChess1, areasForChess1, 16, 80);
		workshopManager.createChessList("Chess-children", daysForChess2, groupsForChess2, areasForChess2, 6, 14);
	}

	@Test
	public void testFindFootballArea() {
		Area expected = Area.«¿À≤«Õ»◊Õ»…;
		List<Football> real = workshopManager.findFootball(expected);
		Assert.assertEquals(2, real.size());
		for (Football football: real){
			List<Area> realAreas = football.getArea();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Area expectedNull = Area.ÿ≈¬◊≈Õ ≤¬—‹ »…;
		List<Football> realNull = workshopManager.findFootball(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindFootballDay() {
		Day expected = Day.MONDAY;
		List<Football> real = workshopManager.findFootball(expected);
		Assert.assertEquals(1, real.size());
		for (Football football: real){
			List<Day> realDays = football.getDay();
			Assert.assertTrue(realDays.contains(expected));
		}
		
		Day expectedFew = Day.FRIDAY;
		List<Football> realFew = workshopManager.findFootball(expectedFew);
		Assert.assertEquals(2, realFew.size());
		for (Football football: realFew){
			List<Day> realDays = football.getDay();
			Assert.assertTrue(realDays.contains(expectedFew));
		}
		
		Day expectedNull = Day.WEDNESDAY;
		List<Football> realNull = workshopManager.findFootball(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindFootballGroup() {
		Group expected = Group.SPECIAL;
		List<Football> real = workshopManager.findFootball(expected);
		Assert.assertEquals(1, real.size());
		for (Football football: real){
			List<Group> realGroups = football.getGroup();
			Assert.assertTrue(realGroups.contains(expected));
		}
		
		Group expectedFew = Group.NORMAL;
		List<Football> realFew = workshopManager.findFootball(expectedFew);
		Assert.assertEquals(2, realFew.size());
		for (Football football: realFew){
			List<Group> realGroups = football.getGroup();
			Assert.assertTrue(realGroups.contains(expectedFew));
		}
		
		Group expectedNull = Group.PREPARATORY;
		List<Football> realNull = workshopManager.findFootball(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindFootballUniformPrice() {
		int expected = 300;
		List<Football> real = workshopManager.findFootball(expected);
		for (Football football: real){
			Assert.assertEquals(expected, football.getUniformPrice());
		}
		
		int expectedNull = 100;
		Assert.assertNull(workshopManager.findFootball(expectedNull));
	}

	@Test
	public void testFindFootballMinMaxAge() {
		int expectedMin = 5;
		int expectedMax = 11;
		List<Football> real = workshopManager.findFootball(expectedMin, expectedMax);
		for (Football football: real){
			Assert.assertTrue((football.getMaxAge() >= expectedMax) && (football.getMinAge() <= expectedMin));
		}
		
		int expectedFewMin = 6;
		int expectedFewMax = 9;
		List<Football> realFew = workshopManager.findFootball(expectedFewMin, expectedFewMax);
		Assert.assertEquals(2, realFew.size());
		for (Football football: realFew){
			Assert.assertTrue((football.getMaxAge() >= expectedFewMax) && (football.getMinAge() <= expectedFewMin));
		}
		
		int expectedMinNull = 4;
		int expectedMaxNull = 15;
		List<Football> realNull = workshopManager.findFootball(expectedMinNull, expectedMaxNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindArcheryArea() {
		Area expected = Area.ÿ≈¬◊≈Õ ≤¬—‹ »…;
		List<Archery> real = workshopManager.findArchery(expected);
		Assert.assertEquals(1, real.size());
		for (Archery archery: real){
			List<Area> realAreas = archery.getArea();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Area expectedNull = Area.«¿À≤«Õ»◊Õ»…;
		List<Archery> realNull = workshopManager.findArchery(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindArcheryDay() {
		Day expected = Day.SATURDAY;
		List<Archery> real = workshopManager.findArchery(expected);
		Assert.assertEquals(1, real.size());
		for (Archery archery: real){
			List<Day> realAreas = archery.getDay();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Day expectedNull = Day.MONDAY;
		List<Archery> realNull = workshopManager.findArchery(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindArcheryGroup() {
		Group expected = Group.NORMAL;
		List<Archery> real = workshopManager.findArchery(expected);
		Assert.assertEquals(1, real.size());
		for (Archery archery: real){
			List<Group> realAreas = archery.getGroup();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Group expectedNull = Group.SPECIAL;
		List<Archery> realNull = workshopManager.findArchery(expectedNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindArcheryEquipmentPrice() {
		int expectedNull = 100;
		Assert.assertNull(workshopManager.findArchery(expectedNull));
		
		int expected = 2500;
		List<Archery> real = workshopManager.findArchery(expected);
		Assert.assertEquals(1, real.size());
		for (Archery archery: real){
			Assert.assertEquals(expected, archery.getEquipmentPrice());
		}
	}

	@Test
	public void testFindArcheryMinMaxAge() {
		int expectedFewMin = 12;
		int expectedFewMax = 16;
		List<Archery> realFew = workshopManager.findArchery(expectedFewMin, expectedFewMax);
		Assert.assertEquals(2, realFew.size());
		for (Archery archery: realFew){
			Assert.assertTrue((archery.getMaxAge() >= expectedFewMax) && (archery.getMinAge() <= expectedFewMin));
		}
		
		int expectedMin = 7;
		int expectedMax = 11;
		List<Archery> real = workshopManager.findArchery(expectedMin, expectedMax);
		Assert.assertEquals(1, real.size());
		for (Archery archery: real){
			Assert.assertTrue((archery.getMaxAge() >= expectedMax) && (archery.getMinAge() <= expectedMin));
		}
		
		int expectedMinNull = 5;
		int expectedMaxNull = 21;
		List<Archery> realNull = workshopManager.findArchery(expectedMinNull, expectedMaxNull);
		Assert.assertNull(realNull);
	}

	@Test
	public void testFindChessArea() {
		Area expectedFew = Area.‘–¿Õ ≤¬—‹ »…;
		List<Chess> realFew = workshopManager.findChess(expectedFew);
		Assert.assertEquals(2, realFew.size());
		for (Chess chess: realFew){
			List<Area> realAreas = chess.getArea();
			Assert.assertTrue(realAreas.contains(expectedFew));
		}
		
		Area expected = Area.«¿À≤«Õ»◊Õ»…;
		List<Chess> real = workshopManager.findChess(expected);
		Assert.assertEquals(1, real.size());
		for (Chess chess: real){
			List<Area> realAreas = chess.getArea();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Area expectedNull = Area.√¿À»÷‹ »…;
		Assert.assertNull(workshopManager.findChess(expectedNull));
	}

	@Test
	public void testFindChessDay() {
		Day expectedFew = Day.TUESDAY;
		List<Chess> realFew = workshopManager.findChess(expectedFew);
		Assert.assertEquals(2, realFew.size());
		for (Chess chess: realFew){
			List<Day> realAreas = chess.getDay();
			Assert.assertTrue(realAreas.contains(expectedFew));
		}
		
		Day expected = Day.MONDAY;
		List<Chess> real = workshopManager.findChess(expected);
		Assert.assertEquals(1, real.size());
		for (Chess chess: real){
			List<Day> realAreas = chess.getDay();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Day expectedNull = Day.THURSDAY;
		Assert.assertNull(workshopManager.findChess(expectedNull));
	}

	@Test
	public void testFindChessGroup() {
		Group expectedFew = Group.SPECIAL;
		List<Chess> realFew = workshopManager.findChess(expectedFew);
		Assert.assertEquals(2, realFew.size());
		for (Chess chess: realFew){
			List<Group> realAreas = chess.getGroup();
			Assert.assertTrue(realAreas.contains(expectedFew));
		}
		
		Group expected = Group.NORMAL;
		List<Chess> real = workshopManager.findChess(expected);
		Assert.assertEquals(1, real.size());
		for (Chess chess: real){
			List<Group> realAreas = chess.getGroup();
			Assert.assertTrue(realAreas.contains(expected));
		}
		
		Group expectedNull = Group.PREPARATORY;
		Assert.assertNull(workshopManager.findChess(expectedNull));
	}

	@Test
	public void testFindChessMinMaxAge() {
		int expectedMin = 7;
		int expectedMax = 13;
		List<Chess> real = workshopManager.findChess(expectedMin, expectedMax);
		Assert.assertEquals(1, real.size());
		for (Chess chess: real){
			Assert.assertTrue((chess.getMaxAge() >= expectedMax) && (chess.getMinAge() <= expectedMin));
		}
		
		int expectedMinNull = 10;
		int expectedMaxNull = 90;
		Assert.assertNull(workshopManager.findChess(expectedMinNull, expectedMaxNull));
	}

}
