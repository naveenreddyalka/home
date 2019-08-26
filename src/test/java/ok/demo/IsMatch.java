package ok.demo;

public class IsMatch {

    public static void main(String[] args) {
  
         System.out.println(check("aa", "a") == false);
         System.out.println(check("adceb", "*a*b")==true);
         System.out.println(check("cb", "?a")==false);
         System.out.println(check("aa", "*")==true);
         System.out.println(check("acdcb", "a*c?b")==false);
         System.out.println(check("abefcdgiescdfimde","ab*cd?i*de") ==true);
         System.out.println(check("mississippi","m??*ss*?i*pi")==false);
         System.out.println(check("aaaa","***a")==true);
         System.out.println(check("hi","*?")==true);
         System.out.println(check("cabddab","*ab")==true);
         System.out.println(check("ac","ab")==false);
         System.out.println(check("mississippi","m*issip*")==true);
         
    }

    public static boolean check(String s, String p) {
        int i = 0;
        int j = 0;
        int lastSkip = 0;
        boolean skiped = false;
        boolean skip = false;
        
        if(s==null || p==null) return false;
        
        if(s.equals(p)) return true;
        
        if(p.length()>0 && s.length()>0 && p.charAt(j) != '*' && p.charAt(j) != '?' && p.charAt(j) != s.charAt(i)) {
            return false;
        }

        while (j < p.length()) {
            if (p.charAt(j) == '*') {
                j++;
                lastSkip=j-1;
                skip = true;
                skiped = true;
                continue;
            }

            if (p.charAt(j) == '?') {
                j++;
                i++;
                skip = false;
                continue;
            }
            
            if(i >= s.length()) break;
            
            if (p.charAt(j) == s.charAt(i)) {
                j++;
                i++;
                skip=false;
            } else {
                if (skip) {
                    i++;
                } else if(skiped){
                    j=lastSkip;
                }else {
                    return false;
                }
            }
        }

        if (i == s.length() && j == p.length())
            return true;
        else {
            if(i < s.length()) {
                if(skip) {
                    while(j<p.length()) {
                       if(p.charAt(j)=='*') j++;
                       else return false;
                    }
                    return j == p.length();
                }else {
                    
                    if (skiped && j == p.length()) {
                        if (p.charAt(j-1) == '?' || p.charAt(j-1) == '*') {
                                return true;
                        }else {
                            return check(s.substring(i),p.substring(lastSkip));
                        }
                    }
                }
            }
            
        }

        return false;
    }
}
