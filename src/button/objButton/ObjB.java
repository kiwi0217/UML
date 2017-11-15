package button.objButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import mode.BasicObjMode;
import uml.ButtonArea;

/**
 *
 * @author kiwi
 */

public class ObjB extends JButton
{
    
    protected String btn_name;
    protected ButtonArea BArea;
    
    public ObjB(String btn_name, int x, int y, int width, int height)
    {
        super(btn_name);
        this.btn_name = btn_name;
        this.setBounds(x, y, width, height);
        this.setBackground(Color.CYAN);
    }

    public void setOnClickListener(){
        this.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                BArea.resetButtonColor();
                setBackground(Color.BLACK);
                BArea.getUmlEditor().getCanvas().setBasicObject(new object.ClassObj());
                BArea.getUmlEditor().getCanvas().setMode(new BasicObjMode());
            }
        });
    }
    
    public void setButtonArea(ButtonArea BArea)
    {
        this.BArea = BArea;
    }
}
