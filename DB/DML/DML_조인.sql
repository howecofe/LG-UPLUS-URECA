-- JOIN vs SubQuery
-- 어느 방법이 더 빠르냐? 일반적으로 JOIN이 효율이 더 좋다.

-- JOIN

-- Cartesian Product
select * from customer; -- 1건

select * from customer, orders; -- 1건 : customer 1건 X orders 1건

select * from customer, orders, book; -- 1건 : customer 1건 X orders 1건 X book 1건

-- customer 2 insert, book 2 insert 후
select * from customer, orders, book; -- 4건 : customer 2건 X orders 1건 X book 2건 

select *
  from customer, orders, book
 where customer.custid = orders.custid; -- 2건 : customer 1건 X orders 1건 X book 2건
 
select *
  from customer, orders, book
 where customer.custid = orders.custid
   and orders.bookid = book.bookid; -- 1건 : customer 1건 X orders 1건 X book 1 건
 
select customer.custid, customer.name, orders.saleprice, book.bookname
  from customer, orders, book
 where customer.custid = orders.custid
   and orders.bookid = book.bookid; -- 1건 : customer 1건 X orders 1건 X book 1건

select customer.custid, customer.name, orders.saleprice, book.bookname
  from customer, orders, book
 where customer.custid > 1
   and customer.custid = orders.custid
   and orders.bookid = book.bookid; -- 0건 : customer 1건 X orders 1건 처리 중 orders에는 custid가 1만 존재하기 때문

-- 데이터 원복

-- 3-21
select *
  from customer, orders -- 5 X 10 = 50건
 where customer.custid = orders.custid; -- 1 X 10 = 10건

-- 3-22, 3-23
-- 이름으로 정렬
select *
from customer, orders
where customer.custid = orders.custid
order by customer.name desc;

-- 이름으로 asc 정렬, 이름이 같으면판매가격으로 내림차순 정렬
select *
from customer, orders
where customer.custid = orders.custid
order by customer.name asc, orders.saleprice desc;

-- table alias
select *
from customer c, orders o
where c.custid = o.custid
order by c.name asc, o.saleprice desc;

-- table alias 생략한 컬럼에 대해 유추
select c.name, saleprice
from customer c, orders o
where c.custid = o.custid
order by c.name asc, o.saleprice desc;

-- ambiguous column
select c.name, custid -- 오류 발생
from customer c, orders o
where c.custid = o.custid
order by c.name asc, o.saleprice desc;

