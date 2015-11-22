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

public class ConvirtiendoString extends JFrame {

	private JPanel contentPane;
	private JTextField edadJText;
	int edad,masa;
	String edadTxt;
	String masaTxt;
	private JTextField masaJText;
	private JLabel lblMasaCorporal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvirtiendoString frame = new ConvirtiendoString();
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
	public ConvirtiendoString() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 11, 46, 14);
		contentPane.add(lblEdad);
		
		edadJText = new JTextField();
		edadJText.setBounds(10, 36, 290, 20);
		contentPane.add(edadJText);
		edadJText.setColumns(10);
		
		JButton btnConvertir = new JButton("Calcular");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Convertimos la edad en un int
				edadTxt=edadJText.getText();
				edad=Integer.valueOf(edadTxt);
				System.out.println("Edad "+edad);
				//Calcular la masa corporal
				masa=edad*2+10;
				masaTxt=String.valueOf(masa);
				masaJText.setText(masaTxt);
			}
		});
		btnConvertir.setBounds(10, 72, 89, 23);
		contentPane.add(btnConvertir);
		
		masaJText = new JTextField();
		masaJText.setColumns(10);
		masaJText.setBounds(10, 131, 290, 20);
		contentPane.add(masaJText);
		
		lblMasaCorporal = new JLabel("Masa corporal");
		lblMasaCorporal.setBounds(10, 106, 125, 14);
		contentPane.add(lblMasaCorporal);
	}
}
