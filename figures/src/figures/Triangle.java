package figures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle extends Figure {

	private Point pointA, pointB, pointC;
	private double sideAB, sideBC, sideAC;

	public Triangle(Point a, Point b, Point c) {
		
		if (!degeneracyCheck(a,b,c)) {
			throw new IllegalArgumentException("Degenerate triangle");
		}
		if (area() < 0) {
			throw new IllegalArgumentException("Area < 0");
		}

		pointA = a;
		pointB = b;
		pointC = c;
	}
	
	private double calcSideLength(Point start, Point end) {
		return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
	}
	
	private boolean degeneracyCheck(Point a, Point b, Point c) {
		sideAB = calcSideLength(a, b);
		sideBC = calcSideLength(b, c);
		sideAC = calcSideLength(a, c);
		if (sideAB < (sideBC + sideAC) && sideBC < (sideAB + sideAC) && sideAC < (sideBC + sideAB)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	protected Point centriod() {
		double x = (pointA.getX() + pointB.getX() + pointC.getX()) / 3;
		double y = (pointA.getY() + pointB.getY() + pointC.getY()) / 3;
		return new Point(x, y);
	}

	@Override
	protected double area() {
		double p = (sideAB + sideBC + sideAC);
		return sqrt(p * (p - sideAB) * (p - sideBC) * (p - sideAC));
	}

	@Override
	protected boolean isTheSame(Figure figure) {
		// TODO Auto-generated method stub
		return false;
	}

}
