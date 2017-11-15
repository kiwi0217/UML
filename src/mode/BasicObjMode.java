package mode;

import uml.Canvas;

public class BasicObjMode extends Mode
{
    public void mousePressHold(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        canvas.createBasicObj(mouseX, mouseY);  //在滑鼠位置創造物件
    }
}
