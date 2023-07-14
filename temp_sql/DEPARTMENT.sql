-- DEPARTMENT
/*
DROP TABLE "DEPARTMENT" CASCADE CONSTRAINTS;
CREATE TABLE "DEPARTMENT" (
	"NO"	NUMBER		NOT NULL,
	"UPPER_DEPARTMENT_NO"	NUMBER		NULL,
	"NAME"	VARCHAR2(30)		NULL
);

ALTER TABLE "DEPARTMENT" ADD CONSTRAINT "FK_DEPARTMENT_TO_DEPARTMENT_1" FOREIGN KEY (
	"UPPER_DEPARTMENT_NO"
)
REFERENCES "DEPARTMENT" (
	"NO"
);
*/

DROP SEQUENCE SEQ_DEPARTMENT_NO;
CREATE SEQUENCE SEQ_DEPARTMENT_NO NOCYCLE NOCACHE;

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    'ZOODY������',
    NULL
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ������ �Ʒ� 2�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�濵������',
    1
)
;

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '����������',
    1
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- �濵������ �Ʒ� 4�� ��

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ѹ���',
    2
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '���',
    2
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ü���',
    2
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�����',
    2
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ���������� �Ʒ� 4�� ��

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������ȹ��',
    3
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '��������1��',
    3
);


INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '��������2��',
    3
);


INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������ ������',
    3
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- �ѹ��� �Ʒ� 4�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ѹ��λ�',
    4
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�������',
    4
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�뵿����',
    4
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�繫',
    4
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ��� �Ʒ� 3�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�',
    5
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    'ȯ��',
    5
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������',
    5
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- �ü��� �Ʒ� 4�� �μ�
 
INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '����ü�',
    6
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '���ȭ��',
    6
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '����ü�',
    6
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ü�����',
    6
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ������ȹ�� �Ʒ� 4�� �μ�   

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�������',
    8
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '��������ȹ',
    8
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '��������',
    8
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ڿ��н�',
    8
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ��������1�� �Ʒ� 4�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������',
    9
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������',
    9
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�ͼ���',
    9
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������',
    9
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ��������2�� �Ʒ� 4�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�뵿��',
    10
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '��̵���',
    10
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '������ī',
    10
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '���ο�',
    10
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- ������������ �Ʒ� 5�� �μ�

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '���¿���',
    11
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�м�����',
    11
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '����',
    11
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '����',
    11
);

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '�濪',
    11
);
