/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tu_darmstadt.tk.wardriving.control;

import de.tu_darmstadt.tk.wardriving.entity.Location;
import de.tu_darmstadt.tk.wardriving.entity.RouterData;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

/**
 * This service takes the raw signal data as input, calculates the data using
 * the trilateration method and returns the router information in a list
 *
 * @author abd_salam_shaikh
 */
public class CentroidCalculatorServiceImpl implements CentroidCalculatorService{

    SignalDistanceTransformer signalDistanceTransformer = new SignalDistanceTransformer();
    RouterData routerData = new RouterData();

    @Override
    public List<RouterData> calculate(double[][] positions, double[] rssi, long bssid) {
        double[] distances = new double[rssi.length];
        for (int i = 0; i < rssi.length; i++) {
            distances[i] = signalDistanceTransformer.transformSignal(rssi[i]);
        }
        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        LeastSquaresSolver solver = new LeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();
        Location location = new Location();
        location.setLatitude(optimum.getPoint().toArray()[0]);
        location.setLongitude(optimum.getPoint().toArray()[1]);
        routerData.setBssid("1234");
        routerData.setLocation(location);
        routerData.setTimestamp(Instant.EPOCH);
        List<RouterData> routerDataList = new ArrayList<>();
        routerDataList.add(routerData);
        return routerDataList;
    }
}
