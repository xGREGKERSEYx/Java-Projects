
public class FillerClass {

   
    public static void main(String[] args) {
        int[] nums;
        nums = new int[15];
        nums[0] = 555;
        nums[1] = 9011;
        nums[2] = 482;
        nums[3] = 1771;
        
     
        int N = nums.length;
        int positive_pointer = 0;
        
        while(positive_pointer < N && nums[positive_pointer] < 0){
            positive_pointer +=1;
        }
        int negative_pointer = positive_pointer - 1;
        
        int[] sorted_squares = new int[N];
        int counter = 0;
        
        while(negative_pointer >= 0 && positive_pointer < N){
            if(nums[negative_pointer] * nums[negative_pointer] < nums[positive_pointer] * nums[positive_pointer]){
                sorted_squares[counter] = nums[negative_pointer] * nums[negative_pointer];
                nums[negative_pointer] -=1;
            }else{
                sorted_squares[counter] = nums[positive_pointer] * nums[positive_pointer];
                nums[positive_pointer] +=1;
            }
            counter += 1;
        }
        while(negative_pointer >= 0){
            sorted_squares[counter] = nums[negative_pointer] * nums[negative_pointer];
            nums[negative_pointer] -=1;
            counter += 1;
        }
        while(positive_pointer >= 0){
            sorted_squares[counter] = nums[positive_pointer] * nums[positive_pointer];
            positive_pointer += 1;
            counter += 1;
    }
        System.out.print(sorted_squares.toString());
    }
}   
    