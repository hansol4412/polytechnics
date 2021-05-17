drop function if exists f_get_distance;
delimiter $$
create function  f_get_distance(_num integer,_lat double, _long double) returns double
BEGIN
declare p_lat double;
declare p_long double;
declare _dis double;
set p_lat = 37.3860521;
set p_long = 127.1214038;
	SELECT (6371*acos(cos(radians(p_lat))*cos(radians(latitude))*cos(radians(longtitude) -radians(p_long))+sin(radians(p_lat))*sin(radians(latitude)))) 
    into _dis FROM freewifi where num = _num;
return _dis;
END $$
delimiter ;
-- ---------------------------------------------------------------------------------------------------
drop procedure if exists wifi;
delimiter $$
create procedure wifi(_page integer, _count integer)
BEGIN 
declare _Num integer;
declare _start integer;
declare _overRange integer;
declare _totalcount integer;

set _totalcount = 0;
select count(*) into _totalcount from freewifi;
set _Num = _totalcount / _count;
set _start = (_page-1) * _count;
set _overRange = (_Num)*_count - _count;
    
    if _page < 1 then
		select num as 번호, place_addr_road as 주소, latitude as 위도, longtitude as 경도, f_get_distance(num, latitude, longtitude) as 거리 from freewifi limit 0,_count;
	elseif _page > _Num then
		select num as 번호, place_addr_road as 주소, latitude as 위도, longtitude as 경도, f_get_distance(num, latitude, longtitude) as 거리 from freewifi where num > _overRange+ _count;
	else
		select num as 번호, place_addr_road as 주소, latitude as 위도, longtitude as 경도, f_get_distance(num, latitude, longtitude) as 거리 from freewifi limit _start,_count;
	END if;

End $$
-- ------------------------------------------------------------------------------------------------
call wifi(500, 30);


select place_addr_road as 주소, latitude as 위도, longtitude as 경도 from freewifi limit 0,30;
select count(*) from freewifi;


SELECT (6371*acos(cos(radians(37.3860521))*cos(radians(latitude))*cos(radians(longtitude) -radians(127.1214038))+sin(radians(37.3860521))*sin(radians(latitude)))) AS distance FROM freewifi

select f_get_distance(num, latitude, longtitude) as 거리 from freewifi limit 0,30;