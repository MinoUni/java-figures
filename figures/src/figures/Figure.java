package figures;

public abstract class Figure {
	
	protected abstract Point centriod();
	
	protected abstract double area();
	
	protected abstract boolean isTheSame(Figure figure);
}
