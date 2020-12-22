package ok.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPoint {

	static List<Integer> points = new ArrayList<Integer>();
	static int[][] copy;
	static int count =0;
	static  Random r = new Random();
    
    public static void solution(int[][] rects) {
    	copy = rects;
    	for(int i=0; i < rects.length;i++) {
    		int max  = (Math.abs((rects[i][2]-rects[i][0]))+1)*(Math.abs((rects[i][3]-rects[i][1]))+1);
    		count = count + max;
    		points.add(max);
    	}
    }
    
    public  static int[] pick() {
    	
    	int x = r.nextInt(count);
    	int i =0;
    	
    	while(x>0) {
    		x = x - points.get(i);
    		if(x<0) break;
    		i++;
    	}
    	
    	if(copy[i][2]-copy[i][0]>0)
    	{
    		x = r.nextInt(copy[i][2]-copy[i][0]) + copy[i][0];
    	}
    	else if(copy[i][2]-copy[i][0]==0)
    	{
    		x = 0;
    	}
    	else {
    		x = r.nextInt(Math.abs(copy[i][2]-copy[i][0])) + copy[i][0];
    	}
    	
    	int y;
    	
    	if(copy[i][3]-copy[i][1]>0)
    	{
    		y = r.nextInt(copy[i][3]-copy[i][1]) + copy[i][1];
    	}
    	else if(copy[i][3]-copy[i][1]==0)
    	{
    		y = 0;
    	}
    	else {
    		y = r.nextInt(Math.abs(copy[i][3]-copy[i][1])) + copy[i][1];
    	}
    	
    	int[] ret = {x,y};
    	
    	return ret;
    }
    
	public static void main(String[] args) {
		int[][] rects = {{82918473, -57180867, 82918476, -57180863}, {83793579, 18088559, 83793580, 18088560}, {66574245, 26243152, 66574246, 26243153}, {72983930, 11921716, 72983934, 11921720}};
		solution(rects);
		System.out.println(pick());
	}
}
