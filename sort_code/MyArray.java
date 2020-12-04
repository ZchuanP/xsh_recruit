public class MyArray {
    // java中的数组可以赋值排序，但是不能更改数组的引用
    private  final int[] array_sort;

    MyArray(int[] array_sort1){
        this.array_sort=array_sort1;
    }

    // 冒泡排序
    public void Bubble_sort(){
        boolean flag = false;
        for(int i=0; i<this.array_sort.length;i++) {
            for (int j = 0; j < array_sort.length - i - 1; j++) {
                if (array_sort[j] > array_sort[j + 1]) {
                    int t = array_sort[j];
                    array_sort[j] = array_sort[j + 1];
                    array_sort[j + 1] = t;
                    flag = true;
                }
            }
            if(!flag) return;
        }
    }

    // 选择排序
    public void Select_sort(){
        for(int i=0;i<array_sort.length;i++){
            int max_index = 0;
            for (int j=1 ; j<array_sort.length-i; j++){
                if(array_sort[j] > array_sort[max_index]) max_index=j;
            }
            int max= array_sort[max_index];
            array_sort[max_index]=array_sort[array_sort.length-i-1];
            array_sort[array_sort.length-1-i] = max;

        }
    }

    // 插入排序
    public void Insert_sort(){
        for (int i =0; i<array_sort.length-1; i++) {
            for (int j=i+1;j>0;j--){
                if(array_sort[j]<array_sort[j-1]){
                    int t= array_sort[j];
                    array_sort[j]=array_sort[j-1];
                    array_sort[j-1]=t;
                }
            }
        }
    }

    // 希尔排序
    public void Hill_sort(){
        // 设定初始步长约为数组长度的1/3
        int stride=array_sort.length/3+1 ;
        // 当步长未缩短为1时，进行希尔排序
        while(stride > 0){
            // 抽象为每一个循环为一个划分好的希尔序列
            for(int i = stride; i<array_sort.length;i++){
                int temp = array_sort[i];
                int j = i- stride;
                // 每一序列进行插入排序
                while(j>=0 && array_sort[j]>temp){
                    array_sort[j+stride]=array_sort[j];
                    j-=stride;
                }
                array_sort[j+stride]= temp;
            }
            //缩短步长，再次希尔
            stride = stride/2;

        }
    }


    // 快速排序
    public void Quick_sort(int left, int right){
        if(left>right){
            return;
        }
        int mid = Divide_array(left,right);
        Quick_sort(left,mid-1);
        Quick_sort(mid+1,right);
    }

    public int Divide_array(int low, int high){
        // 每次都以左边第一个作为基准值
        int standard = array_sort[low];

        while(low<high) {
            // 从右边开始选出第一个比基准值小的
            while (low < high && array_sort[high] > standard) {
                high--;
            }
            array_sort[low++] = array_sort[high];

            while (low < high && array_sort[low] < standard) {
                low++;
            }
            array_sort[high--] = array_sort[low];
        }

        array_sort[low]=standard;
        return low;
    }



    // 归并排序
    public void me_sort(int left, int right,int[] result){
        if(left<right){
            int mid = (left+right)/2;
            me_sort(left,mid,result);           // 排左边
            me_sort(mid+1,right,result);   // 排右边
            merge1(left,mid,right,result);     // 归并
        }
    }


    public void merge1(int left,int mid,int right, int[] result) {
        // 归并时左右序列都是有序的（从只有两个元素开始归并，产生的是有序序列）
        int i = left;   // 左序列的指针(left-->mid)
        int j = mid+1;  // 右序列的指针(mid+1-->right)
        int k = 0;      // 辅助序列的指针
        // 每次在左右序列中找到较小值填到辅助序列
        while (i<=mid && j<=right){
            if(array_sort[i]<array_sort[j]){
                result[k++]=array_sort[i++];
            }
            else {
                result[k++] = array_sort[j++];
            }
        }
        // 退出时左右序列必定只有一个遍历结束，未遍历到的一定是较大的，直接填到辅助数组后面即可。
        if(i==mid+1){
            while(j<=right)
                result[k++]=array_sort[j++];
        }
        if(j==right+1){
            while(i<=mid)
                result[k++]=array_sort[i++];
        }
        k=0;
        // 每一次归并后将归并的结果覆盖到原数组
        while(left<right)
            array_sort[left++]=result[k++];
    }




    // 堆排序
    public void Heap_sort(){
        int end_index= array_sort.length-1;
        while(end_index>0){
            // 构造大顶堆
            creat_big_top(end_index);
            // 交换堆顶元素（最大值）和最后一个元素
            swap_index(0,end_index);
            // 已排好序列生长，end_index--
            end_index--;
        }
    }

    public void creat_big_top(int end){
        for(int i=0;i<=end;i++){
            int j = i;
            // 当子节点大于父节点时交换
            while(j>0 && array_sort[(j-1)/2]<array_sort[j]){
                swap_index(j,(j-1)/2);
                j=(j-1)/2;
            }
        }
    }

    public void swap_index(int i,int j ){
        int t= array_sort[i];
        array_sort[i]=array_sort[j];
        array_sort[j]=t;
    }


    // 基数排序
    public void base_sort(){

    }

    public void print_array(){
        for (int j : this.array_sort) {
            System.out.print(j+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] list = new int[10000];
        for(int i=0;i<10000;i++){
            list[i]=(int)(Math.random()*10000);
        }
//        int[] list = {56,3,2,6,5};
        MyArray sort = new MyArray(list);
        sort.print_array();
//        sort.Bubble_sort();
//        sort.Select_sort();
//        sort.Insert_sort();
//        sort.Hill_sort();
//        sort.quick_sort(0,list.length-1);
//        sort.Quick_sort(0,list.length-1);


//        int[] result= new int[10000];
//        sort.me_sort(0,list.length-1,result);
        sort.Heap_sort();

        sort.print_array();


    }


}

