-- Table creation
CREATE TABLE IF NOT EXISTS PATIENTS (
    patient_id INT NOT NULL,
    patient_first_name VARCHAR(50) NOT NULL,
    patient_last_name VARCHAR(50) NOT NULL,
    patient_birth_date  DATE NOT NULL,
    patient_gender   CHAR(1)     NOT NULL
);

CREATE TABLE IF NOT EXISTS PRESCRIPTIONS (
    prescription_id INT NOT NULL,
    patient_id INT NOT NULL,
    medicine_id INT NOT NULL,
    prescription_date   DATE    NOT NULL
);

CREATE TABLE IF NOT EXISTS MEDICINES (
    medicine_id INT NOT NULL,
    min_age_consumption INT,
    max_age_consumption INT,
    gender_consumption CHAR(1)
);

-- Constraint creation
ALTER TABLE PATIENTS ADD CONSTRAINT pat_pk_patid PRIMARY KEY(patient_id);
ALTER TABLE PRESCRIPTIONS ADD CONSTRAINT pres_pk_preid PRIMARY KEY(prescription_id);
ALTER TABLE MEDICINES ADD CONSTRAINT med_pk_medid PRIMARY KEY(medicine_id);

ALTER TABLE PRESCRIPTIONS ADD CONSTRAINT pre_fk_patid FOREIGN KEY(patient_id) REFERENCES PATIENTS(patient_id);
ALTER TABLE PRESCRIPTIONS ADD CONSTRAINT pre_fk_medid FOREIGN KEY(medicine_id) REFERENCES MEDICINES(medicine_id);

ALTER TABLE PATIENTS ADD CONSTRAINT pat_ck_patgender CHECK (patient_gender IN ('M'/*MALE*/, 'F'/*FEMALE*/));
ALTER TABLE MEDICINES ADD CONSTRAINT med_ck_patgender CHECK (gender_consumption IN ('M'/*MALE*/, 'F'/*FEMALE*/));

-- Sequence for patient_id
CREATE SEQUENCE PATIENTS_SEQ
    INCREMENT BY 1
    START WITH 1000;

