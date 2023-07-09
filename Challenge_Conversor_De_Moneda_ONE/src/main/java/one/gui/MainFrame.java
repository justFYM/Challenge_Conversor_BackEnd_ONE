package one.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import one.gui.InputPanel.InputPanelListener;
import one.gui.InputTempPanel.InputTempPanelListener;
import one.gui.OptionPanel.OptionPanelListener;
import one.gui.OptionTempPanel.OptionTempPanelListener;
import one.gui.ResultadoDineroPanel.ResultadoDineroPanelListener;
import one.gui.ResultadoTempPanel.ResultadoTempPanelListener;

public class MainFrame extends JFrame implements InputPanelListener, OptionPanelListener, ResultadoDineroPanelListener, InputTempPanelListener, OptionTempPanelListener, ResultadoTempPanelListener{

	private JPanel contentPanel;
	private JComboBox<String> selectComboBox;
	private InputPanel inputPanel;
	private OptionPanel	optionPanel;
	private ResultadoDineroPanel resultadoDineroPanel;
	private InputTempPanel inputTempPanel;
	private OptionTempPanel optionTempPanel;
	private ResultadoTempPanel resultadoTempPanel;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Conversor de moneda / temperatura");


		getContentPane().setLayout(new BorderLayout());


		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { -2, 37, -15 }; 
		contentPanel = new JPanel(gbl_contentPanel);


		getContentPane().add(contentPanel, BorderLayout.CENTER);

		selectComboBox = new JComboBox<>();
		selectComboBox.addItem("Conversor de moneda");
		selectComboBox.addItem("Conversor de temperatura");


		JLabel titleLabel = new JLabel("Bienvenido/a");


		GridBagConstraints titleLabelConstraints = new GridBagConstraints();
		titleLabelConstraints.insets = new Insets(0, 0, 5, 5);
		titleLabelConstraints.gridx = 1; 
		titleLabelConstraints.gridy = 0;
		titleLabelConstraints.anchor = GridBagConstraints.CENTER;
		titleLabelConstraints.insets.top = 10;
		titleLabelConstraints.insets.bottom = 10;
		contentPanel.add(titleLabel, titleLabelConstraints);


		GridBagConstraints comboBoxConstraints = new GridBagConstraints();
		comboBoxConstraints.insets = new Insets(0, 0, 5, 5);
		comboBoxConstraints.gridx = 1; 
		comboBoxConstraints.gridy = 1;
		comboBoxConstraints.anchor = GridBagConstraints.CENTER;
		comboBoxConstraints.insets.top = 10;
		comboBoxConstraints.insets.bottom = 10;
		contentPanel.add(selectComboBox, comboBoxConstraints);



		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.insets = new Insets(10, -35, 10, 5);
		buttonConstraints.gridx = 1; 
		buttonConstraints.gridy = 2;
		buttonConstraints.anchor = GridBagConstraints.WEST;
		JButton button = new JButton("Aceptar");
		contentPanel.add(button, buttonConstraints);


