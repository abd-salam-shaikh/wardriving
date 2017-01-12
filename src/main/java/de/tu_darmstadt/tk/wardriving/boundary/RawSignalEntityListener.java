/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.boundary;

import de.tu_darmstadt.tk.wardriving.control.AutowireHelper;
import de.tu_darmstadt.tk.wardriving.control.CentroidCalculatorService;
import de.tu_darmstadt.tk.wardriving.entity.RawSignal;
import javax.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author abd_salam_shaikh
 */
public class RawSignalEntityListener {
    @Autowired
    private CentroidCalculatorService centroidCalculatorService;
    
   @PrePersist
    public void prePersist(RawSignal rawSignal) {
        AutowireHelper.autowire(this, this.centroidCalculatorService);
        double[][] positions = new double[][]{{rawSignal.getLocation().getLatitude(),rawSignal.getLocation().getLongitude()}};
        double[] rssi = new double[]{1.0};
        long bssid = 1;
        this.centroidCalculatorService.calculate(positions, rssi, bssid);
    }
}
