CREATE TABLE IF NOT EXISTS Users (
   Id serial PRIMARY KEY,
   Surname VARCHAR(50) NOT NULL,
   Firstname VARCHAR(50) NOT NULL,
   Patronymic VARCHAR(50),
   Login VARCHAR(50) NOT NULL,
   Password VARCHAR(50) NOT NULL,
   Rank VARCHAR(50),
   Age INT NOT NULL,
   Sex VARCHAR(50) NOT NULL,
   Adventurer BOOLEAN NOT NULL,
   Phone_number VARCHAR(50) ,
   Email VARCHAR(50),
   Role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Orders (
   Id serial PRIMARY KEY,
   Title VARCHAR(50) NOT NULL,
   Descriptions text NOT NULL,
   Rank VARCHAR(50),
   Reward float,
   Location VARCHAR(250) NOT NULL,
   Photo_url bytea,
   Status VARCHAR(50) NOT NULL,
   Date_added datetime NOT NULL,
   Adventurer_id int REFERENCES users(id),
   Customer_id int NOT NULL REFERENCES users(id)
);