		button.setSize(button.getPreferredSize()); 
		int buttonWidth = button.getWidth(); 


		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = selectComboBox.getSelectedIndex()+1;
				if(option==1) {
					
					contentPanel.setVisible(false);
					getContentPane().remove(contentPanel);
					inputPanel.setVisible(true);
					
					getContentPane().add(inputPanel, BorderLayout.CENTER);

					String selectedOption = (String) selectComboBox.getSelectedItem();

					
					inputPanel.setSelectedOption(selectedOption);
				}else {
					
					contentPanel.setVisible(false);
					getContentPane().remove(contentPanel);
					inputTempPanel.setVisible(true);
					
					getContentPane().add(inputTempPanel, BorderLayout.CENTER);

					String selectedOption = (String) selectComboBox.getSelectedItem();

					
					inputTempPanel.setSelectedOption(selectedOption);
				}




			}
		});

		
		GridBagConstraints cancelButtonConstraints = new GridBagConstraints();
		cancelButtonConstraints.insets = new Insets(10, 5, 10, -35);
		cancelButtonConstraints.gridx = 1;
		cancelButtonConstraints.gridy = 2;
		cancelButtonConstraints.anchor = GridBagConstraints.EAST;
		JButton cancelButton = new JButton("Salir");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPanel.add(cancelButton, cancelButtonConstraints);

		inputPanel = new InputPanel();
		inputPanel.setVisible(false); 

		
		inputPanel.setInputPanelListener(this);

		
		optionPanel = new OptionPanel();
		optionPanel.setVisible(false);
		optionPanel.setOptionPanelListener(this);

		
		resultadoDineroPanel = new ResultadoDineroPanel();
		resultadoDineroPanel.setVisible(false);
		resultadoDineroPanel.setResultadoDineroPanelListener(this);

		
		inputTempPanel = new InputTempPanel();
		inputTempPanel.setVisible(false);
		inputTempPanel.setInputTempPanelListener(this);

		
		optionTempPanel = new OptionTempPanel();
		optionTempPanel.setVisible(false);
		optionTempPanel.setOptionTempPanelListener(this);

		
		resultadoTempPanel = new ResultadoTempPanel();
		resultadoTempPanel.setVisible(false);
		resultadoTempPanel.setResultadoTempPanelListener(this);

		pack();
		setMinimumSize(new Dimension(400, 400)); 
		setLocationRelativeTo(null); 
	}

	@Override
	public void onVolverPressed() {
		getContentPane().remove(inputPanel); 
		getContentPane().add(contentPanel);
		contentPanel.setVisible(true); 
	}
	@Override
	public void onVolverOPPressed() {
		getContentPane().remove(optionPanel); 
		getContentPane().add(inputPanel);
		optionPanel.setVisible(false);
		inputPanel.setVisible(true); 
	}
	@Override
	public void onVolverRDPPressed() {
		getContentPane().remove(resultadoDineroPanel); 
		resultadoDineroPanel.setVisible(false);
		getContentPane().add(contentPanel);
		contentPanel.setVisible(true);
		
	}
	@Override
	public void onVolverRTPPressed() {
		getContentPane().remove(resultadoTempPanel); 
		resultadoTempPanel.setVisible(false);
		getContentPane().add(contentPanel);
		contentPanel.setVisible(true);
		
	}
	@Override
	public void onVolverITPPressed() {
		getContentPane().remove(inputTempPanel); 
		inputTempPanel.setVisible(false);
		getContentPane().add(contentPanel);
		contentPanel.setVisible(true);
		
	}
	@Override
	public void onVolverOTPPressed() {
		getContentPane().remove(optionTempPanel); 
		getContentPane().add(inputTempPanel);
		optionTempPanel.setVisible(false);
		inputTempPanel.setVisible(true); 
	}

	public void onConvertirPressed() {
		contentPanel.setVisible(false); 
		getContentPane().remove(contentPanel);
		inputPanel.setVisible(false); 
		getContentPane().remove(inputPanel);
		String dineroIngresado = inputPanel.getDinero();
		optionPanel.setDinero(dineroIngresado); 
		
		optionPanel.setVisible(true);
		getContentPane().add(optionPanel);

		
	}
	public void onConvertirITPressed() {
		contentPanel.setVisible(false); 
		getContentPane().remove(contentPanel);
		inputTempPanel.setVisible(false); 
		getContentPane().remove(inputTempPanel);
		String dineroIngresado = inputTempPanel.getDinero();
		optionTempPanel.setDinero(dineroIngresado); 
		
		optionTempPanel.setVisible(true);
		getContentPane().add(optionTempPanel);

		
	}
	public void onConvertirOPPressed(String input, String resultado) {
		contentPanel.setVisible(false); 
		getContentPane().remove(contentPanel);
		optionPanel.setVisible(false); 
		getContentPane().remove(optionPanel);
		resultadoDineroPanel.setVisible(true);
		resultadoDineroPanel.setInputYResultado(input, resultado);
		getContentPane().add(resultadoDineroPanel);

		
	}
	public void onConvertirOTPPressed(String input, String resultado) {
		contentPanel.setVisible(false); 
		getContentPane().remove(contentPanel);
		optionTempPanel.setVisible(false); 
		getContentPane().remove(optionTempPanel);
		resultadoTempPanel.setVisible(true);
		resultadoTempPanel.setInputYResultado(input, resultado);
		getContentPane().add(resultadoTempPanel);

		
	}



	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}
}
