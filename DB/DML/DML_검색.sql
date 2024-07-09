use madangdb;

desc book; -- 테이블 구조 확인

-- <데이터 조작어: 검색 (SELECT)>
-- 순서: from -> where -> select
select *
  from customer
 where name = '김연아';

select name, address
  from customer
 where name = '김연아';

-- select 문법
/*
select [*, distinct, 컬럼명, 컬럼명]
  from
[where and]
[group by]
[having]
[order by]
*/

-- 3-1 select/from
select bookname, price
  from book;

-- 3-2
select bookid, bookname, price, publisher
  from book;

select *
  from book;

-- 3-3
select distinct publisher -- 중복 제거
  from book;

select count(distinct publisher)
  from book;

-- where booknmae like '축구의 역사' <= where bookname = '축구의 역사'
-- LIKE 사용 시 [%] 같이 사용
-- null <- 해당 컬럼에 값이 없는, != '';
-- null 체크 <= is null or is not null 사용 ( '= null' X)
-- 조건이 1개이면 where만 사용, 조건이 2개 이상이면 and, or 사용
-- 부정 not

-- 3-4 where
select *
  from book
 where price < 20000;
  
-- 3-5
select *
  from book
 where price >= 10000 and price <= 20000;
 
select *
  from book
 where pricet between 10000 and 20000;
 
-- 3-6
select *
  from book
 where publisher = '굿스포츠' or publisher = '대한미디어';
 
select *
  from book
 where publisher in ('굿스포츠', '대한미디어'); -- in 연산자 안에 subquery가 올 수 있다.
 
-- 부정
select *
  from book
 where publisher != '굿스포츠' and publisher != '대한미디어'; -- or X
 
 select *
  from book
 where publisher not in ('굿스포츠', '대한미디어');
 
-- 3-7
select *
  from book
 where bookname like '축구의 역사'; -- where bookname = '축구의 역사'

-- 3-8
select bookname, publisher
  from book
 where bookname LIKE '축구%';

select bookname, publisher
  from book
 where bookname LIKE '%이야기';

select bookname, publisher
  from book
 where bookname LIKE '%의%';
 
desc customer;
select *
  from customer
where name LIKE '%연%';

-- 3-9
select bookname, publisher
  from book
 where bookname LIKE '_구%';
 
 -- 3-10 복합조건
 select bookname, publisher
  from book
 where price >= 20000 and bookname like '%축구%';

-- 3-11
select *
  from book
 where publisher = '굿스포츠' or publisher = '대한미디어';
 
-- order by <= select가 확정된 후 처리
-- from -> where -> select -> order by 
-- 3-12 order by
select *
  from book
order by bookname; -- default : asc

-- 3-13
select *
 from book
order by price, bookname;

-- 3-14
select *
  from book
order by price desc, publisher asc;

-- 5가지 기본 함수 sum(), avg(), count(), max(), min()
-- 조건의 전체 또는 group by 로 묶어서 처리

-- 3-15 집계 함수
desc orders;
select sum(saleprice) as 총매출
  from orders;

-- alias (as)
select orderid as orderId, custid custId, bookid 'book id'
from orders;

-- 3-16
desc customer;
select sum(saleprice) as 총매출
   from orders
  where custid = (
	select custid
      from customer
	 where name = '김연아'
 );
 
select sum(saleprice) as 총매출
  from orders, customer
 where orders.custid = customer.custid and customer.name = '김연아';
 
select sum(saleprice) as 총매출
  from orders join customer on orders.custid = customer.custid
 where customer.name = '김연아';
 
-- 3-17
select sum(saleprice) Total, round(avg(saleprice)) Average, min(saleprice) Minimum, max(saleprice) Maximum
from orders;

-- 3-18 count(): null을 제외한 튜플의 개수
select count(*) totalCnt
from orders;

select count(*) yunaCnt
from orders
where custid = 2;

-- 3-19 group by : 전체 row를 쪼갠다. 어떻게? group by 뒤에 오는 조건으로.
select count(*)
from orders;

select custid, count(*) -- 10건을 custid로 쪼개서 각각 count(*), group by 절에 사용한 컬럼을 select에서 사용
from orders
group by custid;

select custid, bookid, count(*) -- group by 절에 사용하지 않은 컬럼은 select에서 사용 x (bookid)
from orders
group by custid;

select custid, count(*) 도서수량, sum(saleprice) 총액
from orders
group by custid;

-- 3-20 having
-- from -> where -> group by -> having -> select -> order by
select custid, count(*) 도서수량, sum(saleprice) 총액
from orders
group by custid
having custid in (1, 2);

select custid, count(*) 도서수량
from orders
where saleprice >= 8000
group by custid
having count(*) >= 2
order by custid;