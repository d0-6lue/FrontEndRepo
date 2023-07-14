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
    'ZOODY ��������'
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
    '�濵��������'
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
    '������������'
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
    '�ѹ�����'
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
    '�����'
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
    '�ü�����'
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
    '������ȹ����'
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
    '��������1����'
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
    '��������2����'
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
    '��������������'
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
    '�ͼ�����'
)
;