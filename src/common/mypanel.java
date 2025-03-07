package common;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class mypanel extends JPanel {

	/**
	 * panel
	 */
	private static final long serialVersionUID = -9177368255482734306L;
	private ImageIcon mIcon;

	public mypanel(ImageIcon micon) {
		this.setOpaque(false);
		this.mIcon = micon;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(mIcon.getImage(), 0, 0, mIcon.getIconWidth(), mIcon.getIconHeight(), this);

	}
}
