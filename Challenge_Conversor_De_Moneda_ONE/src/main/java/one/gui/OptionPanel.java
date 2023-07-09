package one.gui;

import javax.swing.JPanel;

import one.gui.InputPanel.InputPanelListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class OptionPanel extends JPanel {
	private JLabel lblDinero;



	public interface OptionPanelListener {
		void onVolverOPPressed();
		void onConvertirOPPressed(String monto, String resultado);
	}
	private OptionPanelListener optionPanelListener;
	public void setOptionPanelListener(OptionPanelListener listener) {
		this.optionPanelListener = listener;
	}

	
	public OptionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 128};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Monto: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(10, 80, 10, 10);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		lblDinero = new JLabel("New label");
		lblDinero.setEnabled(false);
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDinero = new GridBagConstraints();
		gbc_lblDinero.anchor = GridBagConstraints.EAST;
		gbc_lblDinero.insets = new Insets(10, 0, 10, 60);
		gbc_lblDinero.gridx = 2;
		gbc_lblDinero.gridy = 1;
		add(lblDinero, gbc_lblDinero);

		JLabel lblNewLabel_1 = new JLabel("Seleccione el tipo de conversi\u00F3n");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("De peso chileno a D�lar");
		comboBox.addItem("De peso chileno a Euros");
		comboBox.addItem("De peso chileno a Libras Esterlinas");
		comboBox.addItem("De peso chileno a Yen Japon�s");
		comboBox.addItem("De peso chileno a Won sul-coreano");
		comboBox.addItem("De D�lar a peso chileno");
		comboBox.addItem("De Euro a peso chileno");
		comboBox.addItem("De Libras Esterlinas a peso chileno");
		comboBox.addItem("De Yen Japon�s a peso chileno");
		comboBox.addItem("De Won sul-coreano a peso chileno");


		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(10, 10, 10, 10);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);

		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = comboBox.getSelectedIndex()+1;
				String resultado = calcularDinero(opcion, lblDinero.getText());
				String inputUno = inputUno(lblDinero.getText(), opcion);
				
			
				optionPanelListener.onConvertirOPPressed(inputUno, resultado);
			}
		});
		GridBagConstraints gbc_btnConvertir = new GridBagConstraints();
		gbc_btnConvertir.anchor = GridBagConstraints.EAST;
		gbc_btnConvertir.insets = new Insets(10, 10, 10, 35);
		gbc_btnConvertir.gridx = 2;
		gbc_btnConvertir.gridy = 4;
		add(btnConvertir, gbc_btnConvertir);

		JButton btnVolver = new JButton("Volver");
		GridBagConstraints gbc_btnVolver = new GridBagConstraints();
		gbc_btnVolver.anchor = GridBagConstraints.WEST;
		gbc_btnVolver.insets = new Insets(10, 35, 10, 10);
		gbc_btnVolver.gridx = 2;
		gbc_btnVolver.gridy = 4;
		add(btnVolver, gbc_btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (optionPanelListener != null) {
					optionPanelListener.onVolverOPPressed();
				}
			}
		});

	}
	public String calcularDinero(int opcion, String monto) {
		
		double numero = Double.parseDouble(monto);
		if(opcion == 1) {
			
			   double montoDolares = numero / 800;
			   DecimalFormat decimalFormat = new DecimalFormat("#.00");
		       String resultado = decimalFormat.format(montoDolares);
		       System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 2) {
			  double montoDolares = numero / 800;
			   DecimalFormat decimalFormat = new DecimalFormat("#.00");
		       String resultado = decimalFormat.format(montoDolares);
		       System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 3) {
			  double montoDolares = numero / 1000;
			   DecimalFormat decimalFormat = new DecimalFormat("#.00");
		       String resultado = decimalFormat.format(montoDolares);
		       System.out.println(resultado);
		       return resultado;

		}
	
		
		
		if(opcion == 4) {
			 double montoDolares = numero /6;
			   DecimalFormat decimalFormat = new DecimalFormat("#.00");
		       String resultado = decimalFormat.format(montoDolares);
		       System.out.println(resultado);
		       return resultado;
			
		}
		if(opcion == 5) {
			 double montoDolares = numero /5.5;
			   DecimalFormat decimalFormat = new DecimalFormat("#.00");
		       String resultado = decimalFormat.format(montoDolares);
		       System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 6) {
			 double montoDolares = numero * 800;
		     DecimalFormat decimalFormat = new DecimalFormat("#,###");
		       String resultado = decimalFormat.format(montoDolares);
		        
		        resultado = resultado.replace(",", "");
		        System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 7) {
			 double montoDolares = numero * 800;
		     DecimalFormat decimalFormat = new DecimalFormat("#,###");
		       String resultado = decimalFormat.format(montoDolares);
		        
		        resultado = resultado.replace(",", "");
		        System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 8) {
			 double montoDolares = numero * 1000;
		     DecimalFormat decimalFormat = new DecimalFormat("#,###");
		       String resultado = decimalFormat.format(montoDolares);
		        
		        resultado = resultado.replace(",", "");
		        System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 9) {
			 double montoDolares = numero * 6;
		     DecimalFormat decimalFormat = new DecimalFormat("#,###");
		       String resultado = decimalFormat.format(montoDolares);
		        
		        resultado = resultado.replace(",", "");
		        System.out.println(resultado);
		       return resultado;
		}
		if(opcion == 10) {
			 double montoDolares = numero * 5.5;
		     DecimalFormat decimalFormat = new DecimalFormat("#,###");
		       String resultado = decimalFormat.format(montoDolares);
		        
		        resultado = resultado.replace(",", "");
		        System.out.println(resultado);
		       return resultado;

		}
		
	
		return "";

	}
	
	
	

	public String inputUno (String dinero, int option) {
		String inputUno;
		if(option == 1) {
			 inputUno = dinero+" en peso chileno a D�lar";
			 return inputUno;
		}
		if(option == 2) {
			inputUno = dinero+" en peso chileno a Euros";
			return inputUno;
		}
		if(option == 3) {
			inputUno = dinero+" en peso chileno a Libras Esterlinas";
			return inputUno;
		}
		
		
		if(option == 4) {
			inputUno = dinero+" en peso chileno a Yen Japon�s";
			return inputUno;
		}
		if(option == 5) {
			inputUno = dinero+" en peso chileno a Won sul-coreano";
			return inputUno;
		}
		if(option == 6) {
			inputUno = dinero+" en D�lar a peso chileno";
			return inputUno;
		}
		if(option == 7) {
			inputUno = dinero+" en Euro a peso chileno";
			return inputUno;
		}
		if(option == 8) {
			inputUno = dinero+" en Libras Esterlinas a peso chileno";
			return inputUno;
		}
		if(option == 9) {
			inputUno = dinero+" en Yen Japon�s a peso chileno";
			return inputUno;
		}
		if(option == 10) {
			inputUno = dinero+" en Won sul-coreano a peso chileno";
			return inputUno;
		}
		
		return "";
	}

	public void setDinero(String dinero) {
		lblDinero.setText(dinero);
	}
}
