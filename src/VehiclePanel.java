import javax.swing.JPanel;
import java.awt.*;

public class VehiclePanel extends JPanel {
    private double carX, bikeY;

    double getCarX() {
        return carX;
    }
    void setCarX(double x) {
        carX = x;
    }
    double getBikeY() {
        return bikeY;
    }
    void setBikeY(double y) {
        bikeY = y;
    }
    public VehiclePanel(double carX, double bikeY) {
        this.carX = carX;
        this.bikeY = bikeY;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension size = getSize();
        // Width x/y
        int x = size.width;
        int y = size.height;

        g.setColor(Color.GREEN);
        g.fillRect((int) carX, x / 2, 20, 10); // draw car
        g.setColor(Color.BLUE);
        g.fillRect(y / 2, (int) bikeY, 10, 20); // draw bike
    }
}