package one.gui;

import javax.swing.JPanel;

import one.gui.OptionPanel.OptionPanelListener;

import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadoTempPanel extends JPanel {

	public interface ResultadoTempPanelListener {
		void onVolverRTPPressed();
		
	}
	private ResultadoTempPanelListener resultadoTempPanelListener;
	private JLabel lblInput;
	
	public void setResultadoTempPanelListener(ResultadoTempPanelListener listener) {
		this.resultadoTempPanelListener = listener;
	}
	
	public void setInputYResultado(String input,String resultado) {
		this.lblInput.setText(input+" son "+resultado);
		
		
	}
	public ResultadoTempPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{48, 0, 0, 0};
		setLayout(gridBagLayout);
		
		lblInput = new JLabel("DE INPUT1 A INPUT2 SON: ");
		GridBagConstraints gbc_lblInput = new GridBagConstraints();
		gbc_lblInput.anchor = GridBagConstraints.WEST;
		gbc_lblInput.gridx = 1;
		gbc_lblInput.gridy = 0;
		add(lblInput, gbc_lblInput);
		
		JLabel lblNewLabel_2 = new JLabel("\u00BFQuiere realizar otra operaci\u00F3n?");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton = new JButton("S\u00ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultadoTempPanelListener.onVolverRTPPressed();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}

}
