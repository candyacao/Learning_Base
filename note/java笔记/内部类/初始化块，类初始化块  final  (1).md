## 初始化块
```
      {
          语句
      }
      修饰符可以没有，有也只能是static
      由static修饰的代码块叫静态代码块，也叫类初始化代码块
      没有static修饰的代码块叫非静态代码块，也叫实力初始化代码块

   * 实力初始化块  是"假象"，一个类被编译之后，该代码块就会消失，都会还原到每个构造器的所有代码之前。
   作用：所以可以将所有构造器前面相同的部分提取到实例初始化代码块中，
   * 只要程序调用构造器创建对象，程序就会先执行实例初始化代码块--因为实例初始化代码块被还原到构造器的super之后，this和剩余的所有代码之前。创建一个对象，调用一次。
   * 定义属性时的给属性赋值，也是一个"假象"，一个类被便一直很编译之后，该代码块就会消失，都会还原到每个构造器的所有代码之前。两个在构造器中的顺序 就是他们原来代码的顺序	
```
```java
public class AA {
	public static void main(String[] args) {		
		A cat = new A();
	}
}
class A{
	{
		System.out.println("hhh");
		age = 20;
	}
	int age = 2;
	public A(){
        System.out.println("无参构造器");
		System.out.println(age);
	}
    public A(int m){
        System.out.println("有参构造器");
    }
}
//编译后变为
class A{
    int age;
    public A(){
        System.out.println("hhh");
		age = 20;              //初始化块中的内容

        age = 2;               //属性的赋值语句      
                              //如果原码中的初始化块和定义属性的位置对调一下，那么编译之后，在构造器中的位置也应该对调。
        System.out.println("无参构造器");
		System.out.println(age);
	}
    public A(int m){
        System.out.println("hhh");
		age = 20;

        age = 2;

        System.out.println("有参构造器");
    }
}



```


## 类初始化块
```
 负责对类执行初始化
 当程序第一次主动使用该类时，系统会为改类分配内存空间，并执行初始化(调用类初始化快)
 只要使用该类，基本都算主动使用--除了仅使用类声明变量
 整个程序中该代码块只执行一次

 定义静态变量时指定的初始值，也是"假象"---指定后的初始值，编译之后就变成静态代码块中的一条赋值语句，先后取决于代码的先后。
 ```
```java
public class AA {

	public static void main(String[] args) {
        A cat;   //在这没有主动使用类，仅仅这一种情况不算主动使用类。
		cat = new A();
	}
}

class A{
	
	static int age=2;
	static{
        system.out.println("类初始化块");
		age = 20;
	}
    //编译之后，上面的四行语句变为
      static int age;
      static{
          age=2;
          
          system.out.println("类初始化块");
          age=20;
      }
    //----

	
	public A(){
		
		System.out.println(age);
	}
}
```
#### 注意

* 初始化任何类之前一定要先从Object开始初始化，然后依次初始化他的祖先，最后在初始化自己

* 创建任何对象，一定是从Object的构造器开始执行。然后再执行祖先的构造器，最后执行自己的构造器，

### 例题

```java
public class StaticClass_类初始化快 {
	public static void main(String[] args) {
		new Sub(3.4);
		System.out.println("-------------------");
		new Sub(1.4);
	}
}
class Base{
	static {
		System.out.println("Base的类初始化快");
	}
	{
		System.out.println("Base的实例初始化快");
	}

	public Base(){
		System.out.println("Base 无参 构造器");
	}
	public Base(String string){
		System.out.println("Base Strng 构造器");
	}
}
class Mid extends Base{
	static {
		System.out.println("Mid的类初始化快");
	}
	{
		System.out.println("Mid的实例初始化快");
	}
	public Mid(){
		super("hsfg");
		System.out.println("Mid 无参 构造器");
	}
	public Mid(double d){
		this();
		System.out.println("Mid int 构造器");
	}

}
class Sub extends Mid{
	static {
		System.out.println("Sub的类初始化快");
	}
	{
		System.out.println("Sub的实例初始化快");
	}
	public Sub(){
		System.out.println("Sub 无参 构造器");
	}
	public Sub(double d){
		this();
		System.out.println("Sub double 构造器");
	}
}

```

答案
   Base的类初始化快
   Mid的类初始化快
   Sub的类初始化快
   Base的实例初始化快
   Base Strng 构造器
   Mid的实例初始化快
   Mid 无参 构造器
   Sub的实例初始化快
   Sub 无参 构造器
   Sub double 构造器
   -------------------
   Base的实例初始化快
   Base Strng 构造器
   Mid的实例初始化快
   Mid 无参 构造器
   Sub的实例初始化快
   Sub 无参 构造器
   Sub double 构造器

## final
可以修饰变量，方法，也可以修饰类----final与abstract互斥，永远不能同时出现
* 修饰变量，该变量赋值后，不能被重新赋值，并且final修饰的变量必须被赋值，并且只能赋值一次。
   * 修饰成员变量，
      * 没有被final修饰的普通成员变量，可以不显式指定初始值，系统会默认分配初始值
      * 被final修饰的成员变量，必须显式指定初始值，
         * final修的的实例变量
            - 在类中赋值
            - 在实例初始化代码块中赋值
            - 在构造器中赋值     -----------这三个地方的本质，就是在构造器中赋值
         * final修饰类变量
            - 在类中赋值
            - 在类初始化代码块中赋值   -----------这三两个地方的本质，就是在类初始化代码块中赋值
    * 修饰引用类型变量，只能保证改引用变量本身不会被改变，该引用变量所引用的对象完全可以被修改

* 修饰的“宏替换”的变量
   * 如果变量满足一下3个条件，这个变量就会消失，该类出现的所有该变量，在编译时就会被替换成该变量的设定的那个值
      1. 变量用final修饰
      2. 声明变量时指定初始值
      3. 变量的初始值可以在编译时确定下来
    

* 修饰方法
   * 改方法不能被重写
   * 可以被重载，也可以被子类调用 ----避免了改方法被子类破坏


* 修饰类
   * 表明该类不能派生子类
      比如String、Math、System
      Object 一定不是fianl修饰的



