import javax.swing.*;
import java.awt.*;

public class Ataque {
    private int x;
    private int y;
    private Image imagem;
    private int width;
    private int height;
    private int velocidade;
    private boolean visible;

    public Ataque(int x, int y) {
        setVisible(true);
        setVelocidade(5);
        this.setX(x);
        this.setY(y);
        ImageIcon ii = new ImageIcon("bullet.png");
        setImagem(ii.getImage());
        setWidth(getImagem().getWidth(null));
        setHeight(getImagem().getHeight(null));
    }

    public void move() {
        setY(y - getVelocidade());
        if (y < 720)
            this.visible = false;
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
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
