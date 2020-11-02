package com.company;

public class ShellSort extends Sort {
    private static ShellSort shellSort = new ShellSort();
    private ShellSort(){}
    public static ShellSort Instance(){return shellSort;}

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h<N/3) h = 3*h+1;
        while (h>=1){
            for (int i = h;i<N;i++){
                for (int j = i;j>=h && less(a[j],a[j-h]);j-=h)
                    exch(a,j,j-h);
            }
            h = h/3;
        }
    }
}
