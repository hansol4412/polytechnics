drop procedure if exists get_sum;
delimiter $$
create procedure get_sum(
	in _id integer,
    out _name varchar(20),
    out _sum integer
    )
BEGIN
	declare _kor integer;
	declare _eng integer;
	declare _mat integer;
	set _kor=0;
        
	select name, kor, eng, mat	
		into _name, _kor, _eng, _mat from examtable3 where id = _id;
	set _sum = _kor + _eng + _mat;
END $$
delimiter ;

call get_sum(209901, @name, @sum);
select @name, @sum;
    

            