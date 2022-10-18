package utilities;

import exceptions.EmptyStringException;
import exceptions.NegativeNumberException;
import java.io.Serializable;

/**
 * Класс, описывающий квартиру.
 * Реализует интерфейс Serializable для сериализации и десериализации объектов класса.
 * Поля класса закрыты, реализованы методы доступа (геттеры и сеттеры для каждого поля).
 */
public class Flat implements Serializable {
	
	/** Динамическое поле стоимости. */
	private double cost;
	
	/** Поле площади */
	private float square;
	
	/** Поле этажа */
	private int floor;
	
	/** Поле номера квартиры */
	private int flatNumber;
	
	/** Поле города  */
	private String city;
	
	/** Поле улицы */
	private String street;
	
	/** Поле номера дома */
	private String buildingNumber;
	
	/** Конструктор класса по умолчанию. */
	public Flat() throws EmptyStringException, NegativeNumberException {
		this("none", "none", "none", 1, 1, 1);
		this.cost = 1;
	}
	
	/**
	 * Параметризованный конструктор класса.
	 *
	 * @param city город
	 * @param street улица
	 * @param buildingNumber номер дома
	 * @param flatNumber номер квартиры
	 * @param floor этаж
	 * @param square площадь
	 */
	public Flat(String city, String street, String buildingNumber, int flatNumber, int floor,
			float square) throws EmptyStringException, NegativeNumberException {
		stringFieldChecker(city);
		this.city = city;
		
		stringFieldChecker(street);
		this.street = street;
		
		stringFieldChecker(buildingNumber);
		this.buildingNumber = buildingNumber;
		
		numericFieldChecker(flatNumber);
		this.flatNumber = flatNumber;
		
		numericFieldChecker(floor);
		this.floor = floor;
		
		numericFieldChecker(square);
		this.square = square;
		
		this.cost = countCost();
	}
	
	/**
	 * Метод, вычисляющий примерную стоимость квартиры.
	 *
	 * @return стоимость
	 */
	private double countCost() {
		final double FLOORRATIO = 1.3;
		final int SQUARECOST = 150000;
		if (floor > 5) {
			return FLOORRATIO * SQUARECOST * square;
		}
		return SQUARECOST * square;
	}
	
	/** Метод строкового представления объекта класса. */
	@Override
	public String toString() {
		return String.format("%15s %15s %15s %10d %10d %10.2f %20.2f\n", city, street, buildingNumber,
				flatNumber, floor, square, cost);
	}
	
	/**
	 * Геттер площади.
	 *
	 * @return площадь
	 */
	public float getSquare() {
		return square;
	}
	
	/** Сеттер площади.
	 *
	 * @param square площадь
	 */
	public void setSquare(float square) throws NegativeNumberException {
		numericFieldChecker(square);
		this.square = square;
	}
	
	/**
	 * Геттер этажа.
	 *
	 * @return этаж
	 */
	public int getFloor() {
		return floor;
	}
	
	/** Сеттер этажа.
	 *
	 * @param floor этаж
	 */
	public void setFloor(int floor) throws NegativeNumberException {
		numericFieldChecker((float)floor);
		this.floor = floor;
	}
	
	/**
	 * Геттер номера квартиры.
	 *
	 * @return номер квартиры
	 */
	public int getFlatNumber() {
		return flatNumber;
	}
	
	/** Сеттер номера квартиры.
	 *
	 * @param flatNumber номер квартиры
	 */
	public void setFlatNumber(int flatNumber) throws NegativeNumberException {
		numericFieldChecker((float)flatNumber);
		this.flatNumber = flatNumber;
	}
	
	/**
	 * Геттер города.
	 *
	 * @return город
	 */
	public String getCity() {
		return city;
	}
	
	/** Сеттер улицы.
	 *
	 * @param city город
	 */
	public void setCity(String city) throws EmptyStringException {
		stringFieldChecker(city);
		this.city = city;
	}
	
	/**
	 * Геттер улицы.
	 *
	 * @return улица
	 */
	public String getStreet() {
		return street;
	}
	
	/** Сеттер улицы.
	 *
	 * @param street улица
	 * */
	public void setStreet(String street) throws EmptyStringException {
		stringFieldChecker(street);
		this.street = street;
	}
	
	/**
	 * Геттер номера здания.
	 *
	 * @return номер здания
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}
	
	/** Сеттер номера здания.
	 *
	 * @param buildingNumber номер здания
	 */
	public void setBuildingNumber(String buildingNumber) throws EmptyStringException {
		stringFieldChecker(buildingNumber);
		this.buildingNumber = buildingNumber;
	}
	
	/**
	 * Геттер стоимости.
	 *
	 * @return стоимость
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Метод, проверяющий значения для числовых полей.
	 *
	 * @param value значение поля
	 */
	private static void numericFieldChecker(float value) throws NegativeNumberException {
		if (value <= 0) {
			throw new NegativeNumberException("the value of the field must be greater than zero", value);
		}
	}
	
	/**
	 * Метод, проверяющий значения для строковых полей.
	 *
	 * @param value значение поля
	 */
	private static void stringFieldChecker(String value) throws EmptyStringException {
		if (value.isEmpty() || value.trim().isEmpty()) {
			throw new EmptyStringException("the value of the field must be greater than zero", value);
		}
	}
	
}
