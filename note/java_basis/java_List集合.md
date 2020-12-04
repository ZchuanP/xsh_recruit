# List
### 性质
 * List是最基础的一种集合接口，是一种有序列表。行为和数组集合完全相同。增删查改和数组完全一样。
 * List接口允许有重复的元素
 * List中允许添加null元素
 * List 可以通过List.of()快速创建，但不能添加null值
 * 引入迭代器对象和List``import java.util.Iterator;
import java.util.List;``
 ---
### 基本方法
* 在末尾添加一个元素：boolean add(E e)
* 在指定索引添加一个元素：boolean add(int index, E e)
* 删除指定索引的元素：int remove(int index)
* 删除某个元素：int remove(Object e)
* 获取指定索引的元素：E get(int index)
* 获取链表大小（包含元素的个数）：int size()
---
### 分类
#### 1. ArrayList
* ArrayList内部是用数组来存储所有元素。
* ArrayList把添加删除等操作封装起来，操作时类似于数组，却不用关心内部元素如何移动。
* 创建	
    List<String> list = new ArrayList<>();
#### 2. LinkedList
* LinkedList通过链表来实现了List接口
* 创建	
    List<String> list = new LinkedList<>();

---
### 遍历List
##### 用for循环根据索引配合get(int)方法遍历
	for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
缺点：代码复杂，在Linkedlist实现时访问速度很慢，效率不高
##### 用迭代器来访问List
* Iterator本身也是一个对象，由List的实例调用iterator()方法的时候创建的。
* Iterator对象知道如何遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高的访问效率。
* Iterator对象有两个方法：
**boolean hasNext()判断是否有下一个元素，
  E next()返回下一个元素。**

使用Iterator遍历List代码如下

	public class Main {
    	public static void main(String[] args) {
        	List<String> list = List.of	("apple", "pear", "banana");
        	for (Iterator<String> it = 	list.iterator(); it.hasNext(); ) {
            	String s = it.next();
            	System.out.println(s);
        	}
	  	}
    }


java本身提供了for each循环帮我们使用Iterator遍历。所以上面的for循环可以改写为：

	for (String s : list) {
            System.out.println(s);
        }

**只要实现了Iterable接口的集合类都可以用for each循环来遍历**

---
### LIst和Array的转换
* 通过toArray(T[])传入一个**相同数据类型**的Array，List会自动把元素传到Array中  
#######
	public class Main {
    	public static void main(String[] args) {
        	List<Integer> list = List.of(12, 34, 56);
        	Integer[] array = list.toArray(new Integer[3]);
        	for (Integer n : array) {
            	System.out.println(n);
        	}
      	}
	}

