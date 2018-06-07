package emplyee;

import java.util.*;

import static emplyee.Main.EmployeesService.*;

public class Main {

    public static class EmployeesService{

        static  HashMap<Integer,Employee> employeesss = new HashMap<>();
        static Set<Integer> E = new TreeSet<>();

        public static int  Menu(){
            Scanner in = new Scanner(System.in);
            int option ;

            System.out.println("Emplyee App : ");
            System.out.println("=======================");
            System.out.println("1. Add new Employee ");
            System.out.println("2. Print all Employees ");
            System.out.println("3. Print given Employee ");
            System.out.println("4. max salary ");
            System.out.println("5 . Exsit");
            System.out.println("Enter Your Optin and press Enter:");
            return option =in.nextInt();
        }

        public static void AddNewEmployee(){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Your Employee option 1-for Manafger ,2- for reg and press Enter:");
            int type= in.nextInt();
            System.out.println("Enter Employee ID and press Enter:");
            int ID = in.nextInt();

            if (type==2){
                Employee temp = new Employee();
                temp.setID(ID);
                employeesss.put(ID,temp);
                employeesss.get(ID).input();
                E.add(temp.getSalary());

            }else {
                Maneger temp = new Maneger();
                employeesss.put(ID,temp);
                employeesss.get(ID).input();
                System.out.println("If you want to add employees under maneger  prees 1 and then Enter");
                int isEmployyes = in.nextInt();
                if( isEmployyes ==1 ){

                    System.out.println("Enter number of employess you want to add and then Enter ");
                    int numberOfEmployeesToAdd=in.nextInt();

                    for (int i = numberOfEmployeesToAdd; i >0 ; i--) {
                        System.out.println("Enter id for employee number"+i+":");
                        int  employeeID = in.nextInt();
                        Employee newEmployeUnderManeger = new Employee();
                        newEmployeUnderManeger.setID(employeeID);
                        newEmployeUnderManeger.input();
                        temp.getEmployees().add(employeeID);
                        employeesss.put(employeeID,newEmployeUnderManeger);
                        E.add(newEmployeUnderManeger.getSalary());
                    }
                }
                E.add(temp.getSalary());
            }
        }

        //O(number of Employees) operation
        public static void PrintAllEmployees() {
            // Iterating over keys only
            for (Integer key : employeesss.keySet()) {
                System.out.println("================");
                Employee em = employeesss.get(key);
                em.print();

                }
            }
        }

        //O(1) operation
        public static void PrintGivenEmployee(){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter ID and press Enter : ");
            int ID = in.nextInt();
            Employee temp =  employeesss.get(ID);
            if(temp.isManager()){
                temp.print();
                for (int i = 0; i < ((Maneger)temp).getEmployees().size(); i++) {
                   int id=  ((Maneger)temp).getEmployees().get(i);
                   employeesss.get(id).print();
                }
            }
            else {
                temp.print();
            }
        }


        //O(K)
        public static void MaxBigestSalary() {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter number of biggest hight Employes you want ? :");
            int k= in.nextInt();
            Iterator<Integer> it = E.iterator();
            while(it.hasNext() ){
                System.out.println(it.next());
                k--;
            }

        }



        public static void main(String[] args) {

            String sentence = "hi,how are,you";
            String [] splitArr = split(sentence, ',');
            for (int i = 0; i < splitArr.length ; i++) {
                System.out.println(splitArr[i]);
            }
        //    System.out.println(removeSpacesAndComma("hi   ,how            are,you",' ',','));

//            int operation = Menu();
//
//            while(operation!= 5){
//
//                switch (operation){
//                    case 1 : AddNewEmployee() ;
//                        break;
//                    case 2: PrintAllEmployees();
//                        break;
//                    case 3 : PrintGivenEmployee();
//                        break;
//                    case 4 : MaxBigestSalary();
//                        break;
//                    default: System.out.println("Thanks ' have a Great day");
//                }
//                operation= Menu();
//            }




        }

    public static String[] split(String sentence , char c) {
        int length = 0 ;

        for (int i = 0; i <sentence.length() ; i++) {
            if (sentence.charAt(i ) == ' ' ||sentence.charAt(i ) ==',' ){
                length++;
            }
        }
        length++;
        String [] ans = new String[length];
        int indexArry = 0;
        int indexAns = 0;

        while (indexArry < sentence.length()) {
            String temp = "";

            while ((indexArry < sentence.length() ) && (sentence.charAt(indexArry) != c ) &&  (sentence.charAt(indexArry)!=' ' )  ) {
                temp+=sentence.charAt(indexArry++);
            }
            ans[indexAns++]=temp;
            indexArry++;
        }
        return ans;
    }



