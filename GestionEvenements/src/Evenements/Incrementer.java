package Evenements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Incrementer extends JFrame {

	private JLabel label;
	private JButton button;
	private JButton button2;
	private JButton button3;
	
	public Incrementer(){
		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		this.label = new JLabel("0")	;
		this.label.setAlignmentX(CENTER_ALIGNMENT);
		this.button = new JButton("Incrémenter");
		this.button.setAlignmentX(CENTER_ALIGNMENT);
		this.button2 = new JButton("Incrémenter+2");
		this.button2.setAlignmentX(CENTER_ALIGNMENT);
		this.button3 = new JButton("Incrémenter+3");
		this.button3.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label);
		this.add(button);
		this.add(button2);
		this.add(button3);
		/*
		this.button.addActionListener(new ReponseAuClic(this.label));
		*/
		/*this.button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					Incrementer.this.label.setText(""+(Integer.parseInt(Incrementer.this.label.getText())+1));	
				
			}
		});*/
		this.button.addActionListener(new SourceReponse());
		this.button2.addActionListener(new SourceReponse());
		this.button3.addActionListener(new SourceReponse());
		
		this.pack();
		this.setVisible(true);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new FermetureFenetre());	}
	
	/*private class ReponseAuClic implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Incrementer.this.label.setText(""+(Integer.parseInt(Incrementer.this.label.getText())+1));
			
		}
		
	}*/
	
	private class SourceReponse implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			Object o = arg0.getSource();
			if (o.equals(Incrementer.this.button)){
				Incrementer.this.label.setText(""+(Integer.parseInt(Incrementer.this.label.getText())+1));	
			}
			else if (o.equals(Incrementer.this.button2)){
				Incrementer.this.label.setText(""+(Integer.parseInt(Incrementer.this.label.getText())+2));	
			}
			else if (o.equals(Incrementer.this.button3)){
				Incrementer.this.label.setText(""+(Integer.parseInt(Incrementer.this.label.getText())+3));	
			}
			else {}
		}
	}
	
	public static void main(String[] args){
		Incrementer i = new Incrementer();
	}
	
}
