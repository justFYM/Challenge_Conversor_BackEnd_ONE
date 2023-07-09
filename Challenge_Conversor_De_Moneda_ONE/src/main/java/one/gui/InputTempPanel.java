package one.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputTempPanel extends JPanel {


	public interface InputTempPanelListener {
	    void onVolverITPPressed();
	    void onConvertirITPressed();
	}

	private InputTempPanelListener inputTempPanelListener;

	public void setInputTempPanelListener(InputTempPanelListener listener) {
		this.inputTempPanelListener = listener;
	}
	private JTextField textField;
	private JLabel lblOption;

	public void setSelectedOption(String selectedOption) {
		lblOption.setText(selectedOption);
	}  
	public String getSelectedOption() {
		String option = lblOption.getText();
		return option;
	}  
	
	public String getDinero() {
		String dinero = textField.getText();
		return dinero;
	}


	public InputTempPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Opci\u00F3n seleccionada:  ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, -15, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		lblOption = new JLabel("aaa");
		lblOption.setEnabled(false);
		GridBagConstraints gbc_lblOption = new GridBagConstraints();
		gbc_lblOption.anchor = GridBagConstraints.EAST;
		gbc_lblOption.insets = new Insets(0, 0, 5, -15);
		gbc_lblOption.gridx = 0;
		gbc_lblOption.gridy = 0;
		add(lblOption, gbc_lblOption);

		JLabel lblTexto = new JLabel("Ingrese la temperatura que quiere convertir");
		GridBagConstraints gbc_lblTexto = new GridBagConstraints();
		gbc_lblTexto.insets = new Insets(10, 10, 10, 10);
		gbc_lblTexto.gridx = 0;
		gbc_lblTexto.gridy = 2;
		add(lblTexto, gbc_lblTexto);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(10, 10, 10, 10);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnConvertir = new JButton("Convertir");
		GridBagConstraints gbc_btnConvertir = new GridBagConstraints();
		gbc_btnConvertir.anchor = GridBagConstraints.EAST;
		gbc_btnConvertir.insets = new Insets(10, 10, 10, 40);
		gbc_btnConvertir.gridx = 0;
		gbc_btnConvertir.gridy = 4;
		add(btnConvertir, gbc_btnConvertir);
		btnConvertir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (inputTempPanelListener != null) {
		        	inputTempPanelListener.onConvertirITPressed();
		        }
		    }
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inputTempPanelListener != null) {
					inputTempPanelListener.onVolverITPPressed();
				}
			}
		});


		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.anchor = GridBagConstraints.WEST;
		gbc_btnVolver.insets = new Insets(10, 40, 10, 10);
		gbc_btnVolver.gridx = 0;
		gbc_btnVolver.gridy = 4;
		add(btnVolver, gbc_btnVolver);


	}
}
