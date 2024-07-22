-- 공통코드 조별활동
-- 공통코드를 스토리 또는 업무 흐름 기반(프론트 화면 ~~ 백엔드 처리 코드 등)으로 주문 엔티티의 주문 상태를 코드화
-- 주문 상태: 주문 완료, 주문 취소, 결제 완료, 배송 준비, 배송 진행중, 배송 완료

use FoodDeliveryDB;

create table group_code(
	group_code char(3) not null,
    group_code_name varchar(50) not null,
    primary key(group_code)
);

create table code(
	group_code char(3) not null,
    code char(3) not null,
    code_name varchar(50) not null,
    use_yn char(1) null,
    primary key(group_code, code)
);

-- group_code
insert into group_code values ('001', '주문 상태');

-- code
insert into code values ('001', '010', '주문 완료', 'Y');
insert into code values ('001', '020', '주문 취소', 'Y');
insert into code values ('001', '030', '결제 완료', 'Y');
insert into code values ('001', '040', '배송 준비', 'Y');
insert into code values ('001', '050', '배송 진행중', 'Y');
insert into code values ('001', '060', '배송 완료', 'Y');

select c.code, c.code_name
  from group_code g, code c
 where g.group_code = c.group_code
   and g.group_code = '001'; -- 주문 상태

-- 스토리 (업무 흐름)
-- 1) 사용자가 front-end: 주문 버튼 클릭하면 서버에 주문 요청
-- 2) back-end: order 테이블에 데이터가 insert되고 이때 상태는 '주문 완료' 코드
-- 3) front-end: 주문 상세페이지의 주문 상태가 '주문 완료'로 표시

-- 주문 테이블
create table order_test (
	order_id int not null auto_increment,
    user_id int not null,
    price int not null,
    order_clsf char(3) not null,
    primary key (order_id)
);

-- 주문
-- 주문 요청 시점에 order 테이블에 insert : '주문 완료' 코드는 '010'
insert into order_test (user_id, price, order_clsf) values (1, 3000, '010');
insert into order_test (user_id, price, order_clsf) values (2, 2000, '010');

select * from order_test;

-- 주문 상세 정보 조회 화면을 위한 front-end 요청에 대한 처리
select order_id, user_id, price, order_clsf, (select c.code_name from group_code g, code c where g.group_code = '001' and c.code = order_clsf) order_clsf_nm
  from order_test
 where user_id = 1; -- 1번 유저의 주문 상세 확인
   
