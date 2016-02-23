package mygame;

import com.simsilica.es.EntityComponent;

public class Defense implements EntityComponent {

    private final double power;

    public Defense(double power) {
        if (power < 0) {
            this.power = 0;
        } else {
            this.power = power;
        }
    }

    public double getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Defense[" + power + "]";
    }
}
