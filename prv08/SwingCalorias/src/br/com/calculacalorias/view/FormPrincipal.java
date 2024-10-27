/**
@author Rick
 */
package br.com.calculacalorias.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.calculacalorias.controller.Calorias;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal {

	private JFrame frmCalculadoraImcVerso;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JTextField textFieldIMC;
	private JTextField textFieldIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal window = new FormPrincipal();
					window.frmCalculadoraImcVerso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraImcVerso = new JFrame();
		frmCalculadoraImcVerso.setTitle("Calculadora Calorias");
		frmCalculadoraImcVerso.setBounds(100, 100, 450, 300);
		frmCalculadoraImcVerso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraImcVerso.getContentPane().setLayout(null);

		JLabel lblDigiteSeuPeso = new JLabel("Digite seu peso:");
		lblDigiteSeuPeso.setBounds(31, 58, 148, 25);
		frmCalculadoraImcVerso.getContentPane().add(lblDigiteSeuPeso);

		JLabel lblDigiteSuaAltura = new JLabel("Digite sua altura:");
		lblDigiteSuaAltura.setBounds(31, 95, 148, 25);
		frmCalculadoraImcVerso.getContentPane().add(lblDigiteSuaAltura);

		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(159, 61, 78, 19);
		frmCalculadoraImcVerso.getContentPane().add(textFieldPeso);
		textFieldPeso.setColumns(10);

		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(159, 98, 78, 19);
		frmCalculadoraImcVerso.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);

		JLabel lblIMC = new JLabel("Suas Calorias São:");
		lblIMC.setBounds(31, 212, 217, 25);
		frmCalculadoraImcVerso.getContentPane().add(lblIMC);

		textFieldIMC = new JTextField();
		textFieldIMC.setBounds(224, 214, 114, 19);
		frmCalculadoraImcVerso.getContentPane().add(textFieldIMC);
		textFieldIMC.setColumns(10);

		JButton btnCalcula = new JButton("Calcular");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Calorias cal = new Calorias(Float.parseFloat(textFieldPeso.getText()),
				Float.parseFloat(textFieldAltura.getText()),Integer.parseInt(textFieldIdade.getText()));

				String resultado = Float.toString(cal.calculaCalorias());
				textFieldIMC.setText(resultado);
			}
		});
		btnCalcula.setBounds(159, 176, 117, 25);
		frmCalculadoraImcVerso.getContentPane().add(btnCalcula);
		
		JLabel lblDigiteSeuPeso_1 = new JLabel("Digite sua idade:");
		lblDigiteSeuPeso_1.setBounds(31, 132, 148, 25);
		frmCalculadoraImcVerso.getContentPane().add(lblDigiteSeuPeso_1);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setColumns(10);
		textFieldIdade.setBounds(159, 135, 78, 19);
		frmCalculadoraImcVerso.getContentPane().add(textFieldIdade);
	}
}
