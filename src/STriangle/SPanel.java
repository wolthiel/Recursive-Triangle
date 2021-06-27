package STriangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Polygon;
import java.util.Map;
import java.awt.Toolkit;

public class SPanel extends Panel{
	private static int maxDepth = 8;
	private static Color[] colors = {new Color(0x172A3A), new Color(0x004346), new Color(0x508991), new Color(0x74B3CE), new Color(0x09BC8A), new Color(0x1FF4FF)};
		
	private void drawTriangle(Graphics g, int[] x, int[] y, int level) {
		Polygon p = new Polygon(x,y,3);
		g.setColor(Color.BLACK);
		g.drawPolygon(p);
		g.setColor(colors[level%colors.length]);
		g.fillPolygon(p);
	}
	
	public void paint(Graphics g) {
		Dimension frameSize = STriangle.frameSize();
		int h = ((frameSize.height)/100)*99;
		double width = (2*h)/Math.sqrt(3);
		int w = (int) Math.round(width); 
		int i = 0;
		drawing(g,w,h,i);
	}
	private void drawing(Graphics g, int w, int h, int i) {
		int u = 2;
		int q = 1;
		int d = 2;
		int s = 1;
		for (int o = 1; o < maxDepth; o++) {
			u = u*2;
		}
		drawTriangle(g, new int[] {0,w/2,w}, new int[] {h,0,h}, i);
		while (2 <= u) {
			while (s <= u) {
				while (q < (u-s+1)) {
					drawTriangle(g, new int[] {(d)*w/(u*2),(d+1)*w/(u*2),(d-1)*w/(u*2)}, new int[] {(u-s+1)*h/u,(u-s)*h/u,(u-s)*h/u}, i+2);
					d = d + 2;
					q++;
				}
				q = 1;
				s = s+1;
				d = s+1;
			}
			u = u/2;
			q = 1;
			d = 2;			
			s = 1;
			i = i+1;
		}
	}
}
