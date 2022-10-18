package tui;

import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import utilities.Flat;

import static tui.Input.*;
import static utilities.FileIO.*;

/** Класс, отвечающий за вывод текстового меню и взаимодействия пользователя с ним. */
public class Menu {

	/** Метод, выводящий текстовое меню. */
	private static void printMenu() {
		System.out.print("""
					
					MENU
					----------
					1. Menu.
					2. Add an empty object.
					3. Add a custom object.
					4. Edit by id.
					5. Delete by id.
					6. Flats table.
					7. Sort by any column (in ascending order).
					8. Save.
					9. Load.
					10. Exit.
					----------
					""");
	}
	
	/** Метод, выводящий список полей класса Flat. */
	private static void printFields() {
		System.out.print("""
       
              Existing fields:
              ----------------
              1. City.
              2. Street.
              3. Building number.
              4. Flat number.
              5. Floor.
              6. Square.
              7. Cost.
              """);
	}
	
	/** Метод, выводящий сообщение об отсутствии данных. */
	private static void noDataMsg() {
		System.err.print("""
								No data!
								
								""");
	}
	
	/** Метод, выводящий сообщение об ожидании ввода пользователя. */
	private static void waitForInputMsg() {
		System.out.print("\nMake your choice: ");
	}
	
	/** Метод, выводящий сообщение об успехе выполнения какой-либо операции. */
	private static void completeMsg() {
		System.out.print("""
					________
					Complete.
					""");
	}
	
	/** Метод, выводящий сообщение ою отсутствии изменений. */
	private static void noChange() {
		System.err.println("Illegal argument value! Nothing changed.");
	}
	
