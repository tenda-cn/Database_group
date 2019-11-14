CREATE TABLE publish
(
uid int NOT NULL,
cid int NOT NULL CONSTRAINT C_Fore FOREIGN KEY REFERENCES comment(cid),
CONSTRAINT U_C_Prim PRIMARY KEY(uid,cid)
)