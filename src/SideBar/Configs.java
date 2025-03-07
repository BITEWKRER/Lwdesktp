package SideBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Configs {
	public static String Config = new String();

	public static boolean createConfig() throws IOException {
		String filenameTemp;
		boolean flag = false;
		String path = System.getProperty("user.dir");
		filenameTemp = path + "\\Config.txt";
		File filename = new File(filenameTemp);
		if (!filename.exists()) {
			filename.createNewFile();
			flag = true;
		}
		return flag;
	}

	public static void writeConfig(String Config) {
		try {
			String relativepath = System.getProperty("user.dir") + "\\Config.txt";
			FileWriter fileWriter = new FileWriter(relativepath);
			fileWriter.write(Config);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readConfig() {
		try {
			String relativepath = System.getProperty("user.dir") + "\\Config.txt";
			Scanner in = new Scanner(new File(relativepath));
			while (in.hasNext()) {
				String str = in.nextLine();
				Config = str;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Config;
	}

	public static void CleanConfig() {

		try {
			String relativepath = System.getProperty("user.dir") + "\\Config.txt";
			FileWriter fileWriter = new FileWriter(relativepath);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
