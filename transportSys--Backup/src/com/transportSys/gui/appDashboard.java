package com.transportSys.gui;

import com.transport.connection.employeeWindow;  // Adding payments

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;


public class appDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	//----- Declaring the panels/buttons as an instance variable(at the class level) of the 'appDashboard' -----
	private JPanel panelPayments;

	
	//-----------------------------------------------------------------------------------------------------------
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appDashboard frame = new appDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public appDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 750);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 250, 205));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//----------- Adding buttons to other GUI files: -----------
		panelPayments = new JPanel();
	    panelPayments.addMouseListener(new PanelButtonMouseAdapter(panelPayments));
		
	    
	    //-----------------------------------------------------------
	    
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 0, 128));
		panelMenu.setBounds(0, 0, 330, 713);
		contentPanel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelCustomers = new JPanel();
		panelCustomers.addMouseListener(new PanelButtonMouseAdapter(panelCustomers)); //Adding mouse hover/click effect
		panelCustomers.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelCustomers.setBackground(new Color(250, 240, 230));
		panelCustomers.setBounds(10, 210, 310, 50);
		panelMenu.add(panelCustomers);
		panelCustomers.setLayout(null);
		
		JLabel lblCustomers = new JLabel("Customers");
		lblCustomers.setForeground(new Color(0, 0, 0));
		lblCustomers.setHorizontalAlignment(SwingConstants.LEFT);
		lblCustomers.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblCustomers.setBounds(101, 10, 199, 31);
		panelCustomers.add(lblCustomers);
		
		JPanel panelOrders = new JPanel();
		panelOrders.addMouseListener(new PanelButtonMouseAdapter(panelOrders)); //Adding mouse hover/click effect
		panelOrders.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelOrders.setBackground(new Color(250, 240, 230));
		panelOrders.setBounds(10, 280, 310, 50);
		panelMenu.add(panelOrders);
		panelOrders.setLayout(null);
		
		JLabel lblOrders = new JLabel("Orders");
		lblOrders.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrders.setForeground(Color.BLACK);
		lblOrders.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblOrders.setBounds(101, 10, 199, 31);
		panelOrders.add(lblOrders);
		
		/*JPanel*/ panelPayments = new JPanel();
		panelPayments.addMouseListener(new PanelButtonMouseAdapter(panelPayments)); //Adding mouse hover/click effect
		panelPayments.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelPayments.setBackground(new Color(250, 240, 230));
		panelPayments.setBounds(10, 350, 310, 50);
		panelMenu.add(panelPayments);
		panelPayments.setLayout(null);
		
		JLabel lblPayments = new JLabel("Payments");
		lblPayments.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayments.setForeground(Color.BLACK);
		lblPayments.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblPayments.setBounds(101, 10, 199, 31);
		panelPayments.add(lblPayments);
		
		JPanel panelProductDeliveries = new JPanel();
		panelProductDeliveries.addMouseListener(new PanelButtonMouseAdapter(panelProductDeliveries)); //Adding mouse hover/click effect
		panelProductDeliveries.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelProductDeliveries.setBackground(new Color(250, 240, 230));
		panelProductDeliveries.setBounds(10, 420, 310, 50);
		panelMenu.add(panelProductDeliveries);
		panelProductDeliveries.setLayout(null);
		
		JLabel lblDeliveries = new JLabel("Deliveries");
		lblDeliveries.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeliveries.setForeground(Color.BLACK);
		lblDeliveries.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblDeliveries.setBounds(101, 10, 199, 31);
		panelProductDeliveries.add(lblDeliveries);
		
		JPanel panelProductLists = new JPanel();
		panelProductLists.addMouseListener(new PanelButtonMouseAdapter(panelProductLists)); //Adding mouse hover/click effect
		panelProductLists.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelProductLists.setBackground(new Color(250, 240, 230));
		panelProductLists.setBounds(10, 490, 310, 50);
		panelMenu.add(panelProductLists);
		panelProductLists.setLayout(null);
		
		JLabel lblProductLists = new JLabel("Product Lists");
		lblProductLists.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductLists.setForeground(Color.BLACK);
		lblProductLists.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblProductLists.setBounds(101, 10, 199, 31);
		panelProductLists.add(lblProductLists);
		
		JPanel panelEmployees = new JPanel();
		panelEmployees.addMouseListener(new PanelButtonMouseAdapter(panelEmployees)); //Adding mouse hover/click effect
		panelEmployees.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelEmployees.setBackground(new Color(250, 240, 230));
		panelEmployees.setBounds(10, 560, 310, 50);
		panelMenu.add(panelEmployees);
		panelEmployees.setLayout(null);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployees.setForeground(Color.BLACK);
		lblEmployees.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblEmployees.setBounds(101, 10, 199, 31);
		panelEmployees.add(lblEmployees);
		
		JPanel panelOffices = new JPanel();
		panelOffices.addMouseListener(new PanelButtonMouseAdapter(panelOffices)); //Adding mouse hover/click effect
		panelOffices.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelOffices.setBackground(new Color(250, 240, 230));
		panelOffices.setBounds(10, 630, 310, 50);
		panelMenu.add(panelOffices);
		panelOffices.setLayout(null);
		
		JLabel lblOffices = new JLabel("Offices");
		lblOffices.setHorizontalAlignment(SwingConstants.LEFT);
		lblOffices.setForeground(Color.BLACK);
		lblOffices.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblOffices.setBounds(101, 10, 199, 31);
		panelOffices.add(lblOffices);
		
		JPanel panelLogo = new JPanel();
//		panelHome.addMouseListener(new PanelButtonMouseAdapter(panelHome));
		panelLogo.setBounds(10, 10, 310, 190);
		panelMenu.add(panelLogo);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(358, 424, 530, 254);
		contentPanel.add(panelMainContent);
		panelMainContent.setLayout(null);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
	    
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
		    this.panel = panel;
		}
		    
		@Override
		public void mouseEntered(MouseEvent e) {
		    panel.setBackground(new Color(255, 228, 181)); // Light orange shade on hover
		}
		    
		@Override
		public void mouseExited(MouseEvent e) {
		    panel.setBackground(Color.WHITE); // Original white color when mouse exits
		}
		    
		@Override
		public void mousePressed(MouseEvent e) {
		    panel.setBackground(new Color(240, 240, 235)); // Slightly deeper shade on press
		}
		    
		@Override
		public void mouseReleased(MouseEvent e) {
		    panel.setBackground(new Color(255, 228, 181)); // Light orange shade on release
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		    if (panel == panelPayments) {
		        paymentsWindow windowGUI = new paymentsWindow();
		        windowGUI.setVisible(true);
		    }
		    // more code
		}
		
		
	}
}