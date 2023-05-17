DROP TABLE CHAT_LOG CASCADE CONSTRAINTS;
CREATE TABLE CHAT_LOG (
    CHAT_NO             NUMBER          PRIMARY KEY,
    QUOTATION_NO        NUMBER          NOT NULL,
    CHAT_SENDER         NUMBER          NOT NULL,
    CHAT_CONTENT        VARCHAR2(2000),
    CHAT_REQUEST        CHAR(1)         DEFAULT 'X'  CONSTRAINT CHAT_REQUEST_CHECK CHECK (CHAT_REQUEST IN ('O', 'X')),
    CHAT_ATTACHMENT     CHAR(1)         DEFAULT 'X'  CONSTRAINT CHAT_ATTACHMENT_CHECK CHECK (CHAT_ATTACHMENT IN ('O', 'X')),
    CHAT_READ           CHAR(1)         DEFAULT 'X'  CONSTRAINT CHAT_READ_CHECK CHECK (CHAT_READ IN ('O', 'X')),
    CHAT_STATUS         CHAR(1)         DEFAULT 'O'  CONSTRAINT CHAT_STATUS_CHECK CHECK (CHAT_STATUS IN ('O', 'X')),
    CHAT_ENROLL_DATE    TIMESTAMP       DEFAULT SYSDATE
)
;
CREATE SEQUENCE SEQ_CHAT_LOG_NO NOCACHE NOCYCLE;

DROP TABLE CHAT_ATTACHMENT CASCADE CONSTRAINTS;
CREATE TABLE CHAT_ATTACHMENT (
    CHAT_ATTACHMENT_NO      NUMBER          PRIMARY KEY, 
    CHAT_NO                 NUMBER          NOT NULL,
    ORIGIN_NAME             VARCHAR2(1000)  NOT NULL,
    CHANGE_NAME             VARCHAR2(1000)  NOT NULL,
    ENROLL_DATE             TIMESTAMP       DEFAULT SYSDATE,
    STATUS                  CHAR(1)         DEFAULT 'O' CHECK ( STATUS IN ('O' , 'X') )
)
;

DROP TABLE CHAT_REQUEST CASCADE CONSTRAINTS;
CREATE TABLE CHAT_REQUEST (
    REQUEST_NO          NUMBER          PRIMARY KEY ,
    CHAT_REQUEST_CAT    NUMBER          NOT NULL    ,
    CHAT_NO             NUMBER          NOT NULL    ,
    REQUEST_CONTENT     VARCHAR2(3000)              
)
;

DROP TABLE REQUEST_ADD_OPTION CASCADE CONSTRAINTS;
CREATE TABLE REQUEST_ADD_OPTION (
    REQUEST_NO                  NUMBER      NOT NULL,
    ESTIMATE_OPTION_NUMBER      NUMBER      NOT NULL,
    QUANTITY                    NUMBER      NOT NULL
)
;

DROP TABLE REQUEST_DELETE_OPTION CASCADE CONSTRAINTS;
CREATE TABLE REQUEST_DELETE_OPTION (
    REQUEST_NO                  NUMBER      NOT NULL,
    QUOTATION_OPTION_NUMBER     NUMBER      NOT NULL
)
;

DROP TABLE REQUEST_CHANGE_DATE CASCADE CONSTRAINTS;
CREATE TABLE REQUEST_CHANGE_DATE (
    REQUEST_NO              NUMBER      NOT NULL,
    DIRECTION               NUMBER      CONSTRAINT DIRECTION_CHECK CHECK ( DIRECTION IN ('1', '-1') ) NOT NULL,
    PERIOD                  NUMBER      NOT NULL
)
;

DROP TABLE HANDSEL_REQUEST CASCADE CONSTRAINTS;
CREATE TABLE HANDSEL_REQUEST (
    REQUEST_NO              NUMBER      NOT NULL,
    HANDSEL                 NUMBER      NOT NULL
)
;


commit;
select * from chat_log;