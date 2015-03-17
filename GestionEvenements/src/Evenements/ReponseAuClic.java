package Evenements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ReponseAuClic implements ActionListener {

	private JLabel label;
	
	public ReponseAuClic(JLabel l){
		this.label = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.label.setText(""+(Integer.parseInt(this.label.getText())+1));
		
	}
	

}
