
package view;

import controller.PerimetterAndArea;

public class PerimetterArea {
    PerimetterAndArea perimetterAndArea = new PerimetterAndArea();
    public void run() {
        System.out.println("");
        perimetterAndArea.setRetangleValue();
        perimetterAndArea.setCircelValue();
        perimetterAndArea.setTriangleValue();
        perimetterAndArea.display();
    }
}
