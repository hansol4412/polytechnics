use kopo41;
drop table if exists reservation;
create table reservation (
	name varchar(20) not null,
    reserve_date date not null,
    room integer not null,
    addr varchar(100),
    tel varchar(20),
    ipgum_name varchar(20),
    memo varchar(100),
    input_date date,
    primary key(name, reserve_date, room)
);
desc reservation;

insert into reservation values ("나연","2021-05-16", 1, "서울 강남구", "010-1111-2222", "나연", "따뜻한방 주세요", current_date());
insert into reservation values ("모모","2021-05-27", 2, "서울 강남구", "010-1111-3333", "모모", "따뜻한방 주세요", current_date());
insert into reservation values ("다현","2021-06-30", 3, "서울 강남구", "010-2222-2222", "다현", "따뜻한방 주세요", current_date());
insert into reservation values ("쯔위","2021-07-16", 1, "서울 강남구", "010-3333-2222", "사나", "따뜻한방 주세요", current_date());

select * from reservation;

-- --------------------------------------------------------------------------------------------------------------
drop procedure if exists reserve_calc;
delimiter $$
create procedure reserve_calc()
begin
	declare _date date;
    declare _cnt integer;
    declare _room1 varchar(20);
    declare _room2 varchar(20);
    declare _room3 varchar(20);
    set _cnt = 0;
    
    drop table if exists reserve_stat;
    create table reserv_stat(
		reserve_date date not null,
        room1 varchar(20),
        room2 varchar(20),
        room3 varchar(20),
        primary key(reserve_date)
        );
        
	 _loop: LOOP
		set _cnt = _cnt +1;
        set _date = date_add(now(), interval 1 day);
		if (select exists (select * from reservation where reserve_date = _date and room = 1) as success) = 1 then
			select name into _room1 from reservation  where reserve_date = _date and room = 1;
		else
			set _room1 = "예약가능";
        end if;
        
        if (select exists (select * from reservation where reserve_date = _date and room = 2) as success) = 1 then
			select name into _room2 from reservation  where reserve_date = _date and room = 2;
		else
			set _room2 = "예약가능";
        end if;
        
        if (select exists (select * from reservation where reserve_date = _date and room = 3) as success) = 1 then
			select name into _room3 from reservation  where reserve_date = _date and room = 3;
		else
			set _room3 = "예약가능";
        end if
        insert into reservation values (_date, _room1, _romm2, _room3);
        if _cnt = 30 then
			leave _loop;
		end if;
	END loop _loop;
	
    end $$
    
    call reserve_calc();

use kopo41;

select reserve_date, date_add(reserve_date, interval 1 day) from reservation;
select exists (select * from reservation where reserve_date ="2021-05-16" and room = 1) as success;















