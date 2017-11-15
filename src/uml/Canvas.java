package uml;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import line.Line;
import mode.Mode;
import object.BasicObj;

public class Canvas extends JPanel
{
    /*全部都宣告進來START*/
    private static Canvas uniqueInstance;
    private ArrayList<Entity> entityList = new ArrayList<Entity>();
    private ArrayList<BasicObj> objList = new ArrayList<BasicObj>();
    private ArrayList<BasicObj> objSelectList = null;
    private BasicObj basicObj = null;
    private Line line = null;
    private Mode mode = null;
    private SelectGraph selectGraph = null;
    private boolean MouseInBasicObj = false;
    private int lastMouseX;
    private int lastMouseY;
    /*全部都宣告進來END*/
    
    public static Canvas getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new Canvas();
        }  
        return uniqueInstance;
    }
    public void initialization(int x, int y, int width, int height)
    {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBounds(x, y, width, height);
        this.setMouseEvent();
        this.setOpaque(false);
    }

    public void setLastMouseX(int x){this.lastMouseX = x;}
    public void setLastMouseY(int y){this.lastMouseY = y;}
    public void setSelectGraph(SelectGraph selectGraph){this.selectGraph = selectGraph;}
    public void setObjSelectList(ArrayList<BasicObj> objSelectList){this.objSelectList = objSelectList;}
    
    public ArrayList<BasicObj> getObjSelectList(){return this.objSelectList;}
    public ArrayList<Entity> entityList(){return this.entityList;}
    public ArrayList<BasicObj> getBasicObjList(){return this.objList;}
    public Line getLine(){return this.line;}    
    public BasicObj getBasicObject(){return this.basicObj;}
    public SelectGraph getSelectGraph(){return this.selectGraph;}
    
    public boolean getMouseInObj(){return this.MouseInBasicObj;}

    private void setMouseEvent()
    {
        this.addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                mode.mouseDrag(e.getX(), e.getY());
            }
        });

        this.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mousePressed(MouseEvent e)
            {
                mode.mousePressHold(e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e)
            {
                mode.mouseFree(e.getX(), e.getY());
            }
        });
    }
    
    public void checkMouseInObj(int mouseX, int mouseY)
    {
        for (int eachObj = objList.size() - 1; eachObj >= 0; eachObj--) //越後面被加進來越大
        {
            BasicObj basicObject = objList.get(eachObj);
            int objXstart = basicObject.getX();
            int objYstart = basicObject.getY();
            int objXend = objXstart + basicObject.getWidth();
            int objYend = objYstart + basicObject.getHeight();
            if (mouseX >= objXstart && mouseX <= objXend && mouseY >= objYstart && mouseY <= objYend) 
            { // 點到基本物件
                this.basicObj = basicObject; //取最上層的物件
                MouseInBasicObj = true;
                break;
            } 
            else  //沒有點到基本物件
            {
                MouseInBasicObj = false;
            }
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int eachEntity = 0; eachEntity < entityList.size(); eachEntity++)
        {
            entityList.get(eachEntity).draw(g);
        }
    }

    public void moveBasicObject(int mouseX, int mouseY)
    {

        for (int i = 0; i < objList.size(); i++)
        {
            objList.get(i).setPortShow("all", false);
        }

        int movedX = mouseX - lastMouseX;  // 算出移動距離
        int movedY = mouseY - lastMouseY;  // 算出移動距離

        basicObj.setX(basicObj.getX() + movedX);
        basicObj.setY(basicObj.getY() + movedY);
        basicObj.movePortLocation(movedX, movedY);
        repaint();

        lastMouseX = mouseX;
        lastMouseY = mouseY;

    }

    public void createBasicObj(int mouseX, int mouseY)
    {
        BasicObj BasicObject = (BasicObj) this.basicObj.clone();
        BasicObject.setX(mouseX);
        BasicObject.setY(mouseY);
        BasicObject.objPorts();
        objList.add(BasicObject);
        entityList.add(BasicObject);
        repaint();
    }

    public void setBasicObject(BasicObj basicObj)
    {
        this.basicObj = new BasicObj();
        this.basicObj = basicObj;
    }

    public void setLine(Line line)
    {
        this.line = new Line();
        this.line = line;
    }

    
    public void setMode(Mode mode)
    {
        this.mode = new Mode();
        this.mode = mode;
    }

}
