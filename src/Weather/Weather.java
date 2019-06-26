package Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import SideBar.Setting;
public class Weather implements Runnable{

	public String info[] = new String[9];
	public boolean complete=false;
	public boolean read=false;
	public Weather() {
		
	}
	public void ReRead()
	{
		complete=false;
		read=false;
		for (int i = 0; i < info.length; i++) {
			info[i]=null;
		}
		
	}
	@Override 
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			if(complete==false)
			{
				
				String[] pra = { "", "", "", "" };
				
				try {
					String pythonFile = System.getProperty("user.dir") + "\\src\\Weather\\WeatherSpider.exe";
					pra[0] = pythonFile;
					pra[1] = String.valueOf(Setting.Hlocation);
					String[] paramter = new String[] { pra[0], pra[1] };

					Process pr = Runtime.getRuntime().exec(paramter);
					BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
					String call;
					int i = 0;
					while ((call = in.readLine()) != null) {
						this.info[i] = call;
						i++;
					}
					complete=true;
					in.close();
					pr.waitFor();
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
