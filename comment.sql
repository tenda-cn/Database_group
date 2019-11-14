CREATE TABLE comment
(
cid int NOT NULL CONSTRAINT comment_Prim PRIMARY KEY,
c_time VARCHAR(50) NOT NULL ,
c_content text,
c_facility VARCHAR(10) NOT NULL,
useful_amount int NOT NULL,
c_score decimal(10,2) NOT NULL,
see_movie_status VARCHAR(10) NOT NULL
)