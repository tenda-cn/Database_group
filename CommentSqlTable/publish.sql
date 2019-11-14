CREATE TABLE publish
(
uid int NOT NULL,
cid int NOT NULL CONSTRAINT C_Fore FOREIGN KEY REFERENCES comment(cid),
c_score decimal(10,2) NOT NULL ,
CONSTRAINT U_C_Prim PRIMARY KEY(uid,cid)
)