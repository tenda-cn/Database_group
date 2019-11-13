--电影
create table Movie(
	mID int primary key,
	mname nvarchar(20),
	movieLanguage nvarchar(10),
	duration nvarchar(20),		--时长
	area nvarchar(20),
	releaseTime date,
	othername nvarchar(100),
	content text,
	price float
)

--职员
create table Worker(
	wid int primary key,
	wcountry nvarchar(20),
	wname nvarchar(30),
)

--导演关系
create table direct(
	wid int,
	mID int,
	constraint d_prim primary key(wid, mID)
)

--出演关系
create table act(
	wid int,
	mID int,
	constraint a_prim primary key(wid, mID)
)

--编剧关系
create table author(
	wid int,
	mID int,
	constraint at_prim primary key(wid, mID)
)

--类型 type是关键字，故改为typ
create table Typ(
	typename nvarchar(30) primary key
)

--电影类型关系
create table mtype(
	mID int,
	typename nvarchar(30),
	constraint mt_prim primary key(mID, typename)
)

--标签
create table tag(
	tag nvarchar(30) primary key
)

--电影标签关系
create table mtag(
	mID int,
	tag nvarchar(30),
	constraint mtg_prim primary key(mID, tag)
)

drop table act
drop table author
drop table direct
drop table Movie
drop table mtag
drop table mtype
drop table tag
drop table Typ
drop table Worker