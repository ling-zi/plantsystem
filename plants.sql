/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/25 17:38:25                           */
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
   uname                varchar(20) comment '昵称',
   uemail               varchar(30) comment '用于登录',
   upassword            varchar(20),
   uimageurl            varchar(200),
   ustatus              int comment '0：普通用户 1：管理员',
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
   rid                  int not null,
   pmsid                int not null,
   primary key (rid, pmsid)
);

/*==============================================================*/
/* Table: fk_user_has_role                                      */
/*==============================================================*/
create table fk_user_has_role
(
   uid                  int not null,
   rid                  int not null,
   primary key (uid, rid)
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
   rid                  int not null auto_increment,
   rname                varchar(20),
   rdesc                varchar(200),
   rstatus              int,
   primary key (rid)
);

alter table roles comment '在系统里的职位 例如：普通用户、管理员、超级管理员';

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
   cstatus              int comment '0：存在 1：删除',
   primary key (cid)
);

alter table fk_role_has_permission add constraint FK_fk_role_has_permission foreign key (rid)
      references roles (rid) on delete restrict on update restrict;

alter table fk_role_has_permission add constraint FK_fk_role_has_permission2 foreign key (pmsid)
      references permission (pmsid) on delete restrict on update restrict;

alter table fk_user_has_role add constraint FK_fk_user_has_role foreign key (uid)
      references User (uid) on delete restrict on update restrict;

alter table fk_user_has_role add constraint FK_fk_user_has_role2 foreign key (rid)
      references roles (rid) on delete restrict on update restrict;

alter table usercomments add constraint FK_fk_plants_hascomment foreign key (pid)
      references plant (pid) on delete restrict on update restrict;

alter table usercomments add constraint FK_写 foreign key (uid)
      references User (uid) on delete restrict on update restrict;

