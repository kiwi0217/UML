package line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Composition extends Line{
  
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke drawLine = new BasicStroke(width);
        g2D.setStroke(drawLine);
        g2D.setPaint(Color.BLACK);
        updateLineLocation();
        
        double angle = (float) Math.toDegrees(Math.atan2(endY - startY, endX - startX));
        int diamondAngle = 45; 
        int diamondLen = 17;
        int lineEndX   = (int)(endX - diamondLen * Math.cos(Math.toRadians(angle)));
        int lineEndY   = (int)(endY - diamondLen * Math.sin(Math.toRadians(angle)));
   
        g2D.drawLine(startX, startY, lineEndX, lineEndY);
        
        diamondLen = 10;
        int x1   = (int)(endX - diamondLen * Math.cos(Math.toRadians(angle + diamondAngle)));
        int y1   = (int)(endY - diamondLen * Math.sin(Math.toRadians(angle + diamondAngle)));
        int x2   = (int)(endX - diamondLen * Math.cos(Math.toRadians(angle - diamondAngle)));
        int y2   = (int)(endY - diamondLen * Math.sin(Math.toRadians(angle - diamondAngle)));
        

        int polygonX[] = {lineEndX, x1, endX,  x2 };//菱形四個邊
        int polygonY[] = {lineEndY, y1, endY,  y2 };
        g2D.drawPolygon(polygonX, polygonY, 4);
        
    }
}
