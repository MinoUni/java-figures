package figures;

public abstract class Figure {
	
	protected abstract Point centroid();
	
	protected abstract double area();
	
	protected abstract boolean isTheSame(Figure figure);
}
