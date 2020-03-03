INSERT INTO room(name) VALUES ('PHELPS 2510');
INSERT INTO room(name) VALUES ('PHELPS 3526');
INSERT INTO room(name) VALUES ('PHELPS 3525');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 16','F19','Mirza', 'mirza@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 160','F19','Ding', 'ding@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 130A','W20','Koc', 'koc@ucsb.edu');
INSERT INTO course_offering (course_id,quarter,instructor_name, instructor_email) VALUES ('CMPSC 130B','W20','Lokshtanov', 'lokshtanov@ucsb.edu');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Scott','Chow','scottpchow@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Zach','Sisco','zachsisco@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Yinon','Rousso','yinonRousso@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('Kate','Perkins','kateperkins@example.org');
INSERT INTO tutor (first_name,last_name,email) VALUES ('George','Kripac','Georgekripac@example.org');
INSERT INTO tutor_assignment(course_offering_id, tutor_id) VALUES (1, 1);
INSERT INTO room_availability(quarter, start_time, end_time, day, room_id) VALUES ('W20', '800', '900', 'W', '1');
INSERT INTO room_availability(quarter, start_time, end_time, day, room_id) VALUES ('W20', '1100', '1230', 'T', '2');
INSERT INTO room_availability(quarter, start_time, end_time, day, room_id) VALUES ('W20', '1200', '1500', 'M', '3');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('1', '800', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('1', '830', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('2', '1100', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('2', '1130', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('2', '1200', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1200', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1230', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1300', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1330', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1400', '30');
INSERT INTO time_slot(room_availability_id, start_time, duration) VALUES ('3', '1430', '30');
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (2,1);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (2,2);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (2,3);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (2,4);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (1,5);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (1,6);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (1,7);
INSERT INTO time_slot_assignment(tutor_id, time_slot_id) VALUES (1,8);