-- 3-24
-- 동명이인이 있을 경우 고객이 중복 처리된다.
select c.name, sum(o.saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
order by c.name;

select c.name, sum(o.saleprice) -- key 컬럼에 대한 group by 절은 가장 세분화된 group by가 되므로 select에 다른 컬럼이 와도 문제 X
from customer c, orders o
where c.custid = o.custid
group by c.custid -- key column
order by c.name;

select c.name, sum(o.saleprice) -- gropu by 절의 phone과 name이 맞지 않는다. phone이 와야 한다.
from customer c, orders o
where c.custid = o.custid
group by c.phone -- non key column
order by c.phone;

-- 3-25
-- 아래 두 쿼리는 결과가 같고 수행계획도 같다. 단, mysql 기준
-- dbms가 달라지면 다른 결과를 낳을 수 있다.
select c.name, b.bookname
from customer c, book b, orders o
where c.custid = o.custid
and b.bookid = o.bookid;

select c.name, b.bookname
from customer c, book b, orders o
where o.custid = c.custid
and o.bookid = b.bookid;

-- ANSI SQL JOIN
select c.name, o.saleprice
from customer c, orders o
where c.custid = o.custid;

select c.name, o.saleprice
from customer c inner join orders o
where c.custid = o.custid;

select c.name, o.saleprice
from customer c inner join orders o on c.custid = o.custid;

-- 3개 테이블 조인
select c.name, b.bookname
from customer c inner join orders o on o.custid = c.custid
				join book b on o.bookid = b.bookid;

-- 셀프 조인 (<- inner join)
-- 공통코드 관리에서도 많이 사용
-- hr database / employees table 기준
-- first_name이 'Alexander', last_name이 'Hunold'인 사람이 관리하는 사원들 목록
select staff.*
from employees staff, employees manager
where manager.first_name = 'Alexander'
	and manager.last_name = 'Hunold'
    and staff.manager_id = manager.employee_id;

-- 3-26 
select c.name, b.bookname
from customer c, orders o, book b
where c.custid = o.custid
	and b.bookid = o.bookid
    and b.price = 20000;

-- 3-27 : outer join
-- inner join 관계가 없는 데이터도 나오도록 쿼리 수행
-- 주문하지 않은 박세도 나온다.
-- left outer join (왼쪽 테이블 기준으로 관계가 없어도 출력)
select c.name, o.saleprice
from customer c left outer join orders o on c.custid = o.custid;

-- inner join : 아래의 쿼리는 주문한 사람만 나온다. (주문하지 않은 박세리는 안 나온다.)
select c.name, o.saleprice
from customer c join orders o on c.custid = o.custid;

-- 휴가 안 간 사원 목록
-- 휴가 테이블에 어떤 사원이 언제 신청했고, 얼마 기간의 휴가를 사용, 사용중...
-- 휴가를 가지 않은 사원을 포함한 전체 목록을 조회하려면 [사원 테이블 left outer join 휴가 테이블]

-- 즐겨찾기 장소 관계에서 사용자가 즐겨찾기 등록한 장소를 그렇지 않은 장소와 함께 조회해서 별도로 표시할 경우
-- 장소 기준 left outer join 즐겨찾기 형태로 처리해야 원래 보여주려던 장소 목록을 출력할 수 있다.
-- 가령 장소가 100만개, 즐겨찾기 1000만개

-- ----------------------------------------------------------------------------

-- 3-28 : subquery : query의 일부가 별도의 완성적인 query
select max(price) -- 가장 비싼 도서의 가격 (35000)
from book;

select bookname
from book
where price = 35000;

select bookname
from book
where price = (select max(price) from book);

-- subquery 부분만 고려
select max(price) from book; -- 단일행, 단일열
select bookid, bookname from book; -- 다중행, 다중열
select bookid from book; -- 다중행, 단일열
select bookid, bookname from book where bookid = 3; -- 단일행, 다중열

-- Subquery returns more than 1 row. <- 오류메세지
-- 해결 : subquery가 복수개의 row return할 경우, 대응되는 왼쪽의 컬럼에 in 사용
select bookname
from book
where price = (select price from book);

select bookname
from book
where price in (select price from book);

-- Operand should contain ~~~ 
-- 해결 : subquery의 return column과 대응되는 왼쪽 컬럼의 수가 맞지 않는 경우이므로, 갯수를 동일하게 맞춰준다.
select bookname
from book
where (bookid, bookname) in (select bookid, bookname from book);

-- 3-29
-- 도서를 주문한 고객의 이름
select name
from customer
where custid in (select distinct custid from orders); -- 메모리 성능 측면에서 subqeury 자체에서 distinct를 써주는 것이 좋다.

-- 위 subquery를 join 형태로 변경
select customer.name -- 10명의 중복 포함 고객의 이름
from customer, orders
where customer.custid = orders.custid;

select distinct customer.name -- distinct로 중복 제거
from customer, orders
where customer.custid = orders.custid;

-- subquery는 메모리에 적재한 후 처리 (io disk swaping)
-- <= subquery는 메모리에 적재 후 처리되므로 매우 빠르게 처리된다. 하지만 메모리 자원을 낭비한다.

-- 3-30
-- 3개의 테이블을 모두 사용
-- subquery
select name
from customer
where custid in (
	select distinct custid from orders where bookid in (
		select distinct bookid from book where publisher = '대한미디어'
    )
);

-- join 으로 1: orders, book join
select name
from customer
where custid in (
	select o.custid
	from orders o, book b
	where o.bookid = b.bookid
		and b.publisher = '대한미디어'
);

-- join 으로 2: customer, orders, book 3 테이블 모두 join
select c.name
from customer c, orders o, book b
where o.custid = c.custid
	and o.bookid = b.bookid
	and b.publisher = '대한미디어';

-- 3-31 상관 서브쿼리 (중요!!)
-- 출판사별로 출판사의 평균 도서 가격보다 비싼 도서를 구하시오.
select b1.*
from book b1
where b1.price > (select avg(b2.price) from book b2 where b2.publisher = b1.publisher);

select b1.*
from book b1, (
			select publisher, avg(price) avg_price
            from book
            group by publisher
			) b2
where b1.publisher = b2.publisher
	and b1.price > b2.avg_price;

select b1.*
from book b1 join (select publisher, avg(price) avg_price from book group by publisher) b2 on b1.publisher = b2.publisher
where b1.price > b2.avg_price;

-- 3-32 집합 연산 : union, union all
-- union은 일반적으로 테이블 또는 쿼리의 결과가 비슷한데, 두 결과를 합쳐야 할 때 사용
select *
from customer
where address like '대한민국%'
union -- 중복 제거
-- union all -- 중복 제거 X
select *
from customer
where custid in (select custid from orders);

select *
from customer
where address like '대한민국%'
	or custid in (select custid from orders);
