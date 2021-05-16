-- use kopo41;
-- drop table if exists examtable3;
-- create table examtable3(
-- 	name varchar(20),
--     id int not null primary key,
--     kor int,
--     eng int,
--     mat int);
--     desc examtable;

-- delete from examtable3 where id >0;
-- insert into examtable3 value ("나연", 209901, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("정연", 209902, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("모모", 209903, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("사나", 209904, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("지효", 209905, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("미나", 209906, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("다현", 209907, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("채영", 209908, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("쯔위", 209909, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("송가인", 209910, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("나연", 209911, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("정연", 209912, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("모모", 209913, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("사나", 209914, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("지효", 209915, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("미나", 209916, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("다현", 209917, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("채영", 209918, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("쯔위", 209919, rand()*100, rand()*100, rand()*100);
-- insert into examtable3 value ("송가인", 209920, rand()*100, rand()*100, rand()*100);

-- select * from examtable3;
--  select * from examtable3 order by kor;
-- select * from examtable3 order by eng;
-- select * from examtable3 order by kor,eng;
-- select * from examtable3 order by kor asc;
-- select * from examtable3 order by kor desc;
-- select * from examtable3 order by name desc;
-- select * from examtable3 order by mat desc;
-- select *, kor+eng+mat, (kor+eng+mat)/3  from examtable3
-- select *, kor+eng+mat, (kor+eng+mat)/3  from examtable3 order by (kor+eng+mat) desc;
-- select *, kor+eng+mat as total, (kor+eng+mat)/3 as average 
-- from examtable3 order by total desc;

-- select name as 이름, id as 학번, kor as 국어, eng as 영어, mat as 수학,
-- kor+eng+mat as 합계, (kor+eng+mat)/3 as 평균 from examtable3 order by 합계 desc;  

-- select * from examtable3 group by name; 
-- select name, count(name) from examtable3 group by name; 
-- select * from examtable3 group by kor;
-- select kor, count(kor) from examtable3 group by kor;
-- select kor, count(kor) from examtable3 group by eng;
-- select  kor, count(kor), eng, count(eng) from examtable3 group by kor, eng;
-- select eng, count(eng) from examtable3 group by eng;

-- insert into examtable3 value ("팽수", 209921, 100, 90, rand()*100);
-- insert into examtable3 value ("팽수", 209922, 100, 90, rand()*100);
-- select kor, count(kor), eng, count(eng) from examtable3 group by name, kor, eng;

-- select name, count(name), kor, count(kor), eng, count(eng) from examtable3 
-- group by name, kor, eng;

-- select *, name, count(name), kor, count(kor), eng, count(eng) from examtable3 
-- group by name, kor, eng;

-- select eng, count(eng) from examtable3 group by eng having count(eng) > 1;







    
    