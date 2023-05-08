import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements ActionListener, Runnable {
    private JButton carBtn, bikeBtn;
    private int carX = 0, bikeY = 0;
    private Thread carThread, bikeThread;
    private final int frameWidth = 400, frameHeight = 400;
    private VehiclePanel vehiclePanel;

    public Main() {
        carBtn = new JButton("Move Car");
        carBtn.addActionListener(this);
        bikeBtn = new JButton("Move Bike");
        bikeBtn.addActionListener(this);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2));
        btnPanel.add(carBtn);
        btnPanel.add(bikeBtn);

        // Add vehiclePanel
        vehiclePanel = new VehiclePanel(carX, bikeY);

        JFrame frame = new JFrame("Vehicle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(btnPanel, BorderLayout.SOUTH); // btnPanel in bottom of our GUI
        contentPane.add(vehiclePanel, BorderLayout.CENTER);
    }

    private void updateVehiclePanel() {
        vehiclePanel.setCarX(carX);
        vehiclePanel.setBikeY(bikeY);
        vehiclePanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carBtn) {
            if (carThread == null) {
                carThread = new Thread(this);
                carThread.start();
            }
        } else if (e.getSource() == bikeBtn) {
            if (bikeThread == null) {
                bikeThread = new Thread(this);
                bikeThread.start();
            }
        }
        updateVehiclePanel();
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == carThread) {
            while (carX <= frameWidth) {
                carX += 8;
                repaint();
                try {
                    Thread.sleep(35);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            carX = 0;
            carThread = null; // set carThread to null for next use
        } else if (currentThread == bikeThread) {
            while (bikeY <= frameHeight) {
                bikeY += 6;
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bikeY = 0;
            bikeThread = null; // set bikeThread to null for next use
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}


