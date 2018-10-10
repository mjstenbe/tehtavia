import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class JavaGui {
	private static JTextField txtCelsius;
	private static JTextField syöte;
	private static JTextField tulos;
	private static JTextField fahrenheit;

	public static void main(String[] args) {

		JFrame ikkuna = new JFrame("Celsius converter");
	
		ikkuna.setSize(300, 100);
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ikkuna.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		ikkuna.setResizable(false);
		
		txtCelsius = new JTextField();
		txtCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelsius.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		txtCelsius.setText("Celsius");
		ikkuna.getContentPane().add(txtCelsius);
		txtCelsius.setColumns(10);
		txtCelsius.setEditable(false);
		
		syöte = new JTextField();
		syöte.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		ikkuna.getContentPane().add(syöte);
		syöte.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tulos = syöte.getText();
				double num = Double.parseDouble(tulos);
				double muunnos = num * 1.8 + 32;
				String viimeinen = Double.toString(muunnos);
				fahrenheit.setText(viimeinen);
			}
		});
		ikkuna.getContentPane().add(btnConvert);
		
		fahrenheit = new JTextField();
		ikkuna.getContentPane().add(fahrenheit);
		fahrenheit.setColumns(10);
		
		
		
		
		
		
		ikkuna.setVisible(true);
		
		
	}

}
