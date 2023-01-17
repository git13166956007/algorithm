package com.sherlock.leetcode;

/**
 * @author Sherlock
 * @date 2022/1/20 11:48
 * @describe
 */
public class FirstBadVersion_278 {

    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        while (low<=high){
            int mid = low + high>>1;
            if(isBadVersion(mid)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }

    private Boolean isBadVersion(int n){

        return true;
    }
}
