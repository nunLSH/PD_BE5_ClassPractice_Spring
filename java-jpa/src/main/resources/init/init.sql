insert into book(bk_idx, author, amount, category, title, created_at)
values (1000, '김애란', '3', 'NOVEL', '비행운', '2023-03-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1001, '조앤롤링', '4', 'NOVEL', '해리포터', '2023-04-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1002, '에리히프롬', '5', 'HUMANITY', '사랑의기술', '2023-03-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1003, '비트겐슈타인', '6', 'HUMANITY', '논리철학논고', '2025-04-06 3:02:40');
insert into book(bk_idx, author, amount, category, title, created_at)
values (1004, '황정은', '7', 'NOVEL', '디디의우산', '2025-04-06 3:02:40');

insert into member(user_id, email, role, password, tel, created_at)
values ('jpa', 'jpa@jpa.com', 'ROLE_USER', '1234', '010-0112-0119', '2023-03-06 3:02:40');
insert into member(user_id, email, role, password, tel, created_at)
values ('sec', 'sec@sec.com', 'ROLE_USER', '1234', '010-0112-0120', '2023-04-06 3:02:40');
insert into member(user_id, email, role, password, tel, created_at)
values ('boot', 'boot@boot.com', 'ROLE_ADMIN', '1234', '010-0112-0121', '2025-03-06 3:02:40');
insert into member(user_id, email, role, password, tel, created_at)
values ('test', 'test@test.com', 'ROLE_USER', '1234', '010-0112-0122', '2025-04-06 3:02:40');




insert into rent(rent_id, title, user_id, created_at)
values (100001, '비행운 외 4권', 'test', '2023-03-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100002, '비행운 외 1권', 'jpa', '2023-04-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100003, '비행운 외 1권', 'sec', '2023-03-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100004, '디디의 우산 외 1권', 'test', '2025-04-06 3:02:40');
insert into rent(rent_id, title, user_id, created_at)
values (100005, '논리철학논고 외 1권', 'test', '2025-04-06 3:02:40');

insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200001, 100001, 1000, '비행운', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200002, 100001, 1001, '해리포터', 'RENT', '2023-04-13 3:02:40', '2023-04-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200007, 100001, 1004, '디디의우산', 'RENT', '2023-04-13 3:02:40', '2023-04-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200008, 100001, 1003, '논리철학논고', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200009, 100001, 1004, '디디의우산', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200003, 100002, 1000, '비행운', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200004, 100002, 1001, '해리포터', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200005, 100003, 1000, '비행운', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200006, 100003, 1001, '해리포터', 'RENT', '2023-03-13 3:02:40', '2023-03-06 3:02:40');
insert into rent_book(rb_idx, rent_id, bk_idx, book_title, state, return_date, created_at)
values (200010, 100005, 1003, '논리철학논고', 'RENT', '2025-04-13 3:02:40', '2025-03-06 3:02:40');
