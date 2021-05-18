use kopo41;
drop table if exists answer;
create table answer (
	subjectID int not null primary key,
	a01 int, a02 int, a03 int, a04 int, a05 int, a06 int, a07 int, a08 int,
    a09 int, a10 int, a11 int, a12 int, a13 int, a14 int, a15 int, a16 int,
    a17 int, a18 int, a19 int, a20 int
);

drop table if exists testing;
create table testing(
	subjectID int not null,
    stu_name varchar(50),
    stu_id int not null,
    a01 int, a02 int, a03 int, a04 int, a05 int, a06 int, a07 int, a08 int,
    a09 int, a10 int, a11 int, a12 int, a13 int, a14 int, a15 int, a16 int,
    a17 int, a18 int, a19 int, a20 int,
    primary key(subjectID, stu_name)
);

drop table if exists scoring;
create table scoring(
	subjectID int not null,
    stu_name varchar(50),
    stu_id int not null,
    a01 int, a02 int, a03 int, a04 int, a05 int, a06 int, a07 int, a08 int,
    a09 int, a10 int, a11 int, a12 int, a13 int, a14 int, a15 int, a16 int,
    a17 int, a18 int, a19 int, a20 int,
    score int,
    primary key (subjectID, stu_name)
);

drop table if exists reporttable;
create table reporttable (
	stu_name varchar(50),
    stu_id int not null,
    kor int,
    eng int,
    mat int
)

-- --------------------------------------------------
insert into answer value (1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
							  rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);  # 국어

insert into answer value (2, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
							  rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);  # 영어

insert into answer value (3, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
							  rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);  # 수학
                              
select * from answer;

-- -----------------------------------------------------
drop procedure if exists insert_test;
delimiter $$
create procedure insert_test(_limit integer)
BEGIN
	declare _name varchar(20);
	declare _id integer;
	declare _cnt integer;
    set _cnt=0;
    _loop: LOOP
		set _cnt = _cnt +1;
        set _name = concat("홍길", cast(_cnt as char(4))) ;
		set _id = 209900 + _cnt;
		insert into testing value (1, _name, _id, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
									 rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);
		insert into testing value (2, _name, _id, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
									 rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);
		insert into testing value (3, _name, _id, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, 
									 rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1, rand()*3+1);
        if _cnt = _limit then
			leave _loop;
		end if;
	END loop _loop;
END $$
call insert_test(1000);
select * from testing order by stu_id, subjectID;
select count(*) from testing;
use kopo41;
--   -------------------------------------------------------------------------------------------------------------------------------------------
drop procedure if exists insert_score;
delimiter $$
create procedure insert_score(_limit integer)
BEGIN
	declare _id integer;
	declare _cnt integer;
    set _cnt=0;
    _loop: LOOP
		set _cnt = _cnt +1;
		set _id = 209900 + _cnt;
		insert into scoring select t.subjectID, t.stu_name, t.stu_id, t.a01 = a.a01, t.a02 = a.a02, t.a03 = a.a03, t.a04 = a.a04, t.a05 = a.a05,
								   t.a06 = a.a06, t.a07 = a.a07, t.a08 = a.a08, t.a09 = a.a09, t.a10 = a.a10, t.a11 = a.a11, t.a12 = a.a12,
								   t.a13 = a.a13, t.a14 = a.a14, t.a15 = a.a15, t.a16 = a.a16, t.a17 = a.a17, t.a18 = a.a18, t.a19 = a.a19, t.a20 = a.a20,
                                  ((t.a01 = a.a01) + (t.a02 = a.a02)   + (t.a03 = a.a03)   +( t.a04 = a.a04)  + (t.a05 = a.a05) +
								   (t.a06 = a.a06) +( t.a07 = a.a07) +( t.a08 = a.a08) + (t.a09 = a.a09) + (t.a10 = a.a10) +( t.a11 = a.a11) + (t.a12 = a.a12)  +
								   (t.a13 = a.a13) +( t.a14 = a.a14) +( t.a15 = a.a15) + (t.a16 = a.a16) + (t.a17 = a.a17)  +( t.a18 = a.a18) + (t.a19 = a.a19) + (t.a20 = a.a20)) *5
                                   from testing as t, answer as a where t.subjectID = 1 and  a.subjectID  =1 and t.stu_id = _id ;
