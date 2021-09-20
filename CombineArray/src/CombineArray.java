import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        do {
            System.out.print("nhap so phan tu cua mang 1: ");
            n1 = sc.nextInt();
        } while (n1 <= 0);
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            System.out.print("phan tu arr1["+i+"]: ");
            arr1[i] = sc.nextInt();
        }
        System.out.println("mang 1 la: ");
        for (int i = 0; i < n1; i++) {
            System.out.print(arr1[i] + "\t");
        }

        do {
            System.out.print("\nnhap so phan tu cua mang 2: ");
            n2 = sc.nextInt();
        } while (n2 <= 0);
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            System.out.print("phan tu arr2["+i+"]: ");
            arr2[i] = sc.nextInt();
        }
        System.out.println("mang 2 la: ");
        for (int i = 0; i < n2; i++) {
            System.out.print(arr2[i] + "\t");
        }
        System.out.println("\nmang sau khi gop: ");
        int[] arr3 = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            arr3[i] = arr1[i];
            System.out.print(arr3[i] + "\t");
        }
        for (int i = n1; i < n2+n1; i++) {
            arr3[i] = arr2[i-n1];
            System.out.print(arr3[i] + "\t");
        }
    }
}
