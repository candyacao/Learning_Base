# DML语句
1. 主要内容:
	* insert
	* update
	* delete
	* commit
	* savepoint
	* rollback

2. sql语句的分类:
	* select查询语句
	* DML
        * insert 
        * update 
        * delete
	* DDL
	* DCL
	* 事务控制语句
##	测试使用的表: 没有主外键关联
```sql
	create table t_user(
		id number,
		name varchar2(10) constraint user_name_nn not null,
		email varchar2(10),
		gender char(1),
		age number,
		birthday date,
		constraint user_id_pk primary key(id),
		constraint user_email_un unique(email),
		constraint user_gender_ck check(gender in('f','m'))
	);
	drop table t_user;
```
### insert-------------向表中插入数据
1. 默认是向表中的每一个列中【依次】插入数据
```sql
insert into t_user values(1,'tom','abc','f',20,'11-8月-98');
```
   **违反任意一种约束那么就插入数据失败**

2. 也可以指明向表中的哪些列插入数据

**可以任意交换下面列名的位置,只要values语句中的值也对应交换即可**
```sql
insert into t_user(id,name,email,gender,age,birthday) values(2,'tom','abc1','f',20,'11-8月-98');
```
3. 列的值可以是null的话,那么也在插入的时候不指定这个列

**unique约束和check约束的值,都【可以】为null**

**主键约束和非空约束的值,都【不可以】为null**
```sql
insert into t_user(id,name,email,gender) values(3,'tom','abc3','f');
insert into t_user(id,name,email) values(4,'tom','abc3');
insert into t_user(id,name) values(5,'tom');
```		

4. 使用运行时参数设置需要输入表中的值
```sql
		insert into t_user(id,name) values(&id,'&name');
```
5. 把查询的结果 插入到表中。前提是查询的列的顺序和要插入表中列的顺序是一致的,这个一致指的的是数据类型是一致的。
```sql
		insert into t_user(id,name,birthday) 
		select id,last_name,start_date 
		from s_emp;
```
	
### update语句:
1. 修改表中所有数据的age值为20岁
```sql		
    update t_user set age=20;
```		
2. 修改表中所有数据的age和gender的值
```sql
	update t_user set age=25,gender='m';
```		
3. 修改表中id小于10数据的age和gender的值为null
```sql
	update t_user 
	set 
	age=null,gender=null 
	where id<10;
```		
4. 修改id为18的用户的名字为zhangsan
```sql
	update t_user set name='zhangsan' where id=18;
```
	
### delete语句
1. 删除表中id大于20的用户信息
```sql
    delete from t_user where id>20;
```
2. 删除名字为张三的用户信息
```sql
    delete from t_user where name='zhangsan';
```
3. 删除表中所有的数据
```sql
    delete from t_user;
```
	
## 测试使用的表: 主外键关联
```sql
create table t_customer(
	id number,
	name varchar2(20) constraint customer_name_nn not null,
	constraint customer_id_pk primary key(id)
);

create table t_order(
	id number,
	price number,
	customer_id number,
	constraint order_id_pk primary key(id),
	constraint order_cid_fk foreign key(customer_id) references t_customer(id)
);
	
drop table t_order;
drop table t_customer;
```
### insert语句:
1. t_customer表中插入数据
```sql
	insert into t_customer(id,name) values(1,'tom1');
	insert into t_customer(id,name) values(2,'tom2');
	insert into t_customer(id,name) values(3,'tom3');
```
2. t_order表中插入数据
```sql
	//customer_id外键列的值必须是t_customer表中出现过的
	insert into t_order(id,price,customer_id) values(1,1000,1);
	insert into t_order(id,price,customer_id) values(2,2000,2);

	//插入出错,因为6这个值并没有在t_customer表中出现过的
	insert into t_order(id,price,customer_id) values(3,3000,6);
 ```
3. t_order表中插入数据
```sql
		//默认情况下,外键列上的值是可以为空的
		insert into t_order(id,price,customer_id) values(3,3000,null);
		insert into t_order(id,price) values(4,4000);
```
**如果在外键列上加一个非空约束,那么这个外键列的值就不能为null了(可以给一个列上添加多种约束)**

4. t_order表中插入数据
```sql
		//默认情况下,外键列上的值是可以重复的
		insert into t_order(id,price,customer_id) values(5,5000,1);
		insert into t_order(id,price,customer_id) values(6,6000,1);
```
**如果在外键列上加一个唯一约束,那么这个外键列的值就不能重复了(可以给一个列上添加多种约束)**

