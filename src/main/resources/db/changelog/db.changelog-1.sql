-- liquibase formatted sql

-- changeset jarison.araujo:1.0 dbms:mysql

CREATE TABLE address (
    id bigint auto_increment,
	zip_code VARCHAR(9),
	street VARCHAR(255),
    number integer,
    district varchar(255),
    city VARCHAR(255),
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 


CREATE TABLE company (
	id bigint auto_increment not null,
    name varchar(255) not null,
    document varchar(15) not null,
	vacancies integer null,
	site varchar(255) null,
    address_pk bigint not null,
    foreign key (address_pk) references address (id),
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 


CREATE TABLE user (
	id bigint auto_increment not null,
    name varchar(255) not null,
    document varchar(15) not null,
    ager integer not null,
	login varchar(100) not null,
	password varchar(100) not null,
	salary DECIMAL(19,2) not null,
    company_pk bigint not null,
    address_pk bigint not null,
    foreign key (company_pk) references company (id),
    foreign key (address_pk) references address (id),
    primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 


