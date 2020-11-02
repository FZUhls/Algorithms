package com.company;

public class InsertionSort extends Sort {
    private static InsertionSort insertionSort = new InsertionSort();
    private InsertionSort(){}
    public static InsertionSort Instance(){
        return insertionSort;
    }
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 1;i<N;i++){
            for(int j = i;j>0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }
    }
}
