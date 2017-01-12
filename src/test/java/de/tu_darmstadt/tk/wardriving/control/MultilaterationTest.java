package de.tu_darmstadt.tk.wardriving.control;

import de.tu_darmstadt.tk.wardriving.control.Multilateration.Point;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MultilaterationTest {
	
	private static final double DELTA = 1e-15;
	
	@Test
	public void centroidOfPoints() {
		Set<Point> points = new HashSet<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(0, -1));
        points.add(new Point(1, -1));

        Point p = Point.centroid(points);
        System.out.println("Centroid: " + p);
	}
	
	@Test
	public void distanceBetweenEqualPointsShouldBeZero() {
		Point p = new Point(1, 2);
		assertEquals(p.distance(p), 0.0, DELTA);
	}
	
	@Test
	public void distanceBetweenPoints() {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		assertEquals(p1.distance(p2), Math.sqrt(2.0), DELTA);
	}
	
}
