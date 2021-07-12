import java.util.Scanner;
public class merge_sort_median{
int num1,num2;
int A[];
int B[];
int C[];
merge_sort_median(){// The constructor initializes the array with user inputs.
    Scanner sc = new Scanner(System.in);
    System.out.println("Specify the number of elements in the first array : ");
    num1 = sc.nextInt();
    A = new int[num1];
    System.out.println("Specify the number of elements in the second array : ");
    num2 = sc.nextInt();
    B = new int[num2];
    System.out.println("Enter the Elements in the first array : ");
    for(int i = 0; i <num1; i++){
        A[i] = sc.nextInt();
    }
    System.out.println("Enter the Elements in the second array : ");
    for(int i = 0; i <num2; i++){
        B[i] = sc.nextInt();
    }
    C = new int[num1+num2];
    sc.close();
}
    void merge(){// Merges the array with iterative approach
        for(int i = 0; i <num1; i++){
            C[i] = A[i];
        }
        for(int i = 0; i <num2;i++){
            C[i+num1] = B[i];
        }
    }
    void sort(){// Sorts the array using the bubble sorting Algorithm
        for(int i = 0; i < C.length -1; i++){
            for(int j = 0; j < C.length - i -1; j++){
                if (C[j] > C[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = C[j];
                    C[j] = C[j+1];
                    C[j+1] = temp;
                }
                
            }
        }
    }
    void show_median(){
        System.out.println("The merged Array is : ");
        for(int i = 0; i <(num1 + num2); i++){
            System.out.print(C[i] + "  ");
        }System.out.println("");
        if (C.length%2 == 0){System.out.print("The array has even number of elements so its median is : ");
        int k1 = C[(C.length/2)];
        int k2 = C[((C.length)/2 + 1)];
        double median = (double)(k1+k2/2);
        System.out.println(median);
    }
    else{
        System.out.println("The median is : "+((C.length/2) + 1 ));
    }
    }
    public static void main(String[] args) {
        merge_sort_median ob = new merge_sort_median();
        ob.merge();
        ob.sort();
        ob.show_median();
    }    
}