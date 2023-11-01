package com.transportSys.gui.del;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelPayments extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelPayments() {
		setBorder(new LineBorder(new Color(64, 64, 64), 4));
		setBackground(new Color(255, 248, 220));
		setSize(697, 693);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payments");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 50));
		lblNewLabel.setBounds(37, 34, 402, 69);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
		panel.setBounds(10, 24, 677, 97);
		add(panel);
	}
}
