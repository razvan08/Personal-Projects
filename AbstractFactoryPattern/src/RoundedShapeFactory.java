
public class RoundedShapeFactory extends AbstractFactory{
	@Override
	public Shape getShape(String shapeType) {
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new RoundedRectangle();
		}else if(shapeType.equalsIgnoreCase("Square")) {
			return new RoundedSquare();
		}
		return null;
	}
}
