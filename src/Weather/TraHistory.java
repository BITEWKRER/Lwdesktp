package Weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TraHistory {

	public static void readTxt() {
		try {
			String relativepath = System.getProperty("user.dir") + "\\History.txt";
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new File(relativepath));
			while (in.hasNext()) {
				String str = in.nextLine();
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void writeTxt(String History) {

		try {
			String relativepath = System.getProperty("user.dir") + "\\History.txt";
			System.out.println(relativepath);
			PrintWriter out = new PrintWriter(relativepath);
			out.write(History);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
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
