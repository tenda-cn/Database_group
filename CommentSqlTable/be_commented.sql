CREATE TABLE be_commented
(
mID int NOT NULL,
cid int NOT NULL CONSTRAINT C_Fore1 FOREIGN KEY REFERENCES comment(cid),
see_movie_status varchar(10) NOT NULL ,
CONSTRAINT M_C_Prim PRIMARY KEY(mID,cid)
)