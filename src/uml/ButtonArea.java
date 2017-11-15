package uml;


import button.objButton.ObjB;
import button.lineButton.LineB;
import button.objButton.ClassObjB;
import button.objButton.UseCaseObjB;
import button.lineButton.Association;
import button.lineButton.Composition;
import button.Select.Select;
import button.lineButton.Generalization;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonArea extends JPanel
{
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final String[] buttonNameList = new String[]{"select","association","generalization","composition","class","use case"};
    private int numOfButton = buttonNameList.length;
    private UMLobby umLobby;

    public ButtonArea(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
    }
    
    public void setUmlEditor(UMLobby umLobby){this.umLobby = umLobby;}

    private void addButton(JButton btn){this.add(btn);}
    
    public UMLobby getUmlEditor(){return this.umLobby;}
    
    public void resetButtonColor()
    {
          for (Component c : this.getComponents())
          {
              c.setBackground(Color.CYAN);
          }
    }

    public void createButton()
    {
        int buttonX = 0;
        int buttonY = 0;
        int buttonW = width;
        int buttonH = (height-61) / numOfButton;
        int buttonCount = 0;        
        
        /*這邊應該要用一個for但是有點髒*/
        buttonY = buttonCount * buttonH;
        Select selectButton = new Select(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        selectButton.setBArea(this);
        this.addButton(selectButton);
        buttonCount++;

        buttonY = buttonCount * buttonH;
        LineB LineButton = new Association(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        LineButton.setBArea(this);
        this.addButton(LineButton);
        buttonCount++;

        buttonY = buttonCount * buttonH;
        LineButton = new Generalization(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        LineButton.setBArea(this);
        this.addButton(LineButton);
        buttonCount++;
       
        buttonY = buttonCount * buttonH;
        LineButton = new Composition(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        LineButton.setBArea(this);
        this.addButton(LineButton);
        buttonCount++;
       
        buttonY = buttonCount * buttonH;
        ObjB objButton = new ClassObjB(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        objButton.setButtonArea(this);
        this.addButton(objButton);
        buttonCount++;
        
        buttonY = buttonCount * buttonH;
        objButton = new UseCaseObjB(buttonNameList[buttonCount], buttonX, buttonY, buttonW, buttonH);
        objButton.setButtonArea(this);
        this.addButton(objButton);
        buttonCount++;
    }
}
