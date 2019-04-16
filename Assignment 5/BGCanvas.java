/*
* NUID: 001444756
* @author Harshitha Sangameshwarappa Gaddadhar
*/
package edu.neu.csye6200.bg;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 * @author HarshithaGS
 * BGCanvas is a method which inherits the JPanel . 
 * BGCanvas implements the Observer class since it needs to keep observing the BGGenerationSet . So any chnages made in the BGGEneerationSet durng the growth of the plant, the BGCanvas will be notified and the changes in the UI are made.
 * This BGcanvas class is made as a Singleton class  because evry update/change made in the java code needs to be implemneted on the same BGcanavs or a single BGcanvas.
 */
public class BGCanvas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(BGCanvas.class.getName());
	private long counter = 30000L;

	//An instance of BGGenerationSet
	BGGenerationSet gen_growth;

	//The initial coordinates for each stem 
	private int startx;
	private int starty;
	private int endx;
	private int endy;

	//Making this class as a Singleton
	private static BGCanvas instance = null;
	public static BGCanvas instance () {
		if (instance ==null) instance = new BGCanvas();
		return(instance);
	}

	/**
	 * CellAutCanvas constructor
	 */
	public BGCanvas() {
	}

	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
		drawBG(g); // Our Added-on drawing
	}

	/**
	 * Draw the CA graphics panel
	 * @param  This method implements the java code on to the UI. 
	 * First the y axis is flipped in order for the image of the growth of the plant to be in the upward direction. This is done using the Insets function
	 * First the base is painted and then the respective child stems are painted
	 * the start and end locations of the stems are obtained through gen_growth which is an object of BGGenerationSet
	 */
	public void drawBG(Graphics g) {
		log.info("Drawing BG " + counter++);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();

		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);

		//Insets is a swing object which representsthe boundary of a container. In this case it is used to flip the y axis in  order for the plant to grow in the upward direction on UI
		Insets insets = getInsets();
		int h = getHeight() - insets.top - insets.bottom;
		//Move the origin to bottom-left, flip y axis
		((Graphics2D) g).scale(1.0, -1.0);
		g.translate(0, -h - insets.top);

		//Drawing a base line to set a ground line
		paintLine(g2d, 0, 100 , size.width, 100, Color.MAGENTA);

		//Steps to paint the base stem and its child stems
		if (gen_growth!=null) {
			startx = gen_growth.PlantSet1.BaseStem.getStart_location()[0][0]*2; 
			starty =  gen_growth.PlantSet1.BaseStem.getStart_location()[0][1]*2;
			endx = gen_growth.PlantSet1.BaseStem.getStart_location()[1][0]*2;
			endy =  gen_growth.PlantSet1.BaseStem.getStart_location()[1][1]*2;
			paintLine( g2d, startx, starty, endx, endy, Color.BLUE); 
			//for every stem to the base stem
			for  ( BGStem bgs1 : gen_growth.PlantSet1.MasterChildStem) {
				this.startx = bgs1.getStart_location()[0][0] * 2;
				this.starty = bgs1.getStart_location()[0][1]  *2;
				this.endx = bgs1.getStart_location() [1][0] * 2;
				this.endy = bgs1.getStart_location()[1][1] *2;
				paintLine( g2d, startx, starty,endx,endy, Color.YELLOW); 
			}
		}
	}

	/**
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		g2d.drawLine(startx,starty, endx, endy);
	}
	
	
	@Override
	public void update(Observable o, Object generation) {
		gen_growth = (BGGenerationSet) generation;
		this.validate();
		this.repaint();
	}
}

















