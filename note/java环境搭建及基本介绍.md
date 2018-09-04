# corejava 是一门语言
# 语言：
	语言=OS+数据结构+算法+思想
	OS：操作系统
	数据结构：保存数据
			队（先进先出），栈（先进后出），二叉树，链表
	算法：做游戏开发就需要考虑算法
		不用判断语句和三目运算符，一句话来判断整数a，b的大小
		System.out.println((|a+b|+|a-b|)/2)
	思想：语言的灵魂
	思想：语言的灵魂
		Java：面向对象
		c：面向过程
		c++：不完全面向对象
		面向过程的过程：注重的是过程
		面向对象：注重的是对象
			对象：万物皆对象
				每个对象都有自己的特征
			模板：class称之为类  类包括属性和行为
			面向对象编程：先构建各种类，然后根据类创建对象，接下来操作对象中的属性和行为
# 基础Java编程
## 环境搭建
	下载JDK，在oracle官网下载
	安装JDK
	配置环境变量
		JAVA_HOME:jdk的安装路径
		CLASSPATH：指定字节码文件的加载路径
		PATH：指定JDK中命令工具的路径
			JDK路径下的bin
			如java，javac
## JDK Java开发工具 Java development kit
* JDK中主要包含哪些东西：
	1、JVM：用来编译执行Java代码
	2、各种类库：放在jre/lib/tr.jar
		常用的类System，Date
		常用的包：java.io
				  java.net
				  java.lang
				  java.util
	3、各种工具：在/bin下  
		如java（执行），javac（编译），javadoc（生成Java文档），jar（用来打包，打成jar包）

## Java是什么
	1、Java是一门编程语言
		开发桌面应用程序，如qq，邮件（需要客户端）
		开发服务器应用，如淘宝（只需要浏览器）
	  Java版本：javaSE：开发桌面应用程序     Java标准版
	 		    javaEE：开发服务器应用程序   Java企业版
	 		    javaME：开发移动应用程序     Java移动版
	2、Java是一个开发环境
		先安装jdk
	3、Java是一个应用环境
		只能开发应用程序，不能开发系统程序。
	4、Java是一个部署环境
		Java开发的是企业级应用程序，需要部署到服务器上，服务器上本身也是Java环境。用Java语言编写而成
## 为什么选择Java（Java的特性）
* Java提供一个解释性的环境
	    --------跨平台
	    c，c++ ------>编译后的文件------->cpu机器码
	    Java --------->编译之后的文件（字节码文件 .class）--->通过JVM解释成机器码交给CPU
	    字节码文件是一个与系统与硬件无关的中间文件,字节码文件跨平台，JVM实现跨平台
	加快开发速度
	一次编译，到处运行
	多线程----应用层面
	支持动态更新
* 提供了一个更加简单的编程方式
	1）没有指针，在开发程序（应用程序）上是没用指针，在底层有指针
		Java中推出对象的引用这个概念
	2）在代码层面上没有内存管理
		c，c++需要程序员手动管理内存，先开辟内存，然后释放内存
		c：malloc（）开辟内存
		   free（）释放内存
		c++：new开辟内存
		     delete（）释放内存
		Java：new开辟内存
		      程序员不需要关心释放内存的问题
		      GC（垃圾回收器）来自动回收内存
	3）纯面向对象的编程
	    一切都是对象，操作也是对象
	    构建类，创建类，操作对象的属性和行为
* 如何实现：JVM，GC，代码安全验证

## GC垃圾回收器
* 垃圾：无用对象所占用的内存空间成为垃圾
		无用对象是合法分配内存空间，后面通过任何方式都无法访问的这块空间，这块空间即为垃圾
* 垃圾回收：回收无用对象所占据的内存空间。回收new出来后产生的垃圾
* 垃圾回收器：是一个系统级别比较低的线程，自动回收系统，程序员无法控制垃圾回收器
		线程：程序运行的最小单元
		进程：资源分配的最小单元
* 垃圾回收器什么时候工作：
	1、系统闲置的时候
	2、内存严重不足的时候
* 程序员通过java.lang.System.gc()或java.lang.Runtime.gc()
			通知GC应该工作了。只是通知，不是控制GC工作
* 垃圾回收器算法：
	1）标记清扫法：只是清扫垃圾，对内存没有整理，内存比较琐碎，有更多碎片，效率高
	2）内存搬移法：对内存进行整理，内存更加完整，效率低

## Java代码安全机制
* 编写阶段：编写.java文件
* 编译阶段：将.java文件编译成.class文件，.class文件是字节码文件，可以运行在各个平台上
* 运行阶段：运行.class文件
	1、类加载：将.class文件从硬盘中加载到内存中
	2、字节码验证
			JIT：即时编译器   inter公司
			8020原则：80%的功能会常用到20%的代码
				20%代码称之为热点代码
		1)JVM版本是否兼容，向下兼容　　高版本兼容低版本，低版本不能兼容高版本
		2)不能破坏系统的安全性
		3)栈不能上溢和下溢
		4)数据类型是否正确
		5)数据类型转换是否正确

## 编写Java代码
.Java文件中导入包
	package com.briup.ch01
编译：
javac -d . First.java 
	-d 指定.class文件存放的路径
	连同包package一起编译
		package的意义:包必须在第一行，可有可无。建议加包
			1、使用文件结构的方式管理类
			2、避免命名冲突，在同一个包中不能存在重名文件
			3、一旦加上包之后，类名就发生改变，变为包名加类名，即为权限类名
			4、定义package的格式：公司域名的倒写+组+功能
		import：导包，如果使用的类不在当前包中就需要导入
			    可以导入多个，放在package下面
		public class：定义公共类
					  public class后的类名必须和文件名相同
					  一个java文件可以定义多个类，但只有一个公共类
		public static void main(String[] args){}:主方法，是程序的入口
		System.out.println(内容)：输出语言
		new Date():创建对象
运行:
java com.briup.ch01.First

# 方法的定义
	修饰符 返回值类型 方法名(参数列表){
		方法体
	}
	public static void main(String[] args){
		//.......
	}
	public static void add(){
		//........
	}
	public 访问修饰符，控制访问权限
	private 访问修饰符，只能自己访问
	static 是静态的
	void 没有返回值
	方法返回值：执行该方法之后所产生的结果
		如果方法中有返回值，必须要有一个return，返回结果
	参数列表：方法接受传入的数据
	          调用该方法的时候传入参数列表的值

	public int add(int a,int b){
		return a+b;
	}

	不用static是非静态
	public void add(){}  非静态

# 方法的调用
	静态方法的调用:方法名(参数)

## 编译
javac -encoding utf-8 -d classes src/com/md02/Student.java
	-encoding utf-8：文件编码
	-d：指定.class文件的生成路径
javac -encoding utf-8 -cp classes src\com\md02\StudentTest.java	
	-cp：寻找所依赖的字节码文件的所有路径

## 运行
java -cp classes com.md02.StudentTest
	通过找到字节码文件的所在路径,用完整的包名路径去运行





