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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaFornecedor extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel Quadro;
	private JLabel lblseusProdutos;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaFornecedor frame = new AreaFornecedor();
					frame.setVisible(true);
					frame.setTitle("Área Fornecedor");
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
	public AreaFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		Quadro = new JPanel();
		Quadro.setBackground(new Color(198, 182, 155));
		Quadro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Quadro);
		Quadro.setLayout(null);
		
		
		Choice meusProdutosChoice = new Choice();
		meusProdutosChoice.setBounds(75, 178, 229, 20);
		Quadro.add(meusProdutosChoice);
		
		
		
		JLabel meusProdutosFornecedorLabel = new JLabel("Meus Produtos");
		meusProdutosFornecedorLabel.setForeground(new Color(80, 49, 49));
		meusProdutosFornecedorLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		meusProdutosFornecedorLabel.setBounds(113, 147, 150, 25);
		Quadro.add(meusProdutosFornecedorLabel);
		
		JLabel areaFornecedorTituloLabel = new JLabel("ÁREA FORNECEDOR");
		areaFornecedorTituloLabel.setForeground(new Color(80, 49, 49));
		areaFornecedorTituloLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		areaFornecedorTituloLabel.setBounds(184, 35, 300, 51);
		Quadro.add(areaFornecedorTituloLabel);
		
		
		
		
		JButton novoProdutoButton = new JButton("NOVO PRODUTO");
		novoProdutoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos2 areaFornecedor = new Produtos2();
				areaFornecedor.setVisible(true);
				dispose();
			}
		});
		novoProdutoButton.setBackground(new Color(80, 49, 49));
		novoProdutoButton.setForeground(new Color(198, 182, 155));
		novoProdutoButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		novoProdutoButton.setBounds(449, 160, 170, 45);
		novoProdutoButton.setFocusable(false);
		Quadro.add(novoProdutoButton);
		
		JButton deletarButton = new JButton("DELETAR");
		deletarButton.setBackground(new Color(80, 49, 49));
		deletarButton.setForeground(new Color(198, 182, 155));
		deletarButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deletarButton.setBounds(476, 467, 120, 30);
		deletarButton.setFocusable(false);
		Quadro.add(deletarButton);
		
		JButton editarButton = new JButton("EDITAR");
		editarButton.setBackground(new Color(80, 49, 49));
		editarButton.setForeground(new Color(198, 182, 155));
		editarButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		editarButton.setBounds(476, 384, 120, 30);
		editarButton.setFocusable(false);
		Quadro.add(editarButton);
		
		
		
		JButton deslogarAreaFornecedorButton = new JButton("");
		deslogarAreaFornecedorButton.setIcon(new ImageIcon(AreaFornecedor.class.getResource("/guisoftwareimgs/portavoltar.png")));
		deslogarAreaFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial enderecoFornecedor = new PaginaInicial();
				enderecoFornecedor.setVisible(true);
				dispose();
			}
		});
		deslogarAreaFornecedorButton.setForeground(new Color(198, 182, 155));
		deslogarAreaFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deslogarAreaFornecedorButton.setBackground(new Color(80, 49, 49));
		deslogarAreaFornecedorButton.setBounds(0, 538, 58, 73);
		Quadro.add(deslogarAreaFornecedorButton);
		
		
		
	}
}
