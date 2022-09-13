public class Derivative{
  public static void main(String[] args){
    System.out.println(newt(4, 0.03125, 0.001));
  }
  public static double f(double x){//function method
    return x*x*x*x-3*x*x*x+x-11;//returns function output(in this case, x^2-17)
  }

  //newton's method; approximate the closest zero of a function
  //precondition: x is not a local maximum or minimum
  //parameters: initial approximation x, double h, error epsilon
  public static double newt(double x, double h, double epsilon){
    double x1= x;
    x = x + epsilon + epsilon;
    while(Math.abs(x1-x)>epsilon){//while difference greater than error
      x=x1;
      x1=x - f(x)/deriv(x, h);//newton's method
    }
    return x1;//returns current approximation
  }
  public static double deriv(double x, double h){//derivative method
    return (f(x+h)-f(x-h))/(2*h);//returns numerical derivative
  }

}
