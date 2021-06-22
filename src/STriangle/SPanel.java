package STriangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Polygon;
import java.util.Map;

public class SPanel extends Panel {
	private static int maxDepth = 9;
	private static Color[] colors = {new Color(0x172A3A), new Color(0x004346), new Color(0x508991), new Color(0x74B3CE), new Color(0x09BC8A), new Color(0x1FF4FF)};
	
	private void drawRecursively(Graphics g, int[] x, int[] y, int level) {
		drawTriangle(g, x, y, level);
	}
	
	/*private Map<Integer, int[][]> getNewTriangles(int[] x, int[] y){
		
	}*/
	
	private void drawTriangle(Graphics g, int[] x, int[] y, int level) {
		Polygon p = new Polygon(x,y,3);
		g.setColor(Color.BLACK);
		g.drawPolygon(p);
		g.setColor(colors[level%colors.length]);
		g.fillPolygon(p);
	}
	
	public void paint(Graphics g) {
		drawTriangle(g, new int[] {150,250,325}, new int[] {150,100,125}, 9);
	}
}