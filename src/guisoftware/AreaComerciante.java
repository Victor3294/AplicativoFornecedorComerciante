package guisoftware;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pacote.conector.MetodoDAO;
import pacoteDTO.FornecedorDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AreaComerciante extends JFrame {

	private JPanel contentPane;
	private JTextField oQueVoceProcuraTextField;
	private JTable areaComercianteTable;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaComerciante frame = new AreaComerciante();
					frame.setVisible(true);
					frame.setTitle("Área Comerciante");
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
	public AreaComerciante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 182, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel oQueVoceProcuraLabel = new JLabel("O que você procura ?");
		oQueVoceProcuraLabel.setForeground(new Color(80, 49, 49));
		oQueVoceProcuraLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oQueVoceProcuraLabel.setBounds(75, 165, 195, 25);
		contentPane.add(oQueVoceProcuraLabel);
		
		
		JLabel areaDoComercianteLabel = new JLabel("ÁREA DO COMERCIANTE");
		areaDoComercianteLabel.setForeground(new Color(80, 49, 49));
		areaDoComercianteLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		areaDoComercianteLabel.setBounds(150, 30, 373, 51);
		contentPane.add(areaDoComercianteLabel);
		
		
		
		
		oQueVoceProcuraTextField = new JTextField();
		oQueVoceProcuraTextField.setBounds(52, 201, 234, 30);
		contentPane.add(oQueVoceProcuraTextField);
		oQueVoceProcuraTextField.setColumns(10);
		
		
		
		
		
		JButton deslogarAreaFornecedorButton = new JButton("");
		deslogarAreaFornecedorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaInicial deslogar = new PaginaInicial();
				deslogar.setVisible(true);
				dispose();
			}
		});
		deslogarAreaFornecedorButton.setIcon(new ImageIcon(AreaComerciante.class.getResource("/guisoftwareimgs/portavoltar.png")));
		deslogarAreaFornecedorButton.setForeground(new Color(198, 182, 155));
		deslogarAreaFornecedorButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		deslogarAreaFornecedorButton.setBackground(new Color(80, 49, 49));
		deslogarAreaFornecedorButton.setBounds(10, 527, 58, 73);
		deslogarAreaFornecedorButton.setFocusable(false);
		contentPane.add(deslogarAreaFornecedorButton);
		
		JButton areaComerciantePesquisarButton = new JButton("Pesquisar");
		areaComerciantePesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FornecedorDTO objFornecedorDTO = new FornecedorDTO();
					MetodoDAO objFornecedorDAO = new MetodoDAO();
					objFornecedorDTO.setNomeProduto(oQueVoceProcuraTextField.getText());
					ArrayList<FornecedorDTO> listaID = objFornecedorDAO.retiraIDFornecedorProduto(objFornecedorDTO);
					DefaultTableModel model = new DefaultTableModel() {
						
						private static final long serialVersionUID = 1L;

						@Override
						  public boolean isCellEditable(int row, int column) {
						   
						    return false;
						  }
						};
					
					model.addColumn("Coluna 1");
					model.addColumn("Coluna 2");
					model.addColumn("Coluna 3");
					model.addColumn("Coluna 4");
					
					ArrayList<FornecedorDTO> lista = objFornecedorDAO.PesquisaFornecedor( objFornecedorDTO);
					
					for(FornecedorDTO fornecedor: lista) {
						Object[] rowData = {fornecedor.getNomeFantasiaFornecedor(), fornecedor.getEntregaFornecedor(), fornecedor.getNomeProduto(), fornecedor.getProdutoPreco()};
						model.addRow(rowData);
					}
					areaComercianteTable.setModel(model);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Mostra Lista: " +  erro);
				}
			}});
		areaComerciantePesquisarButton.setBounds(197, 242, 89, 23);
		contentPane.add(areaComerciantePesquisarButton);
		
		JScrollPane scrollPaneAreaComerciante = new JScrollPane();
		scrollPaneAreaComerciante.setEnabled(false);
		scrollPaneAreaComerciante.setBounds(312, 144, 343, 315);
		contentPane.add(scrollPaneAreaComerciante);
		
		areaComercianteTable = new JTable();
		
		
		areaComercianteTable.setFocusable(false);
		areaComercianteTable.getTableHeader().setReorderingAllowed(false);
		scrollPaneAreaComerciante.setViewportView(areaComercianteTable);
	}	
}



