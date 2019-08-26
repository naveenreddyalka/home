package ok.demo.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class AllPaths {

    public static void main(String[] args) {
        int[][] mat = { {1 ,2 ,3 ,4 },
                        {5 ,6 ,7 ,8 },
                        {9 ,10,11,12},
                        {13,14,15,16}};
        
        
        int[][] mat2 = {  {0 ,0 ,1 ,0},
                          {0 ,1 ,0 ,1},
                          {0 ,1 ,1 ,1},
                          {0 ,0 ,0 ,0}};
                    
        //System.out.println(mat[1][2]); = 7
        
        //printAll(mat,4,4,0,0,"");
        
        int r = findShortest(mat2, 4, 4);
        
        System.out.println(r);
        
    }
    
    private static int findShortest(int[][] mat, int m, int n) {
      
      Queue<String> points = new LinkedList<String>();
      
      int[] x = {0,-1,1,0,1,-1,1,-1};
      int[] y = {-1,0,1,1,0,1,-1,-1};
      
      points.add("0A0");
      points.add(null);
      
      int steps = 0;
      boolean reached = false;
    while (!points.isEmpty()) {
   
      String ptStr = points.poll();
      
      if (ptStr == null) {
        if(!points.isEmpty()) points.add(null);
        steps++;
        continue;
      }
      
      String[] point = ptStr.split("A");
      mat[Integer.parseInt(point[0])][Integer.parseInt(point[1])] =1;
      
     
      if (Integer.parseInt(point[0]) == m-1 && Integer.parseInt(point[1]) == n-1) {
        //return steps;
        reached = true;
        break;
      } else {

        for (int i = 0; i < 8; i++) {
          if (valdiate(points,mat,nextValue(ptStr, x[i], y[i]), m, n)) {
            points.add(nextValue(ptStr, x[i], y[i]));
          }
        }
      }

    }
    
    if(reached) return steps;
    else return -1;
      
    }
    
  private static String nextValue(String start, int x, int y) {
    String[] spi = start.split("A");

    return (Integer.parseInt(spi[0]) + x) + "A" + (Integer.parseInt(spi[1]) + y);
  }
    
  private static boolean valdiate(Queue<String> points,int[][] mat,String start, int m, int n) {
    String[] spi = start.split("A");
   
   // if(points.contains(start)) return false;
        
    if (Integer.parseInt(spi[0]) < 0 || Integer.parseInt(spi[0]) > m-1)
      return false;
    if (Integer.parseInt(spi[1]) < 0 || Integer.parseInt(spi[1]) > n-1)
      return false;
    
    if(mat[Integer.parseInt(spi[0])][ Integer.parseInt(spi[1])]!=0) return false;
   
    
    return true;
  }
    
    private static void printAll(int[][] mat,int x,int y,int p1, int p2,String path) {
       
        if(p1==(x-1) && p2==(y-1)) {
            path = add(path, mat[p1][p2]);
            System.out.println(path);
            return;
        }
        
        if(p1==(x-1)) {
           for(int i=p2;i<y;i++) {
               path = add(path,mat[p1][i]);
           }
           System.out.println(path);
           return;
        }
        
        if(p2==(y-1)) {
            for(int i=p1;i<x;i++) {
                path =  add(path,mat[i][p2]);
            }
            System.out.println(path);
            return;
        }
        path = add(path, mat[p1][p2]);
        printAll(mat,x,y,p1+1, p2,path);
        printAll(mat,x,y,p1,p2+1,path);
        
    }
    
    private static String add(String path,int a) {
        return path = path + "->"+a;
    }
}
