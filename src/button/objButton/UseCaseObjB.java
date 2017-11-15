package button.objButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mode.BasicObjMode;

public class UseCaseObjB extends ObjB
{
    public UseCaseObjB(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name, x, y, width, height);
        this.setOnClickListener();
    }
    
    @Override
    public void setOnClickListener()
    {
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BArea.resetButtonColor();
                setBackground(Color.BLACK);
                BArea.getUmlEditor().getCanvas().setBasicObject(new object.UseCaseObj());
                BArea.getUmlEditor().getCanvas().setMode(new BasicObjMode());
            }
        });
    }
}
