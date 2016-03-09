import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

public class ProbandoCLayout extends JFrame {

	private JPanel contentPane;
	
	//IDENTIFICADORES
	final static String VENTANA1 = "Ventana 1";
	final static String VENTANA2 = "Ventana 2";
	
	Ventana1 v1=new Ventana1();
	Ventana2 v2=new Ventana2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoCLayout frame = new ProbandoCLayout();
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
	public ProbandoCLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Añadir las ventanas al contenedor
		contentPane.add(v1,VENTANA1);
		contentPane.add(v2,VENTANA2);
		
		
		//Accedemos al boton de Ventana 1
		v1.btnAVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANA2);
			}
		});
		//Accedemos al boton de Ventana 2
		v2.btnAVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    CardLayout cl = (CardLayout)(contentPane.getLayout());
			    cl.show(contentPane, VENTANA1);
			}
		});
	}

}
