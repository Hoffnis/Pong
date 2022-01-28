import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public double x, y; 
	public int width, heigth;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 30;
		this.heigth = 5;
	}

	public void tick() {
		x += (Game.ball.x -x - 6) * 0.1;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, heigth);
	}
	
}

