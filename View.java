
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class View extends JPanel
{
    private Model model;
    
    public View(Model model)
    {
        this.model = model;
    }

    public void paintComponent(Graphics g){
            super.paintComponent(g);
            for(Figure f : model.getFigure()) {
            g.setColor(f.getColour());
                switch(f.getShape()) {
                    case DOT:
                        g.fillOval(f.getX() - 5, f.getY() - 7, 10, 10);
                        break;
                    case OVAL:
                        g.fillOval(f.getX(), f.getY(), (int)(f.getWidth()*1.165), (int)(f.getHeight()*1.165)); // *1.165 for musen ska vara i kante
                        break;
                    case RECTANGLE:
                        g.fillRect(f.getX(), f.getY(), f.getWidth(), f.getHeight());
                        break;
                }
            }
        }
}
