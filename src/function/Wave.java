package function;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import common.WavePanel;

public class Wave extends WavePanel {

	/**
	 * right to left wave line
	 */
	private static final long serialVersionUID = 6468793172802060425L;
	private java.util.List<Integer> values; // 保存接收到的数据的容器.
	private static final int MAX_VALUE = 50; // 接收到的数据的最大值.
	private static final int MAX_COUNT_OF_VALUES = 20; // 最多保存数据的个数.

	public Wave() {

		values = Collections.synchronizedList(new ArrayList<Integer>());

		// 使用一个线程模拟产生数据.
		new Thread(new Runnable() {
			@Override
			public void run() {
				Random rand = new Random();
				try {
					while (true) {
						addValue(rand.nextInt(MAX_VALUE)); // 产生一个数据，并模拟接收并放到容器里.
						repaint();
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 抗锯齿

		g2d.setStroke(new BasicStroke(6)); // stroke

		int w = getWidth();
		int h = getHeight();
		int gap = (w / MAX_COUNT_OF_VALUES); // avg gap
		int length = values.size(); // length of list

		for (int i = 0; i < length - 1; ++i) {
			// line
			g2d.setStroke(new BasicStroke(4)); // stroke
			g2d.setColor(new Color(255, 51, 102));
			g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

			// wave line
			g2d.setColor(new Color(99, 184, 255));
			g2d.setStroke(new BasicStroke(6)); // stroke
			g2d.drawLine(gap * (MAX_COUNT_OF_VALUES - length + i), normalizeValueForYAxis(values.get(i), h),
					gap * (MAX_COUNT_OF_VALUES - length + i + 1), normalizeValueForYAxis(values.get(i + 1), h));

			// draw circle
			g2d.setStroke(new BasicStroke(8)); // stroke
			int r = 5;
			g2d.setColor(new Color(238, 154, 0));
			g2d.drawOval((gap * (MAX_COUNT_OF_VALUES - length + i)) - r, (normalizeValueForYAxis(values.get(i), h)) - r,
					r * 2, r * 2);

		}
	}

	private void addValue(int value) {
		if (values.size() > MAX_COUNT_OF_VALUES) {
			values.remove(0);
		}
		values.add(value);
	}

	private int normalizeValueForYAxis(int value, int h) {
		return (int) ((double) h / MAX_VALUE * value);
	}

}
