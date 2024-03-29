import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Entity {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int width;
    private int height;
    private int speed;
    private Image image;
    private Rectangle rectangle;
    private ArrayList<Ataque> tiros;
    Fundo f = new Fundo();

    public Entity() throws IOException {
        setX(600);
        setY(600);
        setTiros(new ArrayList<>());
        setSpeed(4);
        setWidth(f.getWidth());
        setHeight(f.getHeight());
        setDx(0);
        setDy(0);
        ImageIcon ii = new ImageIcon("craftidle.png");
        setImage(ii.getImage());
        setWidth(getImage().getWidth(null));
        setHeight(getImage().getHeight(null));
        //image = image.getScaledInstance((int) (width*0.2), (int) (height*0.2),0);
    }

    public void atirar(){
        getTiros().add(new Ataque(x + width/3, y + height/2));
    }

    public void move(){
        x += dx;
        y += dy;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getDx(int i) {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public ArrayList<Ataque> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Ataque> tiros) {
        this.tiros = tiros;
    }
}

