package button.lineButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mode.LineMode;

public class Association extends LineB
{
    public Association(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name, x, y, width, height);
        this.setOnClickListener();
    }
    
    public void setOnClickListener()
    {
        this.addActionListener(new ActionListener()
        {
            @Override
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
