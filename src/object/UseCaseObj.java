package object;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class UseCaseObj extends BasicObj
{

    public UseCaseObj()
    {
        this.width = 100;
        this.height = 50;
    }
    
    @Override
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        BasicStroke stroke = new BasicStroke(4);
        g2D.setStroke(stroke);     
        
        g2D.setPaint(Color.black);
        g2D.drawOval(x,y,width,height);
        g2D.setPaint(Color.LIGHT_GRAY);
        g2D.fillOval(x,y,width,height);
        
        Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
        g2D.setFont(font);  
        g2D.setPaint(Color.black);
        int name_width = g.getFontMetrics().stringWidth(this.objName);
        g2D.drawString(this.objName,x + width / 2 - name_width / 2, y + height / 2);

        for(int eachPort = 0 ; eachPort < portList.size() ; eachPort++)
        {
            portList.get(eachPort).draw(g);
        }
        
    }

}
