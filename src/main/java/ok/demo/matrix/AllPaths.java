package ok.demo.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.codec.CharEncoding;

public class AllPaths {

  public static void main(String[] args) {
    int[][] mat = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] mat2 = {
      {0, 0, 1, 0},
      {0, 1, 0, 1},
      {0, 1, 1, 1},
      {0, 0, 0, 0}
    };

    // System.out.println(mat[1][2]); = 7

    // printAll(mat,4,4,0,0,"");

    int r = findShortest(mat2, 4, 4);

    System.out.println(r);
  }

  static class Point {
    public int x;
    public int y;
  }

  public static  boolean getOp(char c) {
      if(c=='-') return true;
      if(c=='+') return true;
      return false;
  }
  
  public static  int getSum(char c, int sum, int val) {
      if(c=='-') {
          return sum - val;
      } else {
          return sum + val;
      }
     System.out.println();
  }
  
  public static int getValue(String ex){
      int sum =-1;
      Character lastOp = '*';
      for(int i=0;i<ex.length();i++){
          String v = "";
          char  c  = ex.charAt(i);
        if(getOp(c)){
          if(sum==-1) throw  new RuntimeException();
          lastOp = c;
          sum = sum + Integer.parseInt(v);
        }else{
          v = v+c;
        }
          
      }
      
      
    }
  
  
  
  public static  boolean getOp(int in , char c) {
      if(c=='-') return true;
      if(c=='+') return true;
      return false;
  }
  
  private static int findShortest(int[][] mat, int m, int n) {

    Queue<Point> points = new LinkedList<Point>();

    int[] x = {0, -1, 1, 0, 1, -1, 1, -1};
    int[] y = {-1, 0, 1, 1, 0, 1, -1, -1};
    Point p = new Point();
    p.x = 0;
    p.y = 0;
    points.add(p);
    points.add(null);
    
    String a = " ";
    a.length()
    charAt(index)

    
    
    int steps = 0;
    boolean reached = false;
    while (!points.isEmpty()) {

      Point pt = points.poll();

      if (pt == null) {
        if (!points.isEmpty()) {
          points.add(null);
        }
        steps++;
        continue;
      }

      mat[pt.x][pt.y] = 1;

      if (pt.x == m - 1 && pt.y == n - 1) {
        // return steps;
        reached = true;
        break;
      } else {

        for (int i = 0; i < 8; i++) {
          if (valdiate(mat, nextValue(pt, x[i], y[i]), m, n)) {
            points.add(nextValue(pt, x[i], y[i]));
          }
        }
      }
    }

    if (reached) return steps;
    else return -1;
  }

  private static Point nextValue(Point start, int x, int y) {
    Point p = new Point();
    p.x = (start.x + x);
    p.y = (start.y + y);
    return p;
  }

  private static boolean valdiate(int[][] mat, Point start, int m, int n) {

    if (start.x < 0 || start.x > m - 1) return false;
    if (start.y < 0 || start.y > n - 1) return false;

    if (mat[start.x][start.y] != 0) return false;

    return true;
  }

  private static void printAll(int[][] mat, int x, int y, int p1, int p2, String path) {

    if (p1 == (x - 1) && p2 == (y - 1)) {
      path = add(path, mat[p1][p2]);
      System.out.println(path);
      return;
    }

    if (p1 == (x - 1)) {
      for (int i = p2; i < y; i++) {
        path = add(path, mat[p1][i]);
      }
      System.out.println(path);
      return;
    }

    if (p2 == (y - 1)) {
      for (int i = p1; i < x; i++) {
        path = add(path, mat[i][p2]);
      }
      System.out.println(path);
      return;
    }
    path = add(path, mat[p1][p2]);
    printAll(mat, x, y, p1 + 1, p2, path);
    printAll(mat, x, y, p1, p2 + 1, path);
  }

  private static String add(String path, int a) {
    return path = path + "->" + a;
  }
}
