package trapockage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TraHistory {
	public static String history = new String();

	public static String readTxt() {
		try {
			String relativepath = System.getProperty("user.dir") + "\\History.txt";
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new File(relativepath));
			while (in.hasNext()) {
				String str = in.nextLine();
				history += str + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return history;
	}

	public static void CleanTxt() {

		try {
			String relativepath = System.getProperty("user.dir") + "\\History.txt";
			FileWriter fileWriter = new FileWriter(relativepath);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeTxt(String History) {
		BufferedWriter out = null;
		try {
			String relativepath = System.getProperty("user.dir") + "\\History.txt";
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(relativepath, true)));
			out.write(History);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean createTxt() throws IOException {
		String filenameTemp;
		boolean flag = false;
		String path = System.getProperty("user.dir");
		filenameTemp = path + "\\History.txt";
		File filename = new File(filenameTemp);
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}
}
