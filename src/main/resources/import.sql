-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
insert into ANIMAL
    (uuid, name, type, comment, available, owner)
values
    ('5e64362e-b8e8-4361-ae99-b44109ba20a4', 'Miezi', 'WALRUS', NULL, 'true', NULL);