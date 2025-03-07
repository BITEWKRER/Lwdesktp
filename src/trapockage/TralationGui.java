package trapockage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import SideBar.ShowText;

public class TralationGui extends JFrame {

	/**
	 * ����Gui
	 */
	private static final long serialVersionUID = -3924685216407329361L;

	private Translation translation;
	private int flag = 1;
	private int tra_flag = 0;
	private JButton submitbtn = new JButton("�ύ");
	private JButton clearbtn = new JButton("���");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TralationGui() throws IOException {

		this.setLayout(null);
		this.add(new ShowText(20, 2, 150, 30, "�����뷭���ı���", new Color(0, 0, 0)));
		this.add(new ShowText(360, 2, 150, 30, "��������", new Color(0, 0, 0)));

		JTextArea inputtext = new JTextArea();
		inputtext.setLineWrap(true);
		inputtext.setLayout(null);
		inputtext.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		JScrollPane inputjsp = new JScrollPane(inputtext);
		inputjsp.setBounds(10, 30, 230, 190);
		inputjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		JTextArea outputtext = new JTextArea();
		outputtext.setLineWrap(true);
		outputtext.setLayout(null);
		outputtext.setEditable(false);
		outputtext.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		JScrollPane outputjsp = new JScrollPane(outputtext);
		outputjsp.setBounds(355, 30, 230, 190);
		outputjsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		JComboBox Tra_box = new JComboBox();
		Tra_box.setBounds(245, 35, 100, 25);
		Tra_box.addItem("�ȸ跭��");
		Tra_box.addItem("��ɽ�ʰ�");
		Tra_box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (e.getItem() == "�ȸ跭��") {
					tra_flag = 0;
				} else if (e.getItem() == "��ɽ�ʰ�") {
					tra_flag = 1;
				}
			}
		});

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(245, 65, 100, 25);
		comboBox.addItem("����Ӣ");
		comboBox.addItem("������");
		comboBox.addItem("Ӣ����");
		comboBox.addItem("Ӣ����");
		comboBox.addItem("������");
		comboBox.addItem("����Ӣ");

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem() == "����Ӣ") {
					flag = 1;
				} else if (e.getItem() == "������") {
					flag = 3;
				} else if (e.getItem() == "Ӣ����") {
					flag = 2;
				} else if (e.getItem() == "Ӣ����") {
					flag = 3;
				} else if (e.getItem() == "������") {
					flag = 2;
				} else if (e.getItem() == "����Ӣ") {
					flag = 1;
				}
			}
		});

		TraHistory.createTxt();
		submitbtn.setBounds(245, 95, 100, 25);
		submitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (inputtext.getText().length() == 0) {
					outputtext.setText("����Ϊ��,�����ԣ�");
				} else {
					translation = new Translation(inputtext.getText(), flag, tra_flag);
					if (translation.Result.substring(1).length() != 0) {
						outputtext.setText(translation.Result.substring(1));
						TraHistory.writeTxt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " -->  "
								+ inputtext.getText() + "  :  " + outputtext.getText() + "\n");
					} else {
						outputtext.setText("�����޽��");
					}

				}
			}
		});
		clearbtn.setBounds(245, 125, 100, 25);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputtext.setText("");
				outputtext.setText("");
			}
		});

		this.add(Tra_box);
		this.add(comboBox);
		this.add(inputjsp);
		this.add(outputjsp);
		this.add(clearbtn);
		this.add(submitbtn);
		this.setTitle("��ʱ����-.-!  ");
		this.setSize(600, 290);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

}
