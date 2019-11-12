create table evaluationLabel
(
	movieName varchar(50) not null,
	labelType varchar(50) not null,
    labelContent varchar(50) not null,
    primary key(labelContent)
)