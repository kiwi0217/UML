package mode;

import object.BasicObj;
import java.util.ArrayList;
import line.Line;
import entity.Entity;
import uml.Canvas;

public class LineMode extends Mode
{
   
    public void mousePressHold(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        canvas.checkMouseInObj(mouseX, mouseY);
        boolean MouseInObj = canvas.getMouseInObj();
        if (MouseInObj == true) {
            Line line = canvas.getLine();
            line = (Line) line.clone();
            BasicObj basicObj = canvas.getBasicObject();
            //確認滑鼠在物件三角形的位置
            switch (basicObj.checkMouseArea(mouseX, mouseY, line)) {
                case "left":
                    line.setStartX(basicObj.getX());
                    line.setStartY(basicObj.getY() + basicObj.getHeight() / 2);
                    break;
                case "top":
                    line.setStartX(basicObj.getX() + basicObj.getWidth() / 2);
                    line.setStartY(basicObj.getY());
                    break;
                case "right":
                    line.setStartX(basicObj.getX() + basicObj.getWidth());
                    line.setStartY(basicObj.getY() + basicObj.getHeight() / 2);
                    break;
                case "bottom":
                    line.setStartX(basicObj.getX() + basicObj.getWidth() / 2);
                    line.setStartY(basicObj.getY() + basicObj.getHeight());
                    break;
            }
            line.setEndX(line.getStartX());
            line.setEndY(line.getStartY());
            canvas.setLine(line);
            ArrayList<Entity> entityList = canvas.entityList();
            entityList.add(line);
        }
    }
    public void mouseFree(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        canvas.checkMouseInObj(mouseX, mouseY);
        boolean MouseInObj = canvas.getMouseInObj();
        BasicObj basicObj = canvas.getBasicObject();
        Line line = canvas.getLine();
        if (MouseInObj) {
            //設定線在物件的哪一個區塊
            switch (basicObj.checkMouseArea(mouseX, mouseY, line)) {
                case "left":
                    line.setEndX(basicObj.getX());
                    line.setEndY(basicObj.getY() + basicObj.getHeight() / 2);
                    break;
                case "top":
                    line.setEndX(basicObj.getX() + basicObj.getWidth() / 2);
                    line.setEndY(basicObj.getY());
                    break;
                case "right":
                    line.setEndX(basicObj.getX() + basicObj.getWidth());
                    line.setEndY(basicObj.getY() + basicObj.getHeight() / 2);
                    break;
                case "bottom":
                    line.setEndX(basicObj.getX() + basicObj.getWidth() / 2);
                    line.setEndY(basicObj.getY() + basicObj.getHeight());
                    break;
            }
        } 
        else {
            ArrayList<Entity> entityList = canvas.entityList();
            entityList.remove(line);
        }
        
        ArrayList<BasicObj> basicObjList = canvas.getBasicObjList();
        for (int eachObj = 0; eachObj < basicObjList.size(); eachObj++) {
            basicObjList.get(eachObj).setPortShow("all", false);
        }
        canvas.repaint();
    }
    public void mouseDrag(int mouseX, int mouseY)
    {
        Canvas canvas = Canvas.getInstance();
        Line line = canvas.getLine();
        line.setEndX(mouseX);
        line.setEndY(mouseY);
        canvas.repaint();
    }
}