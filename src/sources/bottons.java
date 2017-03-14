package sources;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin_master
 */
public class bottons extends JFrame implements ActionListener {
    private JPanel test;
    private JButton[][] buttons;
    private bottons(){
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test");
        this.setResizable(false);
        buttons = new JButton[5][5];
        test = new JPanel();
        test.setLayout(new GridLayout(5,5));
        int index = 0;
        for(int i = 0 ; i<5 ; i++){
            for(int j = 0; j<5 ; j++){
                test.add(buttons[i][j] = new JButton(Integer.toString(index++)));
                buttons[i][j].addActionListener(this);
            }
        }
        //this.add(test, BorderLayout.CENTER);


    }

@Override
public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    Component[] components = test.getComponents();

    for (int i = 0; i < components.length; i++) {
        if (components[i] == o) {
            // Remove the button that was clicked.
            test.remove(i);

            // Add a blank label in place of the button.
            test.add(new JLabel(), i);
        }
    }

    // Force Swing to repaint the panel.
    test.repaint();
}
    public static void main(String[] args)  {
        new bottons();
    }


}
class winExit extends WindowAdapter {
    static final int CLOSE = 0;
    int id;
    /**
     * @description sources.winExit constructor
     * @constructor sources.winExit
     * @param id 
     */
    winExit(int id) {
        this.id = id;
    }
    /**
     * @description windows closing event function (override)
     * @function windowClosing
     * @param we The window closing event.
     * @see java.awt.event.WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(CLOSE);
    }
}