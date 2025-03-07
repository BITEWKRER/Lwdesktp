package jmp123.gui;

import java.io.IOException;
import jmp123.PlayBack;
import jmp123.decoder.IAudio;

public class PlayListThread extends Thread {
	private volatile boolean interrupted;
	private PlayBack playback;
	private String path;
	private boolean playing = false;

	public PlayListThread(IAudio audio) {
		playback = new PlayBack(audio);
		setName("playlist_thread");
	}

	public synchronized void pause() {
		if (playing) {
			playback.pause();
		}
	}

	public void append(String path) {
		this.path = path;
		playback.stop();
		playback.close();
		if (playing == false) {
			start();
			playing = true;
		}
	}

	/**
	 * 终止此播放线程。
	 */

	public synchronized void interrupt() {
		interrupted = true;
		super.interrupt();
		playback.stop();
	}

	@Override
	public void run() {

		while (!interrupted) {
			try {
				if (playback.open(path, "")) {
					playback.start(false);
				}
			} catch (IOException e) {
				// 如果打开网络文件时被用户中断，会抛出异常。
			} finally {
				playback.close();
			}
		}
//		System.out.println("jmp123.gui.PlayListThread.run() ret.");
	}

}
