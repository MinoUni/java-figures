package figures;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import java.util.Objects;

public class Circle extends Figure {
	
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius) {
		
		if (Objects.isNull(center))
			throw new NullPointerException("Center point is NULL");
		if (!degeneracyCheck(radius))
			throw new IllegalArgumentException("Radius = " + radius + " < 0");
		if (area() < 0)
			throw new IllegalArgumentException("Area = " + area() + " < 0");
		this.center = center;
		this.radius = radius;
	}

	private boolean degeneracyCheck(double radius) {
		return radius > 0;
	}

	@Override
	protected Point centriod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double area() {
		return PI * pow(radius, 2);
	}

	@Override
	protected boolean isTheSame(Figure figure) {
		// TODO Auto-generated method stub
		return false;
	}

}
