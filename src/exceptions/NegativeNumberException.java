package exceptions;

/**
 * Класс самописного исключения.
 * Исключение возникает в случае, если полю типа int или float было передано отрицательное
 *  или равное нулю значение.
 */
public class NegativeNumberException extends Exception {
  
  /**
	 * Параметризованный конструктор класса NegativeNumberException.
	 *
	 * @param message сообщение, выводимое при возникновении исключения
	 */
  public NegativeNumberException(String message) {
    super(message);
  }
  
}