-- Insertions
-- Table patients
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (1, 'Banky', 'McCreery', 'M', '2009-04-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (2, 'Ulrika', 'Carn', 'F', '2001-06-29');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (3, 'Cully', 'Keynes', 'M', '2022-03-19');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (4, 'Eleanore', 'Epilet', 'F', '2017-11-07');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (5, 'Sharleen', 'Gapp', 'F', '2002-01-28');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (6, 'Jacynth', 'Aizikov', 'F', '1986-01-19');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (7, 'Tybalt', 'Laurentin', 'M', '2011-08-21');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (8, 'Rozele', 'Voak', 'F', '1988-08-17');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (9, 'Terrel', 'Yurshev', 'M', '2009-04-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (10, 'Dom', 'Esslement', 'M', '1981-09-15');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (11, 'Boony', 'Grewcock', 'M', '1996-05-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (12, 'Freedman', 'Collomosse', 'M', '2002-12-04');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (13, 'Klarika', 'Galliford', 'F', '2004-01-19');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (14, 'Bondy', 'Wrack', 'M', '2012-07-05');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (15, 'Sada', 'Klaggeman', 'F', '1996-04-04');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (16, 'Keenan', 'Shevels', 'M', '1961-09-10');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (17, 'Denny', 'Perazzo', 'F', '1985-01-02');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (18, 'Morry', 'Tixall', 'M', '1969-06-30');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (19, 'Brigida', 'Fanning', 'F', '1988-07-04');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (20, 'Sherlock', 'Grcic', 'M', '1955-09-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (21, 'Culver', 'Chater', 'M', '1977-02-05');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (22, 'Anestassia', 'Lovell', 'F', '2021-10-21');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (23, 'Kurt', 'Brunnen', 'M', '1975-03-05');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (24, 'Ned', 'Ferrelli', 'M', '1983-07-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (25, 'Mathe', 'Worswick', 'M', '1969-08-23');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (26, 'Nicholle', 'Ducker', 'F', '1983-03-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (27, 'Roxi', 'McPaik', 'F', '1982-10-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (28, 'Elana', 'Luciani', 'F', '1963-10-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (29, 'Dermot', 'Gurley', 'M', '2014-03-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (30, 'Donielle', 'Grigoroni', 'F', '1979-11-02');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (31, 'Pincus', 'Donati', 'M', '1983-09-02');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (32, 'Nealson', 'Baccas', 'M', '2016-05-17');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (33, 'Dore', 'Woodworth', 'F', '2004-11-23');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (34, 'Dorelia', 'Smurthwaite', 'F', '1961-06-03');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (35, 'Rachele', 'Siddell', 'F', '1951-02-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (36, 'Enrico', 'Megarry', 'M', '1975-11-07');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (37, 'Easter', 'Conrard', 'F', '1960-01-08');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (38, 'Arty', 'Python', 'M', '2016-08-16');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (39, 'Hamil', 'Chaddock', 'M', '2012-12-21');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (40, 'Jenda', 'MacKettrick', 'F', '1989-12-09');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (41, 'Violetta', 'Rickards', 'F', '1979-08-01');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (42, 'Editha', 'Menpes', 'F', '1963-12-03');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (43, 'Roseanna', 'Carswell', 'F', '1974-04-09');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (44, 'Mikol', 'Klimushev', 'M', '2011-02-01');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (45, 'Caritta', 'Cotton', 'F', '1974-07-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (46, 'Sioux', 'Parchment', 'F', '1994-07-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (47, 'Ingmar', 'Giovanizio', 'M', '1974-06-13');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (48, 'Lancelot', 'Petrus', 'M', '1980-11-17');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (49, 'Chicky', 'Giacomoni', 'M', '2010-02-16');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (50, 'Gordon', 'Portman', 'M', '2014-01-08');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (51, 'Abdul', 'Schultheiss', 'M', '1957-07-15');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (52, 'Bibbie', 'Halmkin', 'F', '1985-01-11');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (53, 'Whitby', 'Mosconi', 'M', '1975-01-12');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (54, 'Tommy', 'Lockie', 'M', '2022-06-10');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (55, 'Berkeley', 'Epilet', 'M', '2010-05-30');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (56, 'Cecilio', 'Fearne', 'M', '1954-07-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (57, 'Hillary', 'Goldthorpe', 'M', '2007-05-23');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (58, 'Titus', 'Donnett', 'M', '1954-07-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (59, 'Gaston', 'Littrik', 'M', '1995-05-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (60, 'Kaspar', 'Cerie', 'M', '2016-09-01');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (61, 'Turner', 'Sellens', 'M', '2022-12-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (62, 'Orel', 'Ranking', 'F', '2001-11-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (63, 'Terrill', 'Bault', 'M', '2012-08-09');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (64, 'Brittany', 'Walcher', 'F', '1977-04-23');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (65, 'Lucienne', 'Glader', 'F', '1984-02-16');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (66, 'Elinore', 'Thorbon', 'F', '1954-10-03');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (67, 'Garik', 'Hasely', 'M', '2021-05-09');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (68, 'Brock', 'Huntress', 'M', '1956-03-27');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (69, 'Jan', 'Cloney', 'M', '1981-09-01');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (70, 'Doria', 'Cron', 'F', '2021-03-23');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (71, 'Kippy', 'Sudlow', 'M', '1994-09-18');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (72, 'Lisa', 'Collough', 'F', '1982-08-18');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (73, 'Ozzie', 'Lindup', 'M', '2020-04-30');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (74, 'Edlin', 'Lammin', 'M', '2015-03-03');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (75, 'Gearalt', 'Keegan', 'M', '2012-08-25');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (76, 'Henri', 'Lakey', 'M', '1957-08-05');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (77, 'Zabrina', 'Dutch', 'F', '2013-04-14');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (78, 'Marcelia', 'Putterill', 'F', '1956-09-04');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (79, 'Darnall', 'Akitt', 'M', '2004-03-07');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (80, 'Crysta', 'Waleworke', 'F', '2022-10-13');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (81, 'Patience', 'Aizik', 'F', '2006-02-27');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (82, 'Judas', 'Billin', 'M', '1980-09-17');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (83, 'Malinda', 'Este', 'F', '1982-12-18');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (84, 'Arlinda', 'Louthe', 'F', '1968-06-19');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (85, 'Ethel', 'Bobasch', 'F', '1971-03-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (86, 'Christal', 'Truggian', 'F', '1995-12-08');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (87, 'Bentlee', 'Matias', 'M', '1996-07-30');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (88, 'Kimberlyn', 'Piecha', 'F', '1959-10-27');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (89, 'Kelsi', 'Kettlewell', 'F', '2002-05-22');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (90, 'Belinda', 'Baddiley', 'F', '2022-04-26');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (91, 'Greta', 'Blackly', 'F', '1950-02-14');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (92, 'Humbert', 'Dixie', 'M', '1957-10-02');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (93, 'Bent', 'Barzen', 'M', '2012-11-15');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (94, 'Rodolfo', 'McCallam', 'M', '1953-10-07');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (95, 'Garrik', 'Boase', 'M', '1973-04-09');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (96, 'Sutherlan', 'Ivasyushkin', 'M', '2005-12-29');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (97, 'Salim', 'Aleksandrev', 'M', '2000-01-21');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (98, 'Jillayne', 'Scholig', 'F', '2001-03-06');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (99, 'Tris', 'Cornehl', 'M', '2020-10-31');
insert into PATIENTS (patient_id, patient_first_name, patient_last_name, patient_gender, patient_birth_date) values (100, 'Inglis', 'Dawks', 'M', '2020-11-16');


