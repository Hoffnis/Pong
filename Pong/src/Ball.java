import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x, y; 
	public int width, heigth;
	public double dx, dy;
	public double speed = 1.0;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 3;
		this.heigth = 3;
		
		int angle = new Random().nextInt(359);
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}

	public void tick() {
		
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx*= -1;
		}
		else if(x+(dx*speed) < 0) {
			dx*=-1;
		}
		
		if(y > Game.HEIGTH) {
			new Game();
			return;
		}
		
		else if(y < 0) {
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width, heigth);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.heigth);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.heigth);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(125 -40) + 40 + 1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0)
			dy *= -1;
			speed = speed+ 0.005;
		}
		else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(125 - 40) + 40 +1;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy < 0)
			dy *= -1;
			speed = speed+ 0.05;
		}
		
		x += dx * speed;
		y += dy * speed;
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, width, heigth);
	}

}
