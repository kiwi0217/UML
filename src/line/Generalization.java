package line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Generalization extends Line
{
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke drawLine = new BasicStroke(width);
        g2D.setStroke(drawLine);
        g2D.setPaint(Color.BLACK);
        updateLineLocation();
        
        double angle = (float) Math.toDegrees(Math.atan2(endY - startY, endX - startX));
        int arrowAngle = 30; 
        int traingleLen = 10;
        int lineEndX   = (int)(endX - traingleLen * Math.cos(Math.toRadians(angle)));
        int lineEndY   = (int)(endY - traingleLen * Math.sin(Math.toRadians(angle)));
   
        g2D.drawLine(startX, startY, lineEndX, lineEndY);
        
        int x1   = (int)(endX - traingleLen * Math.cos(Math.toRadians(angle + arrowAngle)));
        int y1   = (int)(endY - traingleLen * Math.sin(Math.toRadians(angle + arrowAngle)));
        int x2   = (int)(endX - traingleLen * Math.cos(Math.toRadians(angle - arrowAngle)));
        int y2   = (int)(endY - traingleLen * Math.sin(Math.toRadians(angle - arrowAngle)));
        
        int polygonX[] = {x1, x2, endX}; //三角形x軸
        int polygonY[] = {y1, y2, endY}; //三角形Y軸
        g2D.drawPolygon(polygonX, polygonY, 3); //三角形箭頭
    }
}
