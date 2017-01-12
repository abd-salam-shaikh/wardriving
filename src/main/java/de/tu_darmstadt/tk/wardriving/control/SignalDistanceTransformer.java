package de.tu_darmstadt.tk.wardriving.control;

/**
 * Created by abd_salam_shaikh on 11/14/2015.
 */
public class SignalDistanceTransformer implements Transformer {

    @Override
    public  double transformSignal(double rssi) {
        double base = 10;
        double exponent = (-rssi-10)/35;
        double distance = 1.0/3.0*(Math.pow(base,exponent)- 1);
        return calFeetToMeter(distance);
    }

    static double calFeetToMeter(double distance) {
        return distance*0.3048;
    }

}
