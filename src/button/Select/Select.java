package button.Select;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mode.SelectMode;
import uml.ButtonArea;

public class Select extends JButton
{
    private ButtonArea BArea;
    public Select(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.CYAN);
        this.setOnClickListener();
    }
    
    public void setOnClickListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BArea.resetButtonColor();
                setBackground(Color.BLACK);
                BArea.getUmlEditor().getCanvas().setMode(new SelectMode());
            }
        });
    }
    public void setBArea(ButtonArea BArea)
    {
        this.BArea = BArea;
    }
}
