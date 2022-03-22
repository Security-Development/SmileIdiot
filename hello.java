import java.awt.*;
import javax.swing.*;
import java.lang.Math;

class hello {

    static int x = 0;
    static int y = 0;
    static int check = 1;
    
    private static void showForm(String title, int xx, int yy) {

        ImageIcon img = new ImageIcon("./smile.jpg");
        JFrame f = new JFrame();
        Dimension background = Toolkit.getDefaultToolkit().getScreenSize();
        JLabel l = new JLabel("You are an idiot");
        JPanel p = new JPanel();

        l.setHorizontalAlignment(l.CENTER);
        p.setLayout(new BorderLayout());
        p.add(l, BorderLayout.NORTH);
        p.add(new JLabel(img), BorderLayout.SOUTH);
        l.setFont(new Font(l.getFont().getName(), l.getFont().getStyle(), 30));
        f.setTitle(title);

        if( check == 1  ) {
            x += 100;
            y += 100;

            if( x > background.height )
                check = 0;

        } else if( check == 0  ) {
            x += 100;
            y -= 100;

            if( y < 0)
                check = 1;
            else if( y < 500)
                check = 2;

        } else if( check == 2) {
            x -= 100;
            y -= 100;

            if( y < 0 )
                check = 3;

            if( x < 0)
                check = 0;
        } else if( check == 3) {
            x -=100;
            y += 100;

            if( y > background.height )
                check = 0;
        } 

        f.setBounds(x, y, 300, 300);
        f.add(p);
        f.setVisible(true);
        f.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                sendForm((int)((Math.random() * 500)), (int)((Math.random() * 500)));
            }

        });
        
    }

    public static void sendForm(int xx, int yy) {
        hello c = new hello();
        c.x = xx;
        c.y = yy;
        for(int i = 0; i < 100; i++)
            c.showForm("You are an idiot", i, i);
    }
    
    public static void main(String args[]) throws Exception{
        sendForm(100, 300);
    }
}

    