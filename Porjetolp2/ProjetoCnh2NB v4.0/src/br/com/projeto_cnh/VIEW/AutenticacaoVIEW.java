package br.com.projeto_cnh.VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author Henrique Hyonemoto
 * @author Marina Nakashima
 */

public class AutenticacaoVIEW extends PrincipalVIEW {
	// Sistema de Login Criptografado com SHA2-256
		private static final long serialVersionUID = 1L;
		static JPanel contentPane;
		private static JTextField txtuser;
		private static JPasswordField passwordField;
		static String Client = "37B9FC9718F32B6F8CC447812D6E9EE6309D3DFFEA9EEC4315D96390227834E1";
		static String Corp = "9863D98D2031A799645BA7F451EFFAE03B7FE2E8EAB625DD4C05D504B7771A19";
		static String senhaout;
		static String senha;
		static MessageDigest algorithm = null;
		static byte messageDigest[] = null;
		static StringBuilder hexString;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AutenticacaoVIEW auth = new AutenticacaoVIEW();
						auth.setVisible(true);
						auth.setTitle("Sistema Autoescola");
						auth.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		// Criando frame Login
		public AutenticacaoVIEW() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(-6, -37, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JButton btnLogin = new JButton("Login");
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					if (txtuser.getText().equals("")) {
						System.out.println("Digite o usuário!");
					}
					if (passwordField == null) {
						System.out.println("Digite a senha!");
					}
					ChecarLogin();
				}
			});

			btnLogin.setBounds(208, 154, 88, 25);
			contentPane.add(btnLogin);
			txtuser = new JTextField();
			txtuser.setBounds(198, 72, 114, 19);
			contentPane.add(txtuser);
			txtuser.setColumns(10);

			JLabel lblUsurio = new JLabel("Usuário:");
			lblUsurio.setBounds(120, 74, 70, 15);
			contentPane.add(lblUsurio);

			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setBounds(130, 115, 70, 15);
			contentPane.add(lblSenha);

			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						ChecarLogin();
					}
				}
			});
			passwordField.setBounds(198, 113, 114, 19);
			contentPane.add(passwordField);
		}

		public static void ChecarLogin() {

			senha = new String(passwordField.getPassword());
			try {
				algorithm = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			senhaout = hexString.toString();

			if (txtuser.getText().equals("OPERADOR") && (senhaout.equals(Client))) {
				PrincipalVIEW principal = new PrincipalVIEW();
				principal.setVisible(true);
				PrincipalVIEW.menuBar.setVisible(true);
				PrincipalVIEW.menuCadastro.setVisible(true);
				PrincipalVIEW.menuCliente.setVisible(false);
				PrincipalVIEW.menuInstrutor.setVisible(false);
				PrincipalVIEW.menuSair.setVisible(true);
				PrincipalVIEW.menuVeiculo.setVisible(true);
				// contentPane.dispose();
				//senha: CLIENTE
			}

			if (txtuser.getText().equals("ADMIN") && (senhaout.equals(Corp))) {
				PrincipalVIEW principal = new PrincipalVIEW();
				principal.setVisible(true);
				PrincipalVIEW.menuBar.setVisible(true);
				PrincipalVIEW.menuCadastro.setVisible(true);
				PrincipalVIEW.menuCliente.setVisible(true);
				PrincipalVIEW.menuInstrutor.setVisible(true);
				PrincipalVIEW.menuSair.setVisible(true);
				PrincipalVIEW.menuVeiculo.setVisible(true);
				// contentPane.dispose();
				//senha: MESTRE
			}
			// FormPrincipal.chckbxmntmFullHd.setSelected(true);
			// FormPrincipal.chkModel();
		}
}
