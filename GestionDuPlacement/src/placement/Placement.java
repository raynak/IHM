package placement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box.Filler;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Placement {

	private JFrame frame;

	public Placement(){
		this.frame = new JFrame();
	}

	public void borderLayout(){
		this.frame.setTitle("BorderLayout");
		JButton nord = new JButton("nord");
		JButton sud = new JButton("sud");
		JButton est = new JButton("est");
		JButton ouest = new JButton("ouest");
		JButton center = new JButton("centre");
		this.frame.setLayout(new BorderLayout());
		this.frame.add(nord, BorderLayout.NORTH);
		this.frame.add(center, BorderLayout.CENTER);
		this.frame.add(ouest, BorderLayout.WEST);
		this.frame.add(est, BorderLayout.EAST);
		this.frame.add(sud, BorderLayout.SOUTH);
		this.frame.setLocation(0, 0);
		this.frame.setPreferredSize(new Dimension(350,300));

	}


	public void flowLayout(){
		this.frame.setTitle("FlowLayout");
		this.frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		for (int i=1; i<=16; i++){

			String bname = "Bouton "+i;
			System.out.println(bname);
			this.frame.add(new JButton(bname));
		}
		this.frame.setLocation(400, 0);
		this.frame.setPreferredSize(new Dimension(350,300));
	}

	public void affiche(){
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		this.frame.setVisible(true);
	}

	public void gridLayout(){
		this.frame.setTitle("GridLayout");
		this.frame.setLayout(new GridLayout(4,4));
		for (int i=1; i<=16; i++){
			String bname = "Bouton "+i;
			this.frame.add(new JButton(bname));
		}	
		this.frame.setLocation(800, 0);
		this.frame.setPreferredSize(new Dimension(500,300));

	}

	public void boxLayout(){

		this.frame.setTitle("BoxLayout");
		this.frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		this.frame.setPreferredSize(new Dimension(200,300));
		this.frame.setSize(new Dimension(200,300));

		System.out.println(this.frame.getWidth());
		JButton b1 = new JButton("Bouton 1");
		b1.setSize(150, 50);
		b1.setMinimumSize(new Dimension(130, 20));
		b1.setPreferredSize(new Dimension(150, 50));
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton b2 = new JButton("Bouton 2");
		b2.setPreferredSize(new Dimension(this.frame.getWidth(), 30));
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);


		JButton b3 = new JButton("Bouton 3");
		b3.setPreferredSize(new Dimension(this.frame.getWidth(), 30));
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);

		Filler filler = new Filler(new Dimension(5,150), new Dimension(5,75), new Dimension(5,20));
		this.frame.getContentPane().add(b1);
		this.frame.getContentPane().add(b2);
		this.frame.getContentPane().add(filler);
		this.frame.getContentPane().add(b3);
		this.frame.setLocation(0, 400);
		System.out.println(b1.getSize());
	}

	public void gridBagLayout(){
		this.frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JButton b1 = new JButton("Bouton 1");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		this.frame.add(b1, c);
		JButton b2 = new JButton("Bouton 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx=1;
		c.gridy=0;
		this.frame.add(b2, c);
		JButton b3 = new JButton("Bouton 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx=2;
		c.gridy=0;
		this.frame.add(b3, c);
		JButton b4 = new JButton("Bouton 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx=3;
		c.gridy=0;
		this.frame.add(b4, c);
		JButton b5 = new JButton("Bouton 5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth=4;
		c.gridx=0;
		c.gridy=1;
		this.frame.add(b5, c);
		JButton b6 = new JButton("Bouton 6");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx=0;
		c.gridwidth=3;
		c.gridx=0;
		c.gridy=2;
		this.frame.add(b6, c);
		JButton b7 = new JButton("Bouton 7");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth=1;

		c.gridx=3;
		c.gridy=2;
		this.frame.add(b7, c);
		JButton b8 = new JButton("Bouton 8");
		c.fill = GridBagConstraints.VERTICAL;
		c.gridheight=2;
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space

		c.gridx=0;
		c.gridy=3;
		this.frame.add(b8, c);
		JButton b9 = new JButton("Bouton 9");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight=1;
		c.gridwidth=3;
		c.gridx=1;
		c.gridy=3;
		this.frame.add(b9, c);
		JButton b10 = new JButton("Bouton 10");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=4;
		this.frame.add(b10, c);
		this.frame.setLocation(350, 400);
	}

	public void absolu(){
		this.frame.setLayout(null);
		this.frame.setSize(300, 200);
		JButton b1 = new JButton("Bouton 1");
		b1.setBounds(0,0, 50, 20);
		b1.repaint();

	}

	public static void main(String[] args){
		Placement p = new Placement();
		p.borderLayout();
		p.affiche();

		Placement p2 = new Placement();
		p2.flowLayout();
		p2.affiche();

		Placement p3 = new Placement();
		p3.gridLayout();
		p3.affiche();

		Placement p4 = new Placement();
		p4.boxLayout();
		p4.affiche();

		Placement p5 = new Placement();
		p5.gridBagLayout();
		p5.affiche();

		Placement p6 = new Placement();
		p6.absolu();
		p6.affiche();

	}
}
