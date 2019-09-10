package ok.demo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPalindroms {

  public static void main(String[] args) {

    System.out.println(countPalindromes("abbab"));
    printAllPalindromes("abbab");
    List<Integer> songs = new ArrayList<Integer>();
    songs.add(60);
    songs.add(60);
    songs.add(60);

    // System.out.println(playlist(songs));
  }

  public static void printAllPalindromes(String s) {

    for (int k = 0; k < s.length(); k++) {
      int i = k;
      int j = k;
      while (i >= 0 && j <= s.length() - 1) {
        if (s.charAt(i) == s.charAt(j)) {
          System.out.println(s.substring(i, j + 1));
          i--;
          j++;
        } else {
          break;
        }
      }

      i = k;
      j = k + 1;
      while (i >= 0 && j <= s.length() - 1) {
        if (s.charAt(i) == s.charAt(j)) {
          System.out.println(s.substring(i, j + 1));
          i--;
          j++;
        } else {
          break;
        }
      }
    }
  }

  public static int countPalindromes(String s) {

    int n = s.length();
    int R[][] = new int[n][n];
    boolean P[][] = new boolean[n][n];

    for (int i = 0; i < n; i++) P[i][i] = true;

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        P[i][i + 1] = true;
        R[i][i + 1] = 1;
      }
    }

    for (int gap = 2; gap < n; gap++) {
      for (int i = 0; i < n - gap; i++) {
        int j = gap + i;
        if (s.charAt(i) == s.charAt(j) && P[i + 1][j - 1]) P[i][j] = true;
        if (P[i][j] == true) R[i][j] = R[i][j - 1] + R[i + 1][j] + 1 - R[i + 1][j - 1];
        else R[i][j] = R[i][j - 1] + R[i + 1][j] - R[i + 1][j - 1];
      }
    }
    return R[0][n - 1];
  }

  public static long playlist(List<Integer> songs) {
    int n = songs.size();
    int zeron = 0;

    for (int i = 0; i < n; i++) {
      // if (songs.get(i) != 60) {
      if (songs.get(i) == 0) zeron++;

      songs.set(i, songs.get(i) % 60);
      // }
    }

    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < n; i++) {

      if (!hm.containsKey(songs.get(i))) {
        hm.put(songs.get(i), 0);
      }

      hm.put(songs.get(i), hm.get(songs.get(i)) + 1);
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (songs.get(i) == 0) {
        if (hm.get(0) != null) {
          count += hm.get(0);
          count--;
        }
      } else {
        if (hm.get(60 - songs.get(i)) != null) count += hm.get(60 - songs.get(i));

        if (60 - songs.get(i) == songs.get(i)) count--;
      }
    }

    return (long) (count / 2);
  }

  public abstract class Shape {
    public abstract void drawShape();
  }

  public class Square extends Shape implements Name {
    @Override
    public void drawShape() {
      System.out.println("Drawing a Square");
    }

    @Override
    public String getName() {
      return "Square";
    }
  }

  public class Cirlce extends Shape implements Name {
    @Override
    public void drawShape() {
      System.out.println("Drawing a Cirlce");
    }

    @Override
    public String getName() {
      return "Cirlce";
    }
  }

  public class Rectangle extends Shape implements Name {
    @Override
    public void drawShape() {
      System.out.println("Drawing a Rectangle");
    }

    @Override
    public String getName() {
      return "Rectangle";
    }
  }

  public interface Name {
    public String getName();
  }

  public class ShapeFactory {
    /*Map<String, Shapes> shapes = new HashMap<>();

    public ShapeFactory() {
      super();

      shapes.put("Square", new Square());
      shapes.put("Rectangle", new Rectangle());
      shapes.put("Cirlce", new Cirlce());
    }*/

    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public ShapeFactory() {
      super();

      shapes.add(new Square());
      shapes.add(new Rectangle());
      shapes.add(new Cirlce());
    }

    public void drawShape(String shape) {
      boolean found = false;
      Shape printShape = null;
      for (Shape a : shapes) {
        if (((Name) a).getName().equals(shape)) {
          printShape = a;
          found = true;
        }
      }
      if (found) {
        printShape.drawShape();
      } else {
        System.out.println("Drawing " + shape + "is not supported");
      }
    }
  }

  public static String winner(String erica, String bob) {
    int e = 0;
    int b = 0;
    for (int i = 0; i < erica.length(); i++) {
      e = e + getPoints(erica.charAt(i) + "");
    }

    for (int i = 0; i < bob.length(); i++) {
      b = b + getPoints(bob.charAt(i) + "");
    }

    if (e == b) {
      return "tie";
    } else if (e > b) {
      return "erica";
    } else {
      return "bob";
    }
  }

  public static int getPoints(String val) {

    switch (val) {
      case "E":
        return 1;
      case "M":
        return 3;
      default:
        return 5;
    }
  }

  public static int addNumbers(float a, float b) {
    return (int) (a + b);
  }
}
