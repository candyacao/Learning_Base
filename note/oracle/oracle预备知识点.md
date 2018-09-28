# oracle数据库
* 前言     oracle sql
* 第一章   Selecting Rows
* 第二章   Sorting & Limiting Selected Rows
* 第三章   Single Row Functions
* 第四章   Displaying Data from Multiple Tables
* 第五章   Group Function 
* 第六章   Subqueries
* 第七章   Specifying Variables at Runtime
* 第八章   Overview of Data Modeling and Database Design
* 第九章   Creating Tables
* 第十章   Oracle Data Dictionary
* 第十一章 Manipulating Data(DML)
* 第十二章 Altering Tables and Constraints
* 第十三章 Creating Sequences
* 第十四章 Creating View
* 第十五章 Creating Indexes
* 第十六章 Controlling User Access

## 前言
1. 一个认知
```
	认知什么是oracle？
		oracle：商业运用第一的关系型数据库
		实质：关系型数据库
	了解oracle数据库发展历史(文档)
```
2. 二个概念
```
	数据库：数据存储的仓库
	关系型数据库：数据库中保存的对象之间可以存在一定的关联系，并非完全独立。
	主要反映到以后学习的主外键.
	了解数据库发展历史(文档)
```
3. 三个名词
```
	sql:结构化的查询语句，操作oracle数据库的语言(crud),是一门语言
	sqlplus:oracle软件自带的可以输入sql，且将sql执行结果显示的终端
	pl/sql:程序化的sql语句，在sql语句的基础上加入一定的逻辑操作，如if for...,使之成为一个sql块，完成一定的功能
```
4. 四种对象
```
	table：表格，由行和列组成，列又称字段，每一行内容为表格的一条完整的数据。
	view:  视图，一张表或者多张表的部分或者完整的映射，好比表格照镜子，镜子里面的虚像就是view
	除去常见的table和view两种对象以外，oracle数据库还支持如下四种对象
	sequence：序列 
	index：索引，提高数据的访问效率
	synonym：同义，方便对象的操作  
	program unit：程序单元，pl/sql操作的对象
```
5. 五种分类
```
	sql的五大分类:
	Data retrieval：数据查询
		select
	DML：数据操纵语言（行级操作语言）：
		操作的是表格当中一条一条的数据
		insert update delete
	DDL：数据定义语言（表级操作语言）：
		操作的内容为表格（对象）
		create （创建表） 
		alter   (修改表)
		drop    (删除表) 
		truncate  (清空表)
		rename   (重命名)
	transaction control：事务控制 	原子性
		commit (提交)
		rollback (回滚)
		savepoint (设置回滚点)
	DCL：数据控制语言
		grant (分配权限) 
		revoke (回收权限)
```		
6. delete，truncate区别
```
	delete：  删除表中的一条或者多条记录，该操作需要提交事务
	truncate：清空表格,该操作不需要提交事务
```
7. 查看服务状态
```
  	在win+r窗口输入services.msc回车
```
