drop function if exists f_get_score1;
delimiter $$
create function f_get_score1(_sum integer) returns integer
BEGIN
declare _num integer;
declare _cnt integer;
declare _id integer;
declare _sumRank integer;
set _cnt=0;
set _num = 1;
	_loop: LOOP
		set _cnt = _cnt+1;
        set _id = _cnt;
        select kor+eng+mat into _sumRank from grade where studentid = _id;
        
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
-- ----------------------------------------------------------------------------------------
drop procedure if exists sum_avg;
delimiter $$
create procedure sum_avg(_start integer, _finish integer)
BEGIN 
	drop table if exists sumavg;
    create table sumavg (kor int, eng int, mat int, sum int, avg double);
    insert into sumavg select sum(kor), sum(eng), sum(mat), (sum(kor) +  sum(eng) + sum(mat)), (sum(kor) +  sum(eng) + sum(mat))/3 from grade where studentid >= _start and studentid <= _finish;
	insert into sumavg select avg(kor), avg(eng), avg(mat), (avg(kor) +  avg(eng) + avg(mat)), (avg(kor) +  avg(eng) + avg(mat))/3 from grade where studentid >= _start and studentid <= _finish;
	insert into sumavg select sum(kor), sum(eng), sum(mat), (sum(kor) +  sum(eng) + sum(mat)), (sum(kor) +  sum(eng) + sum(mat))/3 from grade where studentid >= 0 and studentid <=_finish;
	insert into sumavg select avg(kor), avg(eng), avg(mat), (avg(kor) +  avg(eng) + avg(mat)), (avg(kor) +  avg(eng) + avg(mat))/3 from grade where studentid >= 0 and studentid <= _finish;
End $$
-- ----------------------------------------------------------------------------------------
drop procedure if exists grade_print;
delimiter $$
create procedure grade_print(_page integer, _count integer)
BEGIN 
declare _Num integer;
declare _start integer;
declare _over integer;
declare _overRange integer;

set _Num = 1000 / _count;
set _start = (_page-1) * _count;
set _over = (_Num)*_count;
set _overRange = _over - _count;
	
    if _page < 1 then
		select studentid as 번호, name as 이름, kor as 국어, eng as 영어, mat as 수학 , 
        (kor + eng + mat) as 총점,  (kor + eng + mat)/3 as 평균, f_get_score1(kor+eng+mat) as 순위 from grade limit 0,_count;
        call sum_avg(0, _count);
	elseif _page > _Num then
		select studentid as 번호, name as 이름, kor as 국어, eng as 영어, mat as 수학,
         (kor + eng + mat) as 총점,  (kor + eng + mat)/3 as 평균, f_get_score1(kor+eng+mat) as 순위 from grade where studentid > _overRange;
         call sum_avg(_overRange+1, 1000);
	else
		select studentid as 번호, name as 이름, kor as 국어, eng as 영어, mat as 수학,
         (kor + eng + mat) as 총점,  (kor + eng + mat)/3 as 평균, f_get_score1(kor+eng+mat) as 순위 from grade limit _start,_count;
         call sum_avg(_start+1, _start + _count);
	END if;
    
    select * from sumavg;

End $$

call grade_print(50, 25);

select * from grade;
