package uml;

import object.BasicObj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu
{

    private final UMLobby uml_editor;
    private final Canvas canvas_jpanel;

    public Menu(UMLobby uml_editor)
    {
        this.uml_editor = uml_editor;
        this.canvas_jpanel = Canvas.getInstance();
    }
    
    

    public void create() {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem editItem = new JMenuItem("Group");
        JMenuBar menubar = new JMenuBar();
        editItem.addActionListener(new ActionListener()
        {
            private void Group(){}
            @Override
            public void actionPerformed(ActionEvent e) {Group(); }
        });
        edit.add(editItem);

        JMenuItem editItem2 = new JMenuItem("UnGroup");
        editItem2.addActionListener(new ActionListener()
        {
            private void UnGroup(){}
            @Override
            public void actionPerformed(ActionEvent e) {UnGroup();}
        });
        edit.add(editItem2);

        JMenuItem editItem3 = new JMenuItem("Change object name");
        editItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<BasicObj> objectSelectList = canvas_jpanel.getObjSelectList();
                if(objectSelectList != null && objectSelectList.size() > 0)
                {
                    Object[] options = {"OK", "Cancel"};
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("輸入物件名稱:"));
                    JTextField textField = new JTextField(12);
                    panel.add(textField);

                    int result = JOptionPane.showOptionDialog(uml_editor, panel, "設定物件名稱",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, null);
                    
                    if (result == JOptionPane.YES_OPTION) 
                    {
                        for(int eachObj = 0 ; eachObj < objectSelectList.size() ; eachObj++)
                        {
                            objectSelectList.get(eachObj).setName(textField.getText());
                        }
                        canvas_jpanel.repaint();
                    }
                }        
            }
        });
        edit.add(editItem3);

        menubar.add(file);
        menubar.add(edit);
        uml_editor.setJMenuBar(menubar);
    }
}
