CREATE TABLE employee(
    emp_id      INT             NOT NULL,
    birth_date  DATE            NOT NULL,
    first_name  VARCHAR(14)     NOT NULL,
    last_name   VARCHAR(16)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,   
    PRIMARY KEY (emp_id)
);

SELECT * from employee e 

insert into employee 
values(1005,'1999-07-21','james','bond','M')

drop table employee

CREATE TABLE department (
    dept_id     CHAR(4)         NOT NULL,
    location_id integer 		NOT NULL,
    dept_name   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (dept_id),
    UNIQUE  KEY (dept_name)
);


CREATE table location (
location_id integer NOT NUll,
country char(10) Not NUll,
primary key (location_id),
foreign key (location_id ) references location (location_id )
);


 drop table department
 
 drop table dept_emp 
 
 
 drop table dept_manager 

select * from department d 

insert into department 
values (5,'ui_developer')

alter table department 
add unique key (location_id )

CREATE TABLE dept_manager (
   dept_id      CHAR(4)         NOT NULL,
   emp_id       INT             NOT NULL,
   from_date    DATE            NOT NULL,
   to_date      DATE            NOT NULL,
   FOREIGN KEY (emp_id)  REFERENCES employee (emp_id)    ,
   FOREIGN KEY (dept_id) REFERENCES department (dept_id) ,
   PRIMARY KEY (emp_id,dept_id)
); 


SELECT * from dept_manager dm 


insert into dept_emp 
values (5,1005,'2000-12-21','2000-12-21')

CREATE TABLE dept_emp (
    emp_id      INT             NOT NULL,
    dept_id     CHAR(4)         NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    FOREIGN KEY (emp_id)  REFERENCES employee  (emp_id)  ,
    FOREIGN KEY (dept_id) REFERENCES department (dept_id) ,
    PRIMARY KEY (emp_id,dept_id)
);


SELECT * from dept_emp de 

insert into dept_emp 
values (1004,5,'2000-4-21','2000-5-21')


CREATE TABLE title (
    emp_id      INT             NOT NULL,
    title       VARCHAR(50)     NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE,
    FOREIGN KEY (emp_id) REFERENCES employee (emp_id) ,
    PRIMARY KEY (emp_id,title, from_date)
); 

drop table title 

alter table title 
add column to_date DATE not null


SELECT * from title t 

insert into title 
values (1005,'principal_engineer','2000-09-21',null)




CREATE TABLE salary (
    emp_id      INT             NOT NULL,
    salary      INT             NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    FOREIGN KEY (emp_id) REFERENCES employee (emp_id) ,
    PRIMARY KEY (emp_id, from_date)
); 

insert into salary 
values (1005,90000)

alter table salary 
drop column from_date ,
drop column to_date 

CREATE table location(
location_id integer not null,
country varchar(30) not null,
foreign key (location_id) references location (location_id),
primary key (location_id )
);

drop table location 


