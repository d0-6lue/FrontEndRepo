/*
-- POSITION
DROP TABLE "POSITION" CASCADE CONSTRAINTS;
CREATE TABLE "POSITION" (
	"NO"	NUMBER		NOT NULL,
	"NAME"	VARCHAR2(30)		NULL
);
*/

DROP SEQUENCE SEQ_POSITION_NO;
CREATE SEQUENCE SEQ_POSITION_NO NOCYCLE NOCACHE;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    'ZOODY 동물원장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '경영관리부장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '동물관리부장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '총무과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '운영과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '시설과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '동물기획과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '동물복지1과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '동물복지2과장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '종보전연구실장'
)
;

INSERT INTO POSITION
(
    NO,
    NAME
)
VALUES
(
    SEQ_POSITION_NO.NEXTVAL,
    '맹수팀장'
)
;