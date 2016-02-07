import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	//Panel contenedor
	private JPanel contentPane;

	//Un objeto operaciones
	private Operaciones op;
	
	//botones
	private JButton boton1 = new JButton("1");
	private JButton boton2 = new JButton("2");
	private JButton boton3 = new JButton("3");
	private JButton boton4 = new JButton("4");
	private JButton boton5 = new JButton("5");
	private JButton boton6 = new JButton("6");
	private JButton boton7 = new JButton("7");
	private JButton boton8 = new JButton("8");
	private JButton boton9 = new JButton("9");
	private JButton boton0 = new JButton("0");
	
	//texto resultados
	private JTextField resultado;
	
	//Etiqueta para mi LOG
	private static String _NOMBRE="CALCULADORA";


	/**
	 * Constructor de la Calculadora
	 */
	public Calculadora() {
		System.out.println("Entro en "+_NOMBRE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boton1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton1.setBounds(10, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton1.addActionListener(new miBotonCalculadora());
		contentPane.add(boton1);
		
		boton2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton2.setBounds(79, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton2.addActionListener(new miBotonCalculadora());
		contentPane.add(boton2);
		
		boton3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton3.setBounds(148, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton3.addActionListener(new miBotonCalculadora());
		contentPane.add(boton3);
		
		boton4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton4.setBounds(10, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton4.addActionListener(new miBotonCalculadora());
		contentPane.add(boton4);
		
		boton5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton5.setBounds(79, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton5.addActionListener(new miBotonCalculadora());
		contentPane.add(boton5);
		
		boton6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton6.setBounds(148, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton6.addActionListener(new miBotonCalculadora());
		contentPane.add(boton6);
		
		boton7.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton7.setBounds(10, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton7.addActionListener(new miBotonCalculadora());
		contentPane.add(boton7);
		
		boton8.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton8.setBounds(79, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton8.addActionListener(new miBotonCalculadora());
		contentPane.add(boton8);
		
		boton9.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton9.setBounds(148, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton9.addActionListener(new miBotonCalculadora());
		contentPane.add(boton9);
		
		boton0.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton0.setBounds(79, 218, 59, 58);
		//Aqui se incluye el evento del boton
		boton0.addActionListener(new miBotonCalculadora());
		contentPane.add(boton0);
		
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setFont(new Font("Arial", Font.PLAIN, 16));
		resultado.setBounds(220, 11, 204, 58);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		//Generar un nuevo objeto op
		op=new Operaciones();
	}
	
	//Mi implementación especifica de un ActionListener
	//A través de un Inner class
	private class miBotonCalculadora implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton)e.getSource();
			resultado.setText(resultado.getText()+(b.getText()));
		} 
		
	}
}
