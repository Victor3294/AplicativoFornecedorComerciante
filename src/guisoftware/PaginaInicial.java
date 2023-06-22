package guisoftware;

import java.awt.EventQueue;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.Canvas;
import java.awt.Scrollbar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaginaInicial extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel Quadro;
	private JLabel aindaSemCadastroLabel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial frame = new PaginaInicial();
					frame.setVisible(true);
					frame.setTitle("Bem-Vindo");
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaginaInicial() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		Quadro = new JPanel();
		Quadro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		Quadro.setBackground(new Color(198, 182, 155));
		Quadro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Quadro);
		Quadro.setLayout(null);
		
		
		
		aindaSemCadastroLabel = new JLabel("Já possui cadastro?");
		aindaSemCadastroLabel.setForeground(new Color(80, 49, 49));
		aindaSemCadastroLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		aindaSemCadastroLabel.setBounds(24, 509, 151, 25);
		Quadro.add(aindaSemCadastroLabel);
		
		JLabel CompraLabel = new JLabel("COMPRA E VENDA");
		CompraLabel.setForeground(new Color(98, 49, 49));
		CompraLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CompraLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		CompraLabel.setBounds(150, 44, 379, 51);
		Quadro.add(CompraLabel);
		
		JLabel pratoLabel = new JLabel("");
		pratoLabel.setIcon(new ImageIcon(PaginaInicial.class.getResource("/guisoftwareimgs/pratofinal.png")));
		pratoLabel.setBounds(502, 211, 110, 110);
		Quadro.add(pratoLabel);
		
		JLabel caminhaoLabel = new JLabel("");
		caminhaoLabel.setIcon(new ImageIcon(PaginaInicial.class.getResource("/guisoftwareimgs/truckzinho.png")));
		caminhaoLabel.setBounds(72, 211, 110, 110);
		Quadro.add(caminhaoLabel);
		
		JLabel aindaNaoCadastroPaginaIncialLabel = new JLabel("Ainda não possui cadastro?");
		aindaNaoCadastroPaginaIncialLabel.setForeground(new Color(80, 49, 49));
		aindaNaoCadastroPaginaIncialLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aindaNaoCadastroPaginaIncialLabel.setBounds(470, 395, 177, 25);
		Quadro.add(aindaNaoCadastroPaginaIncialLabel);
		
		JLabel selecionaFuncaoPaginaIncialLabel = new JLabel("Seleciona sua função para cadastrar-se");
		selecionaFuncaoPaginaIncialLabel.setForeground(new Color(80, 49, 49));
		selecionaFuncaoPaginaIncialLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		selecionaFuncaoPaginaIncialLabel.setBounds(447, 419, 227, 25);
		Quadro.add(selecionaFuncaoPaginaIncialLabel);
		
		
		
		
		
		JButton FornecedorBotao = new JButton("FORNECEDOR");
		FornecedorBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedorCadastro paginaInicial = new FornecedorCadastro();
				paginaInicial.setVisible(true);
				dispose();
			}
		});
		FornecedorBotao.setForeground(new Color(198, 182, 155));
		FornecedorBotao.setBackground(new Color(80, 49, 49));
		FornecedorBotao.setFont(new Font("Tahoma", Font.BOLD, 15));
		FornecedorBotao.setBounds(487, 536, 158, 51);
		FornecedorBotao.setFocusable(false);
		Quadro.add(FornecedorBotao);
		
		JButton ComercianteBotao = new JButton("COMERCIANTE");
		ComercianteBotao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		ComercianteBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComercianteCadastro paginaInicial = new ComercianteCadastro();
				paginaInicial.setVisible(true);
				dispose();
			}
		});
		ComercianteBotao.setBackground(new Color(80, 49, 49));
		ComercianteBotao.setForeground(new Color(198, 182, 155));
		ComercianteBotao.setFont(new Font("Tahoma", Font.BOLD, 15));
		ComercianteBotao.setBounds(487, 453, 158, 51);
		ComercianteBotao.setFocusable(false);
		Quadro.add(ComercianteBotao);
		
		
		
		JButton EntrarLoginBotao = new JButton("ENTRAR");
		EntrarLoginBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGIN paginaInicial = new LOGIN();
				paginaInicial.setVisible(true);
				dispose();
			}
		});
		EntrarLoginBotao.setForeground(new Color(198, 182, 155));
		EntrarLoginBotao.setBackground(new Color(80, 49, 49));
		EntrarLoginBotao.setFont(new Font("Tahoma", Font.BOLD, 15));
		EntrarLoginBotao.setBounds(34, 535, 120, 40);
		EntrarLoginBotao.setFocusable(false);
		Quadro.add(EntrarLoginBotao);
	
		
		
		
		
		
		
	}
}
