package ok.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SannerAndMatrixPaths {

  public StringTokenizer tokenizer;
  
  public static List<String> paths = new ArrayList<String>();
  
  public static getStr(String a, String b) {
      
  }

  public static void main(String[] args) {
    int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
    String a = "";
    a.n
    int[][] B = {{1,2},{3,4}};
    int[] intpath = new int[3*3];
    int[][] intpaths = new int[10000][3*3];
   // path(A,3-1,3-1,0,0,"");
    path(A,3-1,3-1,0,0,intpath,0,intpaths,0);
    System.out.println(A);
    
  }

  public static void main2(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    Scanner input = new Scanner(System.in).useDelimiter("\n");
    int problems = -1;
    List<String> out = new ArrayList<String>();
 
    while (input.hasNextLine()) {
      if (problems == -1) {
        try {
          problems = Integer.parseInt(input.next().trim());
        } catch (Exception e) {
          out.add("FAILURE => WRONG INPUT (LINE " + 1 + ")");
          break;
        }
      } else if (out.size() == problems) {
        input.close();
        break;
      } else {
        String in = input.next();
        String[] split = in.split(" ");
        int[] num = new int[split.length];
        List<Integer> nums = new ArrayList<Integer>();
        boolean breakout = false;
        for (int i = 0; i < split.length; i++) {
          try {
            if(split[i].trim().length()==0) {
              continue;
            }
           
           
            
            nums.add(Integer.parseInt(split[i].trim()));
          } catch (Exception e) {
            out.add("FAILURE => WRONG INPUT (LINE " + (out.size() + 2) + ")");
            breakout = true;
            break;
          }

        }

        if (breakout) {
          continue;
        }

        out.add(validate2(nums.toArray(new Integer[0]),out.size() + 2));
      }


    }

    out.forEach(s -> System.out.println(s));

  }
  public static String validate2(Integer[] num, int line) {
    int max = -1;
    Map<Integer, Integer> mapAll = new HashMap<Integer, Integer>();

    for (int i = 0; i < num.length; i++) {
      if (mapAll.get(num[i]) != null) {
        mapAll.put(num[i], mapAll.get(num[i]) + 1);
      } else {
        mapAll.put(num[i], 1);
      }
      
      if (num[i] < 1) {
        return "FAILURE => WRONG INPUT (LINE " + line + ")";
      }

      if (num[i] > max)
        max = num[i];
    }

    if (max == -1) {
      return "FAILURE => WRONG INPUT (LINE " + line + ")";
    }

    for (int i = 1; i <= max; i++) {
      if (mapAll.get(i) == null || mapAll.get(i) != 1) {
        return "FAILURE => RECEIVED: " + num.length + ", EXPECTED: " + max;
      }
    }


    return "SUCCESS => RECEIVED: " + max;


  }
  private static String validate(int[] num,int line) {
    int max = -1;
    int sum = 0;
  
    for (int i = 0; i < num.length; i++) {
      sum = sum + num[i];
      if (num[i] > max)
        max = num[i];
    }
    
    int sumActual = (max * (max + 1)) / 2;

    if (sumActual == sum) {
      return "SUCCESS => RECEIVED: " + max;
    } else {
      return "FAILURE => RECEIVED: " + num.length + ", EXPECTED: " + max;
    }

  }

  private static  int[][] transpose(int[][] A) {
   
    int[][] R = new int[A[0].length][A.length];
    for(int i=0;i<A.length;i++) {
      for(int j=0;j<A[0].length;j++) {
        R[j][i] = A[i][j];
      }
    }
    return R;
  }

  private static void setZeroes(int[][] matrix) {
    Boolean isR = false;
    
    for(int i=0;i<matrix.length;i++) {
      if(matrix[i][0]==0) {
        isR = true;
      }
      for(int j=1;j<matrix[0].length;j++) {
       if(matrix[i][j]==0) {
         matrix[0][j]=0;
             matrix[i][0]=0;   
       }
      }
    }
    for(int i=1;i<matrix.length;i++) {
      if(matrix[i][0]==0) {
        for(int j=1;j<matrix[0].length;j++) {
          matrix[i][j]=0;
        }
      }
    }
    
    for(int j=1;j<matrix[0].length;j++) {
      if(matrix[0][j]==0) {
        for(int i=1;i<matrix.length;i++) {
          matrix[i][j]=0;
        }
      }
    }
    
    if(isR) {
      for(int i=1;i<matrix.length;i++) {
        matrix[i][0]=0;
      }
    }
    
    if(matrix[0][0]==0) {
      for(int i=1;i<matrix.length;i++) {
        matrix[0][i]=0;
      }
    }
    
  }
 
  private static int shortestPathBinaryMatrix(int[][] grid) {
    int count = -1;
    
    return count;
  }
  
private static void path(int[][] grid, int r , int c, int p1, int p2, String path ) {
    
    if(p1==r && p2==c) {
      path = path + "-"+(grid[p1][p2]);
      paths.add(path);
      return;
    }   
    
    Boolean Frow = false;
    Boolean Fcol = false;
    Boolean Lrow = false;
    Boolean Lcol = false;
    
    if(p1==0) {
      Frow = true;
    }
   
    if(p2==0) {
      Fcol = true;
    }
    
    if(p1==r) {
      Lrow = true;
    }
    
    if(p2==c) {
      Lcol = true;
    }
      
    path = path + "-"+(grid[p1][p2]);
    
    if(!Lrow && !Lcol && !path.contains(grid[p1+1][p2+1]+""))
    path(grid,r,c,p1+1,p2+1,path);
    
    if(!Lcol && !path.contains(grid[p1][p2+1]+"") )
    path(grid,r,c,p1,p2+1,path);
    
    if(!Lrow && !path.contains(grid[p1+1][p2]+""))
    path(grid,r,c,p1+1,p2,path);
    
    if(!Frow && !Fcol && !path.contains(grid[p1-1][p2-1]+""))
    path(grid,r,c,p1-1,p2-1,path);
    
    if(!Fcol && !path.contains(grid[p1][p2-1]+""))
    path(grid,r,c,p1,p2-1,path);
    
    if(!Frow && !path.contains(grid[p1-1][p2]+""))
    path(grid,r,c,p1-1,p2,path);
    
    if(!Fcol && !Lrow && !path.contains(grid[p1+1][p2-1]+""))
    path(grid,r,c,p1+1,p2-1,path);
    
    if(!Frow && !Lcol && !path.contains(grid[p1-1][p2+1]+""))
    path(grid,r,c,p1-1,p2+1,path);
      
    }
  
  
  
  private static void path(int[][] grid, int r , int c, int p1, int p2, int[] path,int length,int[][] intpaths, int countPaths  ) {
    
    if(p1==r && p2==c) {
      path[length] = (grid[p1][p2]);
      intpaths[countPaths] = path;
      length++;
      countPaths++;
      return;
    }   
    
    Boolean Frow = false;
    Boolean Fcol = false;
    Boolean Lrow = false;
    Boolean Lcol = false;
    
    if(p1==0) {
      Frow = true;
    }
   
    if(p2==0) {
      Fcol = true;
    }
    
    if(p1==r) {
      Lrow = true;
    }
    
    if(p2==c) {
      Lcol = true;
    }
      
    path[length] = (grid[p1][p2]);
    length++;
    
    if(!Lrow && !Lcol && !check(path,grid[p1+1][p2+1]))
    path(grid,r,c,p1+1,p2+1,path,length,intpaths,countPaths);
    
    if(!Lcol && !check(path,grid[p1][p2+1]) )
    path(grid,r,c,p1,p2+1,path,length,intpaths,countPaths);
    
    if(!Lrow && !check(path,(grid[p1+1][p2])) )
    path(grid,r,c,p1+1,p2,path,length,intpaths,countPaths);
    
    if(!Frow && !Fcol && !check(path,grid[p1-1][p2-1]))
    path(grid,r,c,p1-1,p2-1,path,length,intpaths,countPaths);
    
    if(!Fcol && !check(path,(grid[p1][p2-1])) )
    path(grid,r,c,p1,p2-1,path,length,intpaths,countPaths);
    
    if(!Frow && !check(path,(grid[p1-1][p2])) )
    path(grid,r,c,p1-1,p2,path,length,intpaths,countPaths);
    
    if(!Fcol && !Lrow && !check(path,grid[p1+1][p2-1]) )
    path(grid,r,c,p1+1,p2-1,path,length,intpaths,countPaths);
    
    if(!Frow && !Lcol && !check(path,(grid[p1-1][p2+1])) )
    path(grid,r,c,p1-1,p2+1,path,length,intpaths,countPaths);
      
    }
  
  private static Boolean check(int[] ary , int v) {
    for(int i=0;i<ary.length;i++) {
      if(ary[i]==v) {
        return true;
      }
    }
    return false;
  }
    
  
}
