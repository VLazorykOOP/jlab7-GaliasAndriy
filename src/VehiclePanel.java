import javax.swing.JPanel;
import java.awt.*;

public class VehiclePanel extends JPanel {
    private int carX, bikeY;

    int getCarX() {
        return carX;
    }
    void setCarX(int x) {
        carX = x;
    }
    int getBikeY() {
        return bikeY;
    }
    void setBikeY(int y) {
        bikeY = y;
    }
    public VehiclePanel(int carX, int bikeY) {
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
        g.fillRect(carX, x / 2, 20, 10); // draw car
        g.setColor(Color.BLUE);
        g.fillRect(y / 2, bikeY, 10, 20); // draw bike
    }
}