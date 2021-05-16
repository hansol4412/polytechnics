drop procedure if exists insert_examtable;
delimiter $$
create procedure insert_examtable(_last integer)
BEGIN 
declare _name varchar(20);
declare _id integer;
declare _cnt integer;
set _cnt=0;
delete from examtable3 where id > 0 ;
	_loop: LOOP
		set _cnt = _cnt+1;
        set _name = concat("홍길", cast(_cnt as char(4))) ;
        set _id = 209900 + _cnt;
        
        insert into examtable3 value (_name, _id, rand()*100, rand()*100, rand()*100);
        
        if _cnt=_last then
			leave _loop;
		END if;
	End Loop _loop;
End $$

call insert_examtable(1000);
select * from examtable3;
select *, kor+eng+mat as sum, (kor+eng+mat)/3 as ave from examtable3 Limit 30,59;
        