create table if not exists user_A (
	user_uuid VARCHAR(36) NOT NULL,
	user_name VARCHAR(64) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	PRIMARY KEY(user_uuid)
);

create table if not exists user_B (
	user_uuid VARCHAR(36) NOT NULL,
	user_name VARCHAR(64) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	PRIMARY KEY(user_uuid)
);

create table if not exists user_C (
	user_uuid VARCHAR(36) NOT NULL,
	user_name VARCHAR(64) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	PRIMARY KEY(user_uuid)
);

create table if not exists user_D (
	user_uuid VARCHAR(36) NOT NULL,
	user_name VARCHAR(64) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	PRIMARY KEY(user_uuid)
);
