-- use kopo41;
-- drop table if exists vote;
-- create table vote(
-- 	name varchar(20),
--     age int
-- );

-- drop procedure if exists insert_vote;
-- delimiter $$
-- create procedure insert_vote(_last integer)
-- BEGIN 
-- declare _numName integer;
-- declare _name varchar(20);
-- declare _cnt integer;
-- set _cnt=0;

-- -- delete from vote where age > 0 ;
-- 	_loop: LOOP
-- 		set _cnt = _cnt+1;
--         set _numName = rand()*8+1;
--         
--          if _numName = 1 then
-- 			set _name = '나연';
-- 		elseif _numName = 2 then
-- 			set _name = '정연'; 
-- 		elseif _numName = 3 then
-- 			set _name = '모모'; 
-- 		elseif _numName = 4 then
-- 			set _name = '사나'; 
-- 		elseif _numName = 5 then
-- 			set _name = '지효'; 
-- 		elseif _numName = 6 then
-- 			set _name = '미나'; 
-- 		elseif _numName = 7 then
-- 			set _name = '다현'; 
-- 		elseif _numName = 8 then
-- 			set _name = '채영'; 
-- 		else 
-- 			set _name = '쯔위'; 
-- 		END if;
--         
--         insert into vote value (_name, rand()*8+1);

--         if _cnt=_last then
-- 			leave _loop;
-- 		END if;
-- 	End Loop _loop;
-- End $$

-- call insert_vote(1000);

-- select * from vote;


use kopo41;

drop function if exists f_rate_all;
delimiter $$
create function f_rate_all(_name varchar(20)) returns double
BEGIN
	declare _rate double;
    select (count(name)/(select count(*) from vote)*100) into _rate from vote where name = _name;
return _rate;
END $$
delimiter ;

select name as 이름, count(name) as 득표수, f_rate_all(name) as 득표율
from vote group by name order by count(name) desc;

-- -----------------------------------------------------------------------------------------------------

-- drop function if exists f_rate_member;
-- delimiter $$
-- create function f_rate_member(_name varchar(20)) returns double
-- BEGIN
-- 	declare _rate double;
--     select ((count(name)/(select count(*) from vote where name = _name ))*100) into _rate from vote where name = _name;
-- return _rate;
-- END $$
-- delimiter ;


-- select age as 나이, count(name) as 득표수,  f_rate_member('나연') as 득표율
-- from vote where name = '나연' group by 나이 order by count(age) desc;

-- select age as 나이, count(name) as 득표수, count(name)/(select count(*) from vote where name = '나연')*100 as 득표율
-- from vote where name = '나연' group by 나이 order by count(age) desc;


