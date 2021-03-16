// answer for question 7a and 7b
// for question 7b, i have put the time complexity at question pseudo code in more detail!
public class csci203assn1
{
    //partition function : linear loop which size of array m
    public static int partition(int[]a, int sIndex, int eIndex){
        int pivot = a[eIndex];
        int i = sIndex - 1;
        for(int j = sIndex; j < eIndex; j++){
            if(a[j] <= pivot){
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[eIndex];
        a[eIndex] = a[i+1];
        a[i+1] = temp;
        return i+1;
    }
    //quickSort : recursive call with partition algorithm
    public static void quickSort(int [] a, int sIndex, int eIndex){
        if(sIndex < eIndex){
            int mIndex = partition(a, sIndex, eIndex);
            quickSort(a, sIndex, mIndex-1);
            quickSort(a, mIndex+1, eIndex);
        }
    }
    //binarySearch : cost lgm : recursive call
    public static void binarySearch(int [] m, int left, int right, int target){
        int r = (left+right)/2;
        if(target == m[r]){
            System.out.println(target);
        }      
        else if(r == 0)
           System.out.print("");
        else if(target < m[r]){
            binarySearch(m,left,r-1,target);
        }
        else{
            binarySearch(m,r+1,right,target);
        }
    }
    
   public static void main(String[] args) {
      int [] M = {21, 19, 24, 22, 20, 23, 18};
      int [] F = {17, 17, 22, 19};
      
      // size of m*lgn
      quickSort(M, 0, M.length-1);
            
      int left = 0;
      int right = M.length - 1;
      
      // size of f*lgn / 'f' times loop
      for(int i = 0; i < F.length; i++){ 
         binarySearch(M,left,right,F[i]); 
      }
   }
}
// therefore, this alogrithm runtime complexity is O(m+f(lgm))

