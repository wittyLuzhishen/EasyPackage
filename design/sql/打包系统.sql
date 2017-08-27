CREATE TABLE Channel (
  id     int(10), 
  name   varchar(255) comment '渠道的名称，例如：DEBUG、DEFAULT、STAGING、meng_1254_1_android', 
  `desc` varchar(255) comment '渠道的描述，例如：应用宝、豌豆荚');
CREATE TABLE Task (
  id          int(10), 
  taskGroupId int(10), 
  ChannelId   int(10), 
  status      int(10) comment '任务状态，0新建、1运行中、2成功、3失败、4被终止', 
  startTime   bigint(20), 
  endTime     bigint(20), 
  url         varchar(255) comment '打包成功后包的下载地址', 
  barcode     varchar(255), 
  machineIp   varchar(255) comment '执行该任务的Worker的IP', 
  gradleId    int(11));
CREATE TABLE TaskGroup (
  id             int(10), 
  appId          int(10), 
  branch         varchar(255), 
  version        int(10), 
  createTime     bigint(20), 
  endTime        bigint(20), 
  userId         int(10), 
  changeLogRange varchar(255), 
  facadeIp       varchar(255) comment '用于打包Facade抢任务', 
  lockedTime     bigint(20) comment '该TaskGroup被某Facade请求锁定的时间，用于存在性检测成功后检索出特定条目', 
  status         int(11) comment '0 创建中，1 待分配，2 已分配，3 开始执行') comment='记录某次打包行为包含的任务信息';
CREATE TABLE MailReceiver (
  id    int(10), 
  name  int(10), 
  email int(10));
CREATE TABLE TaskGroup_MailReceiver (
  id             int(10), 
  taskGroupId    int(10), 
  mailReceiverId int(10)) comment='记录某TaskGroup完成后需要邮件通知的邮件地址';
CREATE TABLE App (
  id         int(10), 
  name       varchar(255) comment '应用名称，例如：walilive、miliao', 
  `desc`     varchar(255) comment '描述，例如：直播、米聊', 
  projectDir varchar(255));
CREATE TABLE `User` (
  id        int(10), 
  loginName varchar(255) comment '登录用户名，主键', 
  password  varchar(255) comment '登录密码的映射', 
  name      varchar(255) comment '用户昵称', 
  type      int(10) comment '用户类型，0 普通用户、1 管理员');
CREATE TABLE App_Channel (
  id        int(10), 
  appId     int(10), 
  channelId int(10)) comment='记录某app拥有的渠道';
CREATE TABLE Machine (
  id                int(10), 
  ip                varchar(255), 
  lastHeartBeatTime bigint(20) comment '最后一次心跳时间');
CREATE TABLE Gradle (
  id         int(11), 
  machineId  int(11), 
  pid        int(11), 
  facadeIp   varchar(255), 
  lockedTime bigint(20), 
  status     int(11) comment '0 空闲，1 运行中');
ALTER TABLE Task ADD INDEX FKTask707730 (), ADD CONSTRAINT FKTask707730 FOREIGN KEY () REFERENCES TaskGroup ();
ALTER TABLE Task ADD INDEX FKTask766168 (), ADD CONSTRAINT FKTask766168 FOREIGN KEY () REFERENCES Channel ();
ALTER TABLE TaskGroup_MailReceiver ADD INDEX FKTaskGroup_546427 (), ADD CONSTRAINT FKTaskGroup_546427 FOREIGN KEY () REFERENCES MailReceiver ();
ALTER TABLE TaskGroup_MailReceiver ADD INDEX FKTaskGroup_108554 (), ADD CONSTRAINT FKTaskGroup_108554 FOREIGN KEY () REFERENCES TaskGroup ();
ALTER TABLE TaskGroup ADD INDEX FKTaskGroup661068 (), ADD CONSTRAINT FKTaskGroup661068 FOREIGN KEY () REFERENCES `User` ();
ALTER TABLE App_Channel ADD INDEX FKApp_Channe908830 (), ADD CONSTRAINT FKApp_Channe908830 FOREIGN KEY () REFERENCES App ();
ALTER TABLE App_Channel ADD INDEX FKApp_Channe631206 (), ADD CONSTRAINT FKApp_Channe631206 FOREIGN KEY () REFERENCES Channel ();
ALTER TABLE Gradle ADD INDEX FKGradle939037 (), ADD CONSTRAINT FKGradle939037 FOREIGN KEY () REFERENCES Machine ();
