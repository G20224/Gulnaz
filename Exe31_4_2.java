package Week14;

import java.io.*;
import java.net.*;

import javax.swing.*;

public class Exe31_4_2 extends JApplet {
    private static final long serialVersionUID = 1L;

    private JLabel jlCount = new JLabel();

    private boolean bb = false;

    private String host = "localhost";

    public void init() {
        add(jlCount);

        try {
            Socket socket;
            if (bb)
                socket = new Socket(host, 8000);
            else
                socket = new Socket(getCodeBase().getHost(), 8000);

            DataInputStream inputFromServer = new DataInputStream( socket.getInputStream());

            int count = inputFromServer.readInt();
            jlCount.setText("You are visitor number " + count);

            inputFromServer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ex31_4_2");

        Exe31_4_2 applet = new Exe31_4_2();
        applet.bb = true;

        if (args.length == 1)
            applet.host = args[0];

        frame.add(applet, java.awt.BorderLayout.CENTER);

        applet.init();
        applet.start();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
