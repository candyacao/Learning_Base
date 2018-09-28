# 修改表和约束(alter语句)
```sql
	测试的表:
	create table t_user(
	id number constraint user_id_pk primary key,
	name varchar2(100),
	salary number
	);
	drop table t_user;
```
1. 在表中添加一个新的列
```sql
	alter table t_user 
	add birthday date;
```
2. 删除表的某列
```sql
	alter table t_user 
	drop column birthday;
```
3. 给表中的列添加约束,这个约束相当于之前的表级约束
```sql
	alter table t_user
	add constraint user_name_un
	unique(name);
```
4. 测试刚添加的唯一约束是否生效
```sql
	insert into t_user(id,name) values(1,'zs');
	insert into t_user(id,name) values(2,'zs');
```
5. 删除表中的约束
```sql
	alter table t_user
	drop constraint user_name_un;
```
6. 修改表的名字:
```sql
	rename t_user to mytest;
	rename mytest to t_user;
```
7. 修改表中某列的类型
```sql
	alter table t_user
	modify (name varchar2(500));
```
8. 让约束失效:必须知道约束的名字
```sql
	alter table t_user
	disable constraint user_id_pk cascade;
```
9. 测试是否设置成功
```sql
	insert into t_user(id,name) values(1,'zs1');
	insert into t_user(id,name) values(1,'zs2');
```	
10. 让失效的约束再次生效
```sql
	alter table t_user
	enable constraint user_id_pk;
```
11. 截断表中的数据(删除),不需要提交,默认已经提交,并且不能回滚
```sql
	truncate table t_user;
	相当于:
	delete from t_user;
	commit;

```
12. 给表添加注释
```sql
	comment on table t_user is '很好';
```
	
13. 给列添加注释
```sql
	comment on column t_user.name is 'good';
```

14. 查看表中注释
```sql
	select * from user_tab_comments 
	where table_name=upper('t_user');
```
	
15. 查看列中的注释
```sql
	select * from user_col_comments 
	where 
	comments is not null 
	and 
	table_name=upper('t_user');
```
	
	


# 用户权限控制
1. 创建用户
```sql
	create user user_name identified by password
	例如:
	create user zhangsan identified by zhangsan;
```
2. 删除用户
```sql
drop user zhangsan cascade;
```
3. 赋予权限

```sql
	grant privilege to user;

	例如:把建表 建序列 建视图的权限赋给zhangsan
	grant create table, create sequence,create view to zhangsan;


	//把connect角色和resource角色赋给zhangsan
	//connect连接权限 
	//角色是一组权限的集合
	grant connect,resource to zhangsan;


	注意: 只是登陆oracle数据库的话 需要的权限是create session
```			
4. 修改密码
```sql
	alter user user_name identified by password;

	例如:
	alter user zhangsan identified by zhangsan123;
```
5. 赋予某一个用户某种对象操作的权限
```sql
	grant operator on object to user;
		
	例如:
	grant select 
	on t_user 
	to briup; 
```
6. 回收权限
```sql
	revoke operator on object from user;
	例如:
	revoke select 
	on t_user 
	from briup;
```		
7. 创建同义词synonym
	* 作用:可以隐藏表原来的信息
	* 分类
		* 私有同义词 
		* 公共同义词
```sql
	//给表t_user创建一个私有同义词
	create synonym my_test
	for t_user;
		
	//给用户briup授权可以查询my_test
	grant select 
	on my_test 
	to briup; 

	//收回用户briup查询my_test的权限
	revoke select 
	on my_test 
	from briup;
		
	//利用数据字典查看同义词synonyms
	//用户创建的同义词有哪些
	select synonym_name
	from user_synonyms;

	//用户有权利查询的同义词有哪些
	select synonym_name
	from all_synonyms;

	//用户有权利查询的同义词有哪些是以字母D开头的
	//注意:表中的数据都是大写存在
	select synonym_name
	from all_synonyms
	where synonym_name like 'D%';
	结果可以看到我们常用的dual
```
8. 删除同义词synonym
```sql
	drop synonym name;

	例如:
	删除私有同义词
	drop synonym my_test;
	删除公共同义词
	drop public synonym your_test;   
```