package figures;

import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

import java.util.Objects;

public class Quadrilateral extends Figure {
	
	private Point pointA, pointB, pointC, pointD;
	private double sideAB, sideBC, sideCD, sideAD;
	
	public Quadrilateral(Point a, Point b, Point c, Point d) {
		if (Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(c) || Objects.isNull(d))
			throw new NullPointerException("One of the points is NULL");
		if (!degeneracyCheck(a,b,c,d))
			throw new IllegalArgumentException("Degenerate quadrilateral");
		if (area() < 0)
			throw new IllegalArgumentException("Area = " + area() + " < 0");
		if (!diagonalIntersection(a,b,c,d))
			throw new IllegalArgumentException("Quadrilateral is CONCAVE");
		pointA = a;
		pointB = b;
		pointC = c;
		pointD = d;
	}

	private boolean degeneracyCheck(Point a, Point b, Point c, Point d) {
		sideAB = calcSideLength(a, b);
		sideBC = calcSideLength(b, c);
		sideCD = calcSideLength(c, d);
		sideAD = calcSideLength(a, d);
		if (sideAB >= (sideBC + sideCD + sideAD) || sideBC >= (sideAB + sideCD + sideAD) ||
			sideCD >= (sideAB + sideBC + sideAD) || sideAD >= (sideAB + sideBC + sideCD)) {
			return false;			
		}
		else return true;
	}
	
	private double calcSideLength(Point start, Point end) {
		return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
	}
	
	@Override
	protected double area() {
		double p = abs((sideAB + sideBC + sideCD + sideAD) /2);
		return abs(sqrt((p - sideAB) * (p - sideBC) * (p - sideCD) * (p - sideAD)));
	}
	
	private boolean diagonalIntersection(Point a, Point b, Point c, Point d) {
		double i = (a.getX() - c.getX()) * (b.getY() - d.getY());
		double j = (a.getY() - c.getY()) * (b.getX() - d.getX());
		double determinator = i - j;
		boolean transectionResult = transection(a,b,c,d);
		
		if (determinator == 0) {
			return false;
		}
		else if (!transectionResult) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean transection(Point a, Point b, Point c, Point d) {
		double v1 = (d.getX() - b.getX()) * (a.getY() - b.getY()) - (d.getY() - b.getY()) * (a.getX() - b.getX());
		double v2 = (d.getX() - b.getX()) * (c.getY() - b.getY()) - (d.getY() - b.getY()) * (c.getX() - b.getX());
		double v3 = (c.getX() - a.getX()) * (b.getY() - a.getY()) - (c.getY() - a.getY()) * (b.getX() - a.getX());
		double v4 = (c.getX() - a.getX()) * (d.getY() - a.getY()) - (c.getY() - a.getY()) * (d.getX() - a.getX());
		return (v1 * v2) <= 0 && (v3 * v4) <= 0;
	}
	
	@Override
	protected Point centroid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isTheSame(Figure figure) {
		return false;
	}

	private boolean comparePoints(Quadrilateral other) {
		return true;
	}
}
