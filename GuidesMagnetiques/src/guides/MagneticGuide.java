package guides;

import java.awt.geom.Point2D;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CSegment;
import fr.lri.swingstates.canvas.Canvas;

public class MagneticGuide extends CExtensionalTag {
	
	private CSegment guide;
	private CExtensionalTag oTag ;
	
	public MagneticGuide(Canvas canvas, Point2D p, CExtensionalTag oTag, boolean orientation ){
		if (orientation == true){
			this.guide = canvas.newSegment(0, p.getY(), canvas.getWidth(), p.getY());
			this.guide.addTag(oTag);
		}
		else {
			this.guide = canvas.newSegment(p.getX(), 0, p.getX(), canvas.getHeight());
			this.guide.addTag(oTag);
		}
	}
	

}
