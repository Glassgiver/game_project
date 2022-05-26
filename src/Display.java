import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private JPanel panel;
    private final int COLS = 15; //кол-во столбцов
    private final int ROWS = 1; //кол-во строк
    private final int IMAGE_SIZE = 50; //размер картинки 50 на 50

    public static void main(String[] args) {
        new Display();
    }

    private Display(){
        startPanel();
        frameStat();

    }

    private void startPanel(){
        panel = new JPanel(){
            @Override
            public void paintComponents(Graphics g){
                super.paintComponent(g);
                g.drawImage(getImage("background"), 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(1000, 1000));
        add(panel);
    }

    private void frameStat(){
        pack();
        setTitle("Just live");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //прекращает работу по нажатию крестика
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // увеличивает размер окна до максимума
        setLocationRelativeTo(null);
        setVisible(true); //показывает само окно
        setResizable(true);
    }

    //-------------------------------------------------------------------//

    // получаем картинки
    private Image getImage(String name){
        String filename = "images/" + name.toLowerCase() + "jpg";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

}
