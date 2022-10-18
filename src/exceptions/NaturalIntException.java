package exceptions;

/**
 * Класс исключения, возникающего при присвоении ненатурального числа полям integer
 */
public class NaturalIntException extends Exception {
  private final int number;
  public int getNumber() {
    return number;
  }

  /**
   * Консттруктор исключения
   * @param message сообщение для исключения
   * @param number число, из-за которого было вызвано исключение
   */
  public NaturalIntException(String message, int number) {
    super(message);
    this.number = number;
  }
}
