import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.RecursiveAction;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private Entity entity;
    private Timer timer;
    private ArrayList<Fundo> fundos;
    private ArrayList<Rocha> rochas;
    Fundo f1 = new Fundo();
    Fundo f2 = new Fundo();
    Fundo upperbox = new Fundo();



    public GamePanel() throws IOException {
        rochas = new ArrayList<Rocha>();
        Random random = new Random();
        //FOR DAS ROCHAS
        for(int i = 0; i < 7; i++){
            Rocha rocha = new Rocha(random.nextInt(0, 1080), random.nextInt(0, 400));
            rochas.add(rocha);
        }
        fundos = new ArrayList<Fundo>();
        //--- definindo os fundos ---- ////
        f1.setX(0);f1.setY(0);
        fundos.add(f1);
        f2.setX(f1.getX()); f2.setY(-720);
        fundos.add(f2);
        //-------------------------//
        entity = new Entity();
        addKeyListener(this);
        setBackground(Color.black);
        setSize(f1.getWidth(),f1.getHeight());
        setFocusable(true);

        timer = new Timer(1,this);
        timer.start();
        //definindo limite;
        upperbox.setX(0);upperbox.setY(0);
        upperbox.setWidth(1080);
        upperbox.setHeight(1);
        upperbox.setImage(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        ArrayList<Rocha> removeRochas = new ArrayList<>();
        for(Rocha rocha : rochas){ //REMOVE AS ROCHAS QUANDO A VARIAVEL VISIVEL SE TORNA FALSE
            if (rocha.isVisible())
                g2d.drawImage(rocha.getImagem(), rocha.getX(), rocha.getY(),null);
            else
                removeRochas.add(rocha);
        }
        for (Rocha rocha : removeRochas) {
            rochas.remove(rocha);
        }

        ///-------------------///
        for(Fundo fundo : fundos){//imprime os wallpapers dando a ilusao que esta se movendo no espaço
            g2d.drawImage(fundo.getImage(),fundo.getX(),fundo.getY(),null);
        }
        ///NAVE PRINCIPAL -----------///
        g2d.drawImage(entity.getImage(), entity.getX(), entity.getY(), null);

        for(Rocha rocha : rochas){ //passa por todas as rochas e imprime elas
            g2d.drawImage(rocha.getImagem(),rocha.getX(),rocha.getY(),null);
        }

        ArrayList<Ataque> removeAtaque = new ArrayList<>();
        
        for (Ataque ataque : entity.getTiros()){
            if (!ataque.isVisible()){
                g2d.drawImage(ataque.getImagem(),ataque.getX(),ataque.getY(),null);
            }
            else{
                removeAtaque.add(ataque);
            }
        }
        for (Ataque ataque : removeAtaque){
            entity.getTiros().remove(ataque);
        }
        g2d.setColor(Color.WHITE);
        g2d.drawString("Detritos espaciais: " + rochas.size(), 5, 15);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        ImageIcon ii = new ImageIcon("craft1.png");
        if (tecla == KeyEvent.VK_LEFT){
            entity.setDx(-entity.getSpeed());
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_RIGHT){
            entity.setDx(entity.getSpeed());
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_UP){
            entity.setDy(-entity.getSpeed());
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_DOWN){
            entity.setDy(entity.getSpeed());
        }
        else if (tecla == KeyEvent.VK_SPACE){
            entity.atirar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        ImageIcon ii = new ImageIcon("craftidle.png");
        if (tecla == KeyEvent.VK_LEFT){
            entity.setDx(0);
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_RIGHT){
            entity.setDx(0);
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_UP){
            entity.setDy(0);
            entity.setImage(ii.getImage());
        }
        else if (tecla == KeyEvent.VK_DOWN){
            entity.setDy(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        entity.move();
        f1.move();
        if (f1.getY() == f2.getY()){
            f2.setY(-f1.getHeight());
        }
        f2.move();
        for(Rocha rocha : rochas){
            rocha.move();
        }
        for(Ataque ataque : entity.getTiros()){
            ataque.move();
        }
        for (Rocha rocha : rochas){
            if (rocha.getY() > 720){
                ImageIcon explosion = new ImageIcon("explosion.png");
                if (!(rocha.getImagem() == explosion.getImage())){
                    Random r = new Random();
                    rocha.setX(r.nextInt(0, 900));
                    rocha.setY(r.nextInt(0, 150));
                }
                else{

                }
            }
        }
        checarColisao();
        repaint();
    }

    public void checarColisao(){
        Rectangle nave = entity.getRectangle();
        ImageIcon explosion = new ImageIcon("explosion.png");

        for(Rocha rocha : rochas){
            Rectangle recRocha = rocha.getRetangulo();

            if (nave.intersects(recRocha)){
                entity.setImage(explosion.getImage());
                timer.stop();
            }
        }
        for(Rocha rocha : rochas){
            Rectangle recRocha = rocha.getRetangulo();

            for(Ataque ataque : entity.getTiros()){
                Rectangle recAtaque = ataque.getRetangulo();
                if (recAtaque.intersects(recRocha)){
                    ataque.setVisible(true);
                    rocha.setImagem(explosion.getImage());
                }

            }
            if (rocha.getImagem() == explosion.getImage()){
                if (rocha.getY() > 720){
                    rocha.setVisible(false);
                }
            }
        }
    }
}


