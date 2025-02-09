import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;




enum Shapes { DOT, OVAL, RECTANGLE }

public class Figure implements Serializable
{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color colour;
    private Shapes shape;
    
    
    public Figure(int x, int y, int width, int height, Color colour, Shapes shape){
    
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.colour = colour;
    this.shape = shape;
    
    }
    /*
    public void draw(Graphics g) {
        g.setColor(colour);
        switch(shape) {
            case DOT:
                g.fillOval(x - 5, y - 7, 10, 10);
                break;
            case OVAL:
                g.fillOval(x, y, (int)(width*1.165), (int)(height*1.165));
                break;
            case RECTANGLE:
                g.fillRect(x, y, width, height);
                break;
        }
    
    
    }
    */
   
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setColour(Color colour){
        
        this.colour = colour;
    }
    
    public Color getColour(){
        return colour;
    }
    
    public void setShape(Shapes shape){
        this.shape = shape;
    }
    
    public Shapes getShape(){
        return shape;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
}
