# java 小知识点
### **java 双引号和单引号的区别**

>java中单引号表示字符，双引号表示字符串。<br/>
>所以在做字符串拼接时（print输出），必须用双引号。若用单引号则会输出单个字符的ascll码和数字的和

### java 双冒号运算
> 双冒号运算就是Java中的[方法引用],[方法引用]的格式是 类名::方法名
>> 例如：
>> ``person -> person.getName();``<br/>
>> 可替换成``Person::getName``

### java 随机数的产生
> * 直接使用Math.random()静态方法
>>要返回指定范围内的数<br/>
>``(int)(Math.random()*n）`` 返回0到n的随机整数。(不含n)
> ``(int)(Math.random()*(MAX-MIN+1))+MIN``产生MIN到MAX的随机数 

> * import java.util.Random类，创建一个实例，使用nextInt(int count)获得count以内的整数（注意不包含count）
>>要获取指定范围内的数<br/>使用``nextInt(MAX - MIN + 1) + MIN;``即可


### java 时间函数
+ System.nanoTime() 返回以毫微米记的当前时间数据
+ System.currentTimeMillis() 返回以毫秒记得当前时间数据