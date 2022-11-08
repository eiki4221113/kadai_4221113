import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Bmi {

  public static void main(String[] args) {

    double height;
    double weight;
    BigDecimal bd;

    try {
      Scanner scan = new Scanner(System.in);

      height = getInput(scan, "height(M)");
      weight = getInput(scan, "weight");

      scan.close();

      double result = weight / (height*height);
      //計算結果を小数点第1位までに丸める
      bd = new BigDecimal(result);
      bd = bd.setScale(2, RoundingMode.HALF_UP);

      //結果を表示する
      StringBuilder sb = new StringBuilder();
      sb.append("BMI=" + bd );
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
 

