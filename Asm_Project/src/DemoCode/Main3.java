package DemoCode;
//Bubble sort
public class Main3 {
    public static void main(String[] args) {
        int [] arr = {4, 7, -9, 2, 6, 1};
        int n = arr.length;
        System.out.println("Array before sorting");
        for (int num: arr){
            System.out.print(num + "\t");
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i -1; j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("\nArray after sorting");
        for(int num: arr){
            System.out.print(num + "\t");
        }
    }
}
