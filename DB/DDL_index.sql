-- Index : 조회 속도 증가 but 추가/수정/삭제 속도 감소
select * from jdbc_big where col_1 = 123450; -- execution plan : PK
select count(*) from jdbc_big where col_2 = '강주상'; -- execution plan: full table scan -- 2.48 sec

-- 데이터 건수가 충분히 더 큰 테이블을 만들자.
create table jdbc_big_2 as select * from jdbc_big; -- 만건
insert into jdbc_big (col_2, col_3, col_4) select col_2, col_3, col_4 from jdbc_big_2;
select count(*) from jdbc_big; -- 2000만건

-- col_2에 대한 index 생성

select count(*) from jdbc_big where col_2 = '강주상'; -- 0.0098 sec
select count(*) from jdbc_big where col_2 like '%주상'; -- 2.026 sec : index 타지 않는다. execution plan : full index scan
select count(*) from jdbc_big where col_2 like '강주%'; -- 0.076 sec : index 탄다.

select count(*) from jdbc_big where col_2 = upper(col_2) = '강주상'; -- 3.282 sec : index 타지 않는다. execution plan : full index scan
select count(*) from jdbc_big where col_2 = upper('강주상'); -- 0.013 sec : index 탄다.
