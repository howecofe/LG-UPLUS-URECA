-- <트랜잭션 고립 수준> - tx1
-- 1. READ UNCOMMITED -> Dirty Read (오손 읽기) : 커밋하지 않은 데이터도 보인다.
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;

SELECT	*
FROM	Users
WHERE	id=1; -- age: 30

-- tx2 update (age: 21)

SELECT	*
FROM	Users
WHERE	id=1; -- age: 21 <- uncommited (dirty read)

-- tx2 rollback

SELECT	*
FROM	Users
WHERE	id=1; -- age: 30

commit;

-- 2. READ COMMITED -> Non-repeatable Read (반복적으로 동일한 데이터 읽기 불가능) : 커밋한 데이터만 보인다.
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;

SELECT	*
FROM	Users
WHERE	id=1; -- age: 30

-- tx2 update, commit (age: 21)

SELECT	*
FROM	Users
WHERE	id=1; -- age: 21 <- commited: 커밋된 것을 읽어온다. (non-repeatable read)

commit;

-- 3. READ COMMITED(반복적으로 동일한 데이터 읽기) -> Phantom Read(유령 읽기) 
SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;

SELECT	*
FROM	Users; -- 1 row

-- tx2 insert, commit

SELECT	*
FROM	Users; -- 2 row <- phantom read

commit;

-- 3. REPEATABLE READ(반복적으로 동일한 데이터 읽기) : 커밋한 데이터가 있어도 해당 트랜잭션이 종료되기 전까지 보이지 않는다.
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- 내 트랜잭션이 시작하고 끝나기 전까지는 다른 트랜잭션에 의해 row에 변화(commit 포함)가 생기더라도 동일한 row를 조회한다.
-- REPEATABLE READ가 default
START TRANSACTION;

SELECT	*
FROM	Users; -- 1 row

-- tx2 insert, commit

SELECT	*
FROM	Users; -- 1 row

commit;





