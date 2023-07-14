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
    'ZOODY동물원',
    NULL
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 동물원 아래 2개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '경영관리부',
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
    '동물관리부',
    1
)
;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 경영관리부 아래 4개 과

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '총무과',
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
    '운영과',
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
    '시설과',
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
    '조경과',
    2
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 동물관리부 아래 4개 과

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '동물기획과',
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
    '동물복지1과',
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
    '동물복지2과',
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
    '종보전 연구실',
    3
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 총무과 아래 4개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '총무인사',
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
    '정보통신',
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
    '노동안전',
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
    '재무',
    4
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 운영과 아래 3개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '운영',
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
    '환경',
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
    '고객지원',
    5
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 시설과 아래 4개 부서
 
INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '전기시설',
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
    '기계화공',
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
    '건축시설',
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
    '시설안전',
    6
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 동물기획과 아래 4개 부서   

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '동물원운영',
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
    '동물원기획',
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
    '동물영양',
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
    '자연학습',
    8
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 동물복지1과 아래 4개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '조류팀',
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
    '남미팀',
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
    '맹수팀',
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
    '동양팀',
    9
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 동물복지2과 아래 4개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '대동물',
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
    '어린이동물',
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
    '아프리카',
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
    '유인원',
    10
);

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 종보전연구실 아래 5개 부서

INSERT INTO DEPARTMENT
(
    NO,
    NAME,
    UPPER_DEPARTMENT_NO
)
VALUES
(
    SEQ_DEPARTMENT_NO.NEXTVAL,
    '생태연구',
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
    '분석연구',
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
    '진료',
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
    '병리',
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
    '방역',
    11
);
