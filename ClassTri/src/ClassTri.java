
public class ClassTri {

	public static void main(String[] args) {
		Triangle tri1=new Triangle(1,1.5,1);
		System.out.println(tri1.tostring());
		tri1.setColor("yellow");
		tri1.setFilled(true);
		System.out.println("Triangle:"+"\n  area:"+tri1.getArea()+
				"\n  perimeter:"+tri1.getPerimeter()+
				"\n  color:"+tri1.getColor()+
				"\n  filled:"+tri1.isFilled());
	}

}


class Triangle extends GeometricObject{
		double side1,side2,side3;
		boolean tri=true;
		Triangle(){
			side1=side2=side3=1.0;
		}
		Triangle(double side1,double side2,double side3){
			if((side1+side2-side3<=0)||(side2+side3-side1<=0)||(side1+side3-side2<=0))
			{
				tri=false;
			}
			else
			{
				this.side1=side1;
				this.side2=side2;
				this.side3=side3;			
			}
		}
		double getside1(){
			return side1;
		}
		double getside2(){
			return side2;
		}
		double getside3(){
			return side3;
		}
		public double getPerimeter(){
			return side1+side2+side3;
		}
		public double getArea(){
			double s,area;
			s=(side1+side2+side3)/2;
			area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
			return area;
		}
		String tostring(){
			if(tri==true)
			  return ( "Triangle: side1 = " + side1 + " side2 = " + side2 +  " side3 = " + side3);
			else
			  return ( "It can't be a triangel");
		}
}