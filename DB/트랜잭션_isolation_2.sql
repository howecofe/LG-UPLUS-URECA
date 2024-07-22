-- <트랜잭션 고립 수준> - tx2
-- 1. READ UNCOMMITED
set sql_safe_updates = 0;

START TRANSACTION;

UPDATE	Users
SET		age=21
WHERE	id=1;

rollback;

-- 2. READ COMMITED
set sql_safe_updates = 0;

START TRANSACTION;

UPDATE	Users
SET		age=21
WHERE	id=1;

commit;

-- 2. READ COMMITED
START TRANSACTION;

insert into Users values (3, 'Bob', 27);

commit;

-- 3. REPEATABLE READ -> Phantom Read(유령 읽기)
START TRANSACTION;

insert into Users values (3, 'Bob', 27);

commit;