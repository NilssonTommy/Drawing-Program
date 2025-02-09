
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.IOException;




public class Controller
{
    
    private Model model;
    private View view;
    private Color currentColour;
    private Shapes currentShape;
    private int originalX, originalY;
    
    public static void main(String args[]){
        
        new Controller();
    }

     /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {
        model = new Model();
        view = new View(model);
        currentColour = Color.black;
        currentShape = Shapes.DOT;
    
        makeFrame();
    }
    
    private void saveModel() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(view);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                model.saveFile(fileChooser.getSelectedFile().getPath());
                JOptionPane.showMessageDialog(view, "File saved successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view, "Error saving the file: " + e.getMessage());
            }
        }
    }

    private void loadModel() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(view);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                model.loadFromFile(fileChooser.getSelectedFile().getPath());
                view.repaint();
                JOptionPane.showMessageDialog(view, "File loaded successfully!");
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(view, "Error loading the file: " + e.getMessage());
            }
        }
    }
    
    
    private void makeFrame(){
        
       
            
        JFrame frame = new JFrame("Drawing Program");
    
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
            
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    
        JLabel statusLabel = new JLabel("Mode: " + currentShape + " is using colour: " + currentColour );
        contentPane.add(statusLabel, BorderLayout.SOUTH);
            
        contentPane.add(view, BorderLayout.CENTER);
        view.setBackground(Color.white);

        
        
       
            
        JButton blackButton = new JButton("black");
        buttonPanel.add(blackButton);
        JButton redButton = new JButton("red");
        buttonPanel.add(redButton);
        JButton greenButton = new JButton("green");
        buttonPanel.add(greenButton);
        JButton ovalButton = new JButton("oval");
        buttonPanel.add(ovalButton);
        JButton rectButton = new JButton("rect");
        buttonPanel.add(rectButton);
        JButton dotButton = new JButton("dot");
        buttonPanel.add(dotButton);
        JButton undoButton = new JButton("undo");
        buttonPanel.add(undoButton);
        JButton saveButton = new JButton("save");
        buttonPanel.add(saveButton);
        JButton loadButton = new JButton("load");
        buttonPanel.add(loadButton);
    
       
        blackButton.addActionListener(e -> {currentColour = Color.black;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});
        
    
        redButton.addActionListener(e -> {currentColour = Color.red;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});
 
        greenButton.addActionListener(e -> {currentColour = Color.green;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});

        ovalButton.addActionListener(e -> {currentShape = Shapes.OVAL;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});

        rectButton.addActionListener(e -> {currentShape = Shapes.RECTANGLE;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});

        dotButton.addActionListener(e -> {currentShape = Shapes.DOT;
                    statusLabel.setText("Mode: " + currentShape + " is using colour: " + currentColour);});
 
        undoButton.addActionListener(e -> {model.undoFigure();
                    view.repaint();
                    });

        saveButton.addActionListener(e -> saveModel()); 
 
        loadButton.addActionListener(e -> loadModel());      
        
        
        view.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                originalX = e.getX();
                originalY = e.getY();
                model.addFigure(new Figure(e.getX(), e.getY(), 0, 0, currentColour, currentShape));
                view.repaint();
                

            }
            
            public void mouseReleased(MouseEvent e){
                Figure currentFigure = model.getFigure().getLast();
        
                int width = Math.abs(e.getX() - originalX);
                int height = Math.abs(e.getY() - originalY);
                
                currentFigure.setWidth(width);
                currentFigure.setHeight(height);
                
                if (e.getX() < currentFigure.getX()) {
                    currentFigure.setX(e.getX());
                    
                }
                if (e.getY() < currentFigure.getY()) {
                    currentFigure.setY(e.getY());
                }
                
                
        
                view.repaint();
            }
        });
        
        
        
        view.addMouseMotionListener(new MouseMotionAdapter(){
            
            public void mouseDragged(MouseEvent e) {
                Figure currentFigure = model.getFigure().getLast();
    
    
                int deltaX = e.getX() - originalX;
                int deltaY = e.getY() - originalY;
    
                int width = Math.abs(deltaX);
                int height = Math.abs(deltaY);
                
                currentFigure.setWidth(width);
                currentFigure.setHeight(height);
                
                if (deltaX < 0) {
                    currentFigure.setX(e.getX());
                }
                if (deltaY < 0) {
                    currentFigure.setY(e.getY());
                }
            
                view.repaint();
            }

        });
        
    

        
        


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
    
}
        
       
        
        
        
        
        
        
        
        
        
    
 



 

