package Evenements;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArdoiseMagiqueInterface extends JFrame {

	JPanel ardoise;
	ArdoiseMagique a;
	
	public ArdoiseMagiqueInterface(String text){
		this.setTitle(text);
		this.ardoise = new ArdoiseMagique();
		this.add(ardoise);
		this.ardoise.addMouseListener(new ClicSouris());
		this.ardoise.addMouseMotionListener(new DeplacementSouris());
		
		this.setPreferredSize(new Dimension(400,300));
		this.pack();
		this.setVisible(true);
		
		this.a = (ArdoiseMagique) ArdoiseMagiqueInterface.this.ardoise;
	}

	private class DeplacementSouris implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
//			ArdoiseMagique a = (ArdoiseMagique) ArdoiseMagiqueInterface.this.ardoise;
			ArdoiseMagiqueInterface.this.a.addPoint(arg0.getX(), arg0.getY());
		}
			
		@Override
		public void mouseMoved(MouseEvent arg0) {
			
		}
		
	}

	private class ClicSouris implements MouseListener{

		private int startX;
		private int startY;
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				this.startX = arg0.getX();
				this.startY = arg0.getY();
			} else if (arg0.getButton() == MouseEvent.BUTTON3) {
				ArdoiseMagiqueInterface.this.a.clear();
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			ArdoiseMagiqueInterface.this.a.newCurve();
		}

	
		
	}
	public static void main(String[] args){
	ArdoiseMagiqueInterface a = new ArdoiseMagiqueInterface("Ardoise Magique");
}
}
