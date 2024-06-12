-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO ANIMAL (uuid, name, type, comment, owner)
values ('a63eccb7-5450-4bad-8516-9015b6300e8d', 'Rupert', 'WALRUS', 'Where the hell did he even come from?', null);
insert into ANIMAL (uuid, name, type, comment, owner)
values ('5e64362e-b8e8-4361-ae99-b44109ba20a4', 'Miezi', 'WALRUS', null, null);