--drop database syntek
go
create database syntek
go
use syntek
go
create table VANBAN
(
	id int primary key identity,
	title nvarchar(100) not null
)
go
create table ListFile
(
	idVanBan int references VANBAN(id),
	filename nvarchar(100) not null,
	URL nvarchar(200) not null,
	pagenumber int
)
go
insert into VANBAN(title) values(N'Văn bản 1')
insert into VANBAN(title) values(N'Văn bản 2')
insert into VANBAN(title) values(N'Văn bản 3')
insert into VANBAN(title) values(N'Văn bản 4')
insert into VANBAN(title) values(N'Văn bản 5')
insert into VANBAN(title) values(N'Văn bản 6')
go
insert into ListFile values('1', N'File 1','D:\\test1.docx', 1)
insert into ListFile values('1', N'File 2','D:\\test2.docx', 2)
insert into ListFile values('2', N'File 3','D:\\test3.docx', 3)
insert into ListFile values('2', N'File 4','D:\\test4.docx', 4)
insert into ListFile values('3', N'File 5','D:\\test5.docx', 5)
insert into ListFile values('3', N'File 6','D:\\test6.docx', 6)
insert into ListFile values('3', N'File 7','D:\\test7.docx', 6)
insert into ListFile values('4', N'File 8','D:\\test8.docx', 8)
insert into ListFile values('5', N'File 9','D:\\test9.docx', 9)
