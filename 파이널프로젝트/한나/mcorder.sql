

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
--	private String phoneNum; // �����ѰŴ�
--	private Date orderStartTime;
--	private Date orderCompleteTime;
--	private String orderComplete; // �ֹ��Ϸ�Ǹ� 0 �� 1�̵ȴ�
--	private int deliveryNum;
--	private String address;

select * from Memberorder;

select * from member;

desc member;
select * from memberstatus;
insert into memberstatus values(1,'�Ϲ�ȸ��');

insert into member values('kosta', 1, '1004', '���ѳ�','hanna10299@gmail.com', 
'��⵵���ֽ�', '01033515776', '3', sysdate, '1993-10-29');
  
commit;

select * from RESTAURANT;

insert into RESTAURANT values(1111, '�Ǳ��������̽���', '��⵵�����úд籸', 0,0);

insert into MCDELIVERY values(McDelivery_ordernum.nextval, '��⵵ ������');
insert into MCDELIVERY values(0, '�ֹ� ����');

insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'�Ұ����ż�Ʈ, �ݶ�, ����Ƣ��', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'�Ұ����ż�Ʈ, �ݶ�, ����Ƣ��', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'�Ұ����ż�Ʈ, �ݶ�, ����Ƣ��', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'�Ұ����ż�Ʈ, �ݶ�, ����Ƣ��', sysdate, sysdate, 0, 1111, 0); 
insert into memberorder values(MemberOrder_ordernum.nextval,'kosta', 5000, 
'�Ұ����ż�Ʈ, �ݶ�, ����Ƣ��', sysdate, sysdate, 0, 1111, 0); 