### update语句:
	把俩个测试表删除了重新创建,然后向表中插入一些数据
```sql
	//t_customer表中插入数据
	insert into t_customer(id,name) values(1,'tom1');
	insert into t_customer(id,name) values(2,'tom2');
	insert into t_customer(id,name) values(3,'tom3');

	//t_order表中插入数据
	insert into t_order(id,price,customer_id) values(1,1000,1);
	insert into t_order(id,price,customer_id) values(2,2000,2);

    //把t_order表中id=1的数据的customer_id列修改为3
	update t_order set customer_id = 3 where id = 1;

	//把t_order表中id=1的数据的customer_id列修改为null
	update t_order set customer_id = null where id = 1;
	
	//把t_order表中id=1的数据的customer_id列修改为20
	//sql执行出错,因为就没id=20的顾客
	update t_order set customer_id = 20 where id = 1;
```		
### delete语句:
```sql	
	//删除t_order表中的的所有数据
	//可以成功删除,没有问题,因为删除t_order不会对t_costomer表的数据产生任何影响
	delete from t_order;
		
    //t_order表中插入数据
	insert into t_order(id,price,customer_id) values(1,1000,1);
	insert into t_order(id,price,customer_id) values(2,2000,2);

	//删除t_customer表中id=3的数据
	//删除成功,因为t_order表中外键列中没有引用过这个值
	delete from t_customer where id = 3;

	//删除t_customer表中id=1的数据
	//删除失败,因为t_order表中外键列中已经引用了这个值
	delete from t_customer where id = 1;
```
	  【在这种情况下,on delete 语句就可以起作用了】

### on delete语句
* on delete no action(默认情况:什么不都写)
* on delete cascade
* on delete set null
```		
    on delete语句是在声明外键约束的时候使用的。用户在删除A表中的一条数据,而这条数据被B表中的外键列所引用了,这个时候on delete语句的设置可以告诉oracle这个时候该如何处理
```				
1. 如果在建外键的时候,不加on delete语句,就是on delete no action
* 例1: on delete no action
```sql
1. 创建表
	create table t_customer(
		id number,
		name varchar2(20) constraint customer_name_nn not null,
		constraint customer_id_pk primary key(id)
	);

	create table t_order(
		id number,
		price number,
		customer_id number,
		constraint order_id_pk primary key(id),
		constraint order_cid_fk foreign key(customer_id) references t_customer(id)
	);

2. 插入测试数据:

	//t_customer表中插入数据
	insert into t_customer(id,name) values(1,'tom1');
	insert into t_customer(id,name) values(2,'tom2');
	insert into t_customer(id,name) values(3,'tom3');

	//t_order表中插入数据
	insert into t_order(id,price,customer_id) values(1,1000,1);
	insert into t_order(id,price,customer_id) values(2,2000,2);

	//删除失败
	//ORA-02292: 违反完整约束条件 - 已找到子记录
	delete from t_customer where id = 1;
       
3. 删除表		
	drop table t_order;
	drop table t_customer;
```
		
* 例2: on delete cascade
```sql
1. 建表语句和测试数据上例1相同,只是在声明外键列的时候加入on delete cascade语句

	create table t_order(
		id number,
		price number,
		customer_id number,
		constraint order_id_pk primary key(id),
		constraint order_cid_fk foreign key(customer_id) references t_customer(id) on delete cascade
	);

	//同样做删除测试
	//删除成功,同时级联(cascade)删除了t_order表中所关联的那条数据
	delete from t_customer where id = 1;
```		
* 例3: on delete set null
```sql
1. 建表语句和测试数据上例1相同,只是在声明外键列的时候加入on delete set null语句

	create table t_order(
		id number,
		price number,
		customer_id number,
		constraint order_id_pk primary key(id),
		constraint order_cid_fk foreign key(customer_id) references t_customer(id) on delete set null
	);
		
	//同样做删除测试
	//删除成功,同时把t_order表中所关联的那条数据的外键设置为了null
	delete from t_customer where id = 1;
```	
## 数据库事务
1. DML语句执行的时候,如果当前有事务,那么就使用这个事务,如果当前没有事务,这个执行的DML语句就会产生一个新的事务。
2. 只有DML语句才会产生事务,其他语句不会产生事务。
3. commit/rollback/DDL语句都可以把当前事务给结束掉
4. commit和DDL语句结束事务的方式是把这个事务给提交了
5. rollback结束事务的方式是把这个事务给回滚了

