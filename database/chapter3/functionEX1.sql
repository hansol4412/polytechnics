show global variables like 'log_bin_trust_function_creators';
set global log_bin_trust_function_creators = 'ON';

drop function if exists f_get_sum;
delimiter $$
create function f_get_sum(_id integer) returns integer
BEGIN
	declare _sum integer;
    select kor+eng+mat into _sum from examtable3 where id = _id;
return _sum;
END $$
delimiter ;

select * , f_get_sum(id) from examtable3 ;
