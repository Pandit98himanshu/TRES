create database tresdb;

use tresdb;
create table station (
	code varchar(5) primary key,
    name varchar(255)
);

create table train (
	id int primary key,
    name varchar(255),
    status varchar(20)
);

drop table if exists schedule;
create table schedule (
	id int primary key,
	train_id int,
    station_code varchar(5),
    week_day varchar(10)
);

drop table if exists route;
create table route (
	id int primary key,
	train_id int,
    station_code varchar(5),
    halt_no int,
    day int,
    arr time,
    dep time
);

insert into station values 
('HWH', 'Howrah'),
('BGP', 'Bhagalpur'),
('PRNA', 'Purnia'),
('ARA', 'Arrah'),
('BLR', 'Bangalore'),
('CLG', 'Kahalgaon'),
('SDAH', 'Sealdah');

select * from station;

insert into train values
(70032, 'Royal Express', 'Cancelled'),
(23456, 'Tejas Express', 'Running'),
(43575, 'Mohitu Express', 'Running'),
(43576, 'Mohitva Express', 'Running'),
(35688, 'Purnia Bhagalpur Local', 'Running'),
(35689, 'Bhagalpur Purnia Local', 'Running'),
(83451, 'Howrah Arrah Superfast Express', 'Running'),
(83452, 'Arrah Howrah Superfast Express', 'Running');

select * from train;


insert into schedule values
(1, 70032, 'PRNA', 'mon'),
(2, 70032, 'PRNA', 'thu'),
(3, 70032, 'BLR', 'mon'),
(4, 70032, 'BLR', 'thu'),

(5, 23456, 'HWH', 'mon'),
(6, 23456, 'HWH', 'thu'),
(7, 23456, 'BGP', 'tue'),
(8, 23456, 'BGP', 'fri'),
(9, 23456, 'ARA', 'tue'),
(10, 23456, 'ARA', 'fri'),

(11, 43575, 'ARA', 'mon'),
(12, 43575, 'ARA', 'tue'),
(13, 43575, 'ARA', 'wed'),
(14, 43575, 'ARA', 'thu'),
(15, 43575, 'ARA', 'fri'),
(16, 43575, 'ARA', 'sat'),
(17, 43575, 'ARA', 'sun'),
(18, 43575, 'PRNA', 'mon'),
(19, 43575, 'PRNA', 'tue'),
(20, 43575, 'PRNA', 'wed'),
(21, 43575, 'PRNA', 'thu'),
(22, 43575, 'PRNA', 'fri'),
(23, 43575, 'PRNA', 'sat'),
(24, 43575, 'PRNA', 'sun'),
(25, 43575, 'SDAH', 'mon'),
(26, 43575, 'SDAH', 'tue'),
(27, 43575, 'SDAH', 'wed'),
(28, 43575, 'SDAH', 'thu'),
(29, 43575, 'SDAH', 'fri'),
(30, 43575, 'SDAH', 'sat'),
(31, 43575, 'SDAH', 'sun'),
(32, 43575, 'BLR', 'mon'),
(33, 43575, 'BLR', 'tue'),
(34, 43575, 'BLR', 'wed'),
(35, 43575, 'BLR', 'thu'),
(36, 43575, 'BLR', 'fri'),
(37, 43575, 'BLR', 'sat'),
(38, 43575, 'BLR', 'sun'),
 
(39, 43576, 'BLR', 'mon'),
(40, 43576, 'BLR', 'tue'),
(41, 43576, 'BLR', 'wed'),
(42, 43576, 'BLR', 'thu'),
(43, 43576, 'BLR', 'fri'),
(44, 43576, 'BLR', 'sat'),
(45, 43576, 'BLR', 'sun'),
(46, 43576, 'SDAH', 'mon'),
(47, 43576, 'SDAH', 'tue'),
(48, 43576, 'SDAH', 'wed'),
(49, 43576, 'SDAH', 'thu'),
(50, 43576, 'SDAH', 'fri'),
(51, 43576, 'SDAH', 'sat'),
(52, 43576, 'SDAH', 'sun'),
(53, 43576, 'PRNA', 'mon'),
(54, 43576, 'PRNA', 'tue'),
(55, 43576, 'PRNA', 'wed'),
(56, 43576, 'PRNA', 'thu'),
(57, 43576, 'PRNA', 'fri'),
(58, 43576, 'PRNA', 'sat'),
(59, 43576, 'PRNA', 'sun'),
(60, 43576, 'ARA', 'mon'),
(61, 43576, 'ARA', 'tue'),
(62, 43576, 'ARA', 'wed'),
(63, 43576, 'ARA', 'thu'),
(64, 43576, 'ARA', 'fri'),
(65, 43576, 'ARA', 'sat'),
(66, 43576, 'ARA', 'sun'),
 
(67, 35688, 'PRNA', 'mon'),
(68, 35688, 'PRNA', 'tue'),
(69, 35688, 'PRNA', 'wed'),
(70, 35688, 'PRNA', 'thu'),
(71, 35688, 'PRNA', 'fri'),
(72, 35688, 'PRNA', 'sat'),
(73, 35688, 'PRNA', 'sun'),
(74, 35688, 'BGP', 'mon'),
(75, 35688, 'BGP', 'tue'),
(76, 35688, 'BGP', 'wed'),
(77, 35688, 'BGP', 'thu'),
(78, 35688, 'BGP', 'fri'),
(79, 35688, 'BGP', 'sat'),
(80, 35688, 'BGP', 'sun'),
 
