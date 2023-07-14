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
    '��������',
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
    '����',
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
    '����',
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
    '����',
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
    '����',
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
    '���',
    5
)
;