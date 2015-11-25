package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private String nombreBoton;
	private Login referencia;
	private VentanaPrincipal vPrincipal;

	/**
	 * Create the frame.
	 */
	public Login(VentanaPrincipal vP) {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.nombreBoton="Cmbio texto";
		referencia=this;
		vPrincipal=vP;
		
		
		JButton boton = new JButton("Cerrar");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				referencia.dispose();
			}
		});
		boton.setBounds(238, 228, 186, 23);
		contentPane.add(boton);
		
		JButton saltarVentana = new JButton("VentanaPrincipal >>");
		saltarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.setVisible(true);
				referencia.setVisible(false);
			}
		});
		saltarVentana.setBounds(238, 194, 186, 23);
		contentPane.add(saltarVentana);
	}

}
