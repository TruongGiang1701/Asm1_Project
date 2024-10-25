package DemoCode;
//Insertion sort
public class Main4 {
    public static void main(String[] args) {
        int [] arr = {29, 12, 45, 7, 33};
        int n = arr.length;
        System.out.println("Array after sorting");
        for(int num: arr){
            System.out.print(num + " ");
        }
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("\nArray after sorting");
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
