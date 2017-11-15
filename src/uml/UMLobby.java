/**
 *
 * @author kiwi
 */
package uml;

import java.awt.Color;
import javax.swing.*;

public class UMLobby extends JFrame
{
    private final int startX;
    private final int startY;
    private final int height;
    private final int width;
    private ButtonArea BArea;
    private Canvas canvas;

    
    public UMLobby(String title, int startX, int startY, int width, int height)
    {
        super(title);
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.setBounds(startX, startY, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        
        /*設定按鈕空間*/
        int BAreaX = 0;
        int BAreaY = 0;
        int BAreaW = 120;
        int BAreaH = height;
        BArea = new ButtonArea(BAreaX, BAreaY, BAreaW, BAreaH);
        BArea.setUmlEditor(this);
        this.addPanel(BArea);
        
        /*設定畫布空間*/
        int canvas_x = BAreaX + BAreaW;
        int canvas_y = 0;
        int canvas_width = width - BAreaW;
        int canvas_height = height;
        canvas = Canvas.getInstance();
        canvas.initialization(canvas_x, canvas_y, canvas_width, canvas_height);
        this.addPanel(canvas);
        BArea.createButton();
        
        new Menu(this).create(); //選單
        this.setVisible(true);
    }
    
    private void addPanel(JPanel jpanel)
    {
        jpanel.setLayout(null);
        this.getContentPane().add(jpanel);
    }
    
    public Canvas getCanvas(){return canvas;}
    
}
