package Evenements;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FermetureFenetre extends WindowAdapter {

	public void windowClosing(WindowEvent e){
		System.out.println("Fermeture de la fenetre");
		 System.exit(0);
	}
	
}
