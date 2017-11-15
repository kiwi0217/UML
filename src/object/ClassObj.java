package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ClassObj extends BasicObj
{
    public ClassObj()
    {
        this.width = 100;
        this.height = 80;
    }    
    @Override
    public void draw(Graphics g)
    {
        int latticeLine = height / 3;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        BasicStroke stroke = new BasicStroke(2);
        g2D.setStroke(stroke);     
        g2D.setPaint(Color.lightGray);
        g2D.fillRect(x,y,width,height);
        g2D.setPaint(Color.BLACK);
        g2D.drawRect(x,y,width,height);
        g2D.drawLine(x, y + latticeLine, x + width, y + latticeLine);
        g2D.drawLine(x, y + latticeLine * 2, x + width, y + latticeLine * 2);
        
        Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
        g2D.setFont(font);  
        int name_width = g.getFontMetrics().stringWidth(this.objName);
        g2D.drawString(this.objName,x + width / 2 - name_width / 2, y + height / 3 - 6);
        
        for(int eachPort = 0 ; eachPort < portList.size() ; eachPort++)
        {
            portList.get(eachPort).draw(g);
        }
    }
}