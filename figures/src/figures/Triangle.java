package figures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Objects;

public class Triangle extends Figure {

	private Point pointA, pointB, pointC;
	private double sideAB, sideBC, sideAC;

	public Triangle(Point a, Point b, Point c) {

		if (Objects.isNull(a) || Objects.isNull(b) || Objects.isNull(c)) {
			throw new NullPointerException("One of the points is NULL");
		}
		if (!degeneracyCheck(a, b, c)) {
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
		if (getClass() == figure.getClass()) {
			Triangle other = (Triangle) figure;
			if (comparePoints(other)) {
				System.out.println("Figures = same");
				return true;
			} 
			else {
				System.out.println("Figures != same");
				return false;
			}
		} 
		else {
			System.out.println("Figures different");
			return false;
		}
	}

	private boolean comparePoints(Triangle other) {
		Point[] ourPoints = {pointA, pointB, pointC};
		Point[] otherPoints = {other.pointA, other.pointB, other.pointC};
		boolean[] result = new boolean[ourPoints.length];
		for (int i = 0; i < ourPoints.length; i++) {
			for (int j = 0; j < otherPoints.length; j++) {
				if ((ourPoints[i].getX() == otherPoints[j].getX()) &&
					(ourPoints[i].getY() == otherPoints[j].getY())) {
					result[i] = true;
					break;
				} 
				else {
					result[i] = false;
					continue;
				}
			}
		}
		return (result[0] == true && result[1] == true && result[2] == true);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pointA, pointB, pointC, sideAB, sideAC, sideBC);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Objects.equals(pointA, other.pointA) && Objects.equals(pointB, other.pointB)
				&& Objects.equals(pointC, other.pointC)
				&& Double.doubleToLongBits(sideAB) == Double.doubleToLongBits(other.sideAB)
				&& Double.doubleToLongBits(sideAC) == Double.doubleToLongBits(other.sideAC)
				&& Double.doubleToLongBits(sideBC) == Double.doubleToLongBits(other.sideBC);
	}

}
