package bmi;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Bmi {

  public static void main(String[] args) {

    double height;
    double weight;
    BigDecimal bd;
    double height2;
    double weight2;
    BigDecimal bd2;

    try {
      Scanner scan = new Scanner(System.in);

      height = getInput(scan, "height(M)");
      weight = getInput(scan, "weight");

      height2 = getInput(scan, "height(M)");
      weight2 = getInput(scan, "weight");

      scan.close();

      double result = weight / (height*height);
      double result2 = weight2 / (height2*height2);
      bd = new BigDecimal(result);
      bd2 = new BigDecimal(result2);
      bd = bd.setScale(2, RoundingMode.HALF_UP);
      bd2 = bd2.setScale(2, RoundingMode.HALF_UP);

      StringBuilder sb = new StringBuilder();
      sb.append("BMI=" + bd );
      sb.append("BMI2="+bd2);
      System.out.println(sb.toString());

    } catch (NumberFormatException e) {
      e.printStackTrace();
      System.out.println("Error");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static double getInput(Scanner scan, String msg) {

    double rtn = 0;

    System.out.println(msg);
    while (true) {
      try {
        String input = scan.nextLine();

        rtn = Double.parseDouble(input);

      } catch (NumberFormatException e) {
        System.out.println("Error:NOT.INT.Retry>");
        continue;
      }

      if (rtn <= 0) {
        System.out.println("Error:NOT(-)Retry>");
        continue;
      }
      else {
        break;
      }
    }

    return rtn;
  }
}
 

