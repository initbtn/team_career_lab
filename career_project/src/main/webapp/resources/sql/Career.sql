DROP TABLE careermap; 
DROP TABLE recruitmap;
DROP TABLE careerboard;
DROP TABLE qna_comment;
DROP TABLE qna_like;
DROP TABLE qna_post;
DROP TABLE free_comment;
DROP TABLE free_like;
DROP TABLE free_post;
DROP TABLE recruitment_comment;
DROP TABLE recruitment_like;
DROP TABLE recruitment_post;
DROP TABLE job_posting;
DROP TABLE company;
DROP TABLE company_admin;
DROP TABLE users;

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

CREATE TABLE company_admin(
    email VARCHAR2(50 CHAR) CONSTRAINT pk_company_cid PRIMARY KEY,
    business_number VARCHAR2(20 CHAR),
    password VARCHAR2(30 CHAR),
    name VARCHAR2(30 CHAR),
    belong VARCHAR2(30 CHAR),
    phone VARCHAR2(20 CHAR),
    grade VARCHAR2(20 CHAR),
    created_at DATE
);

CREATE TABLE careerBoard(
    crb_id VARCHAR2(10 CHAR) CONSTRAINT pk_careerBoard_crbid PRIMARY KEY,
    userid VARCHAR2(10 CHAR),
    pr_intro VARCHAR2(1000 CHAR),
    pr_pic VARCHAR2(20 CHAR),
    create_at DATE,
    CONSTRAINT fk_careerBoard_userid FOREIGN KEY (userid) REFERENCES users(userid)
    );

CREATE TABLE company(
    business_no NUMBER CONSTRAINT pk_company_business_no PRIMARY KEY,
    company_name VARCHAR2(50 CHAR),
    c_size VARCHAR2(20),
    c_intro VARCHAR2(1000 CHAR),
    c_pic VARCHAR2(20 CHAR),
    tech VARCHAR2(20 CHAR),
    c_sale number,
    condition VARCHAR2(50 CHAR),
    benefit VARCHAR2(20 CHAR),
    create_at DATE,
    CONSTRAINT fk_jobBoard_id FOREIGN KEY (c_id) REFERENCES company(c_id)
    ); 
    
CREATE TABLE job_posting(
    rec_id VARCHAR2(10 CHAR) CONSTRAINT pk_recruitBoard_recid PRIMARY KEY,
    c_id VARCHAR2(10 CHAR),
    c_size VARCHAR2(20),
    c_intro VARCHAR2(1000 CHAR),
    c_pic VARCHAR2(20 CHAR),
    tech VARCHAR2(20 CHAR),
    c_sale number,
    condition VARCHAR2(50 CHAR),
    benefit VARCHAR2(20 CHAR),
    create_at DATE,
    CONSTRAINT fk_jobBoard_id FOREIGN KEY (c_id) REFERENCES company(c_id)
    ); 

CREATE TABLE careerMap(
    crb_id VARCHAR2(10 CHAR),
    userid VARCHAR2(10 CHAR),
    create_at DATE,
    CONSTRAINT fk_careerMap_crb_id FOREIGN KEY (crb_id) REFERENCES careerBoard(crb_id),
    CONSTRAINT fk_careerMap_userid FOREIGN KEY (userid) REFERENCES users(userid)
    );

CREATE TABLE recruitMap(
    rec_id VARCHAR2(10 CHAR),
    c_id VARCHAR2(10 CHAR),
    create_at DATE,
    CONSTRAINT fk_recruitMap_rec_id FOREIGN KEY (rec_id) REFERENCES recruitBoard(rec_id),
    CONSTRAINT fk_recruitMap_c_id FOREIGN KEY (c_id) REFERENCES company(c_id)
    );

CREATE TABLE qna_post (
  post_id NUMBER(10) PRIMARY KEY,
  userid VARCHAR2(10 CHAR),
  title VARCHAR2(100),
  content VARCHAR2(1000),
  hit NUMBER,
  created_at DATE,
  CONSTRAINT fk_qna_post_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE qna_comment (
  comment_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(10 CHAR),
  content VARCHAR2(1000),
  created_at DATE,
  CONSTRAINT fk_qna_comment_post_id FOREIGN KEY (post_id) REFERENCES qna_post(post_id),
  CONSTRAINT fk_qna_comment_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE qna_like (
  like_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(20 CHAR),
  created_at DATE,
  CONSTRAINT fk_qna_like_post_id FOREIGN KEY (post_id) REFERENCES qna_post(post_id),
  CONSTRAINT fk_qna_like_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE recruitment_post (
  post_id NUMBER(10) PRIMARY KEY,
  userid VARCHAR2(10 CHAR),
  title VARCHAR2(100),
  content VARCHAR2(1000),
  hit NUMBER,
  created_at DATE,
  CONSTRAINT fk_recruitment_post_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE recruitment_comment (
  comment_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(10 CHAR),
  content VARCHAR2(1000),
  created_at DATE,
  CONSTRAINT fk_recruitment_comment_post_id FOREIGN KEY (post_id) REFERENCES recruitment_post(post_id),
  CONSTRAINT fk_recruitment_comment_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE recruitment_like (
  like_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(10 CHAR),
  created_at DATE,
  CONSTRAINT fk_recruitment_like_post_id FOREIGN KEY (post_id) REFERENCES recruitment_post(post_id),
  CONSTRAINT fk_recruitment_like_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE free_post (
  post_id NUMBER(10) PRIMARY KEY,
  userid VARCHAR2(10 CHAR),
  title VARCHAR2(100),
  content VARCHAR2(1000),
  hit NUMBER,
  created_at DATE,
  CONSTRAINT fk_free_post_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE free_comment (
  comment_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(20 CHAR),
  content VARCHAR2(1000),
  created_at DATE,
  CONSTRAINT fk_free_comment_post_id FOREIGN KEY (post_id) REFERENCES free_post(post_id),
  CONSTRAINT fk_free_comment_userid FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE free_like (
  like_id NUMBER(10) PRIMARY KEY,
  post_id NUMBER(10),
  userid VARCHAR2(10 CHAR),
  created_at DATE,
  CONSTRAINT fk_free_like_post_id FOREIGN KEY (post_id) REFERENCES free_post(post_id),
  CONSTRAINT fk_free_like_userid FOREIGN KEY (userid) REFERENCES users(userid)
);