INSERT INTO room(name) VALUES ('Phelps 2510');
INSERT INTO room(name) VALUES('Phelps 3526');
INSERT INTO room(name) VALUES('CSIL');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 16','F19','Mirza', 'mirza@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 160','F19','Ding', 'ding@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 130A','W20','Koc', 'koc@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 130B','W20','Lokshtanov', 'lokshtanov@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC
130C','W20','Lokshtanov', 'li-el@ucsb.edu');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Scott','Chow','scottpchow@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Zach','Sisco','zachsisco@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Yinon','Rousso','yinonRousso@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Kate','Perkins','kateperkins@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('George','Kripac','Georgekripac@example.org');
INSERT INTO tutor_assignment(course_offering_id, tutor_id) VALUES (1, 1);
