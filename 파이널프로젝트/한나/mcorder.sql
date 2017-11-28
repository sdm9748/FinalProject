

select * from Memberorder;

create sequence MemberOrder_ordernum
start with 1
increment by 1
nocache;

create sequence McDelivery_ordernum
start with 1
increment by 1
nocache;
--  private int orderNum;
--	private String id;
--	private int price;
--	private String menu; 
--	private String phoneNum; // 조인한거다
--	private Date orderStartTime;
--	private Date orderCompleteTime;
--	private String orderComplete; // 주문완료되면 0 이 1이된다
--	private int deliveryNum;
--	private String address;

select * from Memberorder;

select * from member;

desc member;
select * from memberstatus;
insert into memberstatus values(1,'일반회원');

insert into member values('kosta', 1, '1004', '최한나','hanna10299@gmail.com', 
'경기도광주시', '01033515776', '3', sysdate, '1993-10-29');
  
commit;

select * from RESTAURANT;

insert into RESTAURANT values(1111, '판교유스페이스점', '경기도성남시분당구', 0,0);

insert into MCDELIVERY values(McDelivery_ordernum.nextval, '경기도 성남시');
insert into MCDELIVERY values(0, '주문 없음');

insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'불고기버거세트, 콜라, 감자튀김', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'불고기버거세트, 콜라, 감자튀김', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'불고기버거세트, 콜라, 감자튀김', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'불고기버거세트, 콜라, 감자튀김', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'불고기버거세트, 콜라, 감자튀김', sysdate, sysdate, 0, 1111, 0); 