	/**
	 * Метод, выводящий таблицу объектов класса Flat.
	 *
	 * @param arr массив для вывода
	 * */
	private static void arrPrint(List<Flat> arr) {
		System.out.print("""
       
							Your table:
							-----------
							""");
		System.out.printf("%c %15s %15s %15s %10s %10s %10s %20s\n", '№', "City|", "Street|",
				"House №|", "Flat №|", "Floor|", "Square|", "Cost|");
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(i + 1);
			System.out.print(arr.get(i).toString());
		}
	}
	
	/**
	 * Метод, создающий новый кастомный объект класса Flat.
	 *
	 * @return новый элемент класса Flat
	 */
	private static Flat newCustom() {
		System.out.print("\nEnter the city: ");
		String city = rawStringIn();
		
		System.out.print("Enter the street: ");
		String street = rawStringIn();
		
		System.out.print("Enter the number of the building: ");
		String buildingNumber = rawStringIn();
		
		System.out.print("Enter the flat number: ");
		int flatNumber = intIn();
		
		System.out.print("Enter the floor number: ");
		int floor = intIn();
		
		System.out.print("Enter the square: ");
		float square = floatIn();
		
		try {
			return new Flat(city, street, buildingNumber, flatNumber, floor, square);
		} catch (EmptyStringException | NegativeNumberException e) {
			System.err.println("Caught: " + e);
			return newEmpty();
		}
	}
	
	/**
	 * Метод, создающий новый кастомный объект класса Flat.
	 *
	 * @return новый элемент класса Flat
	 */
	private static Flat newEmpty() {
		try {
			return new Flat();
		} catch (NegativeNumberException | EmptyStringException e) {
			System.err.println("Caught: " + e);
			return null;
		}
	}
	
	/**
	 * Метод, проверяющий массив на пустоту.
	 *
	 * @param arr исходный массив
	 * @return true - в случае отсутствия данных, false - в противном
	 */
	private static boolean emptyCheck(ArrayList<Flat> arr) {
		if (arr.size() == 0) {
			noDataMsg();
			waitForInputMsg();
			return true;
		}
		return false;
	}
	
	/**
	 * Метод, удаляющий элемент из массива.
	 *
	 * @param arr исходный массив
	 */
	private static void delElem (ArrayList<Flat> arr) {
		System.out.print("\nEnter the id of the element you want to delete: ");
		int id;
		do {
			id = positiveIntIn(intIn());
			if (id > arr.size()) {
				System.err.print("Incorrect choice! Try again: ");
			}
		} while (id > arr.size());
		arr.remove(id - 1);
	}
	
	/**
	 * Метод, редактирующий одно из полей одного из элементов.
	 *
	 * @param arr исходный массив
	 */
	private static void editElem (ArrayList<Flat> arr) {
		System.out.print("\nEnter the id of the element you want to edit: ");
		int id;
		do {
			id = positiveIntIn(intIn());
			if (id > arr.size()) {
				System.err.print("Incorrect choice! Try again: ");
			}
		} while (id > arr.size());
		
		Flat choosenElem = arr.get(id - 1);
		
		printFields();
		waitForInputMsg();
		
		do {
			id = positiveIntIn(intIn());
			if (id > 7) {
				System.err.print("Incorrect choice! Try again: ");
			}
		} while (id > 7);
		
		menuForEdit(id, arr, choosenElem);
	}
	
	/**
	 * Switch для editElem.
	 *
	 * @param field поле
	 * @param arr массив
	 * @param choosenElem выбранный элемент
	 */
	private static void menuForEdit (int field, ArrayList<Flat> arr, Flat choosenElem) {
		String newStr;
		int newInt;
		float newFloat;
		
		System.out.print("\nEnter the new value: ");
		switch (field) {
			case 1 -> {
				newStr = rawStringIn();
				try {
					choosenElem.setCity(newStr);
				} catch (EmptyStringException e) {
					noChange();
				}
			}
			case 2 -> {
				newStr = rawStringIn();
				try {
					choosenElem.setStreet(newStr);
				} catch (EmptyStringException e) {
					noChange();
				}
			}
			case 3 -> {
				newStr = rawStringIn();
				try {
					choosenElem.setBuildingNumber(newStr);
				} catch (EmptyStringException e) {
					noChange();
				}
			}
			case 4 -> {
				newInt = intIn();
				try {
					choosenElem.setFlatNumber(newInt);
				} catch (IllegalArgumentException | NegativeNumberException e) {
					noChange();
				}
			}
			case 5 -> {
				newInt = intIn();
				try {
					choosenElem.setFloor(newInt);
				} catch (NegativeNumberException e) {
					noChange();
				}
			}
			case 6 -> {
				newFloat = floatIn();
				try {
					choosenElem.setSquare(newFloat);
				} catch (NegativeNumberException e) {
					noChange();
				}
			}
			case 7 -> System.out.print("\nCurrent value: " + choosenElem.getCost() +
					" - calculated immutable field\n");
		}
		arrPrint(arr);
	}
	
	/**
	 * Меню для сортировки.
	 *
	 * @param arr исходный массив
	 */
	private static void menuForSort (ArrayList<Flat> arr) {
		int field;
		do {
			field = positiveIntIn(intIn());
			if (field > 7) {
				System.err.print("Incorrect choice! Try again: ");
			}
		} while (field > 7);
		
		switch (field) {
			case 1 -> arr.sort(Comparator.comparing(Flat::getCity));
			case 2 -> arr.sort(Comparator.comparing(Flat::getStreet));
			case 3 -> arr.sort(Comparator.comparing(Flat::getBuildingNumber));
			case 4 -> arr.sort(Comparator.comparing(Flat::getFlatNumber));
			case 5 -> arr.sort(Comparator.comparing(Flat::getFloor));
			case 6 -> arr.sort(Comparator.comparing(Flat::getSquare));
			case 7 -> arr.sort(Comparator.comparing(Flat::getCost));
		}
		arrPrint(arr);
		completeMsg();
	}
	
	/** Метод, выводящий на экран меню пользователя и обрабатывающий взаимодействия с ним. */
	public static void menu() {
		
		ArrayList<Flat> flatsArray = new ArrayList<>(0);  // создание пустового массива
		
		printMenu();
		waitForInputMsg();
		
		while (true) {
			
			int choice = positiveIntIn(intIn());
			
			switch (choice) {
				case 1 -> printMenu();  // вывод меню
				
				case 2 ->  // добавить пустой элемент
					flatsArray.add(newEmpty());
				
				case 3 ->  // добавить кастомный элемент
					flatsArray.add(newCustom());
				
				case 4 -> {  // изменить элемент
					if (emptyCheck(flatsArray))
						continue;
					arrPrint(flatsArray);
					editElem(flatsArray);
				}
				
				case 5 -> {  // удалить элемент
					if (emptyCheck(flatsArray))
						continue;
					arrPrint(flatsArray);
					delElem(flatsArray);
				}
				
				case 6 -> {  // вывести таблицу
					if (emptyCheck(flatsArray))
						continue;
					arrPrint(flatsArray);
				}
				
				case 7 -> {  // сортировка
					if (emptyCheck(flatsArray))
						continue;
					arrPrint(flatsArray);
					printFields();
					waitForInputMsg();
					menuForSort(flatsArray);
				}
				
				case 8 -> {  // сохранить в файл
					if (emptyCheck(flatsArray))
						continue;
					WriteFile(flatsArray);
				}
				
				case 9 -> {  // загрузить из файла
					ArrayList<Flat> temp = ReadFile();
					if (temp != null && temp.size() > 0) {
						flatsArray = temp;
						arrPrint(flatsArray);
					}
					else {
						noDataMsg();
					}
				}
				
				case 10 -> {  // выход
					System.out.print("\nBye-bye!..\n");
					System.exit(0);
				}
				
				default -> System.err.print("Incorrect choice! Try again: ");
			}
			
			if (choice > 1 && choice < 10) {
				completeMsg();
			}
			
			if (choice < 10 && choice > 0) {
				waitForInputMsg();
			}
		}
	}
}
