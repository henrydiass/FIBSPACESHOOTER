import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame {

    private GamePanel painel;

    public GameFrame() throws IOException {
        painel = new GamePanel();
        Fundo f = new Fundo();
        add(painel);
        setTitle("Space Shooter");
        setSize(f.getWidth(),f.getHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
