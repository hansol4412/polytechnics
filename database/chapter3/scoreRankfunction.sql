drop function if exists f_get_score;

delimiter $$
create function f_get_score(_sum integer) returns integer
BEGIN
declare _num integer;
declare _cnt integer;
declare _id integer;
declare _sumRank integer;
set _cnt=0;
set _num = 1;
	_loop: LOOP
		set _cnt = _cnt+1;
        set _id = 209900 + _cnt;
        select kor+eng+mat into _sumRank from examtable3 where id = _id;
        
        if _sum < _sumRank then
			set _num = _num+1;
		END if;
	
        if _cnt=1000 then
			leave _loop;
		END if;
	End Loop _loop;
	return _num;
END $$
delimiter ;


 select *, kor+eng+mat as sum, (kor+eng+mat)/3 as avg, f_get_score(kor+eng+mat) as 순위 from examtable3 order by sum;