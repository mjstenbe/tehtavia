import javax.swing.*;

import javax.swing.event.EventListenerList;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import java.io.PrintWriter;

public class Tekstieditori {

	public static void main(String[] args) {

		String etsittävä = "";

		JFrame ikkuna = new JFrame("Tekstieditori");
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ikkuna.setSize(473, 400);

		JEditorPane editorPane = new JEditorPane();
		ikkuna.getContentPane().add(editorPane, BorderLayout.CENTER);

		JToolBar toolBar = new JToolBar();
		ikkuna.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String rivi = "";
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				Scanner lukija = null;
				File tiedosto = new File(uusiTiedosto);
				try {
					lukija = new Scanner(tiedosto);
				} catch (FileNotFoundException f) {
					f.printStackTrace();
				}

				while (lukija.hasNextLine()) {
					rivi += lukija.nextLine();
					rivi += "\n";
				}

				editorPane.setText(rivi);
			}
		});

		btnNewButton.setIcon(
				new ImageIcon(Tekstieditori.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(btnNewButton);

		JButton btnTallenna = new JButton("");
		btnTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teksti = editorPane.getText();
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);
				try {
					PrintWriter tallennus = new PrintWriter(uusiTiedosto);
					tallennus.println(teksti);

					tallennus.flush();
					tallennus.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnTallenna.setIcon(new ImageIcon(
				Tekstieditori.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		toolBar.add(btnTallenna);

		JButton btnLeikkaa = new JButton("");
		btnLeikkaa.setIcon(
				new ImageIcon(Tekstieditori.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		btnLeikkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Avaa uuden ikkunan, johon voi kirjoittaa merkkijonon, jota haluaa hakea
				JFrame ikkuna = new JFrame("Etsi ja korvaa");
				ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ikkuna.setSize(400, 200);
				ikkuna.setVisible(true);
				ikkuna.setLocation(300, 300);
				ikkuna.getContentPane().setLayout(null);
				
				JLabel lblEtsittvMerkkijono = new JLabel("Etsittävä merkkijono");
				lblEtsittvMerkkijono.setBounds(42, 25, 97, 14);
				ikkuna.getContentPane().add(lblEtsittvMerkkijono);
				
				JTextField textField = new JTextField();
				textField.setBounds(20, 50, 147, 50);
				ikkuna.getContentPane().add(textField);
				textField.setColumns(10);
				
				JTextField textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(214, 50, 147, 50);
				ikkuna.getContentPane().add(textField_1);
				
				JLabel label = new JLabel("Merkkijono jolla korvataan");
				label.setBounds(228, 25, 125, 14);
				ikkuna.getContentPane().add(label);
				
				JButton btnEtsiJaKorvaa = new JButton("Etsi ja korvaa");
				btnEtsiJaKorvaa.setBounds(147, 127, 97, 23);
				ikkuna.getContentPane().add(btnEtsiJaKorvaa);

				btnEtsiJaKorvaa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// hakee editorPane kentästä hakuun kirjoitetun merkkijonon ja merkkaa sen
						String sisalto = editorPane.getText();
						String haettava = textField.getText();
						String korvattava = textField_1.getText();
						int indeksi = sisalto.indexOf(haettava);
						if (indeksi >= 0) {
							String korvattu = sisalto.replaceAll(haettava, korvattava);
							editorPane.setText(korvattu);
						} else {
							System.out.println("Merkkijonoa ei löydy");
						}

					}
				});

			}

		});
		toolBar.add(btnLeikkaa);

		JScrollBar scrollBar = new JScrollBar();
		ikkuna.getContentPane().add(scrollBar, BorderLayout.EAST);

		JMenuBar menuBar = new JMenuBar();
		ikkuna.setJMenuBar(menuBar);

		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);

		JMenuItem mntmAvaa = new JMenuItem("Avaa");
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAvaa.addActionListener(new ActionListener() {
//			Tiedoston avaaminen
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String rivi = "";
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				Scanner lukija = null;
				File tiedosto = new File(uusiTiedosto);
				try {
					lukija = new Scanner(tiedosto);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				while (lukija.hasNextLine()) {
					rivi += lukija.nextLine();
					rivi += "\n";
				}

				editorPane.setText(rivi);

			}
		});
		mnTiedosto.add(mntmAvaa);

		JMenuItem mntmUusi = new JMenuItem("Tallenna");
		mntmUusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teksti = editorPane.getText();
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();
				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);
				try {
					PrintWriter tallennus = new PrintWriter(uusiTiedosto);
					tallennus.println(teksti);

					tallennus.flush();
					tallennus.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

			}
		});
		mntmUusi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmUusi);

		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmLopeta);

		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);

		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Avaa uuden ikkunan, johon voi kirjoittaa merkkijonon, jota haluaa hakea
				JFrame ikkuna = new JFrame("Etsi");
				ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ikkuna.setSize(400, 200);
				ikkuna.setVisible(true);
				ikkuna.setLocation(300, 300);

				JTextField kirjoitus = new JTextField();
				ikkuna.getContentPane().add(kirjoitus, BorderLayout.CENTER);

				JButton etsi = new JButton("Etsi");
				ikkuna.getContentPane().add(etsi, BorderLayout.SOUTH);
				etsi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// hakee editorPane kentästä hakuun kirjoitetun merkkijonon ja merkkaa sen
						String sisalto = editorPane.getText();
						String haettava = kirjoitus.getText();
						int indeksi = sisalto.indexOf(haettava);
						if (indeksi >= 0) {
							System.out.println("Indeksi: " + indeksi);

							editorPane.setSelectionStart(indeksi);
							editorPane.setSelectionEnd(indeksi + haettava.length());
						} else {
							System.out.println("Merkkijonoa ei löydy");
						}

					}
				});

			}

		});
		mnMuokkaa.add(mntmEtsi);

		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mntmKorvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Avaa uuden ikkunan, johon voi kirjoittaa merkkijonon, jota haluaa hakea
				JFrame ikkuna = new JFrame("Etsi ja korvaa");
				ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ikkuna.setSize(400, 200);
				ikkuna.setVisible(true);
				ikkuna.setLocation(300, 300);
				ikkuna.getContentPane().setLayout(null);
				
				JLabel lblEtsittvMerkkijono = new JLabel("Etsittävä merkkijono");
				lblEtsittvMerkkijono.setBounds(42, 25, 97, 14);
				ikkuna.getContentPane().add(lblEtsittvMerkkijono);
				
				JTextField textField = new JTextField();
				textField.setBounds(20, 50, 147, 50);
				ikkuna.getContentPane().add(textField);
				textField.setColumns(10);
				
				JTextField textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(214, 50, 147, 50);
				ikkuna.getContentPane().add(textField_1);
				
				JLabel label = new JLabel("Merkkijono jolla korvataan");
				label.setBounds(228, 25, 125, 14);
				ikkuna.getContentPane().add(label);
				
				JButton btnEtsiJaKorvaa = new JButton("Etsi ja korvaa");
				btnEtsiJaKorvaa.setBounds(147, 127, 97, 23);
				ikkuna.getContentPane().add(btnEtsiJaKorvaa);

				btnEtsiJaKorvaa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// hakee editorPane kentästä hakuun kirjoitetun merkkijonon ja merkkaa sen
						String sisalto = editorPane.getText();
						String haettava = textField.getText();
						String korvattava = textField_1.getText();
						int indeksi = sisalto.indexOf(haettava);
						if (indeksi >= 0) {
							String korvattu = sisalto.replaceAll(haettava, korvattava);
							editorPane.setText(korvattu);
						} else {
							System.out.println("Merkkijonoa ei löydy");
						}

					}
				});

			}

		});
		mnMuokkaa.add(mntmKorvaa);

		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);

		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ikkuna = new JFrame("Tietoja ohjelmasta");
				ikkuna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ikkuna.setSize(400, 200);
				ikkuna.setVisible(true);
				ikkuna.setLocation(300, 300);
				ikkuna.getContentPane().setLayout(null);
				ikkuna.setResizable(false);
				
				
				JLabel lblEtsittvMerkkijono = new JLabel("Tekijä: Miikka Niemeläinen");
				lblEtsittvMerkkijono.setHorizontalAlignment(SwingConstants.CENTER);
				lblEtsittvMerkkijono.setAlignmentX(Component.CENTER_ALIGNMENT);
				lblEtsittvMerkkijono.setBounds(10, 11, 364, 14);
				ikkuna.getContentPane().add(lblEtsittvMerkkijono);
				
				JLabel lblMiikkaniemelainenstudentlaureafi = new JLabel("miikka.niemelainen@student.laurea.fi");
				lblMiikkaniemelainenstudentlaureafi.setHorizontalAlignment(SwingConstants.CENTER);
				lblMiikkaniemelainenstudentlaureafi.setBounds(10, 55, 364, 14);
				ikkuna.getContentPane().add(lblMiikkaniemelainenstudentlaureafi);
				
				JLabel lblHttpsgithubcomdothebarrelroll = new JLabel("https://github.com/DoTheBarrelRoll");
				lblHttpsgithubcomdothebarrelroll.setHorizontalAlignment(SwingConstants.CENTER);
				lblHttpsgithubcomdothebarrelroll.setBounds(10, 80, 364, 14);
				ikkuna.getContentPane().add(lblHttpsgithubcomdothebarrelroll);
			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		ikkuna.setVisible(true);

	}

}
