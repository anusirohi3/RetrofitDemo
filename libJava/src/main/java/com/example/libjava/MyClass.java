package com.example.libjava;

public class MyClass {
    {
        System.out.println("instance block of myclass");
    }

    void anotherMethod() {
        System.out.println("m in anthr mthd");
    }

    static {
        System.out.println("static block of myclass");
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println(1 + ".....m in main");

        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);

         MyClass a = new MyClass();
         a.anotherMethod();
    }

    public class A {
        {
            System.out.println("instance block of ");
        }
    }
}
