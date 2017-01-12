/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.control;

import de.tu_darmstadt.tk.wardriving.entity.RouterData;
import java.util.List;

/**
 *
 * @author abd_salam_shaikh
 */
public interface CentroidCalculatorService {
    
     public List<RouterData> calculate(double[][] positions, double[] rssi, long bssid);
}
