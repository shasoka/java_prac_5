package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/** Метод, отвечающий за чтение данных из файла и их запись (сериализацию). */
public class FileIO {
	
	/**
	 * Метод, сериализующий массив объектов типа ArrayList<Flat> в файл ./data.dat.
	 *
	 * @param arr массив для сериализации
	 */
	public static void WriteFile(ArrayList<Flat> arr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
			oos.writeObject(arr);
		} catch (IOException e) {
			System.err.println("Some problems with your file!\n");
		}
	}
	
	/**
	 * Метод, десериализующий массив объектов типа ArrayList<Flat> из файла ./data.dat.
	 *
	 * @return прочитанный массив (null в случае неудачи чтения)
	 */
	public static ArrayList<Flat> ReadFile() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"))) {
			return (ArrayList<Flat>) ois.readObject();  // непроверенный каст
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Some problems with your file!\n");
			return null;  // возврат null в случае неудачи
		}
	}
	
}
