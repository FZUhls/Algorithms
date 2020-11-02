package com.company;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Sort sort = MergeSort.Instance();
        Random random = new Random(System.currentTimeMillis());

        Integer [] integers = random.ints(100000,0,1000000).boxed().toArray(Integer[]::new);
        //System.out.println("排序前：");
        //sort.show(integers);
        System.out.println("是否排序: "+(sort.isSorted(integers)?"是":"否"));
        long start = System.currentTimeMillis();
        sort.sort(integers);
        long end =System.currentTimeMillis();
        //System.out.println("排序后：");
        //sort.show(integers);
        System.out.println("是否排序: "+(sort.isSorted(integers)?"是":"否")+ "  耗时： "+(end-start));
    }
}
