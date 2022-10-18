package exceptions;

/**
 * Класс исключения, возникающего при присвоении ненатурального числа полям float
 */
public class NaturalFloatException extends Exception {
  private final float number;
  public float getNumber() { return number; }

  /**
   * @param message сообщение для исключения
   * @param number число, из-за которого было вызвано исключение
   */
  public NaturalFloatException(String message, float number) {
    super(message);
    this.number = number;
  }
}