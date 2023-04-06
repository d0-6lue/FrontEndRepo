/*
-- ��������
CREATE USER C##SEMI IDENTIFIED BY "1234";
-- ���� �ο�
GRANT CONNECT, RESOURCE TO C##SEMI;
ALTER USER C##SEMI DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS; -- ���ϸ� INSERT �� ���� �߻�
*/



--DROP----------------------------------------------------------------------------------------------------------------
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_MEMBER_NO;

DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_NOTICE_NO;

DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_BOARD_NO;

DROP TABLE ATTACHMENT CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_ATTACHMENT_NO;

DROP TABLE REPLY CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_REPLY_NO;

DROP TABLE GALLERY CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_GALLERY_NO;

DROP TABLE CATEGORY CASCADE CONSTRAINTS;



--CREATE--------------------------------------------------------------------------------------------------------------
--- MEMBER
CREATE TABLE MEMBER (
    NO NUMBER PRIMARY KEY,
    ID VARCHAR2(100) NOT NULL  UNIQUE,
    PWD VARCHAR2(100) NOT NULL,
    NICK VARCHAR2(100) UNIQUE,
    PROFILE VARCHAR2(100),
    HOBBY VARCHAR2(100),
    STATUS CHAR(1) DEFAULT 'O' CHECK (STATUS IN ('O', 'X')),
    ENROLL_DATE TIMESTAMP DEFAULT SYSDATE,
    MODIFY_DATE TIMESTAMP
);

CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;


-- NOTICE
CREATE TABLE NOTICE (
    NO          NUMBER          PRIMARY KEY,
    TITLE       VARCHAR2(100)   NOT NULL,
    CONTENT     VARCHAR2(4000)  NOT NULL,
    ENROLL_DATE TIMESTAMP       DEFAULT SYSDATE,
    MODIFY_DATE TIMESTAMP,
    STATUS      CHAR(1)         DEFAULT 'O' CHECK (STATUS IN ('O', 'X')),
    HIT         NUMBER          DEFAULT 0
);

CREATE SEQUENCE SEQ_NOTICE_NO NOCYCLE NOCACHE;


-- BOARD
CREATE TABLE BOARD (
    NO                  NUMBER          PRIMARY KEY
    , CATEGORY_NO       NUBMER
    , TITLE             VARCHAR2(100)   NOT NULL
    , CONTENT           VARCHAR2(4000)  NOT NULL
    , WRITER_NO         NUMBER
    , ENROLL_DATE       TIMESTAMP       DEFAULT SYSDATE
    , STATUS            CHAR(1)         DEFAULT 'O' CHECK (STATUS IN ('O','X'))
    , MODIFY_DATE       TIMESTAMP
    , HIT               NUMBER          DEFAULT 0
);

CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;


-- ATTACHEMNT
CREATE TABLE ATTACHEMENT (
    NO              NUMBER          PRIMARY KEY ,
    BNO             NUMBER ,    
    ORIGIN_NAME     VARCHAR2(1000)  NOT NULL ,
    CHANGE_NAME     VARCHAR2(1000)  NOT NULL,
    ENROLL_DATE     TIMESTAMP       DEFAULT SYSDATE ,
    STATUS          CHAR(1)         DEFAULT 'O' CHECK ( STATUS IN ('O','X') )
);

CREATE SEQUENCE SEQ_ATTACHMENT_NO NOCACHE NOCYCLE;


--REPLY
CREATE TABLE REPLY (
    NO              NUMBER              PRIMARY KEY,
    BNO             NUMBER              NOT NULL,
    CONTENT         VARCHAR2(1000)      NOT NULL ,
    WRITER_NO        NUMBER              NOT NULL ,
    ENROLL_DATE     TIMESTAMP           DEFAULT SYSDATE ,
    STATUS          CHAR(1)             DEFAULT 'O' CHECK ( STATUS IN ('O','X') )
);

CREATE SEQUENCE SEQ_REPLY_NO NOCACHE NOCYCLE;


-- GALLERY
CREATE TABLE GALLERY (
    NO              NUMBER              PRIMARY KEY ,
    TITLE           VARCHAR2(100)       NOT NULL ,
    CONTENT         VARCHAR2(4000)      NOT NULL ,
    WRITER_NO        NUMBER              NOT NULL ,
    ORIGIN_NAME     VARCHAR2(1000)      NOT NULL ,
    CHANGE_NAME     VARCHAR2(1000)      NOT NULL ,
    ENROLL_DATE     TIMESTAMP           DEFAULT SYSDATE ,
    STATUS          CHAR(1)             DEFAULT 'O' CHECK ( STATUS IN ('O','X') ) ,
    HIT             NUMBER              DEFAULT 0
);

CREATE SEQUENCE SEQ_GALLERY_NO NOCACHE NOCYCLE;


-- CATEGORY
CREATE TABLE CATEGORY (
    NO          NUMBER          NOT NULL UNIQUE,
    NAME        VARCHAR2(100)   NOT NULL UNIQUE
);



--CONSTRAINTS---------------------------------------------------------------------------------------------------------
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE BOARD ADD CONSTRAINT FK_BOARD_CATEGORY FOREIGN KEY(CATEGORY_NO) REFERENCES CATEGORY(NO);

ALTER TABLE ATTACHMENT ADD CONSTRAINT FK_ATTACHMENT_BOARD FOREIGN KEY(BNO) REFERENCES BOARD(NO);

ALTER TABLE REPLY ADD CONSTRAINT FK_REPLY_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);
ALTER TABLE REPLY ADD CONSTRAINT FK_REPLY_BOARD FOREIGN KEY(BNO) REFERENCES BOARD(NO);

ALTER TABLE GALLERY ADD CONSTRAINT FK_GALLERY_MEMBER FOREIGN KEY(WRITER_NO) REFERENCES MEMBER(NO);



--SAMPLE DATA---------------------------------------------------------------------------------------------------------
-- CATEGORY
INSERT INTO CATEGORY(NO, NAME) VALUES(10, '����');
INSERT INTO CATEGORY(NO, NAME) VALUES(20, '�ڵ�');
INSERT INTO CATEGORY(NO, NAME) VALUES(30, '����');
INSERT INTO CATEGORY(NO, NAME) VALUES(40, '�');
INSERT INTO CATEGORY(NO, NAME) VALUES(50, '�丮');
COMMIT;

-- MEMBER
INSERT INTO MEMBER (NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL, 'ADMIN', '0000', '������');
COMMIT;





