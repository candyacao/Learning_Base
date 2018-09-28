# select语句，数据查询操作
## desc+表名----描述表的信息
## column语句：结果不好看，通过column使我们的显示界面好看。

	COLUMN last_name FORMAT a15;
	可以简写为:
	col last_name for a15;
	COLUMN first_name FORMAT a15;

	Column 没有改变数据表里数据，它只是改变显示。
	Column不是SQL命令,而是sqlplus命令。
	除了刚才这个作用之外，我们下面来看看它
	还有什么作用。

	COLUMN last_name HEADING 'Employee|Name' FORMAT A15
	. 给last_name取别名为Employee|Name , 
		竖杠代表换行。
	. A15表示十五个字节长，一短横杠就是一个字节长

	COLUMN salary JUSTIFY LEFT FORMAT $99,999.00
	. salary JUSTIFY LEFT : 仅仅改变列名显示为左齐
	. FORMAT $99,999.00: 控制显示格式为前面加 $ 符, “，”为分隔符, 0或9代表数字(通配符)，0表示替换对齐数值,位数不足会补足,可以混合使用。

	column 显示所有对列格式的设置情况
	column last_name 显示对last_name列显示设置的情况
	column last_name clear 删除对last_name列格式设置的情况
	Clear column 清除所有column的格式设置
	
	Column columName
	可以显示该列的格式设置，这里的列
	并不特定于某个表.

## select语句
1. 使用select语句查询某张表的所有数据内容
	1. 语法
```sql
	select [distinct] * {col_name1,col_name2,..} 
	from tb_name;
```
**语法中出现的中括号[]，表示该部分可有可无**

		2. 语法解读
		
		1. * ：表示所有列，仅仅作为测试和学习使用，在企业用语中不出现，因为效率低下且可读性差
		2. col_name1：列名，将需要查阅的数据字段列举出来，可以查看多列值，列名之间用,进行分割即可
2. select语句可以对指定的列的所有值进行算术运算。
```sql
	语法：
	   select col_name 运算符 数字 from tb_name;
```
**select语句永远不会对原始数据进行修改，因为查看的内容放在虚表中**

3. 查询当前用户下有多少张表
```sql
	select table_name from user_tables;   //仅查看表
	select * from tab;          //可以查看表、视图等
```
## 常用技巧
1. 给查询的列起别名
	语法：
	select old_column [as] new_column_name from tb_name;
2. 使用||可以使得多列的值或者列和
	特殊的字符串合并到一个列进行显示
	* 语法：
	select col_name||'spe_char'||col_name from tb_name
**注意**
'spe_char':如果一个列的值要跟特殊的字符串连接显示，使用该语法
3. 对null值得替换运算
	nvl()函数
	* 语法：
	select nvl(col_name,change_value) from tb_name;
4. 使用distinct关键词，可以将显示中重复的记录
	只显示一条
	语法：
	select distinct col_name,col_name... from tb_name;

	**注意**
	1. distinct关键词只能放在select关键词后面
	如：select id,distinct title from s_emp;
	该语句语法错!!!!!
	2. 如果distinct关键词后面如果出现多列，表示多列联合去重，即多列的值都相同的时候才会认为是重复的记录。

## sqlplus语句
	sqlplus 登录之后,可以使用buff(缓存)来存储/执行/修改要执行的sql语句 
    1.  buff的特点:
      	1. buff中只能存储一条sql语句(但是这条sql语句可能有很多行)
     	2. 每次放入新的sql语句,会把之前的覆盖掉
      	3. 每次执行sql语句,都会把这个sql语句放到buff里面
    2. 常用语句
		l   查看缓存中的sql语句
		a   在[定位]的那一行后面追加新的内容
		i   在[定位]的那一行下面插入新的一行
		c   替换[定位]的那一行中的某些字符串 
			c/老的字符串/新的字符串
		del 删除[定位]的那一行内容
		n   后面加内容可以重写这一行
		!   后面接终端命令 !clear:清屏 windows中使用$符号 例如:$cls
		/   执行缓存sql命令
	3. clear buffer:清空当前缓存的命令
	4. 常用语句
		save  test.sql  buff中的sql语句保存在test.sql文件中
		get   test.sql  把test.sql中的内容在加载到buff中,但是没有运行
		start test.sql  把test.sql中的内容在加载到buff中并且执行
		@test.sql       把test.sql中的内容在加载到buff中并且执行
		edit file_name  使用系统默认编辑器去编辑文件
## spool语句
	spool file_name 将接下来的sql语句以及sql的运行结果保存到文件中
		sql1
		result1
		sql2
		result2
		...
	spool off  关闭spool功能
	exit：退出