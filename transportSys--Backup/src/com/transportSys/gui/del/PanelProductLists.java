package com.transportSys.gui.del;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PanelProductLists extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelProductLists() {
		setSize(697, 693);
		setLayout(null);
		
		JLabel lblProductLists = new JLabel("Product Lists");
		lblProductLists.setFont(new Font("Century Gothic", Font.BOLD, 50));
		lblProductLists.setBounds(37, 20, 402, 69);
		add(lblProductLists);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.DARK_GRAY, 5, true));
		panel.setBackground(Color.GREEN);
		panel.setBounds(10, 10, 677, 97);
		add(panel);
	}

}
