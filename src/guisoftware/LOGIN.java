package guisoftware;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import pacote.conector.MetodoDAO;
import pacoteDTO.Comerciante_DTO;
import pacoteDTO.FornecedorDTO;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;


public class LOGIN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailCnpjLoginTextField;
	
	private ImageIcon icone;
	private JPasswordField senhaLoginPassword;
	private JCheckBox senhaCheckbox;
	private JFormattedTextField emailcnpjLoginFormatted;
	private MaskFormatter mascaraLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
					frame.setTitle("Login");
					frame.setResizable(false);
					ImageIcon icone = new ImageIcon(getClass().getResource("/guisoftwareimgs/carrinhoicone.png"));
                    frame.setIconImage(icone.getImage());
                   
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel cnpjLoginLabel = new JLabel("CNPJ:");
		cnpjLoginLabel.setForeground(new Color(80, 49, 49));
		cnpjLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cnpjLoginLabel.setBounds(128, 341, 80, 20);
		contentPane.add(cnpjLoginLabel);
		
		JLabel senhaLoginLabel = new JLabel("SENHA:");
		senhaLoginLabel.setForeground(new Color(80, 49, 49));
		senhaLoginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		senhaLoginLabel.setBounds(128, 416, 68, 30);
		contentPane.add(senhaLoginLabel);
		
		JLabel aindaNaoPossuiPerguntaLabel = new JLabel("Ainda não possui cadastro ?");
		aindaNaoPossuiPerguntaLabel.setForeground(new Color(80, 49, 49));
		aindaNaoPossuiPerguntaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aindaNaoPossuiPerguntaLabel.setBounds(10, 508, 193, 52);
		contentPane.add(aindaNaoPossuiPerguntaLabel);
		
		JLabel loginTituloLabel = new JLabel("LOGIN");
		loginTituloLabel.setForeground(new Color(80, 49, 49));
		loginTituloLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		loginTituloLabel.setBounds(331, 77, 120, 78);
		contentPane.add(loginTituloLabel);
		
		JLabel imagemLabel = new JLabel("");
		imagemLabel.setIcon(new ImageIcon(LOGIN.class.getResource("bolos.png")));///guisoftwareimgs/
		imagemLabel.setBounds(167, 61, 120, 120);
		contentPane.add(imagemLabel);
		
		
		
		
	
		
		emailcnpjLoginFormatted = new JFormattedTextField();

		try{
            mascaraLogin = new MaskFormatter("##.###.###/####-##");
            
            mascaraLogin.setPlaceholderCharacter('_');
           
     }
     catch(ParseException excp) {
            
            JOptionPane.showMessageDialog(null, "Erro na formatação: " +  excp.getMessage());
            System.exit(-1);
     }
		
	
		emailcnpjLoginFormatted = new JFormattedTextField(mascaraLogin);
		emailcnpjLoginFormatted.setColumns(10);
		emailcnpjLoginFormatted.setBounds(207, 340, 220, 30);
		
		contentPane.add(emailcnpjLoginFormatted);
	
		
		senhaLoginPassword = new JPasswordField();
		senhaLoginPassword.setColumns(10);
		senhaLoginPassword.setBounds(208, 420, 220, 30);
		senhaLoginPassword.setDocument(new LimiteeTipo(10, LimiteeTipo.TipoEntrada.EMAIL));
		contentPane.add(senhaLoginPassword);
		
		senhaCheckbox = new JCheckBox("Mostrar Senha");
		senhaCheckbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(senhaCheckbox.isSelected()) {
					senhaLoginPassword.setEchoChar((char)0);
				}else {
					senhaLoginPassword.setEchoChar('*');
				}
			}
		});
		senhaCheckbox.setForeground(new Color(198, 182, 155));
		senhaCheckbox.setBackground(new Color(80, 49, 49));
		senhaCheckbox.setBounds(451, 424, 117, 23);
		contentPane.add(senhaCheckbox);
		
		JRadioButton comercianteLoginRadioButton = new JRadioButton("Comerciante");
		comercianteLoginRadioButton.setBackground(new Color(198, 185, 155));
		comercianteLoginRadioButton.setBounds(193, 282, 108, 23);
		contentPane.add(comercianteLoginRadioButton);
		
		JRadioButton fornecedorLoginRadioButtton = new JRadioButton("Fornecedor");
		fornecedorLoginRadioButtton.setBackground(new Color(198, 185, 155));
		fornecedorLoginRadioButtton.setBounds(333, 282, 99, 23);
		contentPane.add(fornecedorLoginRadioButtton);
		
		ButtonGroup fornecedorComerciantePerguntaGrupo = new ButtonGroup();
		fornecedorComerciantePerguntaGrupo.add(fornecedorLoginRadioButtton);
		fornecedorComerciantePerguntaGrupo.add(comercianteLoginRadioButton);
		
		
		
		
		
		JLabel perguntaChaveLabel = new JLabel("Qual das funções abaixo você  gostaria de acessar?");
		perguntaChaveLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		perguntaChaveLabel.setBounds(169, 251, 295, 24);
		contentPane.add(perguntaChaveLabel);
		
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(fornecedorLoginRadioButtton.isSelected()) {
						try {
							FornecedorDTO objFornecedor = new FornecedorDTO();
							objFornecedor.setCnpjFornecedor(emailCnpjLoginTextField.getText());
							objFornecedor.setSenhaFornecedor(senhaLoginPassword.getPassword());
							MetodoDAO objFornecedorAutenticador = new MetodoDAO();
							ResultSet rsobjFornecedorAutenticador = objFornecedorAutenticador.autenticaUsuario(objFornecedor);
							if(rsobjFornecedorAutenticador.next()) {
								AreaFornecedor entrarFornecedor = new AreaFornecedor();
								entrarFornecedor.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Senha ou CNPJ incorretos.");
							}
						} catch (SQLException erro) {
							JOptionPane.showMessageDialog(null, "LOGIN Fornecedor " + erro.getMessage());
						}
					}
					else if(comercianteLoginRadioButton.isSelected()) {
						try {
							Comerciante_DTO objComerciante = new Comerciante_DTO();
							objComerciante.setCnpjComerciante(emailCnpjLoginTextField.getText());
							objComerciante.setSenhaComerciante(senhaLoginPassword.getPassword());
							MetodoDAO objComercianteAutenticador = new MetodoDAO();
							ResultSet rsobjComercianteAutenticador = objComercianteAutenticador.autenticaUsuario(objComerciante);
							if(rsobjComercianteAutenticador.next()) {
								AreaComerciante entrarComerciante = new AreaComerciante();
								entrarComerciante.setVisible(true);
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "Senha ou CNPJ incorretos");
							}
						} catch (SQLException erro) {
							JOptionPane.showMessageDialog(null, "LOGIN Comerciante" +  erro);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Selecione uma das opções de acesso.");
					}
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "LOGIN " + erro);
				}
			}
		});
		entrarButton.setBackground(new Color(80, 49, 49));
		entrarButton.setForeground(new Color(198, 182, 155));
		entrarButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		entrarButton.setBounds(532, 558, 120, 30);
		entrarButton.setFocusable(false);
		contentPane.add(entrarButton);
		
		JButton cadastrarseButton = new JButton("CADASTRAR-SE");
		cadastrarseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial cadastrarse = new PaginaInicial();
				cadastrarse.setVisible(true);
				dispose();
				
			}
		});
		cadastrarseButton.setBackground(new Color(80, 49, 49));
		cadastrarseButton.setForeground(new Color(198, 182, 155));
		cadastrarseButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		cadastrarseButton.setBounds(20, 558, 135, 30);
		cadastrarseButton.setFocusable(false);
		contentPane.add(cadastrarseButton);
		
		
		
	
	}
	
	
}


