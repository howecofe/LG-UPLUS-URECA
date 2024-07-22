-- View
-- 필요에 의해 select 문을 작성
select o.orderid, o.custid, o.bookid, b.bookname, o.saleprice, o.orderdate
 from customer c, orders o, book b
where c.custid = o.custid
  and b.bookid = o.bookid;

-- 자주 반복적으로 사용 -> 하나의 view 로 만들어서 사용
create view Vorder
as
select o.orderid, o.custid, o.bookid, b.bookname, o.saleprice, o.orderdate
 from customer c, orders o, book b
where c.custid = o.custid
  and b.bookid = o.bookid;
  
-- view 사용
select * from Vorder;

-- view 사용 + 조건 ==> 가상의 테이블로 사용
select * from Vorder
 where saleprice > 10000;
 
-- view 수정, 삭제 ==> DB마다 다르다. 일반적으로 지원 x (read only)

-- view의 내부 쿼리 수행
select sub.* from (
	-- view 생성 select
	select o.orderid, o.custid, o.bookid, b.bookname, o.saleprice, o.orderdate
	 from customer c, orders o, book b
	where c.custid = o.custid
	  and b.bookid = o.bookid
	) sub
where sub.saleprice > 10000;

create view Vbook
as (
	select *
	  from book
	 where bookname like '%축구%'
);

select * from Vbook;

-- alter
create or replace view Vorder
as
select o.orderid, o.custid, c.name custname, o.bookid, b.bookname, o.saleprice, o.orderdate
 from customer c, orders o, book b
where c.custid = o.custid
  and b.bookid = o.bookid;

select * from Vorder;

-- 권한 이슈(교재: 보안, 독립)
