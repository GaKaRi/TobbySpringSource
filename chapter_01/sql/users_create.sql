create table users (
	id integer primary key auto increment,
	id varchar(10),	
	name varchar(20) not null,
	password varchar(10) not null
)


CREATE  TABLE springbook.users (

  id INT NOT NULL AUTO_INCREMENT,

  alias VARCHAR(20) NOT NULL ,

  name VARCHAR(20) NOT NULL ,

  password VARCHAR(40) NOT NULL ,

  PRIMARY KEY (id)
);