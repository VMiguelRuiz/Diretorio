package br.com.diretorio.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.diretorio.classe.RetornaDiretorio;
import javax.swing.JComboBox;

public class ViewDiretorio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField diretorioText;
	private JTextField ftpText;
	private JLabel lblDiretrioD;
	private JLabel lblSadaFtp;
	private JCheckBox irD;
	private JCheckBox irFTP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDiretorio frame = new ViewDiretorio();
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
	public ViewDiretorio() {
		setTitle("Diret\u00F3rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		diretorioText = new JTextField();
		diretorioText.setBounds(23, 33, 498, 20);
		contentPane.add(diretorioText);
		diretorioText.setColumns(10);

		ftpText = new JTextField();
		ftpText.setBounds(23, 97, 498, 20);
		contentPane.add(ftpText);
		ftpText.setColumns(10);

		JButton btnNewButton = new JButton("Ir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetornaDiretorio dir = new RetornaDiretorio();

				String diretorio = diretorioText.getText();

				dir.setDiretorio(diretorio);

				dir.converteDiretorioParaFTP();

				dir.verificaStringVazia(irD.isSelected(), irFTP.isSelected());
				
				ftpText.setText(dir.getFtp());
			}
		});
		btnNewButton.setBounds(432, 139, 89, 23);
		contentPane.add(btnNewButton);

		lblDiretrioD = new JLabel("Entre com o diret\u00F3rio D:\\FTP");
		lblDiretrioD.setBounds(23, 11, 171, 14);
		contentPane.add(lblDiretrioD);

		lblSadaFtp = new JLabel("Sa\u00EDda FTP://200.155.3.179/");
		lblSadaFtp.setBounds(23, 72, 147, 14);
		contentPane.add(lblSadaFtp);

		irD = new JCheckBox("Ir para D:\\FTP");
		irD.setSelected(true);
		irD.setBounds(23, 139, 116, 23);
		contentPane.add(irD);

		irFTP = new JCheckBox("Ir para ftp://200.155.3.179/");
		irFTP.setSelected(true);
		irFTP.setBounds(141, 139, 171, 23);
		contentPane.add(irFTP);

	}
}
