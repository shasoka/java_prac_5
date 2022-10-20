package exceptions;

/**
 * Класс самописного исключения.
 * Исключение возникает в случае, если полю типа String была передана пустая или null строка.
 */
public class EmptyStringException extends Exception {

  /**
   * Параметризованный конструктор класса EmptyStringException.
   *
   * @param message сообщение, выводимое при возникновении исключения
   */
  public EmptyStringException(String message) {
    super(message);
  }
  
}
