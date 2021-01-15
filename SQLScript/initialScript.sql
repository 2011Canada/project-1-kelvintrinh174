drop schema if exists expensereimbursement101 cascade;
create schema expensereimbursement101;
set schema 'expensereimbursement101';


create table "ers_user_roles" (
	"ers_user_role_id" serial primary key,
	"user_role" text
);

create table "ers_users" (
	"ers_users_id" serial primary key,
	"ers_username" text not null,
	"ers_password" text not null,
	"user_first_name" text,
	"user_last_name" text,
	"user_email" text not null,
	"user_role_id" int references "ers_user_roles"("ers_user_role_id"),
	constraint "ers_users_un" unique ("ers_username","user_email") 
);

create table "ers_reimbursement_status" (
	"reimb_status_id" serial primary key,
	"reimb_status" text not null
);

create table "ers_reimbursement_type" (
	"reimb_type_id" serial primary key,
	"reimb_type" text not null
);

create table "ers_reimbursement" (
	"reimb_id" serial primary key,
	"reimb_amount" numeric(10,2) not null check (reimb_amount >=0),
	"reimb_submited" timestamp not null,
	"reimb_resolved" timestamp,
	"reimb_description" varchar(250),
	"reimb_receipt" bytea,
	"reimb_author" int references "ers_users"("ers_users_id"),
	"reimb_status_id" int references "ers_reimbursement_status"("reimb_status_id"),
	"reimb_resolver" int references "ers_users"("ers_users_id"),
	"reimb_type_id" int references "ers_reimbursement_type"("reimb_type_id")
);

begin;
insert into "ers_reimbursement_status" (reimb_status) values ('PENDING'),('ACCEPTED'),('REFUSED');
insert into "ers_reimbursement_type" (reimb_type) values ('LODGING'),('TRAVEL'),('FOOD'),('OTHER');
insert into "ers_user_roles" (user_role) values ('EMPLOYEE'),('MANAGER');

commit;