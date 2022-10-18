package utilities;

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
	public Flat() {
		this("none", "none", "none", 0, 0, 0);
		this.cost = 0;
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
			float square) {
		this.city = city;
		this.street = street;
		this.buildingNumber = buildingNumber;
		this.flatNumber = flatNumber;
		this.floor = floor;
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
	public void setSquare(float square) {
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
	public void setFloor(int floor) {
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
	public void setFlatNumber(int flatNumber) {
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
	public void setCity(String city) {
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
	public void setStreet(String street) {
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
	public void setBuildingNumber(String buildingNumber) {
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
	private static void numericFieldChecker(float value) {
		if (value <= 0) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Метод, проверяющий значения для строковых полей.
	 *
	 * @param value значение поля
	 */
	private static void stringFieldChecker(String value) {
		if (value.isEmpty() || value.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
}
