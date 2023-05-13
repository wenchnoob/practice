import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// javax.swing, java.awt

public class UIPractice {



    public static void main(String[] args) {

        JFrame j = new JFrame("Hey");
        j.setMinimumSize(new Dimension(250, 150));

        JButton hey = new JButton("   hey   ");
        hey.addActionListener(new UIPractice.MyListener());
        j.add(hey);

        j.setPreferredSize(new Dimension(250, 150));
        j.setVisible(true);


    }

    static class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setText(button.getText() + "*");
            button.repaint();
        }
    }

    static class MyMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
