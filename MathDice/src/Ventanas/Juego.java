package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;
import Juego.JugadorDB;
import Modelo.confDB;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;

public class Juego extends JPanel {

	//Paneles generales
	private JPanel contentPane;
	
	//Array de dados
	private ImageIcon[] dados3=new ImageIcon[3];
	private ImageIcon[] dados6=new ImageIcon[6];
	private ImageIcon[] dados12=new ImageIcon[12];
	private ImageIcon dadoGris;
	private Random dado=new Random(); //variable que permite controlar el random de los dados
	
	//Almacenamos los numeros aleatorios necesarios para después realizar el cálculo
	private int[] numerosAlmacenadosDados3=new int[3];
	private int[] numerosAlmacenadosDados6=new int[2];
	private int numerosAlmacenadosDados12;
	
	//Clase que almacena el Jugador
	private Jugador player;
	JLabel nombreJugador;
	JLabel puntuacion;
	
	//JLabel de las imágenes
	private JLabel dado1,dado2,dado3;
	private JLabel dado4,dado5;
	private JLabel dado6;
	
	//JLabel de los botones de cotrol
	private JButton suma,resta,mathdice;
	//Caja de resultado
	private JTextField resultado;

	//diferentes variables que nos permiten realizar el control de la app
	private boolean tocaNumero=true;
	private int operacion=0;
	private int numerosIntroducidos=0;
	private boolean esSuma=true;
	
	//JLable de muestra de resultados
	private JLabel resultadoLabel;
	private JLabel resultadoOK;
	//Boton repetir
	private JButton repetir;
	
