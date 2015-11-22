package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaImc extends JFrame {

	private JPanel contentPane;
	private JTextField masaJtext;
	private JTextField alturaJtext;
	private JTextField imcJtext;
	
	//Las variables necesarias para realizar el calculo
	String masa,estatura,imc;
	float masaF,estaturaF,imcF;
	float estaturaFmetros;

	/**
	 * Create the frame.
	 */
	public VentanaImc() {
		setTitle("Calculadora IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Masa (Kg)");
		lblNewLabel.setBounds(10, 11, 116, 14);
		contentPane.add(lblNewLabel);
		
		masaJtext = new JTextField();
		masaJtext.setBounds(10, 36, 116, 20);
		contentPane.add(masaJtext);
		masaJtext.setColumns(10);
		
		JLabel lblEstaturacm = new JLabel("Estatura (cm)");
		lblEstaturacm.setBounds(10, 72, 116, 14);
		contentPane.add(lblEstaturacm);
		
		alturaJtext = new JTextField();
		alturaJtext.setColumns(10);
		alturaJtext.setBounds(10, 97, 116, 20);
		contentPane.add(alturaJtext);
		
		JButton btnNewButton = new JButton("IMC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Recoger los datos de la ventana
				masa=masaJtext.getText();
				masaF=Float.valueOf(masa);
				System.out.println(masaF);
				estatura=alturaJtext.getText();
				estaturaF=Float.valueOf(estatura);
				System.out.println(estaturaF);
				//Calcular imc
				estaturaFmetros=estaturaF/100;
				System.out.println(estaturaFmetros);
				imcF=(masaF)/(estaturaFmetros*estaturaFmetros);
				System.out.println(imcF);
				//Sacar por pantalla imc
				imcJtext.setText(String.valueOf(imcF));
			}
		});
		btnNewButton.setBounds(136, 96, 109, 23);
		contentPane.add(btnNewButton);
		
		imcJtext = new JTextField();
		imcJtext.setEditable(false);
		imcJtext.setBounds(255, 97, 169, 20);
		contentPane.add(imcJtext);
		imcJtext.setColumns(10);
	}

}
