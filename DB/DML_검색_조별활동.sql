-- 조별활동
select * from customer;
select * from book;
select * from orders;

-- 1. 전화번호에 7000이 들어간 고객이 주문한 도서 주문 내역을 높은 가격순으로 검색하고, 가격이 같으면 주문 일자순으로 검색하시오.
select *
from orders
where custid = (
	select custid
	from customer
	where phone like '%7000%'
	)
order by saleprice desc, orderdate asc;

-- 다른 풀이: join 사용
select o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate
  from customer c join orders o on c.custid = o.custid
 where 	c.phone like '%7000%'
order by saleprice desc, orderdate;

-- 다른 풀이
select o.orderid, o.custid, o.bookid, o.saleprice, o.orderdate
  from customer c, orders o
 where 	c.custid = o.custid and c.phone like '%7000%'
order by saleprice desc, orderdate;

-- 2. '야구'와 '배구'가 적혀있는 'bookname'을 높은 가격순으로 정렬
-- 정답 쿼리
select *
  from book
where bookname like '%야구%' or bookname like '%배구%'
order by price desc;

-- 틀린 풀이
select *
  from book
where bookname like ('%야구%', '%배구%')
order by price desc;

-- 다른 풀이
select *
  from book
where bookname regexp '야구|배구'
order by price desc;

-- 3. customer를 이름의 내림차순으로 출력하세요.
select *
  from customer
order by name desc;

-- 4. customer를 주소의 내림차순으로 검색하세요.
select *
  from customer
order by address desc;