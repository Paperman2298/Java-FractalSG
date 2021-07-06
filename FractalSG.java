import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FractalSG extends JFrame{
	private Point a = new Point(400,100),
				  b = new Point(50,550),
				  c = new Point(750,550);
	private int nivel;

	public FractalSG() {
		super("Fractal Sierpinski Gasket");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.nivel = Integer.parseInt(JOptionPane.showInputDialog("Escribe el nivel que deseas dibujar: "));
		this.setVisible(true);
	}
	
	public void pintaLineas(Graphics g, Point a, Point b) {
		g.drawLine(a.x, a.y, b.x, b.y);
		
	}
	
	public Point puntoMedio(Point a, Point b) {
		int xMedio = (a.x+b.x)/2;
		int yMedio = (a.y+b.y)/2;
		return new Point(xMedio,yMedio);
	}
	
	public void pintaTriangulos(Graphics g, int n, Point a, Point b, Point c) {//funcion recursiva
		if(n == 0) {
			this.pintaLineas(g, a, b);
			this.pintaLineas(g, b, c);
			this.pintaLineas(g, c, a);
		}else {
			Point pmAB = this.puntoMedio(a,b);
			Point pmBC = this.puntoMedio(b,c);
			Point pmCA = this.puntoMedio(c,a);
			
			this.pintaTriangulos(g,n-1,a,pmAB,pmCA);
			this.pintaTriangulos(g,n-1,pmAB,b,pmBC);
			this.pintaTriangulos(g,n-1,pmCA,pmBC,c);
		}
	}
	
	public void paint(Graphics g) {//funcion de preparacion
		super.paint(g);
		this.pintaTriangulos(g, this.nivel, this.a, this.b, this.c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FractalSG fsg = new FractalSG();
	}

}
