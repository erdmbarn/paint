import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;



public class Palet extends JPanel implements MouseListener, MouseMotionListener {
    public Color currentColor;
    public int currentTool;

    public Integer x=0, y=0,endx=0,endy=0;

    public Integer index=0;

    public ArrayList<Shape> shapes= new ArrayList<>();

    boolean inpalet=false;

    public Palet()
    {
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
        currentColor=Color.BLACK;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(!shapes.isEmpty())
        {
            for(int i=0;i<shapes.size();i++)
            {
                if(shapes.get(i).getClass().getName().equals("Oval"))
                {
                    Oval yeni = (Oval) shapes.get(i);
                    g.setColor(yeni.color);
                    g.fillOval(yeni.x,yeni.y, yeni.width,yeni.height);
                }
                if(shapes.get(i).getClass().getName().equals("Rectangle"))
                {

                    Rectangle yeni = (Rectangle) shapes.get(i);
                    g.setColor(yeni.color);
                    g.fillRect(yeni.x,yeni.y, yeni.width,yeni.height);
                }
                if(shapes.get(i).getClass().getName().equals("Line"))
                {
                    Line yeni = (Line) shapes.get(i);
                    g.setColor(yeni.color);
                    g.drawLine(yeni.x,yeni.y, yeni.x2, yeni.y2);
                }
            }
        }
        if(currentTool==1)
        {
            g.setColor(currentColor);
            if(endx<x&&endy<y)
            {
                g.fillRect(endx,endy,x-endx,y-endy);
            }
            if(endx>x&&endy<y)
            {
                g.fillRect(x,endy,endx-x,y-endy);
            }
            if(endx>x&&endy>y)
            {
                g.fillRect(x,y,endx-x,endy-y);
            }
            if(endx<x&&endy>y)
            {
                g.fillRect(endx,y,x-endx,endy-y);
            }
        }
        if(currentTool==2)
        {
            g.setColor(currentColor);
            if(endx<x&&endy<y)
            {
                g.fillOval(endx,endy,x-endx,y-endy);
            }
            if(endx>x&&endy<y)
            {
                g.fillOval(x,endy,endx-x,y-endy);
            }
            if(endx>x&&endy>y)
            {
                g.fillOval(x,y,endx-x,endy-y);
            }
            if(endx<x&&endy>y)
            {
                g.fillOval(endx,y,x-endx,endy-y);
            }



        }
        if(currentTool==3)
        {
            g.setColor(currentColor);
           try {
               g.drawLine(x,y,endx,endy);
           }
           catch (NullPointerException ignored)
           {
           }
            shapes.add(new Line(x,y,endx,endy,currentColor));
            x=endx;
            y=endy;
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(currentTool==4)
        {
            for(int i=shapes.size()-1;0<=i;i--)
            {

                if(!Objects.equals(shapes.get(i).getClass().getName(), "Line") &&
                        e.getX()>=shapes.get(i).x && e.getX()<=(shapes.get(i).x+shapes.get(i).width)&&
                e.getY()>=shapes.get(i).y && e.getY()<=(shapes.get(i).y+shapes.get(i).height))
                {
                    if(Objects.equals(shapes.get(i).getClass().getName(), "Rectangle"))
                    {
                        inpalet = true;
                        index = i;
                        break;
                    }
                    else {
                        double dx=(double) shapes.get(i).x+(double) (shapes.get(i).width/2)-e.getX();
                        double centerx=(double) shapes.get(i).width/2;
                        double dy=(double) shapes.get(i).y+(double) (shapes.get(i).height/2)-e.getY();
                        double centery=(double) shapes.get(i).height/2;


                        if (Objects.equals(shapes.get(i).getClass().getName(), "Oval") &&
                                1>= (Math.pow(dx,2)/(Math.pow(centerx,2)))+(Math.pow(dy,2)/(Math.pow(centery,2)))
                        ) {
                            inpalet = true;
                            index = i;
                            break;
                        }
                    }

                }
            }
        }
        else {
            x=e.getX();
            y=e.getY();
            inpalet = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        inpalet=false;
        index= 0;
        if(currentTool==1)
        {
            if(endx<x&&endy<y)
            {
                shapes.add(new Rectangle(endx,endy,x-endx,y-endy,currentColor));
            }
            if(endx>x&&endy<y)
            {
                shapes.add(new Rectangle(x,endy,endx-x,y-endy,currentColor));

            }
            if(endx>x&&endy>y)
            {
                shapes.add(new Rectangle(x,y,endx-x,endy-y,currentColor));
            }
            if(endx<x&&endy>y)
            {
                shapes.add(new Rectangle(endx,y,x-endx,endy-y,currentColor));
            }

        }
        if(currentTool==2)
        {
            if(endx<x&&endy<y)
            {
                shapes.add(new Oval(endx,endy,x-endx,y-endy,currentColor));
            }
            if(endx>x&&endy<y)
            {
                shapes.add(new Oval(x,endy,endx-x,y-endy,currentColor));

            }
            if(endx>x&&endy>y)
            {
                shapes.add(new Oval(x,y,endx-x,endy-y,currentColor));
            }
            if(endx<x&&endy>y)
            {
                shapes.add(new Oval(endx,y,x-endx,endy-y,currentColor));
            }


        }

        x= 0;
        y=0;
        endx= 0;
        endy= 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {
        if(inpalet)
        {
            if(currentTool==4)
            {
                shapes.get(index).x=e.getX()-shapes.get(index).width/2;
                shapes.get(index).y=e.getY()-shapes.get(index).height/2;
                shapes.add(shapes.get(index));
                shapes.remove(index);
                repaint();
            }
            if(currentTool==1)
            {
                endx=e.getX();
                endy=e.getY();
                repaint();
            }
            if(currentTool==2)
            {
                endx=e.getX();
                endy=e.getY();
                repaint();
            }
            if(currentTool==3)
            {
                endx=e.getX();
                endy=e.getY();
                repaint();
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
