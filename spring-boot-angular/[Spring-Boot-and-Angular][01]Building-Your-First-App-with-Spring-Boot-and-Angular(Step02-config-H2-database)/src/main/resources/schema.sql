DROP TABLE BIKE;
CREATE TABLE BIKE
(
   ID                    INTEGER NOT NULL,
   NAME                  VARCHAR(255) NOT NULL,
   EMAIL                 VARCHAR(255),
   PHONE                 VARCHAR(255),   
   MODEL                 VARCHAR(255),   
   SERIALNUMBER          VARCHAR(255),   
   PURCHASEPRICE         NUMBER,
   PURCHASEDATE          DATE, 
   CONTACT               BOOLEAN,
   PRIMARY KEY(ID)
);
