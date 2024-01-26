import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class PaintBrush extends JFrame  {

    private JButton rectButton, ovalButton, penButton, moveButton;
   private Palet drawPanel;

    public PaintBrush() {
        super("Paint Brush");

        drawPanel=new Palet();

        // Create buttons
        rectButton = new JButton("Rectangle");
        ovalButton = new JButton("Oval");
        penButton = new JButton("Pen");
        moveButton = new JButton("Move");

        rectButton.addActionListener(e -> {
            drawPanel.currentTool=1;
        });
        ovalButton.addActionListener(e -> {
            drawPanel.currentTool=2;
        });
        penButton.addActionListener(e -> {
            drawPanel.currentTool=3;
        });
        moveButton.addActionListener(e -> {
            drawPanel.currentTool=4;
        });

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(rectButton);
        buttonPanel.add(ovalButton);
        buttonPanel.add(penButton);
        buttonPanel.add(moveButton);
        JPanel colorpanel=new JPanel(new GridLayout(1,7));
        JPanel Blue = new JPanel();
        Blue.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(44, 104, 234);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(44, 104, 234);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Blue.setBackground(new Color(44, 104, 234));
        JPanel Red = new JPanel();
        Red.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(220, 10, 26);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(220, 10, 26);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Red.setBackground(new Color(220, 10, 26));
        JPanel Green = new JPanel();
        Green.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(15, 145, 2);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(15, 145, 2);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Green.setBackground(new Color(15, 145, 2));
        JPanel Yellow = new JPanel();
        Yellow.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(250, 230, 4);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(250, 230, 4);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Yellow.setBackground(new Color(250, 230, 4));
        JPanel Orange = new JPanel();
        Orange.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(231, 132, 6);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(231, 132, 6);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Orange.setBackground(new Color(231, 132, 6));
        JPanel Purple = new JPanel();
        Purple.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=new Color(74, 8, 176, 208);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=new Color(74, 8, 176, 208);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Purple.setBackground(new Color(74, 8, 176, 208));
        JPanel Black = new JPanel();
        Black.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.currentColor=Color.BLACK;
            }
            @Override
            public void mousePressed(MouseEvent e) {
                drawPanel.currentColor=Color.BLACK;
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        Black.setBackground(Color.BLACK);
        colorpanel.add(Blue);
        colorpanel.add(Red);
        colorpanel.add(Green);
        colorpanel.add(Yellow);
        colorpanel.add(Orange);
        colorpanel.add(Purple);
        colorpanel.add(Black);
        JPanel menupanel=new JPanel(new GridLayout(2,0));
        menupanel.add(colorpanel);
        menupanel.add(buttonPanel);

        // Add components to frame
        add(menupanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[]args)
    {
        new PaintBrush();
    }
}
