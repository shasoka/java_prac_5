package exceptions;

/**
 * Класс самописного исключения.
 * Исключение-последстиве исключений EmptyStringException или NegativeNumberException.
 */
public class InitialisationException extends Exception {
	
	/**
	 * Параметризованный конструктор класса Initialisation.
	 *
	 * @param message сообщение, выводимое при возникновении исключения
	 * @param cause исключение-причина вызванного исключения
	 */
	public InitialisationException(String message, Exception cause) {
		super(message, cause);
	}
	
}
