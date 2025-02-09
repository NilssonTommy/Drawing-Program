

import java.util.*;
import java.awt.Point;
import java.io.*;

public class Model implements Serializable
{
    private LinkedList<Figure> List = new LinkedList<>();
    
    public Model(){
    }

    public void addFigure(Figure F){
        List.add(F);
    }
    
    public LinkedList<Figure> getFigure(){
        
        return List;
    
    }
    
    public void undoFigure() {
        if (!List.isEmpty()) {
        List.remove(List.size() - 1);
        }
    }
    
    public void saveFile(String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(List);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List = (LinkedList<Figure>) ois.readObject();
        }
    }
}
