package com.sherlock.leetcode;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author Sherlock
 * @date 2021/12/21 15:21
 * @describe
 */
public class LongestPalindrome {

    public static void main(String[] args) {
//        String str = "abccccdd";
//        char[] chars = str.toCharArray();
//        int length = chars.length;
//        Set<Character> set  = new HashSet<>();
//        int counter = 0;
//        for (int i = 0; i < length; i++) {
//            char c = str.charAt(i);
//            if (set.contains(c)){
//                counter ++ ;
//                set.remove(c);
//            }else {
//                set.add(c);
//            }
//        }
//        if (set.size()>1){
//            counter = counter+1;
//        }
//
//        System.out.println(counter);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        try{
            System.out.println("主线程开始-----------------");
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                    Runtime.getRuntime().availableProcessors(),
                    0L,
                    TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));
            for (int i = 0; i <20; i++) {
                threadPoolExecutor.execute(()-> {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                });
            }
            countDownLatch.await();
            System.out.println("主线程执行················");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
