package function;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pic extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -190820594456665282L;
	private ImageIcon[] mIcon = new ImageIcon[10];;
	private ImageIcon myIcon;

	public Pic() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					String path = String.format("src/img/%d.png", i); // 格式化工具
					// System.out.println(path);
					mIcon[i] = new ImageIcon(path);

				}
				repaint();
			}
		}).start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(myIcon.getImage(), 0, 0, myIcon.getIconWidth(), myIcon.getIconHeight(), this);
		repaint();
	}
}
