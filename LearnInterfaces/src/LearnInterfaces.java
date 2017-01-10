
public class LearnInterfaces {

	public static void main(String[] args){
		Square Squ=new Square(2);
		Octagon Oct = new Octagon(5);
		System.out.println("The Square:\n  side:"+Squ.getSide()+"\n  area:"+Squ.getArea()
				+"\n  Square:"+Squ.HowToColor());
		System.out.println("The Octagon:\n  side:"+Oct.getSide()+"\n  area:"+Oct.getArea()
				+"\n  perimeter:"+Oct.getPerimeter());
		Octagon Oct1=(Octagon)Oct.clone();
		System.out.println("The Octagon1:\n  side:"+Oct1.getSide()+"\n  area:"+Oct1.getArea()
				+"\n  perimeter:"+Oct1.getPerimeter());
	}

}
class Square extends GeometricObject implements Colorable{
	double side;
	Square(){
		side=1.0;
	}
	Square(double side){
		this.side=side;
	}
	public double getSide() {
		// TODO Auto-generated method stub
		return this.side;
	}
	public double getArea() {
		return this.side*this.side;
	}
	public double getPerimeter() {
		return this.side*4;
	}
	@Override
	public String HowToColor() {
		return "Give it color";
	}
}
class Octagon extends GeometricObject implements Colorable,Comparable,Cloneable{
	double side;
	Octagon(){
		side=1.0;
	}
	Octagon(double side){
		this.side=side;
	}
	public double getArea(){
		double k;
		k=(2+4/Math.sqrt(2));
		return k*side*side;
	}
	public double getSide() {
		// TODO Auto-generated method stub
		return this.side;
	}
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 8*this.side;
	}
	public int compareTo(Object o) {
		if(side>((Octagon)o).side)
		  return 1;
		else
			if(side<((Octagon)o).side)
				return -1;
			else				
				return 0;
	}
	public String HowToColor() {
		return "Give it color";
	}
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
		}
		return this;
	}
}
