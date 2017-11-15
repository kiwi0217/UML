package object;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import entity.Port;
import entity.Entity;
import judge.triangleArea;
import line.Line;

public class BasicObj extends Entity implements Cloneable
{
    protected String objName = "";
    protected int x = 0;
    protected int y = 0;
    protected int width;
    protected int height;
    protected ArrayList<Port> portList = new ArrayList<>();  //物件的四個port依序在: 左,右,上,下
    
    @Override  
    public Object clone()
    {  
        BasicObj bObj =  null ;  
        try {  
            bObj = (BasicObj) super.clone();  
            bObj.portList = new ArrayList<>();
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return bObj;  
    }
    public void objPorts()
    { // 新增物件的點
        int objX = this.getX();
        int objY = this.getY();
        int objW = this.getWidth();
        int objH = this.getHeight();
        
        Port port = new Port();
        int portW = port.getWidth();
        int portH = port.getHeight();
        port.setX(objX - portW / 2);
        port.setY(objY + (objH - portH) / 2);
        this.addPort(port);
        
        port = new Port();
        port.setX(objX + objW - portW / 2);
        port.setY(objY + (objH - portH) / 2);
        this.addPort(port);

        port = new Port();
        port.setX(objX + (objW - portW) / 2);
        port.setY(objY - portH / 2);
        this.addPort(port);

        port = new Port();
        port.setX(objX + (objW - portW) / 2);
        port.setY(objY + objH - portH / 2);
        this.addPort(port);
    }
    public void setName(String objName)
    {
        this.objName = objName;
    }
    public void movePortLocation(int movedX, int movedY)
    {
        for (int eachPort = 0 ; eachPort < portList.size() ; eachPort++)
        {
            Port port = portList.get(eachPort);
            port.setX(port.getX() + movedX);
            port.setY(port.getY() + movedY);
        }
    }
    
    public void setX(int x){this.x = x;}
    public int getX(){return x;}

    public void setY(int y){this.y = y ;}
    public int getY(){return y;}

    public void setWidth(int width){this.width = width;}
    public int getWidth(){return width;} 

    public void setHeight(int height){this.height = height;}
    public int getHeight(){return height;}

    public void addPort(Port port)
    {
        portList.add(port);
    }
    
    public void setPortShow(String s, boolean bool)
    {
        switch(s)
        {
            case "all":
                for(int eachPort = 0 ; eachPort < portList.size() ; eachPort++)
                {
                    portList.get(eachPort).setPortShow(bool);
                }
                break;
        }
    }
    
    //落在物件的上下左右哪個區間
    public String checkMouseArea(int mouse_x, int mouse_y, Line line)
    {
        int objX = this.getX();
        int objY = this.getY();
        int objW = this.getWidth();
        int objH = this.getHeight();
        triangleArea ta = triangleArea.getInstance();
        Point pointLT = new Point(objX, objY);//左上點
        Point pointLB = new Point(objX, objY + objH);//左下
        Point pointRT = new Point(objX + objW, objY);//右上
        Point pointRB = new Point(objX + objW, objY + objH); //右下
        Point objCenteral = new Point(objX + objW / 2, objY + objH / 2);
        Point pointMouse = new Point(mouse_x, mouse_y);
        
        double leftTA = ta.getTA(pointLT, pointLB, objCenteral);
        double topTA = ta.getTA(pointLT, objCenteral, pointRT);
        double rightTA = ta.getTA(objCenteral, pointRB, pointRT);
        double bottomTA = ta.getTA(pointLB, pointRB, objCenteral);
        

        double position = ta.getTA(pointLT, pointLB, pointMouse) + ta.getTA(pointLB, objCenteral, pointMouse) + ta.getTA(pointLT, pointMouse, objCenteral);
        if(position == leftTA)
        {
            Port port = portList.get(0);
            port.setPortShow(true);
            line.addPort(port);
            return "left";
        }
        
        position = ta.getTA(objCenteral, pointMouse, pointRT) + ta.getTA(objCenteral, pointRB, pointMouse) + ta.getTA(pointMouse, pointRB, pointRT);
        if(position == rightTA)
        {
            Port port = portList.get(1);
            port.setPortShow(true);
            line.addPort(port);
            return "right";
        }
        
        position = ta.getTA(pointLT, objCenteral, pointMouse) + ta.getTA(pointLT, pointMouse, pointRT) + ta.getTA(pointMouse, objCenteral, pointRT);
        if(position == topTA)
        {
            Port port = portList.get(2);
            port.setPortShow(true);
            line.addPort(port);
            return "top";
        }
        
        position = ta.getTA(objCenteral, pointLB, pointMouse) + ta.getTA(pointMouse, pointLB, pointRB) + ta.getTA(objCenteral, pointMouse, pointRB);
        if(position == bottomTA)
        {
            Port port = portList.get(3);
            port.setPortShow(true);
            line.addPort(port);
            return "bottom";
        }   
        return "error";
    }
    
    @Override
    public void draw(Graphics g)
    {
        throw new UnsupportedOperationException("UnsupportedOperation"); 
    }
}
