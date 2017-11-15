package mode;

import java.awt.Point;
import java.util.ArrayList;
import entity.Entity;
import entity.SelectGraph;
import object.BasicObj;
import uml.Canvas;

public class SelectMode extends Mode
{
    public void mousePressHold(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        canvas.checkMouseInObj(mouseX, mouseY);
        boolean mouseInBasicObj = canvas.getMouseInObj();
        //點選單一物件，物件點顯示、其餘點隱藏
        if (mouseInBasicObj == true) 
        { 
            ArrayList<BasicObj> objectSelectList = new ArrayList<BasicObj>(); 
            canvas.setObjSelectList(objectSelectList);
            ArrayList<BasicObj> objList = canvas.getBasicObjList();
            for (int eachObj = 0; eachObj < objList.size(); eachObj++){ objList.get(eachObj).setPortShow("all", false);}
            BasicObj basicObj = canvas.getBasicObject();
            basicObj.setPortShow("all", true);
            objectSelectList.add(basicObj);
        }
        //點選空白全點隱藏
        else
        {
            ArrayList<BasicObj> objectSelectList = new ArrayList<BasicObj>();
            canvas.setObjSelectList(objectSelectList);
            SelectGraph selectG = canvas.getSelectGraph();
            selectG = new SelectGraph();
            Point startDrag = new Point(mouseX, mouseY);
            selectG.setStart(startDrag);
            selectG.setEnd(startDrag);
            canvas.setSelectGraph(selectG);
            ArrayList<Entity> shapeList = canvas.entityList();
            shapeList.add(selectG);
        }

        if (mouseInBasicObj == true) 
        {
                canvas.setLastMouseX(mouseX);
                canvas.setLastMouseY(mouseY);
        }
    }
    public void mouseFree(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        boolean mouseInBasicObj = canvas.getMouseInObj();
        if (mouseInBasicObj == false) 
        {
            ArrayList<Entity> entityList = canvas.entityList();
            SelectGraph selectG = canvas.getSelectGraph();
            entityList.remove(selectG);
            ArrayList<BasicObj> objList = canvas.getBasicObjList();
            for (int i = 0; i < objList.size(); i++) 
            {
                BasicObj basicObj = objList.get(i);
                if (selectG.getRect().contains(basicObj.getX(), basicObj.getY(), basicObj.getWidth(), basicObj.getHeight())) 
                {
                    basicObj.setPortShow("all", true);
                    ArrayList<BasicObj> objectSelectList = canvas.getObjSelectList();
                    objectSelectList.add(basicObj);
                } 
                else 
                {
                    basicObj.setPortShow("all", false);
                }
            }
            canvas.repaint();
        } 
    }
    public void mouseDrag(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        boolean mouseInBasicObj = canvas.getMouseInObj();
        if (mouseInBasicObj == false)
        {
            Point endDrag = new Point(mouseX, mouseY);
            SelectGraph selectG = canvas.getSelectGraph();
            selectG.setEnd(endDrag);
            canvas.repaint();
        }
        else if (mouseInBasicObj == true)
        {
            canvas.moveBasicObject(mouseX, mouseY);
            ArrayList<BasicObj> objectSelectList = canvas.getObjSelectList();
            objectSelectList = new ArrayList<BasicObj>();
        }
    }
}