	//Manejador de la base de datos
	private confDB db;
	private JugadorDB jdb;
	/**
	 * Create the frame.
	 */
	public Juego() {
		//Panel principal
		//setTitle("JUEGO");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1000, 530);
		
		contentPane = this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		setLayout(null);
		
		//Dados, configuraciones gennerales
		dado1 = new JLabel("");
		dado1.setBounds(10, 10, 150, 150);
		contentPane.add(dado1);
		
		dado2 = new JLabel("");
		dado2.setBounds(160, 10, 150, 150);
		contentPane.add(dado2);

		dado3 = new JLabel("");
		dado3.setBounds(310, 10, 150, 150);
		contentPane.add(dado3);
		
		dado4 = new JLabel("");
		dado4.setBounds(10, 160, 150, 150);
		contentPane.add(dado4);
		
		dado5 = new JLabel("");
		dado5.setBounds(160, 160, 150, 150);
		contentPane.add(dado5);		

		dado6 = new JLabel("");
		dado6.setBounds(10, 310, 173, 173);
		contentPane.add(dado6);	
		
		//Colocamos los botones de suma y resta
		suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tocaNumero){
					resultado.setText(resultado.getText()+"+");
					tocaNumero=true;
					esSuma=true;
				}
			}
		});
		suma.setFont(new Font("Tahoma", Font.PLAIN, 24));
		suma.setBounds(510, 62, 195, 63);
		contentPane.add(suma);		
		
		resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!tocaNumero){
					resultado.setText(resultado.getText()+"-");
					tocaNumero=true;
					esSuma=false;
				}
			}
		});
		
		//Texto del jugador
		nombreJugador = new JLabel("Bienvenido");
		nombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador.setBounds(510, 5, 464, 21);
		contentPane.add(nombreJugador);
		resta.setFont(new Font("Tahoma", Font.PLAIN, 24));
		resta.setBounds(779, 62, 195, 63);
		contentPane.add(resta);
		
		//Caja de resultados
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(510, 136, 464, 63);
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 36));
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		//Colocamos el boton de resultado
		mathdice = new JButton("MATHDICE");
		mathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numerosIntroducidos>1){
					resultadoLabel.setText("Tu operación es "+String.valueOf(operacion));
					repetir.setEnabled(true);
					if((numerosAlmacenadosDados12+1)==operacion){
						resultadoOK.setText("CORRECTÍSIMO");
						player.setPuntos(player.getPuntos()+5);
						puntuacion.setText("Tu puntuacion es: "+player.getPuntos());
						jdb.actualizarUsuarioPuntos(confDB.getConexion());
					}else{
						resultadoOK.setText("INTÉNTALO DE NUEVO");
					}
				}
			}
		});
		mathdice.setFont(new Font("Tahoma", Font.PLAIN, 24));
		mathdice.setBounds(510, 210, 464, 63);
		contentPane.add(mathdice);
		
		//Cajas de resultados
		resultadoLabel = new JLabel("");
		resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		resultadoLabel.setBounds(510, 358, 464, 41);
		contentPane.add(resultadoLabel);
		
		//Caja de OK
		resultadoOK = new JLabel("");
		resultadoOK.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoOK.setFont(new Font("Tahoma", Font.PLAIN, 36));
		resultadoOK.setBounds(510, 408, 464, 41);
		contentPane.add(resultadoOK);
		
		//BOTON REPETIR
		repetir = new JButton("REPETIR");
		repetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarBotones();
				repetir.setEnabled(false);
			}
		});
		repetir.setEnabled(false);
		repetir.setFont(new Font("Tahoma", Font.PLAIN, 24));
		repetir.setBounds(510, 284, 464, 63);
		contentPane.add(repetir);
		
		puntuacion = new JLabel("Tu puntuacion es: 0");
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
		puntuacion.setBounds(510, 35, 464, 21);
		add(puntuacion);
		
		inicializarBotones();
	}
	
	public void setJugador(Jugador player){
		this.player=player;
		nombreJugador.setText("Bienvenido al juego "+player.getNombre());
		puntuacion.setText("Tu puntuacion es: "+player.getPuntos());
		//Creamos el objeto JugaddorDB
		jdb=new JugadorDB(player);
	}
	private void inicializarBotones(){
		//Cargamos todas las imagenes en los arrays
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_3.png"));
		}
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("img/dado"+String.valueOf(i+1)+"_6.png"));
		}
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("img/dadodoce_"+String.valueOf(i+1)+".png"));
		}
		dadoGris=new ImageIcon(getClass().getResource("img/dadogris.png"));
		
		//Colocamos los dados de 3 caras
		for(int i=0;i<numerosAlmacenadosDados3.length;i++) numerosAlmacenadosDados3[i]=dado.nextInt(3); //El numero aleatorio
		dado1.setIcon(dados3[numerosAlmacenadosDados3[0]]); //Imagen dentro de los JLabel
		dado1.setName("1");
		dado2.setIcon(dados3[numerosAlmacenadosDados3[1]]);
		dado2.setName("2");
		dado3.setIcon(dados3[numerosAlmacenadosDados3[2]]);
		dado3.setName("3");
		dado1.addMouseListener(new ListenerDados());
		dado2.addMouseListener(new ListenerDados());
		dado3.addMouseListener(new ListenerDados());
		//Colocamos los dados de 6 caras
		for(int i=0;i<numerosAlmacenadosDados6.length;i++) numerosAlmacenadosDados6[i]=dado.nextInt(6);
		dado4.setIcon(dados6[numerosAlmacenadosDados6[0]]);
		dado4.setName("4");
		dado5.setIcon(dados6[numerosAlmacenadosDados6[1]]);
		dado5.setName("5");
		dado4.addMouseListener(new ListenerDados());
		dado5.addMouseListener(new ListenerDados());
		//Colocamos los dados de 12 caras
		numerosAlmacenadosDados12=dado.nextInt(12);
		dado6.setIcon(dados12[numerosAlmacenadosDados12]);		
		//REseteamos cajas
		resultadoLabel.setText("");
		resultadoOK.setText("");
		resultado.setText("");
		
		//REseteamos semaforos y  valores
		tocaNumero=true;
		
		operacion=0;
		numerosIntroducidos=0;
		esSuma=true;		
		
	}
	
	private void setOperacion(int num){
		numerosIntroducidos++;
		if(numerosIntroducidos>1){
			if(esSuma) operacion=operacion+num;
			else operacion=operacion-num;
		}else{
			operacion=num;
		}
	}
	
	//Mi implementación especifica de un ActionListener
	//A través de un Inner class
	private class ListenerDados implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel dado = (JLabel) e.getSource();
			int numeroDado=Integer.valueOf(dado.getName());
			if(tocaNumero){
				if(numeroDado<4)
					resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados3[numeroDado-1]+1));
				else
					resultado.setText(resultado.getText()+String.valueOf(numerosAlmacenadosDados6[numeroDado-4]+1));
				dado.removeMouseListener(this);
				dado.setIcon(dadoGris);
				tocaNumero=false;
				if(numeroDado<4)
					setOperacion(numerosAlmacenadosDados3[numeroDado-1]+1);
				else
					setOperacion(numerosAlmacenadosDados6[numeroDado-4]+1);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

	}
}
