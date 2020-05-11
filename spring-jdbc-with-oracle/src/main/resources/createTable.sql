CREATE TABLE EMPLOYEE(
ID NUMBER(19),
FIRST_NAME VARCHAR(255),
START_DATE VARCHAR(255),
JOB_ROLE VARCHAR(255),
DEPARTMENT VARCHAR(255),
EMP_COMMENT VARCHAR(255),
PRIMARY KEY (ID)
);

CREATE SEQUENCE SQ_EMPLOYEE MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10;

INSERT INTO EMPLOYEE VALUES (SQ_EMPLOYEE.nextval,'Rose', '12-01-2015', 'Developer', 'Developing an application', 'No');