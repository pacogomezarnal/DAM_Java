import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProbandoBoton extends JFrame {

	private JPanel contentPane;
	private JTextField caja;
	private JButton boton2;
	private JTextField caja2;

	/*
	 * Punto de entrada a nuesttra app
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoBoton frame = new ProbandoBoton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configuración de la ventana
	 */
	public ProbandoBoton() {
		//Marco y contenido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton
		JButton boton = new JButton("APRETAME!!");
		//LISTENER + EVENTO
		//------------
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Accion  a desarrollar
				caja.setText("Mensaje cuando aprieto");
			}
		});
		//------------
		boton.setBounds(10, 11, 113, 23);
		contentPane.add(boton);
		
		//Mi caja de texto
		caja = new JTextField();
		caja.setBounds(10, 59, 414, 20);		
		contentPane.add(caja);
		caja.setColumns(10);
		
		//Segundo boton
		boton2 = new JButton("COMEME!!");
		//LISTENER + EVENTO
		//------------
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caja2.setText(caja.getText());
			}
		});
		//------------
		boton2.setBounds(10, 107, 113, 23);
		contentPane.add(boton2);
		
		
		//Segunda caja
		caja2 = new JTextField();
		caja2.setColumns(10);
		caja2.setBounds(10, 158, 414, 20);
		contentPane.add(caja2);
		
	}
}
