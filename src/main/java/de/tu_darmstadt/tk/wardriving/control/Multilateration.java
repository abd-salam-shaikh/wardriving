package de.tu_darmstadt.tk.wardriving.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Multilateration {
	
	public static final class Pair<T> {
		public final T first;
		public final T second;
		
		public Pair(T first, T second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public String toString() {
			return "Pair{" + "first=" + first + ", second=" + second + '}';
		}
	}
	
	public static final class Point {
		public final double x;
		public final double y;
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public static Pair<Point> closestPair(Set<Point> points) {
			assert points.size() >= 2;
			List<Point> p = new ArrayList<>(points);
			double minDist = Double.MAX_VALUE;
			Pair<Point> closestPair = null;
			for (int i = 0; i < p.size(); ++i) {
				for (int j = i + 1; j < p.size(); ++j) {
					Point a = p.get(i);
					Point b = p.get(j);
					double distance = a.distance(b);
					if (distance < minDist) {
						closestPair = new Pair<>(a, b);
						minDist = distance;
					}
				}
			}
			assert closestPair != null;
			return closestPair;
		}
		
		public static Point centroid(Set<Point> points){
			double x = 0;
			double y = 0;
			for (Point p : points){
				x += p.x;
				y += p.y;
			}
			return new Point(x / points.size(), y / points.size());
		}
		
		public double distance(Point other) {
			return Math.sqrt(Math.pow(x - other.x, 2.0) + Math.pow(y - other.y, 2.0));
		}

		@Override
		public String toString() {
			return "Point{" + "x=" + x + ", y=" + y + '}';
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
			hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Point other = (Point) obj;
			if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
				return false;
			}
			if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
				return false;
			}
			return true;
		}
	}
	
	public static final class Circle {
		public final Point c;
		public final double r;
		
		public Circle(double x, double y, double r) {
			this.c = new Point(x, y);
			this.r = r;
		}
		
		public boolean isIntersecting(Circle other) {
			return c.distance(other.c) <= r + other.r;
		}
		
		public Set<Point> intersections(Circle other) {
			assert isIntersecting(other);
			double d = c.distance(other.c);
			
			double r1sq = Math.pow(r, 2.0);
			double r2sq = Math.pow(other.r, 2.0);
			double dsq = Math.pow(d, 2.0);
			
			double fac1 = ((r1sq - r2sq) / (2 * dsq));
			
			double baseX = 0.5 * (c.x + other.c.x) + 
				fac1 * (other.c.x - c.x);
			double baseY = 0.5 * (c.y + other.c.y) +
				fac1 * (other.c.y - c.y);
			
			double fac2 = 0.5 * Math.sqrt(
				(2 * ((r1sq + r2sq) / dsq)) -
				(Math.pow(r1sq - r2sq, 2.0) / Math.pow(d, 4.0)) -
				1
			);
			
			Point p1 = new Point(
				baseX + fac2 * (other.c.y - c.y),
				baseY + fac2 * (c.x - other.c.x)
			);
			
			Point p2 = new Point(
				baseX - fac2 * (other.c.y - c.y),
				baseY - fac2 * (c.x - other.c.x)
			);
			
			Set<Point> result = new HashSet<>(2);
			result.add(p1);
			result.add(p2);
			return result;
		}

		@Override
		public String toString() {
			return "Circle{" + "x=" + c.x + ", y=" + c.y + ", r=" + r + '}';
		}

		@Override
		public int hashCode() {
			int hash = 5;
			hash = 71 * hash + Objects.hashCode(this.c);
			hash = 71 * hash + (int) (Double.doubleToLongBits(this.r) ^ (Double.doubleToLongBits(this.r) >>> 32));
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Circle other = (Circle) obj;
			if (!Objects.equals(this.c, other.c)) {
				return false;
			}
			if (Double.doubleToLongBits(this.r) != Double.doubleToLongBits(other.r)) {
				return false;
			}
			return true;
		}
	}
	
	
	
}
