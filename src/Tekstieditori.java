import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Tekstieditori {

	public static void main(String[] args) {
		JFrame ikkuna = new JFrame("Tekstieditori");
		ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ikkuna.setSize(473, 400);

		JToolBar toolBar = new JToolBar();
		ikkuna.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("Tiedosto");
		toolBar.add(btnNewButton);

		JButton btnTallenna = new JButton("Tallenna");
		toolBar.add(btnTallenna);

		JButton btnLeikkaa = new JButton("Leikkaa");
		toolBar.add(btnLeikkaa);

		JEditorPane editorPane = new JEditorPane();
		ikkuna.getContentPane().add(editorPane, BorderLayout.CENTER);
		
		JScrollBar scrollBar = new JScrollBar();
		ikkuna.getContentPane().add(scrollBar, BorderLayout.EAST);

		JMenuBar menuBar = new JMenuBar();
		ikkuna.setJMenuBar(menuBar);

		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);

		JMenuItem mntmAvaa = new JMenuItem("Avaa");
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
		mnTiedosto.add(mntmUusi);

		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmLopeta);

		JMenuItem mntmSulje = new JMenuItem("Sulje");
		mnTiedosto.add(mntmSulje);

		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);

		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mnMuokkaa.add(mntmEtsi);

		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		mnMuokkaa.add(mntmKorvaa);

		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);

		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mnTietoja.add(mntmTietojaOhjelmasta);
		ikkuna.setVisible(true);

	}

}