    public static String removeSpacesAndComma(String str , char c , char z) {
        char[] charArray = str.toCharArray();

        int numSpaces = 0; // number of spaces before 'i'th character
        for (int i = 0; i < charArray.length; i++) {
            // count number of spaces
            if (charArray[i] == c ||charArray[i] == z ) {
                numSpaces++;
            }
            // put 'i'th character into its correct position after removing spaces before it
            else {
                charArray[i-numSpaces] = charArray[i];
            }
        }

        // all the spaces are moved towards the end of the string.
        // Create new string by using non-space characters
        charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);

        return new String(charArray);
    }


    // Prints diamond pattern with 2n rows
    static void printDiamond(int n) {
        int space = n - 1;

        // run loop (parent loop) till number
        // of rows
        for (int i = 0; i < n; i++)
        {
            // loop for initially space, before
            // star printing
            for (int j = 0; j < space; j++)
                System.out.print(" ");

            // Print i+1 stars
            for (int j = 0; j <= i; j++)
                System.out.print("* ");

            System.out.print("\n");
            space--;
        }

        // Repeat again in reverse order
        space = 0;

        // run loop (parent loop) till number
        // of rows
        for (int i = n; i > 0; i--)
        {
            // loop for initially space, before
            // star printing
            for (int j = 0; j < space; j++)
                System.out.print(" ");

            // Print i stars
            for (int j = 0; j < i; j++)
                System.out.print("* ");

            System.out.print("\n");
            space++;
        }
    }

    static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void printSubsets(char set[]) {
        double n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (Math.pow(2,n)); i++)
        {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    // Returns n'th term in look-and-say sequence
    static String countnndSay(int n) {
        // Base cases
        if (n == 1)      return "1";
        if (n == 2)      return "11";

        // Find n'th term by generating all terms from 3 to
        // n-1.  Every term is generated using previous term
        String str = "11"; // Initialize previous term
        for (int i = 3; i<=n; i++)
        {
            // In below for loop, previous character
            // is processed in current iteration. That
            // is why a dummy character is added to make
            // sure that loop runs one extra iteration.
            str += '$';
            int len = str.length();

            int cnt = 1; // Initialize count of matching chars
            String  tmp="" ; // Initialize i'th term in series

            // Process previous term to find the next term
            for (int j = 1; j < len; j++)
            {
                // If current character does't match
                if (str.charAt(j) != str.charAt(j-1))
                {
                    // Append count of str[j-1] to temp
                    tmp += cnt + '0';

                    // Append str[j-1]
                    tmp += str.charAt(j-1);

                    // Reset count
                    cnt = 1;
                }

                //  If matches, then increment count of matching
                // characters
                else cnt++;
            }

            // Update str
            str = tmp;
        }

        return str;
    }

    static int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;  // Initialize count
        Hashtable<Integer,Boolean> hashtable = new Hashtable<Integer, Boolean>();
        // Initialize empty hashmap.


        // Insert array elements to hashmap
        for (int i = 0; i < n; i++){
            hashtable.put(arr[i],true) ;
        }


        for (int i = 0; i < n; i++)
        {
            int x = arr[i];
            if (x - k >= 0 && hashtable.containsKey(x-k)) {
                count++;
            }
            if (hashtable.containsKey(x+k)) {
                count++;
            }
            hashtable.put(x,false);
        }
        return count;
    }

    public static int missingNumberFromSortedArray(int[] numbers){
        int ans =0;
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right){
            int middle = (right + left) / 2 ;

            if ( (numbers[middle] - numbers[middle - 1] ) == 2 ){
                return middle+1;
            }
            else if (numbers[middle] > middle+1){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return -1;
    }

    static boolean check3zero(int[] inputArr){
        Hashtable<Integer,Boolean> sumPairs = new Hashtable<>();
        boolean ans =false ;

        for (int i = 0; i <inputArr.length ; i++) {
            for (int j = 0; j < inputArr.length; j++) {
                int pair = -(inputArr[i]+inputArr[j]);

                if(sumPairs.containsKey(pair)){
                    return true;
                }
                else {
                    sumPairs.put(inputArr[j],true);
                }
            }
        }
        return ans;
    }

    static int getPairsCount(int [] arr,int n, int sum) {
        HashSet<Integer> checkSum =new HashSet<>() ;

        int numberOfFound= 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i=0; i<n; i++)
        {
            if ( !checkSum.contains(arr[i]) ) {
                checkSum.add(arr[i]);

            }
            if (checkSum.contains(sum - arr[i]))
                numberOfFound++;

        }

        return numberOfFound;
    }

    public static String addSpaces(String str , int numberOfSpaceToAdd){

        char[] charArray = new char [str.length()+numberOfSpaceToAdd];
        int newPlace = str.length()+numberOfSpaceToAdd -1;

        for (int i = str.length()-1; i >=0 ; i--)
        {
            charArray[newPlace]=str.charAt(i);
            newPlace--;
            charArray[newPlace] =' ';
            newPlace--;

        }

        return new String(charArray);
    }

    public static boolean solution(int[] nums, int target) {
        if(nums.length == 0) {
            return target == 0;
        }
        int start = 0;
        int end = 0;
        int sum = nums[0];
        if (sum == target) {
            return true;
        }
        while(end < nums.length) {
            if(sum > target) {
                sum -= nums[start++];
            } else {
                end++;
                if(end < nums.length) {
                    sum += nums[++end];
                }
            }
            if (sum == target) {
                return true;
            }
        }
        return false;
    }

    public static void relocate(int  [] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i] += (arr[arr[i]]%arr.length)*arr.length;
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] /= arr.length;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
        }
    }

    public int maxDiff(int arr[], int arr_size) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for(i = 1; i < arr_size; i++)
        {
            if(arr[i] - min_element > max_diff)
                max_diff = arr[i] - min_element;
            if(arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    static void permutate(String[] words, int depth, String permutation){
        if (depth == words.length){
            System.out.println(permutation);
        }
        else {
            String w = words[depth];
            for (int i = 0; i < w.length(); i++){
                permutate(words, depth + 1, permutation + w.charAt(i));
            }
        }
    }

    public static class Node{
        public Node left;
        public Node right;
        public String val;
        Node [] Neighbours;

        public Node(Node left, Node right, String val, Node[] neighbours) {
            this.left = left;
            this.right = right;
            this.val = val;
            Neighbours = neighbours;
        }

        public Node() {
        }

        public Node getLeft() {
            return left;
        }

        public Node[] getNeighbours() {
            return Neighbours;
        }

        public Node getRight() {
            return right;
        }
    }

    public void bfsUsingQueue(Node root) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(root);
        q.add(null);  //null serves as a depth marker

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr != null) {
                System.out.print(curr.val+" ");
                if (curr.left != null)      q.add(curr.left);
                if (curr.right != null)     q.add(curr.right);
            }
            else {
                System.out.println();     // print new line
                if (q.isEmpty())  break;
                q.add(null);
            }
        }
    }

    public  void dfsUsingStack(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        HashSet<Node> visited = new HashSet<>();

        while (!stack.isEmpty())
        {
            Node element=stack.pop();
            System.out.print(element.val+ " ");

            Node[] neighbours=element.getNeighbours();
            for (int i = 0; i < neighbours.length; i++) {
                Node n = neighbours[i];
                if(n!=null && !visited.contains(n) )
                {
                    stack.add(n);
                    visited.add(n);
                    
                }
            }
        }
    }

    static void reverseSentence(char [] sentence ) {
        // Reverse each word in the sentence
        for (int i = 0; i < sentence.length; ++i)
        {
            int j = i ;
            // Find the end of the current word
            while (j < sentence.length-1 && sentence[j] != ' ')
            {
                ++j;
               // System.out.println(sentence[j]);
            }
            reverseWord(sentence,i , j );
            i = j;
        }
        // Reverse the entire sentence
        reverseWord(sentence,0, sentence.length);
    }

    static void reverseWord(char[]  sentence ,int start, int end){
        for (int i = start, j = end; start < end; ++start, --end)
        {
            swap(sentence[start], sentence[end]);
        }
    }

    static void swap(int a, int b){
        int c =b;
        b=a;
        a=c;
        return;
    }
}
