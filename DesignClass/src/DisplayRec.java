
public class DisplayRec{
	public static void main(String[] args){
		Rectangle rec1 = new Rectangle(4,40);
		Rectangle rec2 = new Rectangle(3.5,35.9);
		rec2.setcolor("red");
		System.out.println("Width of the first rectangle: "+rec1.getwidth());
		System.out.println("Height of the first rectangle: "+rec1.getheight());
		System.out.println("Color of the first rectangle: "+rec1.getcolor());
		System.out.println("Area of the first rectangle: "+rec1.getArea());
		System.out.println("Perimeter of the first rectangle: "+rec1.getPerimeter());
		System.out.println("Width of the second rectangle: "+rec2.getwidth());
		System.out.println("Height of the second rectangle: "+rec2.getheight());
		System.out.println("Color of the second rectangle: "+rec2.getcolor());
		System.out.println("Area of the second rectangle: "+rec2.getArea());
		System.out.println("Perimeter of the second rectangle: "+rec2.getPerimeter());
	}
}

class Rectangle {
	 double width=1;
	 double height=1;
	 String color="white";
	 
	 Rectangle(){}
	 
	 Rectangle(double itswidth,double itsheight){
		 width=itswidth;
		 height=itsheight;
	 }    
	 
	 double getwidth(){
		return width;
	 }
	 
	 double getheight(){
		 return height;
	 }
	 
	 String getcolor(){
		 return color;
	 }
	 
	 void setwidth(double w){
		 width=(w>=0 ? w:1);
	 }
	 
	 void setheight(double h){
		 height=(h>=0 ? h:1);
	 }
	 
	 void setcolor(String c){
		 color=c;
	 }
	 
	 double getArea(){
		 return this.width*this.height;
	 }
	 
	 double getPerimeter(){
		 return 2*(this.width+this.height);
	 }
}
