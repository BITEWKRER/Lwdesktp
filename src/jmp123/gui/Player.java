/*
* Player.java -- jmp123 (JAVA MPEG-1/2/2.5 Layer I/II/III Player)
* Copyright (C) 2010
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* If you would like to negotiate alternate licensing terms, you may do
* so by contacting the author: <http://jmp123.sourceforge.net/>
*/
package jmp123.gui;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class Player extends JWindow {

	protected JCheckBoxMenuItem miViewAlbumFrame;
	private PlayListThread playlistThread;
	private AudioGUI theAudioGUI;

	public Player() {

		super();
		this.setLayout(null);
		this.setBackground(new Color(0, 0, 0, 0));
		this.initGUI();
		this.setVisible(false);
		this.toBack();
		this.setLocationRelativeTo(null);
		this.loadDefaultM3U();

		theAudioGUI.setVisible(true);
		this.add(theAudioGUI);
	}

	public AudioGUI getaudiogui() {
		return theAudioGUI;
	}
	public void setviewmodel(int m)
	{
		theAudioGUI.setHistogramType(m);
	}
	public void loadDefaultM3U() {
		playlistThread = new PlayListThread(theAudioGUI);
//		startPlaylistThread();
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		theAudioGUI.setVisible(b);
	}

	public PlayListThread getlistThread() {
		return playlistThread;
	}

	private void initGUI() {

		// 频谱显示
		theAudioGUI = new AudioGUI(44100);
		this.setSize(theAudioGUI.getWindowwh(1), theAudioGUI.getWindowwh(2));

	}

}
