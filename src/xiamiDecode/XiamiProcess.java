package xiamiDecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import SideBar.Setting;

public class XiamiProcess {

	public String[] Names = new String[30];
	public int i = 0;
	private int flag;

	public XiamiProcess(int flag) {
		this.flag = flag;
		Spider();
	}

	public void Spider() {
		String[] pra = { "", "", "", "" };

		try {
			String pythonFile = System.getProperty("user.dir") + "\\src\\xiamiDecode\\XiaMiSipder.exe";
			pra[0] = pythonFile;
			String[] paramter = new String[] { pra[0], String.valueOf(this.flag), String.valueOf(Setting.lists) };
			Process pr = Runtime.getRuntime().exec(paramter);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String call;
			while ((call = in.readLine()) != null) {
				Names[i] = call;
				i++;
			}
			in.close();
			pr.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
