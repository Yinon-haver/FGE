package emplyee;

import java.util.Arrays;

public class RegexParser {
    public static void main(String[] args) {


        System.out.println(IsMatch("b","*b+++++d"));
    }

    private static void assertT(String pattern, String input, boolean isTrue) {
        String format = "isMatch(%s,%s) -> %s";
        String isT = isTrue ? "true" : "false";
        String assersionStatment = String.format(format, input, pattern, isT);
        boolean result = IsMatch(input, pattern);
      // assertThat(assersionStatment, result == isTrue);
    }
    /**
     * @param input - a string input containing characters from a to z
     * @param regex - a regex containing a to z, +s and *s
     * @return true if the input matches the regex, false otherwise
     */
    public static boolean IsMatch(String input, String regex ) {
        boolean [][] DPtable = new boolean[input.length()+1][regex.length()+1];

        for (int i = 0; i <input.length()+1 ; i++) {
            Arrays.fill(DPtable[i],false);
        }

        DPtable[0][0] =true;
        //only * can match with empty string
        for (int j = 1; j <=regex.length() ; j++) {
            if (regex.charAt(j-1)=='*' || regex.charAt(j-1) =='+' ){
                DPtable[0][j] = DPtable[0][j-1];
            }
        }

        for (int i = 1; i <= input.length() ; i++) {
            for (int j = 1; j <= regex.length() ; j++) {
                if(regex.charAt(j-1)=='*'){
                    DPtable[i][j]= DPtable[i][j-1] || DPtable[i-1][j];
                }
                else if ( input.charAt(i-1) == regex.charAt(j-1)){
                    DPtable[i][j]= DPtable[i-1][j-1];
                }
                else if (regex.charAt(j-1)=='+' ){
                    DPtable[i][j]= DPtable[i-1][j-1] ||  DPtable[i][j-1];
                }
                else {
                    //char don't match
                    DPtable[i][j]= false;
                }
            }
        }
        return DPtable[input.length()][regex.length()];
    }

}
