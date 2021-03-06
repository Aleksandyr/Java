-----------------------------------------
--Create tables
------------------------------------

CREATE TABLE users(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50) NOT NULL, 
	username VARCHAR2(50) NOT NULL, 
	password VARCHAR2(100) NOT NULL, 
	status NUMBER NOT NULL,
	date_of_birth DATE, 
	pid VARCHAR2(20) NOT NULL
);

CREATE TABLE authorities(
	id NUMBER PRIMARY KEY,
  authority VARCHAR2(50) NOT NULL
);

CREATE TABLE user_authority(
	id NUMBER PRIMARY KEY,
  user_id NUMBER NOT NULL,
  authority_id NUMBER NOT NULL
);

CREATE TABLE books(
	id NUMBER PRIMARY KEY,
  name VARCHAR2(50) NOT NULL,
  author VARCHAR2(50) NOT NULL,
  year_of_poublishing DATE NOT NULL
);

CREATE TABLE lends(
	id NUMBER PRIMARY KEY,
  user_id NUMBER NOT NULL,
  book_id NUMBER NOT NULL,
  date_of_lending DATE NOT NULL,
  date_of_return DATE NOT NULL
);

------------------------------
-- add primary key sequences
------------------------------

-- users primary key sequence
CREATE SEQUENCE USERS_SEQ3;

CREATE TRIGGER USERS_TRG 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USERS_SEQ3.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

-- authorities primary key sequence
CREATE SEQUENCE AUTHORITIES_SEQ2;

CREATE TRIGGER AUTHORITIES_TRG 
BEFORE INSERT ON AUTHORITIES 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT AUTHORITIES_SEQ2.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

-- user_authority primary key sequence
CREATE SEQUENCE USER_AUTHORITY_SEQ2;

CREATE TRIGGER USER_AUTHORITY_TRG 
BEFORE INSERT ON USER_AUTHORITY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USER_AUTHORITY_SEQ2.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

-- books primary key sequence
CREATE SEQUENCE BOOKS_SEQ2;

CREATE TRIGGER BOOKS_TRG 
BEFORE INSERT ON BOOKS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT BOOKS_SEQ2.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

-- lends primary key sequence
CREATE SEQUENCE LENDS_SEQ3;

CREATE TRIGGER LENDS_TRG 
BEFORE INSERT ON LENDS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT LENDS_SEQ3.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

------------------------
-- add foreign keys
------------------------

-- user_authority foreign key
ALTER TABLE user_authority ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE user_authority ADD FOREIGN KEY (authority_id) REFERENCES authorities(id);

-- lends foreign keys
ALTER TABLE lends ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE lends ADD FOREIGN KEY (book_id) REFERENCES books(id);


---------------------
-- INSERT into tables
---------------------

-- INSERT into authorities
INSERT INTO authorities (authority) VALUES ('ROLE_USER')

INSERT INTO authorities (authority) VALUES ('ROLE_ADMIN')

-- INSERT into users
INSERT INTO users (name, username, status, password, date_of_birth, pid)
VALUES ('asd','asd', 1, '0192023a7bbd73250516f069df18b500', '28-APR-92', '912-9324-1231') --password (admin123)

-- INSERT into user_authority
