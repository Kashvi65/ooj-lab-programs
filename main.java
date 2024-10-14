import java.util.Scanner;
class PrintInfo {
   static void print() {
        System.out.println("Name: Kashvi Agarwal");
        System.out.println("USN: 1BM23CS141");
    }
}
class Books{
 String name; 
 String author;
 int price;
 int numPages;
 Books(String name, String author, int price, int numPages)

{

      this.name = name;
      this.author = author;
      this.price = price;
      this.numPages = numPages;

}

public String toString()

{

String name, author, price, numPages;

name = "Book name: " + this.name + "\n";

author = "Author name: " + this.author + "\n";

price = "Price: " + this.price + "\n";

numPages = "Number of pages: " + this.numPages + "\n";

return name + author + price + numPages;

}
}
class main{

public static void main(String args[])

{ PrintInfo.print();

  Scanner s = new Scanner(System.in);

 int n;
 int i;
 String name;
 String author;
 int price;
 int numPages;
 n=s.nextInt();
 Books b[];
 b=new Books[n];
 for(i=0;i<n;i++){
  System.out.println("enter book name");
  name = s.next();
  System.out.println("enter author name");
  author = s.next();
  System.out.println("enter the price");
  price=s.nextInt();
  System.out.println("enter number of pages");
  numPages = s.nextInt();
  b[i] = new Books(name,author,price,numPages);
}
 for(i=0;i<n;i++){
  System.out.println("Book Details");
  System.out.println(b[i].toString());
}
s.close();
}
}


