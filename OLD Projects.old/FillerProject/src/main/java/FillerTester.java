
public class FillerTester {

   
    public static void main(String[] args) {
        int[] nums;
        nums = new int[4];
        nums[0] = 010;
        nums[1] = 1111;
        nums[2] = 185945;
        nums[3] = 985489;
        
        int consecutive = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                consecutive++;
            }
            
        }
         System.out.print(consecutive);
    }
    
}   
    