# 17.14 最小k个数

---
### 题目描述
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

---
### 题目思路

1. 同时维护k个最小值，每次找出最小值数组中的最大值进行对比决定是否替换即可，复杂度为O(mn),当k较大的时候时间会比较长
2. 直接排序，得到前k个值即可，O(nlogn)
3. 使用堆排序，小顶堆，每次选出最小值，选出k个值即可。


---
### 代码


	1.	class Solution {
	    public int[] smallestK(int[] arr, int k) {
	        int[] res = new int[k];
	        for(int i=0;i<k;i++){
	            res[i]=arr[i];
	        }
	        if(k==0){
	            return res;
	        }
	        for(int i=k;i<arr.length;i++){
	            int max=search_max(res);
	            if(res[max]>arr[i]){
	                res[max]=arr[i];
	            }
	        }
	        Arrays.sort(res);
	        return res; 
	    }

	    public int search_max(int[] min){
	        int max=0;
	        for(int i=1;i<min.length;i++){
	            if(min[max]<min[i]){
	                max=i;
	            }
	        }
	        return max;
	    }
	}



2.

		class Solution {
    		public int[] smallestK(int[] arr, int k) {
    	    	int[] res = new int[k];
    	    	Arrays.sort(arr);
    	    	for(int i=0;i<k;i++){
    	    	    res[i]=arr[i];
    	    	}
    	    	return res;
    		}
		}

3.
	