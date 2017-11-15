package line;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Association extends Line
{
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke drawLine = new BasicStroke(width);
        g2D.setStroke(drawLine);
        g2D.setPaint(Color.BLACK);        
        updateLineLocation();
        g2D.drawLine(startX, startY, endX, endY);
    }
}
