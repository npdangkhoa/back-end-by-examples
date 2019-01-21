--DROP TABLE BIKE;
CREATE TABLE BIKER
(
   ID                    INTEGER NOT NULL,
   NAME                  VARCHAR(255) NOT NULL,
   EMAIL                 VARCHAR(255),
   ROLE                  VARCHAR(255),
   PHONE                 VARCHAR(255),   
   MODEL                 VARCHAR(255),   
   SERIAL_NUMBER         VARCHAR(255),   
   PURCHASE_PRICE        NUMBER,
   PURCHASE_DATE         DATE, 
   CONTACT               BOOLEAN,
   PRIMARY KEY(ID)
);


