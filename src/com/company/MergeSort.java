package com.company;

public class MergeSort extends Sort {
    private Comparable[] aux;
    private MergeSort(){}
    private static MergeSort mergeSort = new MergeSort();
    public static MergeSort Instance(){return mergeSort;}
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        //sort(a,0,a.length-1);
        //sortPro(a,0,a.length-1);
        sortBu(a);
    }
    private void sort(Comparable[] a, int lo, int hi){
        if (hi<=lo)return;
        int mid = lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    private void sortBu(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for(int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }

    //当递归的子数组长度小于10时，对子数组进行插入排序。
    private void sortPro(Comparable[] a,int lo,int hi){
        if (hi - lo+1 <= 10 )
        {
            for (int i =lo+1; i<=hi;i++){
                for (int j = i;j>lo && less(a[j],a[j-1]);j--)
                    exch(a,j,j-1);
            }
            return;
        }
        int mid = lo+(hi-lo)/2;
        sortPro(a,lo,mid);
        sortPro(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    private void merge(Comparable[] a, int lo,int mid,int hi){
        int i = lo,j=mid+1;
        for (int k=lo;k<=hi;k++)
            aux[k] = a[k];
        for (int k=lo;k<=hi;k++)
            if (i>mid) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }
}
