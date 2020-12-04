# Java_Map
---
###性质
* map是一种键值映射表(哈希表)，能够通过key快速的寻找value。
* 使用Map需要引入包``import java.util.HashMap;
import java.util.Map;``
* Map也是一个接口，最常用的实现类是HashMap类。
#
	Map<String, Student> map = new HashMap<>();

---
###基本方法
* ``V put(K key,V value)`` 把key和value做映射放入map中。若key已经存在，则返回被删除的旧的value。
* ``V get(K value) ``通过key值获取对应的value。如key不存在，则返回null。
* ``boolean containsKey(K key)``查询某个key是否存在。


---
###遍历Map
1. 遍历key。使用for each循环遍历Map实例的KeySet()方法返回的set集合（**包含不重复的key的集合**）
#	
	public class Main {
        public static void main	(String[] args) {
        	Map<String, Integer> map = new HashMap<>();
        	map.put("apple", 123);
        	map.put("pear", 456);
        	map.put("banana", 789);
        	for (String key : 	map.keySet()) {
            	Integer value = map.get(key);
            	System.out.println(key + " = " + value);
        	}
      	}
    }

2 同时遍历key和value。使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射
# 
	public class Main {
    	public static void main(String[] args) {
        	Map<String, Integer> map = new HashMap<>();
        	map.put("apple", 123);
        	map.put("pear", 456);
        	map.put("banana", 789);
        	for (Map.Entry<String, Integer> entry : map.entrySet()) {
            	String key = entry.getKey();
            	Integer value = entry.getValue();
            	System.out.println(key + " = " + value);
        	}
    	}
	}

---
###注意事项
* 在map中重复放入键值对（key相同）不会出现问题，但一个key只能对应一个value。**新添加的key的value值会将第一个的value值覆盖掉**。所以**Map中不会存在重复的key**
* Map不保证顺序，所以在遍历时顺序不一定是put的顺序，也不是按key的顺序排序。

 