/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/25 16:36:28                           */
/*==============================================================*/


drop table if exists User;

drop table if exists fk_role_has_permission;

drop table if exists fk_user_has_role;

drop table if exists permission;

drop table if exists plant;

drop table if exists roles;

drop table if exists usercomments;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   uid                  int not null auto_increment,
   uname                varchar(20) comment '�ǳ�',
   uemail               varchar(30) comment '���ڵ�¼',
   upassword            varchar(20),
   uimageurl            varchar(200),
   ustatus              int comment '0����ͨ�û� 1������Ա',
   ucellphone           varchar(20),
   usexy                varchar(2),
   uaddress             varchar(100),
   primary key (uid)
);

/*==============================================================*/
/* Table: fk_role_has_permission                                */
/*==============================================================*/
create table fk_role_has_permission
(
   ��ɫID                 int not null,
   pmsid                int not null,
   primary key (��ɫID, pmsid)
);

/*==============================================================*/
/* Table: fk_user_has_role                                      */
/*==============================================================*/
create table fk_user_has_role
(
   uid                  int not null,
   ��ɫID                 int not null,
   primary key (uid, ��ɫID)
);

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   pmsid                int not null auto_increment,
   pmsname              varchar(20),
   pmsdesc              varchar(200),
   pmsurl               varchar(200),
   pmsstatus            int,
   primary key (pmsid)
);

/*==============================================================*/
/* Table: plant                                                 */
/*==============================================================*/
create table plant
(
   pid                  int not null auto_increment,
   pname                varchar(30),
   pphotos              varchar(200),
   pdesc                varchar(3000),
   pfamily              varchar(20),
   pgenus               varchar(20),
   primary key (pid)
);

alter table plant comment 'succulentplant';

/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles
(
   ��ɫID                 int not null auto_increment,
   ��ɫ����                 varchar(20),
   ��ɫ����                 varchar(200),
   ��ɫ״̬                 int,
   primary key (��ɫID)
);

alter table roles comment '��ϵͳ���ְλ ���磺��ͨ�û�������Ա����������Ա';

/*==============================================================*/
/* Table: usercomments                                          */
/*==============================================================*/
create table usercomments
(
   cid                  int not null auto_increment,
   uid                  int,
   pid                  int,
   ccontext             varchar(280),
   ctime                date,
   cstatus              int comment '0������ 1��ɾ��',
   primary key (cid)
);

alter table fk_role_has_permission add constraint FK_fk_role_has_permission foreign key (��ɫID)
      references roles (��ɫID) on delete restrict on update restrict;

alter table fk_role_has_permission add constraint FK_fk_role_has_permission2 foreign key (pmsid)
      references permission (pmsid) on delete restrict on update restrict;

alter table fk_user_has_role add constraint FK_fk_user_has_role foreign key (uid)
      references User (uid) on delete restrict on update restrict;

alter table fk_user_has_role add constraint FK_fk_user_has_role2 foreign key (��ɫID)
      references roles (��ɫID) on delete restrict on update restrict;

alter table usercomments add constraint FK_fk_plants_hascomment foreign key (pid)
      references plant (pid) on delete restrict on update restrict;

alter table usercomments add constraint FK_д foreign key (uid)
      references User (uid) on delete restrict on update restrict;

