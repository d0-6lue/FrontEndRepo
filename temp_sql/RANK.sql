/*
DROP TABLE "RANK" CASCADE CONSTRAINTS;
CREATE TABLE "RANK" (
	"NO"	NUMBER		NOT NULL,
	"NAME"	VARCHAR2(20)		NULL,
    "GRADE" NUMBER      NULL
);
*/

DROP SEQUENCE SEQ_RANK_NO;
CREATE SEQUENCE SEQ_RANK_NO NOCYCLE NOCACHE;

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '동물원장',
    1
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '부장',
    2
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '과장',
    3
)
;

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '실장',
    3
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '팀장',
    4
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO RANK
(
    NO,
    NAME,
    GRADE
)
VALUES
(
    SEQ_RANK_NO.NEXTVAL,
    '사원',
    5
)
;