package line;

import java.awt.Graphics;
import java.util.ArrayList;
import entity.Entity;
import entity.Port;

public class Line extends Entity implements Cloneable
{
    protected int startX;
    protected int startY;
    protected int endX;
    protected int endY;
    protected float width = 2.0f;
    protected ArrayList<Port> portList = new ArrayList<Port>(); // 0:始點 1:末點
    
    public void setStartX(int x){this.startX = x;}
    public int getStartX(){return this.startX;}
    
    public void setStartY(int y){this.startY = y;}
    public int getStartY(){return this.startY;}
    
    public void setEndX(int x){this.endX = x;}
    public void setEndY(int y){this.endY = y;}
    
    public void addPort(Port port){portList.add(port);}
    
    protected void updateLineLocation()
    { //更新起始與末段的位置
        if(portList.size() == 2){
            Port start = portList.get(0);
            startX = start.getX() + start.getWidth() / 2;
            startY = start.getY() + start.getHeight() / 2;
            Port end = portList.get(1);
            endX = end.getX() + end.getWidth() / 2;
            endY = end.getY() + end.getHeight() / 2;
        }
    }

    @Override  
    public Object clone()
    {  
        Line line =  null ;  
        try 
        {  
            line = (Line) super .clone();
            line.portList = new ArrayList<Port>();
        } catch (CloneNotSupportedException e){}  
        return line;  
    } 
    @Override
    public void draw(Graphics g) {} //子類別實作
}
