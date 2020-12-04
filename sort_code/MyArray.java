public class MyArray {
    // java�е�������Ը�ֵ���򣬵��ǲ��ܸ������������
    private  final int[] array_sort;

    MyArray(int[] array_sort1){
        this.array_sort=array_sort1;
    }

    // ð������
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

    // ѡ������
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

    // ��������
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

    // ϣ������
    public void Hill_sort(){
        // �趨��ʼ����ԼΪ���鳤�ȵ�1/3
        int stride=array_sort.length/3+1 ;
        // ������δ����Ϊ1ʱ������ϣ������
        while(stride > 0){
            // ����Ϊÿһ��ѭ��Ϊһ�����ֺõ�ϣ������
            for(int i = stride; i<array_sort.length;i++){
                int temp = array_sort[i];
                int j = i- stride;
                // ÿһ���н��в�������
                while(j>=0 && array_sort[j]>temp){
                    array_sort[j+stride]=array_sort[j];
                    j-=stride;
                }
                array_sort[j+stride]= temp;
            }
            //���̲������ٴ�ϣ��
            stride = stride/2;

        }
    }


    // ��������
    public void Quick_sort(int left, int right){
        if(left>right){
            return;
        }
        int mid = Divide_array(left,right);
        Quick_sort(left,mid-1);
        Quick_sort(mid+1,right);
    }

    public int Divide_array(int low, int high){
        // ÿ�ζ�����ߵ�һ����Ϊ��׼ֵ
        int standard = array_sort[low];

        while(low<high) {
            // ���ұ߿�ʼѡ����һ���Ȼ�׼ֵС��
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



    // �鲢����
    public void me_sort(int left, int right,int[] result){
        if(left<right){
            int mid = (left+right)/2;
            me_sort(left,mid,result);           // �����
            me_sort(mid+1,right,result);   // ���ұ�
            merge1(left,mid,right,result);     // �鲢
        }
    }


    public void merge1(int left,int mid,int right, int[] result) {
        // �鲢ʱ�������ж�������ģ���ֻ������Ԫ�ؿ�ʼ�鲢�����������������У�
        int i = left;   // �����е�ָ��(left-->mid)
        int j = mid+1;  // �����е�ָ��(mid+1-->right)
        int k = 0;      // �������е�ָ��
        // ÿ���������������ҵ���Сֵ���������
        while (i<=mid && j<=right){
            if(array_sort[i]<array_sort[j]){
                result[k++]=array_sort[i++];
            }
            else {
                result[k++] = array_sort[j++];
            }
        }
        // �˳�ʱ�������бض�ֻ��һ������������δ��������һ���ǽϴ�ģ�ֱ�������������漴�ɡ�
        if(i==mid+1){
            while(j<=right)
                result[k++]=array_sort[j++];
        }
        if(j==right+1){
            while(i<=mid)
                result[k++]=array_sort[i++];
        }
        k=0;
        // ÿһ�ι鲢�󽫹鲢�Ľ�����ǵ�ԭ����
        while(left<right)
            array_sort[left++]=result[k++];
    }




    // ������
    public void Heap_sort(){
        int end_index= array_sort.length-1;
        while(end_index>0){
            // ����󶥶�
            creat_big_top(end_index);
            // �����Ѷ�Ԫ�أ����ֵ�������һ��Ԫ��
            swap_index(0,end_index);
            // ���ź�����������end_index--
            end_index--;
        }
    }

    public void creat_big_top(int end){
        for(int i=0;i<=end;i++){
            int j = i;
            // ���ӽڵ���ڸ��ڵ�ʱ����
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


    // ��������
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