**1. 提交事务是指让这个事务里面的所有操作都生效到数据库中**

**2. 回滚事务是指让这个事务里面的所有操作都撤销**
```sql				
// 测试用的表:
	create table t_customer(
		id number,
		name varchar2(20) constraint customer_name_nn not null,
		constraint customer_id_pk primary key(id)
	);
	drop table t_customer;
```
### 测试
1. 概念：使用俩个终端窗口,同一个账号登录到数据库中,观察事务是否提交对用户查看数据的影响
2. **注意** : 一个用户对A表做了DML操作,但是没有提交事务,这时候别的用户是不能对A表再做其他的DML操作。(为了保证数据的安全和一致性)
		
* 例1
```
    insert ....产生事务A
	update ... 这个操作是事务A中的操作
	insert ..  这个操作是事务A中的操作
	commit;    让事务A里面的三个操作生效、事务A结束
	delete ... 产生新的事务B
	insert ..  这个操作是事务B中的操作
	insert ..  这个操作是事务B中的操作
	insert ..  这个操作是事务B中的操作
	rollback;  让事务B中的四个操作都撤销,事务B结束
```
* 例2
```
	insert ....产生事务A
	update ... 这个操作是事务A中的操作
	insert ..  这个操作是事务A中的操作
	DDL语句;   事务A会被提交,事务A结束
	rollback;  这时候回滚已经对事务A不起作用,因为事务已经被提交了,当前已经没有事务了
```		
**create语句 drop语句 alter语句等都属于DDL语句**

### 事务特征ACID：	
* 原子性：Atomicity

	    同时成功或者同时失败

* 一致性：Consistency 

		事务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。

* 隔离性：Isolation 

		事务操作应该相互独立

* 持久性：Durability 

		事务所做的影响 ，在事务结束之后应该能够是持久的。
	
### isolation  事务隔离级别
1. 事务中产生的问题:

	1. 脏读  
    ```
        主要针对update操作。 一个事务A读到另一个事务B中修改过但是还没有提交的数据
    ```
	2. 不可重复读  
    ```
        主要针对update操作。 一个事务A在第一次读数据和第二次读数据之间,有另一个事务B把这个数据更改并提交了,所以就出现了事务A里面读一个数据俩次,但是读到的结果是不同的。
    ```
	3. 幻读  
    ```
        主要针对的是insert/delete操作。事务A第一次用where条件筛选出了10条数据,事务A第二次用通样的where条件筛选出的却是11条数据,因为事务B在事务A的第一次和第二次查询之间进行了插入操作,并且插入的这个数据满足事务A的where筛选条件.
    ```
		
2. 事务隔离级别
	* read-uncommitted  不提交也能读
	* read-committed    提交之后才能读 解决了脏读
	* repeatable-read   解决了脏读和不可重复读
	* serializable      三个问题都解决了

	级别越高解决的问题越多但是效率越低。

**并不是所有数据库都支持这四种事务隔离级别,比如oracle就只支持第二种和第四种这俩种,比如mysql就四种全支持.** 

	oracle里面默认的事务隔离级别是第二种:read-committed

	oralce里面设置事务隔离级别:
		Set Transaction Isolation Level Read Uncommitted
		Set Transaction Isolation Level Read Committed
		Set Transaction Isolation Level Read Repeatable
		Set Transaction Isolation Level Serializable
	

3. 回滚点/保存点 savepoint
	* DML语句1
		savepoint A
	* DML语句2
		savepoint B
	* DML语句3
		rollback to A/B
```
    这个时候可以通过这个回滚点让事务回滚到指定的位置,如果不指定回滚点而是直接rollback,那么事务会一下子回滚完.

    【特别注意】:rollback到回滚点之后,这个事务并没结束,这个时候还可以接着回滚或者commit提交事务。
```		
```sql
//测试表
	create table t_user(
		id number primary key,
		name varchar2(100),
		salary number
	);
	drop table t_user;
// 插入数据
	insert into t_user values(1,'tom',1000);
	savepoint A;
	insert into t_user(id,name) values(2,'zs');
	savepoint B;
	delete from t_user;
	rollback to B;
```
	然后查询看结果
	select * from t_user;