(81, 35689, 'BGP', 'mon'),
(82, 35689, 'BGP', 'tue'),
(83, 35689, 'BGP', 'wed'),
(84, 35689, 'BGP', 'thu'),
(85, 35689, 'BGP', 'fri'),
(86, 35689, 'BGP', 'sat'),
(87, 35689, 'BGP', 'sun'),
(88, 35689, 'PRNA', 'mon'),
(89, 35689, 'PRNA', 'tue'),
(90, 35689, 'PRNA', 'wed'),
(91, 35689, 'PRNA', 'thu'),
(92, 35689, 'PRNA', 'fri'),
(93, 35689, 'PRNA', 'sat'),
(94, 35689, 'PRNA', 'sun'),
 
(95, 83451, 'HWH', 'tue'),
(96, 83451, 'HWH', 'thu'),
(97, 83451, 'HWH', 'sat'),
(98, 83451, 'SDAH', 'tue'),
(99, 83451, 'SDAH', 'thu'),
(100, 83451, 'SDAH', 'sat'),
(101, 83451, 'CLG', 'wed'),
(102, 83451, 'CLG', 'fri'),
(103, 83451, 'CLG', 'sun'),
(104, 83451, 'BGP', 'wed'),
(105, 83451, 'BGP', 'fri'),
(106, 83451, 'BGP', 'sun'),
(107, 83451, 'PRNA', 'wed'),
(108, 83451, 'PRNA', 'fri'),
(109, 83451, 'PRNA', 'sun'),
(110, 83451, 'ARA', 'wed'),
(111, 83451, 'ARA', 'fri'),
(112, 83451, 'ARA', 'sun'),

(113, 83452, 'ARA', 'mon'),
(114, 83452, 'ARA', 'thu'),
(115, 83452, 'ARA', 'sat'),
(116, 83452, 'PRNA', 'mon'),
(117, 83452, 'PRNA', 'thu'),
(118, 83452, 'PRNA', 'sat'),
(119, 83452, 'BGP', 'mon'),
(120, 83452, 'BGP', 'thu'),
(121, 83452, 'BGP', 'sat'),
(122, 83452, 'CLG', 'mon'),
(123, 83452, 'CLG', 'thu'),
(124, 83452, 'CLG', 'sat'),
(125, 83452, 'SDAH', 'tue'),
(126, 83452, 'SDAH', 'thu'),
(127, 83452, 'SDAH', 'sat'),
(128, 83452, 'HWH', 'tue'),
(129, 83452, 'HWH', 'thu'),
(130, 83452, 'HWH', 'sat');

select * from schedule;


insert into route values
(1, 70032, 'PRNA', 0, 0, '11:0', '11:0'),
(2, 70032, 'BLR', 1, 3, '3:0', '3:0'),

(3, 23456, 'HWH', 0, 0, '9:30', '9:30'),
(4, 23456, 'BGP', 1, 1, '4:0', '4:5'),
(5, 23456, 'ARA', 2, 1, '13:0', '13:0'),

(6, 43575, 'ARA', 0, 0, '3:0', '3:0'),
(7, 43575, 'PRNA', 1, 0, '4:0', '4:2'),
(8, 43575, 'SDAH', 2, 0, '8:30', '8:35'),
(9, 43575, 'BLR', 3, 0, '11:0', '11:0'),

(10, 43576, 'BLR', 0, 0, '12:35', '12:35'),
(11, 43576, 'SDAH', 1, 0, '18:30', '18:34'),
(12, 43576, 'PRNA', 2, 0, '19:0', '19:5'),
(13, 43576, 'ARA', 3, 0, '22:0', '22:0'),

(14, 35688, 'PRNA', 0, 0, '6:0', '6:0'),
(15, 35688, 'BGP', 1, 0, '10:0', '10:0'),

(16, 35689, 'BGP', 0, 0, '11:30', '11:30'),
(17, 35689, 'PRNA', 1, 0, '12:0', '12:0'),

(18, 83451, 'HWH', 0, 0, '19:0', '19:0'),
(19, 83451, 'SDAH', 1, 0, '21:30', '21:32'),
(20, 83451, 'CLG', 2, 1, '6:15', '6:18'),
(21, 83451, 'BGP', 3, 1, '7:0', '7:5'),
(22, 83451, 'PRNA', 4, 1, '10:0', '10:4'),
(23, 83451, 'ARA', 5, 1, '11:30', '11:30'),

(24, 83452, 'ARA', 0, 0, '13:0', '13:0'),
(25, 83452, 'PRNA', 1, 0, '15:30', '15:34'),
(26, 83452, 'BGP', 2, 0, '17:0', '17:2'),
(27, 83452, 'CLG', 3, 0, '18:45', '18:50'),
(28, 83452, 'SDAH', 4, 1, '8:0', '8:4'),
(29, 83452, 'HWH', 5, 1, '10:10', '10:10');

select * from route;

create or replace view view_src_train_id as 
	select train_id 
    from schedule 
    where station_code='SDAH' and week_day='thu';
    
create or replace view view_src as 
    select * from route 
    where train_id in (view_src_train_id) 
    and station_code='SDAH';

create or replace view view_dest as 
    select * from route 
    where train_id in (view_src_train_id) 
    and station_code='PRNA';

select * from view_src;
select * from view_dest;

create or replace view view_res as 
    select view_dest.train_id, view_dest.station_code, view_dest.arr
    from view_src join view_dest on view_src.train_id = view_dest.train_id
    and view_src.halt_no < view_dest.halt_no;

select * from view_res;