insert into scoring select t.subjectID, t.stu_name, t.stu_id, t.a01 = a.a01, t.a02 = a.a02, t.a03 = a.a03, t.a04 = a.a04, t.a05 = a.a05,
								   t.a06 = a.a06, t.a07 = a.a07, t.a08 = a.a08, t.a09 = a.a09, t.a10 = a.a10, t.a11 = a.a11, t.a12 = a.a12,
								   t.a13 = a.a13, t.a14 = a.a14, t.a15 = a.a15, t.a16 = a.a16, t.a17 = a.a17, t.a18 = a.a18, t.a19 = a.a19, t.a20 = a.a20,
                                  ((t.a01 = a.a01) + (t.a02 = a.a02)   + (t.a03 = a.a03)   +( t.a04 = a.a04)  + (t.a05 = a.a05) +
								   (t.a06 = a.a06) +( t.a07 = a.a07) +( t.a08 = a.a08) + (t.a09 = a.a09) + (t.a10 = a.a10) +( t.a11 = a.a11) + (t.a12 = a.a12)  +
								   (t.a13 = a.a13) +( t.a14 = a.a14) +( t.a15 = a.a15) + (t.a16 = a.a16) + (t.a17 = a.a17)  +( t.a18 = a.a18) + (t.a19 = a.a19) + (t.a20 = a.a20)) *5
                                   from testing as t, answer as a where t.subjectID = 2 and  a.subjectID  =2 and t.stu_id = _id ;
insert into scoring select t.subjectID, t.stu_name, t.stu_id, t.a01 = a.a01, t.a02 = a.a02, t.a03 = a.a03, t.a04 = a.a04, t.a05 = a.a05,
								   t.a06 = a.a06, t.a07 = a.a07, t.a08 = a.a08, t.a09 = a.a09, t.a10 = a.a10, t.a11 = a.a11, t.a12 = a.a12,
								   t.a13 = a.a13, t.a14 = a.a14, t.a15 = a.a15, t.a16 = a.a16, t.a17 = a.a17, t.a18 = a.a18, t.a19 = a.a19, t.a20 = a.a20,
                                  ((t.a01 = a.a01) + (t.a02 = a.a02)   + (t.a03 = a.a03)   +( t.a04 = a.a04)  + (t.a05 = a.a05) +
								   (t.a06 = a.a06) +( t.a07 = a.a07) +( t.a08 = a.a08) + (t.a09 = a.a09) + (t.a10 = a.a10) +( t.a11 = a.a11) + (t.a12 = a.a12)  +
								   (t.a13 = a.a13) +( t.a14 = a.a14) +( t.a15 = a.a15) + (t.a16 = a.a16) + (t.a17 = a.a17)  +( t.a18 = a.a18) + (t.a19 = a.a19) + (t.a20 = a.a20)) *5
                                   from testing as t, answer as a where t.subjectID = 3 and  a.subjectID  =3 and t.stu_id = _id ;
					
        if _cnt = _limit then
			leave _loop;
		end if;
	END loop _loop;
END $$
call insert_score(1000);
select * from scoring order by stu_id, subjectID;

 select count(*) from scoring;

