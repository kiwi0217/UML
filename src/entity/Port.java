package entity;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Port extends Entity
{
    public int x;
    private int y;
    private int width;
    private int height;
    private boolean show = false; //預設看不到點選更改
    private final int portSize = 10;
    
    public Port(){this.width = this.height = portSize; }  
    
    public void setX(int x){this.x = x;}
    public int getX(){return this.x;}
    
    public void setY(int y){this.y = y;}
    public int getY(){return this.y;}
    
    public void setWidth(int width){this.width = width;}
    public int getWidth(){return this.width;}
    
    public void setHeight(int height){this.height = height;}
    public int getHeight(){return this.height;}
    
    public void setPortShow(boolean show){this.show = show;}
    
    @Override
    public void draw(Graphics g)
    {
        if(show == true)
        {
            Graphics2D g2D = (Graphics2D) g; 
            g2D.fillRect(x,y,width,height);
        }
    }
}
