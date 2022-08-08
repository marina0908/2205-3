1. 创建数据库newdb1, 字符集utf8并使用
create database newdb1 charset=utf8;
2. 在数据库中创建员工表emp 字段:id,name,sal(工资),deptId(部门id) 字符集utf8
create table emp(id int,name varchar (20),sal int,deptID int);
3. 创建部门表dept 字段:id,name,loc(部门地址) 字符集utf8
create table dept(id int,name varchar (20),loc varchar (20));
4. 部门表插入以下数据: 1 神仙部 天庭       2 妖怪部  盘丝洞
insert into dept values(1,"神仙部","天庭"),(2,"妖怪部","盘丝洞");
5. 员工表插入一下数据:  1 悟空 5000 1  ,   2 八戒  2000  1  ,3 蜘蛛精 8000  2  ,  4 白骨精 9000  2
isert into emp values(1,"悟空",5000,1),(2,"八戒",5000,1),(3,"蜘蛛精",5000,2),(4,"白骨精",5000,12;
6. 查询工资6000以下的员工姓名和工资
select name,sal from emp where sal<6000;
7. 修改神仙部的名字为取经部
update dept set name="取经部" where name="神仙部";
8. 给员工表添加奖金comm字段
alter table emp add comm int;
9. 修改员工表中部门id为1的 奖金为500
update emp set comm=500 where deptID=1;
10. 把取经部的地址改成五台山
update dept set loc="五台山" where name="取经部";
11. 修改奖金字段为性别gender字段 类型为varchar(5)
alter table emp comm gender varchar (5);
12. 修改孙悟空和猪八戒性别为男
update emp set dender="男" where deptID=1;
13. 删除没有性别的员工
delete emp where gender is null;
14. 删除性别字段
alter table emp dorp gender;
15. 删除表  和 删除数据库
dorp table emp;
drop table dept;
drop database newdb1;


