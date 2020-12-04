# XML学习笔记
---
### 概念
* XML是可扩展标记语言（eXtensible Markup Language）的缩写，它是是一种数据表示格式，可以描述非常复杂的数据结构，常用于传输和存储数据。XML文件的后缀为**.xml**

---
### 特点/性质
* XML是纯文本，默认使用UTF-8编码
* XML有固定的结构，首行必定是``<?xml version="1.0"?>``，紧接着可选的声明文档定义类型``<!DOCTYPE note SYSTEM "book.dtd">`` 然后才是XML文档的内容。
* 一个XML文档只能有一个根元素，根元素可以包含任意个子元素，元素可以包含属性。
* 由于使用了<、>以及引号等标识符，如果内容出现了特殊符号，需要使用&???;表示转义。例如，Java<tm>必须写成：
``<name>Java&lt;tm&gt;</name>``
* 格式正确的XML（Well Formed）是指XML的格式是正确的，可以被解析器正常读取。而合法的XML是指，不但XML格式正确，而且它的数据结构可以被DTD或者XSD验证

---
### 解析API

##### DOM
+ 一次性读取XML，并在内存中表示为树形结构；
#
	<?xml version="1.0" encoding="UTF-8" ?>
	<book id="1">
    	<name>Java核心技术</name>
    	<author>Cay S. Horstmann</author>
    	<isbn lang="CN">1234567</isbn>
    	<tags>
        	<tag>Java</tag>
        	<tag>Network</tag>
    	</tags>
    	<pubDate/>
	</book>

解析后结构为：
![](https://raw.githubusercontent.com/baixi123/picture_home/main/DOM_eg.png)
document代表整个XML，是树的根。



##### SAX
以流的形式读取XML，使用事件回调。<br/>
SAX解析流程：
>startDocument：开始读取XML文档；<br/>
>startElement：读取到了一个元素，例如`<book>`；
characters：读取到了字符；<br/>
endElement：读取到了一个结束的元素，例如`</book>`；
endDocument：读取XML文档结束。



