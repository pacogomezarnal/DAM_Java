package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	//Clase que almacena el Jugador
	private Jugador player;
	
	//Clase que almacena la ventana de Juego
	private Juego ventanaJuego =new Juego();
	//Clase que almacena la ventana de Perfil
	private Perfil ventanaPerfil =new Perfil();
	
	//IDENTIFICADORES
	final static String VENTANAJ = "Ventana Juego";
	final static String VENTANAP = "Ventana Perfil";



	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVentanas = new JMenu("Ventanas");
		menuBar.add(mnVentanas);
		
		JMenuItem mntmJuego = new JMenuItem("Juego");
		mnVentanas.add(mntmJuego);
		mntmJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANAJ);
			}
		});
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnVentanas.add(mntmPerfil);
		mntmPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANAP);
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadir las ventanas al contenedor
		
		contentPane.add(ventanaJuego,VENTANAJ);
		contentPane.add(ventanaPerfil,VENTANAP);
		

	}
	
	public void setJugador(Jugador player){
		this.player=player;
		ventanaJuego.setJugador(player);
		ventanaPerfil.setJugador(player);
	}
}
