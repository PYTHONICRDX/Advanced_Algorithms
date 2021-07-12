import java.util.HashMap;
import java.util.Scanner;
public class maxsub {
    static String Findlongest(String str){
        int i;
        int n = str.length();
        int st = 0; // Stores the starting point of a substring
        int curlen = 0; // Stores the length of the current substring without repeating charecter
        int maxlen = 0; //Stores the maximum length of the substring
        int start = 0; //Stores the starting point of a substring
        HashMap<Character,Integer> pos = new HashMap<Character,Integer>();

        for(i = 1; i <n; i++){
            if(!pos.containsKey(str.charAt(i))){ 
        // If this character is not present in hash,
        // then this is first occurrence of this
        // character, store this in hash.
                pos.put(str.charAt(i),i);
            }
            else{
            // If this character is present
            // in hash then this character
            // has previous occurrence,
            // check if that occurrence
            // is before or after starting
            // point of current substring.  
            if (pos.get(str.charAt(i)) >= st){
                // find length of current
                // substring and update maxlen
                // and start accordingly.
                curlen = i - st;
                if(maxlen < curlen){
                    maxlen = curlen;
                    start = st;
                }
                // Next substring will start
                // after the last occurrence
                // of current character to avoid
                // its repetition.
                st = pos.get(str.charAt(i)) + 1;                 
            }
            //Update last occurence of the current charecter
            pos.replace(str.charAt(i),i);            
            }
        }
    // Compare length of last
    // substring with maxlen and
    // update maxlen and start
    // accordingly.
    if (maxlen < i - st)
    {
        maxlen = i - st;
        start = st;
    }
    //The required longest substring without repetition is from str[start] to str[maxlen + start - 1].      
    return str.substring(start,start + maxlen);    
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word : ");
        String str =  sc.nextLine();
        System.out.println(Findlongest(str));
        sc.close();
    }
    
}
