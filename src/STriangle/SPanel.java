package STriangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Polygon;
import java.util.Map;
import java.awt.Toolkit;

public class SPanel extends Panel {
	private static int maxDepth = 8;
	private static Color[] colors = {new Color(0x172A3A), new Color(0x004346), new Color(0x508991), new Color(0x74B3CE), new Color(0x09BC8A), new Color(0x1FF4FF)};
	
	/*private void drawRecursively(Graphics g, int[] x, int[] y, int level) {
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width;
		int h = screenSize.height;
		int i = 0;
		drawing(g,w,h,i);
	}
	private void drawing(Graphics g, int w, int h, int i) {
		//drawTriangle(g, new int[] {w/2,w,0}, new int[] {0,h,h}, i);
		//drawTriangle(g, new int[] {w/2,3*w/4,w/4}, new int[] {0,h/2,h/2}, i+1);
		//drawTriangle(g, new int[] {w/4,0,w/2}, new int[] {h/2,h,h}, i+1);
		//drawTriangle(g, new int[] {3*w/4,w/2,w}, new int[] {h/2,h,h}, i+1);
		int u = 2;
		int q = 1;
		int d = 2;
		//int e = d;
		int s = 1;
		//int r = 2;
		for (int o = 1; o < maxDepth; o++) {
			u = u*2;
		}
		drawTriangle(g, new int[] {0,w/2,w}, new int[] {h,0,h}, i);
		/*while (r <= u) {
			int bu = w/(r*2);
			while (d < r*2) {
				drawTriangle(g, new int[] {d*bu,(d+1)*bu,(d+2)*bu}, new int[] {s*h/r,(s+1)*h/r,s*h/r}, i+2);
				s = s+1;
				d = d+2;
			}
			d = e;
			r = r*2;
			e = e+1;
		}*/
		/*int bu = w/4;
		drawTriangle(g, new int[] {bu,2*bu,3*bu}, new int[] {h/2,h,h/2}, i+2);
		bu = w/8;
		drawTriangle(g, new int[] {bu,2*bu,3*bu}, new int[] {3*h/4,h,3*h/4}, i+2);
		drawTriangle(g, new int[] {3*bu,4*bu,5*bu}, new int[] {3*h/4,h,3*h/4}, i+2);
		drawTriangle(g, new int[] {5*bu,6*bu,7*bu}, new int[] {3*h/4,h,3*h/4}, i+2);
		drawTriangle(g, new int[] {2*bu,3*bu,4*bu}, new int[] {2*h/4,3*h/4,2*h/4}, i+2);
		drawTriangle(g, new int[] {4*bu,5*bu,6*bu}, new int[] {2*h/4,3*h/4,2*h/4}, i+2);
		drawTriangle(g, new int[] {3*bu,4*bu,5*bu}, new int[] {1*h/4,2*h/4,1*h/4}, i+2);*/
		while (2 <= u) {
			while (s <= u) {
				/*while (q <= (u-s+1)) {
					drawTriangle(g, new int[] {(d-1)*w/(u*2),d*w/(u*2),(d-2)*w/(u*2)}, new int[] {(u-s)*h/u,(u-s+1)*h/u,(u-s+1)*h/u}, i);
					d = d + 2;
					q++;
				}*/
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
		
		
		/*drawTriangle(g, new int[] {1*w/16,2*w/16,0*w/16}, new int[] {7*h/8,h,h}, i);
		drawTriangle(g, new int[] {3*w/16,4*w/16,2*w/16}, new int[] {7*h/8,h,h}, i);
		drawTriangle(g, new int[] {5*w/16,6*w/16,4*w/16}, new int[] {7*h/8,h,h}, i);
		drawTriangle(g, new int[] {2*w/16,1*w/16,3*w/16}, new int[] {6*h/8,7*h/8,7*h/8}, i);
		drawTriangle(g, new int[] {4*w/16,3*w/16,5*w/16}, new int[] {6*h/8,7*h/8,7*h/8}, i);
		drawTriangle(g, new int[] {2*w/16,3*w/16,1*w/16}, new int[] {h, 7*h/8, 7*h/8}, 5);
		drawTriangle(g, new int[] {4*w/16,5*w/16,3*w/16}, new int[] {h, 7*h/8, 7*h/8}, 5);*/
	}
}