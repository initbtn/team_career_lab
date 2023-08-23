CREATE TABLE users(
    userid VARCHAR2(10) CONSTRAINT pk_users_userid PRIMARY KEY,
    userpassword VARCHAR2(20 CHAR),
    username VARCHAR2(50),
    useremail VARCHAR2(100),
    usernickname VARCHAR2(20 CHAR),
    useraddress VARCHAR2(30 CHAR),
    userphone VARCHAR2(20 CHAR),
    usercreatedat DATE
);

CREATE TABLE careerBoard(
    crb_id NUMBER CONSTRAINT pk_careerBoard_crbid PRIMARY KEY,
    userid VARCHAR2(10 CHAR),
    pr_intro VARCHAR2(1000 CHAR),
    pr_pic VARCHAR2(20 CHAR),
    create_at DATE,
    CONSTRAINT fk_careerBoard_userid FOREIGN KEY (userid) REFERENCES users(userid)
    );

CREATE TABLE careerMap(
    crb_id NUMBER,
    userid VARCHAR2(10 CHAR),
    create_at DATE,
    CONSTRAINT fk_careerMap_crb_id FOREIGN KEY (crb_id) REFERENCES careerBoard(crb_id),
    CONSTRAINT fk_careerMap_userid FOREIGN KEY (userid) REFERENCES users(userid)
    );

CREATE TABLE follow(
    follow_id NUMBER PRIMARY KEY,
    following VARCHAR2(20 CHAR),
    follower VARCHAR2(20 CHAR),
    CONSTRAINT fk_following_userid FOREIGN KEY (following) REFERENCES users(userid),
    CONSTRAINT fk_follower_userid FOREIGN KEY (follower) REFERENCES users(userid)
);

CREATE TABLE company_admin(
    userid VARCHAR2(50 CHAR) CONSTRAINT pk_company_cid PRIMARY KEY,
    business_number VARCHAR2(20 CHAR),
    password VARCHAR2(30 CHAR),
    name VARCHAR2(30 CHAR),
    belong VARCHAR2(30 CHAR),
    phone VARCHAR2(20 CHAR),
    grade VARCHAR2(20 CHAR),
    created_at DATE
);

CREATE SEQUENCE spring_career.follow_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOCYCLE
NOCACHE;
    
    
CREATE SEQUENCE spring_career.careerboard_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOCYCLE
NOCACHE;



CREATE SEQUENCE  "SPRING_CAREER"."SEQ_FREEBOARD"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;

CREATE SEQUENCE  "SPRING_CAREER"."SEQ_FREEBOARDLIKE"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

CREATE SEQUENCE  "SPRING_CAREER"."SEQ_FREEBOARDREPLY"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;