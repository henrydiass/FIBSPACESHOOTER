import javax.swing.*;
import java.awt.*;

public class Rocha {
    private int x;
    private int y;
    private int width;
    private int height;
    private Image imagem;
    private int velocidade;
    private boolean visible;

    public Rocha(int x, int y){
        setVelocidade(2);
        setX(x+45);
        setY(y+60);
        ImageIcon ii = new ImageIcon("rocha.png");
        setImagem(ii.getImage());
        setWidth(getImagem().getWidth(null));
        setHeight(getImagem().getHeight(null));
        setImagem(getImagem().getScaledInstance((int) (getWidth() *3), (int) (getHeight() *5),0));
        setVisible(true);

    }

    public void move(){
        if(getY() > 720){
            setY(0);
        }
        setY(getY() + getVelocidade());
    }

    public Rectangle getRetangulo() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
