package exceptions;

/**
 * Класс самописного исключения.
 * Исключение возникает в случае, если полю типа int или float было передано отрицательное
 *  или равное нулю значение.
 */
public class NegativeNumberException extends Exception {
  
  /** Строка, вызвавшая исключение. */
  private final float number;
  
  /** Метод, возвращающий значение поля number. */
  public float getNumber() {
    return number;
  }
  
  /**
   * Параметризованный конструктор класса NegativeNumberException.
   *
   * @param message сообщение, выводимое при возникновении исключения
   * @param number переданное число
   */
  public NegativeNumberException(String message, float number) {
    super(message);
    this.number = number;
  }
  
}
