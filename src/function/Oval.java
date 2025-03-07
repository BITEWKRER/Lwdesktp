package function;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;
import java.util.Random;

import common.WavePanel;

public class Oval extends WavePanel {

	/**
	 * enable draw cirle once and once
	 */
	private static final long serialVersionUID = -4466706292627957614L;
	private int r = 100; // init radius
	private int i = 30;

	public Oval() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				new Random();
				try {
					while (true) {
						repaint();
						Thread.sleep(60);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

	private void Circle(Graphics g, int ragap) {
		int x0 = getWidth() / 2;
		int y0 = getHeight() / 2;// 圆心

		((Graphics2D) g).setStroke(new BasicStroke(2)); // stroke
		g.drawOval(x0 - r, y0 - r, r * 2, r * 2);// 椭圆

		((Graphics2D) g).setStroke(new BasicStroke(4)); // stroke
		g.drawOval(x0 - (r + ragap + 2), y0 - (r + ragap + 2), (r + ragap + 2) * 2, (r + ragap + 2) * 2);// 椭圆

	}

	private void Circle1(Graphics g, int ragap) {
		int x0 = getWidth() / 2;
		int y0 = getHeight() / 2;// 圆心

		((Graphics2D) g).setStroke(new BasicStroke(6)); // stroke
		g.drawOval(x0 - r, y0 - r, r * 2, r * 2);// 椭圆
		g.drawOval(x0 - (r + ragap), y0 - (r + ragap), (r + ragap) * 2, (r + ragap) * 2);// 椭圆
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int ragap = 8;
		g.setColor(new Color(255, 185, 15));
		Circle1(g, ragap);
		if ((r + ragap) > getWidth() / 150) {
			g.setColor(new Color(99, 184, 255));
			Circle(g, -30);

			g.setColor(new Color(102, 205, 170));
			Circle1(g, -70);

		}
		g.setColor(new Color(255, 185, 15));
		Circle(g, ragap + 10);

		g.setFont(new Font("微软雅黑", Font.PLAIN, i));
		// "yyyy-MM-dd HH:mm:ss"
		g.setColor(new Color(255, 51, 102));
		SimpleDateFormat df1 = new SimpleDateFormat(" HH:mm:ss");// 设置日期格式
		g.drawString(df1.format(new java.util.Date()), getWidth() / 4 + 50, getHeight() / 2);

		r += 10;
		if (r >= getWidth()) {
			r = 50;
		}
	}
}
