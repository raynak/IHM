import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;


public class WindowAndFrame {

	private JWindow window;
	private JFrame frame;
	
	public WindowAndFrame(){
		JLabel label = new JLabel("texte");
		
		/*this.window = new JWindow();
		this.window.add(label);
		this.window.setSize(300, 200);
		this.window.setLocation(100, 100);
		this.window.setVisible(true);*/
		
		this.frame = new JFrame("JFrame");
		this.frame.add(label);
		this.frame.setLocationRelativeTo(null);

		this.frame.setSize(400, 300);
		//this.frame.setLocation(350, 200);
		this.frame.setDefaultCloseOperation(0);
		this.frame.setVisible(true);
		
		JDialog dialog = new JDialog(this.frame, "titre", true);
		//dialog.setTitle("dialog");
		JLabel textDialog = new JLabel("texte du dialog");
		dialog.add(textDialog);
		dialog.setVisible(true);
		dialog.pack();
		dialog.setLocationRelativeTo(frame);
		//dialog.setModal(true);
		//dialog.setDefaultCloseOperation(0);
		
		//this.frame.pack();
	}
	
	public static void main(String[] args){
		WindowAndFrame gui = new WindowAndFrame();
		//gui.window.setVisible(true);
	}
}
