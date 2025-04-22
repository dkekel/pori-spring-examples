-- INSERT SAMPLE DATA INTO SPRING_CAMPUS TABLE
INSERT INTO SPRING_CAMPUS (NAME, CITY, YEAR_OPENED, DESCRIPTION, ADDRESS)
VALUES ('Spring campus Pori 2025', '28130 Pori, Finland', '2025-05-05',
        'The 2025 cern spring campus is the ninth edition of a series of schools dedicated to information technology and computing. This year, the school will take place in Pori Satakunta university of applied sciences between the 05th and the 09th of may 2025.',
        'Satakunnankatu 23');

-- INSERT SAMPLE ITEMS FOR THE CAMPUS
INSERT INTO SPRING_CAMPUS_ITEMS (SPRING_CAMPUS_ID, ITEMS) VALUES (1, 'Spring');
INSERT INTO SPRING_CAMPUS_ITEMS (SPRING_CAMPUS_ID, ITEMS) VALUES (1, 'Spring MVC');
INSERT INTO SPRING_CAMPUS_ITEMS (SPRING_CAMPUS_ID, ITEMS) VALUES (1, 'Spring Data');
INSERT INTO SPRING_CAMPUS_ITEMS (SPRING_CAMPUS_ID, ITEMS) VALUES (1, 'Spring Boot');
