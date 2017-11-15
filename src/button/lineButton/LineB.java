package button.lineButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mode.LineMode;
import uml.ButtonArea;


public class LineB extends JButton
{
    
    protected String btn_name;
    protected ButtonArea BArea;
    
    public LineB(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name);
        this.btn_name = btn_name;
        this.setBounds(x, y, width, height);
        this.setBackground(Color.CYAN);
    }
    
    public void setBArea(ButtonArea BArea)
    {
        this.BArea = BArea;
    }
    public void setOnClickListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BArea.resetButtonColor();
                setBackground(Color.BLACK);
                BArea.getUmlEditor().getCanvas().setLine(new line.Association());
                BArea.getUmlEditor().getCanvas().setMode(new LineMode());
            }
        });
    } 
   

}