-- -------------------------------------------------------------------------------------------------------------------------------------------------------
drop procedure if exists insert_reporttable;
delimiter $$
create procedure insert_reporttable(_limit integer)
BEGIN
	declare _name varchar(20);
	declare _id integer;
	declare _cnt integer;
    declare _kor integer;
    declare _eng integer;
    declare _mat integer;
    set _cnt=0;
    _loop: LOOP
		set _cnt = _cnt +1;
        set _name = concat("홍길", cast(_cnt as char(4))) ;
		set _id = 209900 + _cnt;
        set _kor = 0;
        set _eng = 0;
        set _mat = 0;
        
        select score into _kor from scoring where subjectID = 1 and stu_id =  _id;
        select score into _eng from scoring where subjectID = 2 and stu_id =  _id;
        select score into _mat from scoring where subjectID = 3 and stu_id =  _id;
        
		insert into reporttable value (_name, _id, _kor, _eng, _mat);

        if _cnt = _limit then
			leave _loop;
		end if;
	END loop _loop;
END $$

call insert_reporttable(1000);

select * , (b.kor+b.eng+b.mat) as sum, (b.kor+b.eng+b.mat)/3 as avg, 
(select count(*)+1 from reporttable as a where (a.kor+a.eng+a.mat) > (b.kor+b.eng+b.mat)) as ran
 from reporttable as b order by sum;
-- ---------------------------------------------------------------------------------------------------------------
drop table if exists test_result;
create table test_result (
	subjectID int,
	testNum varchar(20),
    count int,
    rate double
);

drop procedure if exists result_test;
delimiter $$
create procedure result_test()
BEGIN
	declare _cnt integer;
	declare _subjectID integer;
    declare _num varchar(20);
    declare _count integer;
    declare _rate double;
    set _subjectID=0;
    _loop: LOOP
		set _subjectID = _subjectID +1;
        set _cnt = 0;
            select count(*) into _count from scoring where subjectID = _subjectID and a01 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a01 =  1;
			insert into test_result values (_subjectID, 'a01', _count, _rate);
            
            select count(*) into _count from scoring where subjectID = _subjectID and a02 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a02 =  1;
			insert into test_result values (_subjectID, 'a02', _count, _rate);
            
            select count(*) into _count from scoring where subjectID = _subjectID and a03 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a03 =  1;
			insert into test_result values (_subjectID, 'a03', _count, _rate);
            
            select count(*) into _count from scoring where subjectID = _subjectID and a04 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a04 =  1;
			insert into test_result values (_subjectID, 'a04', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a05 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a05 =  1;
			insert into test_result values (_subjectID, 'a05', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a06 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a06 =  1;
			insert into test_result values (_subjectID, 'a06', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a07 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a07 =  1;
			insert into test_result values (_subjectID, 'a07', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a08 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a08 =  1;
			insert into test_result values (_subjectID, 'a08', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a09 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a09 =  1;
			insert into test_result values (_subjectID, 'a09', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a10 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a10 =  1;
			insert into test_result values (_subjectID, 'a10', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a11 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a11 =  1;
			insert into test_result values (_subjectID, 'a11', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a12 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a12 =  1;
			insert into test_result values (_subjectID, 'a12', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a13 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a13 =  1;
			insert into test_result values (_subjectID, 'a13', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a14 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a14 =  1;
			insert into test_result values (_subjectID, 'a14', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a15 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a15 =  1;
			insert into test_result values (_subjectID, 'a15', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a16 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a16 =  1;
			insert into test_result values (_subjectID, 'a16', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a17 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a17 =  1;
			insert into test_result values (_subjectID, 'a17', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a18 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a18 =  1;
			insert into test_result values (_subjectID, 'a18', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a19 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  194 =  1;
			insert into test_result values (_subjectID, 'a19', _count, _rate);
            
             select count(*) into _count from scoring where subjectID = _subjectID and a20 = 1;
			select count(*)/(select count(*) from scoring)*100 into _rate from scoring where subjectID = _subjectID and  a20 =  1;
			insert into test_result values (_subjectID, 'a20', _count, _rate);

        
        if _subjectID = 3 then
			leave _loop;
		end if;
	END loop _loop;
END $$
call result_test();

select * from test_result;
  select * from scoring;                               
 select count(*) from scoring where subjectID = 1 and a03 =  1;
select count(*)/(select count(*) from scoring)*100  from scoring where subjectID = 1 and a01 =  1;










