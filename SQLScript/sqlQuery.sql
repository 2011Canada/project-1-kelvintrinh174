set schema 'expensereimbursement101';
select * from expensereimbursement101.ers_user_roles;

select * from expensereimbursement101.ers_users eu; 
select * from expensereimbursement101.ers_reimbursement_status ers ;
select * from expensereimbursement101.ers_reimbursement_type ert ;

select * from expensereimbursement101.ers_reimbursement er ;
--insert into expensereimbursement101."ers_users" (ers_username,ers_password,user_email,user_role_id) values ('kelvintrinh1','12345','kelvintrinh@gmail.com',3);
select * from ers_users eu
inner join ers_user_roles eur on eu.user_role_id = eur.ers_user_role_id 
where ers_username = 'kelvintrinh' and ers_password = '12345';

--select * from ers_user_roles where ers_user_role_id = 1;
select * from ers_reimbursement er 
inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id
inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id
where reimb_author = 1
order by er.reimb_submited;


select * from ers_reimbursement er 
inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id
inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id
inner join ers_users eu on eu.ers_users_id = er.reimb_author
where reimb_id = 1;



begin;
update ers_reimbursement set reimb_resolved = '2020-12-31 22:00:29.234', reimb_resolver = 2, reimb_status_id =2 where reimb_id = 1;
commit;

select * from ers_reimbursement_type;
select * from ers_reimbursement_status;

select * from ers_reimbursement er 
inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id
inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id
inner join ers_users eu on eu.ers_users_id = er.reimb_author
order by er.reimb_submited;



/*insert into "ers_users" (ers_username,ers_password,user_email,user_role_id,user_first_name,user_last_name) 
values ('kelvintrinh','12345','kelvintrinh@gmail.com',1,'Kelvin','Trinh') returning "ers_users_id";
insert into "ers_users" (ers_username,ers_password,user_email,user_role_id,user_first_name,user_last_name) values ('luke174','12345','luke174@gmail.com',1,'Luke','AJ');
insert into "ers_users" (ers_username,ers_password,user_email,user_role_id,user_first_name,user_last_name) values ('Bob','12345','bob@gmail.com',2,'Bob','Culinan');
insert into "ers_reimbursement" (reimb_amount,reimb_submited,reimb_author,reimb_status_id,reimb_type_id,reimb_description)
values (20.50,'2020-12-25 10:03:45.345',1,1,1,'My hotel is Four Season') returning "reimb_id";
insert into "ers_reimbursement" (reimb_amount,reimb_submited,reimb_author,reimb_status_id,reimb_type_id,reimb_description)
values (21,'2020-12-26 14:04:31.320',1,1,2,'Business Trip');*/


--update ers_users set user_first_name = 'Max', user_last_name = 'A' where ers_users_id = 3;

select * from ers_reimbursement er 
inner join ers_reimbursement_status ers on er.reimb_status_id = ers.reimb_status_id
inner join ers_reimbursement_type ert on er.reimb_type_id = ert.reimb_type_id
inner join ers_users eu on eu.ers_users_id = er.reimb_author
order by er.reimb_submited;

select * from ers_users eu;

