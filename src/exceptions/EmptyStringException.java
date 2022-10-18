package exceptions;

/**
 * Класс самописного исключения.
 * Исключение возникает в случае, если полю типа String была передана пустая или null строка.
 */
public class EmptyStringException extends Exception {
  
  /** Строка, вызвавшая исключение. */
  private final String str;
  
  /** Метод, возвращающий значение поля str. */
  public String getStr() {
    return str;
  }

  /**
   * Параметризованный конструктор класса EmptyStringException.
   *
   * @param message сообщение, выводимое при возникновении исключения
   * @param str переданная строка
   */
  public EmptyStringException(String message, String str) {
    super(message);
    this.str = str;
  }
  
}
