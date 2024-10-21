import java.util.Scanner;
class PrintInfo {
   static void print() {
        System.out.println("Name: Kashvi Agarwal");
        System.out.println("USN: 1BM23CS141");
    }
}

abstract class shape{
      int dim1;
      int dim2;
      abstract void printarea();
}

class rectangle extends shape{
      public rectangle(){
      this.dim1=dim1;
      this.dim2=dim2;
      }
      public void printarea(){
        Scanner s = new Scanner(System.in);
        System.out.println("enter the l and b");
        dim1=s.nextInt();
        dim2=s.nextInt();

        int area=dim1*dim2;
        System.out.println("area of rectangle: "+area);
      }
}
class triangle extends shape{
      public triangle(){
      this.dim1=dim1;
      this.dim2=dim2;
      }  
       public void printarea(){
        Scanner s = new Scanner(System.in);

         System.out.println("enter the l and b");
        dim1=s.nextInt();
        dim2=s.nextInt();
        double area=(dim1*dim2)/2;
        System.out.println("area of triangle: "+area);
      }
     
}
class circle extends shape{
      final double Pi=3.14;
      public circle(){
      this.dim1=dim1;
      }
      public void printarea(){
      Scanner s = new Scanner(System.in);

       System.out.println("enter the radius");
        dim1=s.nextInt();
        
        double area=Pi*dim1*dim1;
        System.out.println("area of circle: "+area);
      }
}
public class main{
  public static void main (String [] args){
  PrintInfo.print();

   

   
     rectangle R =new rectangle();
    
     R.printarea();
   
     triangle T = new triangle();
     T.printarea();
   
     circle C = new circle();
    C.printarea();
    }
   
}
