-- member 테이블 생성
create table member(
   userid varchar2(15) primary key,
   password varchar2(20) not null,
   name nvarchar2(10) not null,
   gender nvarchar2(10) not null,
   email varchar2(50) not null
);
insert into member values('hong123', 'hong123@', '홍길동', '남', 'hong123@gmail.com');
insert into member values('hong123', 'hong123@', '김자바', '남', 'kim123@gmail.com');

select * from member where userid = 'hong123' and password = 'hong';

alter table member modify gender nvarchar2(10)

select * from member;

update MEMBER set name='김자바' where userid='아이디' and password='현재비밀번호';

delete from MEMBER where userid='hong12343' and password='1414';
