use kopo41;
create table hubo(
	id int not null primary key,
    name varchar(20)
)default charset = utf8;
insert into hubo values (1, "김일등");
insert into hubo values (2, "김이등");
insert into hubo values (3, "김삼등");
insert into hubo values (4, "김사등");

select * from hubo;

drop table tupyo;
create table tupyo(
	id int not null,
    age int not null,
    foreign key (id) references hubo(id)
)default charset = utf8;

select * from tupyo;

select a.id, a.name, count(b.id), count(b.id)/(select count(*) from tupyo)*100 from hubo as a left join tupyo as b on a.id = b.id group by a.id;

drop procedure if exists insert_tupyo1;
delimiter $$
create procedure insert_tupyo1(_limit integer)
BEGIN
	declare _cnt integer;
    set _cnt=0;
    _loop: LOOP
		set _cnt = _cnt +1;
        insert into tupyo value (rand()*5+1, rand()*8+1);
        if _cnt = _limit then
			leave _loop;
		end if;
	END loop _loop;
END $$

call insert_tupyo1(1000);

select age as 나이, count(name) as 득표수, count(name)/(select count(*) from vote where name = '나연')*100 as 득표율
from vote where name = '나연' group by 나이 order by count(age) desc;


select age, count(id), count(id)/(select count(*) from tupyo where id =1)*100 from tupyo where id =1 group by age order by age;






