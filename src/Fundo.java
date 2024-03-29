import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Fundo {
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle rectangle;
    private Image image;
    private int velocidade;

    public Fundo() throws IOException {
        ImageIcon back = new ImageIcon("background.jpg");
        setX(0);
        setY(0);
        setVelocidade(4);
        setImage(back.getImage());
        setWidth(back.getIconWidth());
        setHeight(back.getIconHeight());
    }

    public void move(){
        if(getY() > 720){
            setY(0);
        }
        setY(getY() + getVelocidade());
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}
