insert into book(id,author,amount,category,title,rent_cnt)values(1000,'김애란','3','NOVEL','비행운',5);
insert into book(id,author,amount,category,title,rent_cnt)values(1001,'조앤롤링','4','NOVEL','해리포터',4);
insert into book(id,author,amount,category,title,rent_cnt)values(1002,'에리히프롬','5','HUMANITY','사랑의기술',3);
insert into book(id,author,amount,category,title,rent_cnt)values(1003,'비트겐슈타인','6','HUMANITY','논리철학논고',2);
insert into book(id,author,amount,category,title,rent_cnt)values(1004,'황정은','7','NOVEL','디디의우산',10);
insert into book(id,author,amount,category,title,rent_cnt)values(1005,'test','7','NOVEL','test',10);



insert into member(user_id,email,role,password,tel) values('jpa','jpa@jpa.com','ROLE_USER','1234','010-0112-0119');
insert into member(user_id,email,role,password,tel) values('security','security@security.com','ROLE_ADMIN','1234','010-0112-0120');
insert into member(user_id,email,role,password,tel) values('boot','boot@boot.com','ROLE_USER','1234','010-0112-0121');
insert into member(user_id,email,role,password,tel) values('test','test@test.com','ROLE_ADMIN','1234','010-0112-0122');

insert into rent(id,title,user_id) values(100001,'비행운 외 1권','test');
insert into rent(id,title,user_id) values(100002,'비행운 외 1권','jpa');
insert into rent(id,title,user_id) values(100003,'비행운 외 1권','security');
insert into rent(id,title,user_id) values(100004,'디디의 우산 외 1권','test');
insert into rent(id,title,user_id) values(100005,'논리철학논고 외 1권','test');

insert into rent_book(id,rent_id,book_id,state) values(200001,100001,1000,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200002,100001,1001,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200003,100002,1000,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200004,100002,1001,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200005,100003,1000,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200006,100003,1001,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200007,100004,1004,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200008,100004,1003,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200009,100005,1004,'RENT');
insert into rent_book(id,rent_id,book_id,state) values(200010,100005,1003,'RENT');
