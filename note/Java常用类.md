# Object类
	Object类的主要成员方法：
		1. equals()方法：比较两个对象是否相等，仅当被比较的两个引用变量指向同一个对象时，该方法才返回true。
		2. notify()方法：从等待池中唤醒一个线程，把它转移到锁池
		3. notifyAll()方法：从等待池中唤醒所有的线程，把它们转移到锁池
		4. wait()方法：使当前线程进入等待状态，直到别的线程调用notify()或notifyAll()方法唤醒它。
		5. hashCode()方法：返回对象的哈希码
		6. toString()方法：返回当前对象的字符串
		7. finalize()方法：对于一个已经不被任何引用变量引用的对象，当垃圾回收器准备回收该对象所占用的内存时，将自动调用该对象的finalize()方法。

# String类和StringBuffer类
String类和StringBuffer类主要用来处理字符串，这两个类提供了很多字符串的实用处理方法。String类是不可变类，一个String对象所包含的字符串内容永远不会被改变；而StringBuffer类是可变类，一个StringBuffer对象所包含的字符串内容可以被添加或修改。

## String类中"hello"与new String("hello")的区别
“hello”是直接数，Java虚拟机把它当作编译时常量，在内存中只为它分配一次内存，然后就可以重复使用，而每个new String("hello")都会新建一个String对象。

## 比较String类与StringBuffer类
### String类与StringBuffer类有以下相同点
1. String类与StringBuffer类都用来处理字符串
2. String类与StringBuffer类都提供了length(),toString(),charAt(),substring()方法，他们的用法在两个类中相同
3. 对于String类与StringBuffer类，字符在字符串中的索引位置都从0开始。
4. 两个类中的substring(int beginIndex,int endIndex)方法用来截取子字符串，而且截取的范围都是从beginIndex开始，一直到endIndex-1结束，截取的字符的个数为endIndex-beginIndex。

### String类与StringBuffer类有以下不同点
1. String类是不可变类，StringBuffer是可变类。String类对象一旦创建后，它的内容就不可改变。一些看起来能够改变字符串的方法，实际上是创建一个带有方法所赋予特性的新字符串，而StringBuffer的方法会改变字符缓冲区的字符串内容。
2. String类覆盖了Object类的equals()方法，而StringBuffer类没有覆盖Object类的equals()方法。
3. 两个类都覆盖了Object()的toString()方法，但各自的实现方式不一样：String类的toString()方法返回当前String实例本身的引用，而StringBuffer类的toString()方法返回一个以当前StringBuffer缓冲区中的所有字符为内容的新的String对象的引用。
4. String类对象可以用操作符“+”来连接，而StringBuffer类对象之间不能通过操作符“+”来连接

# 包装类
包装类的特点：
1. 所有的包装类都是final类型，因此不能创建它们的子类
2. 包装类是不可变类，一个包装类的对象自创建后，它所包含的基本类型数据就不能被改变
3. JDK1.5允许基本类型和包装类型进行混合数学运算

# Random类
java.util.Random类提供了一系列用于生成随机数的方法。
* nextInt():返回下一个int类型的随机数，随机数的值大于或等于0
* nextInt(int n):返回下一个int类型的随机数，随机数的值大于或等于0，并小于参数n
* nextLong():返回一个long类型的随机数，随机数的值位于long类型的取值范围内
* nextFloat():返回下一个Float类型的随机数，随机数的值大于等于0，并且小于1.0
* nextDouble():返回下一个Double类型的随机数，随机数的值大于等于0，并且小于1.0
* nextBoolean():返回一个boolean类型的随机数，随机数的值为true或false

# 处理日期的类
Java语言提供了3个处理日期的类，
* java.util.Date：包装了一个long类型数据，表示与GMT(格林尼治标准时间)的1970年1月1号00:00:00这一刻所相距的毫秒数
* java.text.DateFormat：对日期进行格式化
* java.util.Calendar：可以灵活的设置或读取日期中的年、月、日、时、分、秒等信息