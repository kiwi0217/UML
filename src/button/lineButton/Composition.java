package button.lineButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mode.LineMode;

public class Composition extends LineB
{
    public Composition(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name, x, y, width, height);
        this.setOnClickListener();
    } 
    public void setOnClickListener(){
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BArea.resetButtonColor();
                setBackground(Color.BLACK);
                BArea.getUmlEditor().getCanvas().setLine(new line.Composition());
                BArea.getUmlEditor().getCanvas().setMode(new LineMode());
            }
        });
    }
}
