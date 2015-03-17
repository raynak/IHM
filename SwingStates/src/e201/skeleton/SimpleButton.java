package e201.skeleton ;

import fr.lri.swingstates.canvas.*;
import fr.lri.swingstates.canvas.transitions.*;
import fr.lri.swingstates.debug.StateMachineVisualization;
import fr.lri.swingstates.sm.BasicInputStateMachine;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Release;
import fr.lri.swingstates.sm.transitions.TimeOut;

import javax.swing.JFrame ;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font ;
import java.awt.Paint;
import java.awt.Stroke;


public class SimpleButton {
	private CText label ;
	private CRectangle rect;
	private int modifier;
	private int mouseButton;
	private CStateMachine fsm;
	CExtensionalTag strokedTag;
	CExtensionalTag coloredTag;
	private int semiClickCounter;
	private int timerValue;

	SimpleButton(Canvas canvas, String text, int button, int modifier) {
		this.rect = canvas.newRectangle(-8, -8, 100, 25);
		this.rect.setFillPaint(Color.WHITE);
		this.label = canvas.newText(0, 0, text, new Font("verdana", Font.PLAIN, 12)) ;
		this.rect.addChild(label);
		this.modifier = modifier;
		this.mouseButton = button;
		this.semiClickCounter = 0;
		this.timerValue = 500;
		this.strokedTag = new CExtensionalTag() {
			Stroke initialStroke;
			
			public void added(CShape s) {
				initialStroke = s.getStroke();;
				s.setStroke(new BasicStroke(3));
			}

			public void removed(CShape s) {
				s.setStroke(initialStroke);
			}
		};
		this.coloredTag = new CExtensionalTag() {
			Paint initialColor;
			
			public void added(CShape s) {
				initialColor = s.getFillPaint();
				s.setFillPaint(Color.YELLOW);
			}

			public void removed(CShape s) {
				s.setFillPaint(initialColor);
			}
		};
		this.fsm = new CStateMachine() {
			
			@SuppressWarnings("unused")
			public State idle = new State() {
				Transition entree = new EnterOnShape(">> on") {
					public void action() {
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
					};
				};
				
			};
			
			@SuppressWarnings("unused")
			public State on = new State() {
				Transition press = new PressOnShape(SimpleButton.this.mouseButton, SimpleButton.this.modifier, ">> semi") {
					public void action() {
						SimpleButton.this.getShape().addTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().removeTag(SimpleButton.this.strokedTag);
						SimpleButton.this.getMachine().armTimer(SimpleButton.this.timerValue,false); // Armement du timer
						SimpleButton.this.semiClickCounter++; // Incrementation du compteur
					};
				};

				Transition leave = new LeaveOnShape(">> idle") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.strokedTag);
					};
				};
			};
			
			@SuppressWarnings("unused")
			public State semi = new State() {
				Transition timeout = new TimeOut(">> on") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
						SimpleButton.this.action();
					}
				};
				
				Transition release = new Release(">> complet") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
						SimpleButton.this.getMachine().armTimer(SimpleButton.this.timerValue,false); // Armement du timer
						SimpleButton.this.semiClickCounter++; // Incrementation du compteur
					}
				};
				Transition leave = new LeaveOnShape(">> inactif2") {
					public void action(){
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
					}
				};
			};
			
			@SuppressWarnings("unused")
			public State complet = new State() {
				Transition timeout = new TimeOut(">> on") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
						SimpleButton.this.action();
					}
				};
				Transition press = new PressOnShape(SimpleButton.this.mouseButton, SimpleButton.this.modifier, ">> semi") {
					public void action() {
						SimpleButton.this.getShape().addTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().removeTag(SimpleButton.this.strokedTag);
						SimpleButton.this.getMachine().armTimer(SimpleButton.this.timerValue,false); // Armement du timer
						SimpleButton.this.semiClickCounter++; // Incrementation du compteur
					};
				};
				Transition leave = new LeaveOnShape(">> inactif1") {
					public void action(){
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
					}
				};
			};
			
			@SuppressWarnings("unused")
			public State inactif1 = new State() {
				Transition timeout = new TimeOut(">> idle") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
						SimpleButton.this.semiClickCounter = 0;
					}
				};
				Transition entree = new EnterOnShape(">> complet") {
					public void action() {
						SimpleButton.this.getShape().addTag(SimpleButton.this.coloredTag);
					}
				};
			};
			
			@SuppressWarnings("unused")
			public State inactif2 = new State() {
				Transition timeout = new TimeOut(">> idle") {
					public void action() {
						SimpleButton.this.getShape().removeTag(SimpleButton.this.coloredTag);
						SimpleButton.this.getShape().addTag(SimpleButton.this.strokedTag);
						SimpleButton.this.semiClickCounter = 0;
					}
				};
				Transition entree = new EnterOnShape(">> semi") {
					public void action() {
						SimpleButton.this.getShape().addTag(SimpleButton.this.coloredTag);
					}
				};
			};
		};
		
	}
	
	public CStateMachine getMachine() {
		return this.fsm;
	}
	public void action() {
		switch (semiClickCounter) {
			case 0: System.out.println("ACTION! : aucun clic "+semiClickCounter) ;break;
			case 1: System.out.println("ACTION! : Semi clic "+semiClickCounter) ;break;
			case 2: System.out.println("ACTION! : Simple clic "+semiClickCounter) ;break;
			case 3: System.out.println("ACTION! : 1 clic et demi "+semiClickCounter) ;break;
			case 4: System.out.println("ACTION! : Double clic "+semiClickCounter) ;break;
			default: break;
		}
		semiClickCounter = 0;
	}

	public CShape getShape() {
		return rect ;
	}
	static public void main(String[] args) {
		JFrame frame = new JFrame() ;
		Canvas canvas = new Canvas(400,400) ;
		frame.getContentPane().add(canvas) ;
		frame.pack();
		frame.setVisible(true);
		
		SimpleButton simple = new SimpleButton(canvas, "simple", BasicInputStateMachine.ANYBUTTON, BasicInputStateMachine.ANYMODIFIER) ;
		simple.getShape().translateBy(100,100) ;
		
		CStateMachine mach = simple.getMachine();
		mach.attachTo(canvas);
		
		JFrame viz = new JFrame();
		viz.setLocation(400, 0);
		viz.getContentPane().add(new StateMachineVisualization(mach));
		viz.pack();
		viz.setVisible(true);
				
	}

}
