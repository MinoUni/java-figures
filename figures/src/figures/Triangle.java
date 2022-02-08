package figures;

public class Triangle extends Figure {

	private Point pointA, pointB, pointC;
	
	public Triangle(Point a, Point b, Point c) {
		pointA = a;
		pointB = b;
		pointC = c;
	}

	@Override
	protected Point centriod() {
		double x = (pointA.getX() + pointB.getX() + pointC.getX()) /3;
		double y = (pointA.getY() + pointB.getY() + pointC.getY()) /3;
		return new Point(x,y);
	}

	@Override
	protected double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected boolean isTheSame(Figure figure) {
		// TODO Auto-generated method stub
		return false;
	}

}
