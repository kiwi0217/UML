package entity;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;



public class SelectGraph extends Entity
{
    
    private int width;
    private int height;
    private Point startP;
    private Point endP;
    private Rectangle2D rectangle;

    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(2));
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

        if (startP != null && endP != null)
        {
            g2D.setPaint(Color.YELLOW);
            rectangle = makeRectangle(startP.x, startP.y, endP.x, endP.y);
            g2D.draw(rectangle);
        }
    }
  
    
    private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2)
    {
        width = Math.abs(x1 - x2);
        height = Math.abs(y1 - y2);
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), width, height);
    }
    
    public void setStart(Point point){this.startP = point;}
    public int getStartX(){return this.startP.x;}
    
    public void setEnd(Point point){this.endP = point;}
    public int getEndX(){return this.endP.x;}
    
    public int getStartY(){return this.startP.y;}
    public int getEndY(){return this.endP.y;}
    
    public Rectangle2D getRect(){return rectangle;}
}
