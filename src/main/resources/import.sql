-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO owner (uuid, name, address) values ('3c97534f-7789-4a5a-be56-dae85a76d451', 'Miriam Muster',' "Saarstraße 2a"');
INSERT INTO owner (uuid, name, address) values ('8e27c903-5fa1-496a-8eb3-756561905efe', 'Max Muster',' "Saarstraße 2a"');

INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('a63eccb7-5450-4bad-8516-9015b6300e8d', 'Rupert', 'WALRUS', 'Where the hell did he even come from?', true,
        null);
insert into animal
    (uuid, name, type, comment, available, owner_uuid)
values
    ('5e64362e-b8e8-4361-ae99-b44109ba20a4', 'Miezi', 'WALRUS', NULL, 'true', NULL);


INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('f5a3c8da-7d51-4b96-b3e3-bb9cba2f6391', 'Ella', 'AFRICAN_ELEPHANT', 'Loves to splash in water.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('4bead0b7-93e1-468b-9502-e1cfc60e1cb0', 'Max', 'AMERICAN_BISON', 'Very strong and majestic.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('a3e6d49e-485d-4c0e-82d3-50e7c4e8b0b7', 'Zara', 'BALD_EAGLE', 'Has a keen eye for fish.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('8e5a99a5-7022-4bc3-83d8-87f792ce8724', 'Toby', 'BENGAL_TIGER', 'Loves to hide in the tall grass.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('97a850de-71f8-41c4-8c79-f4fbb4f7083a', 'Rocky', 'BLACK_BEAR', 'Often seen climbing trees.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('f98c3a4f-7a4a-43b4-b1c2-0c71a3e2f8a9', 'Bella', 'BLUE_WHALE', 'The gentle giant of the sea.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('65956a62-cf5b-4b93-8e84-20c5b4de9c92', 'Charlie', 'CHEETAH', 'The fastest land animal.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('dd8e02a9-53b2-48cc-8612-2a31c4d7f3c0', 'Daisy', 'CHIMPANZEE', 'Very playful and intelligent.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('8bc69b78-4588-4c93-8c7e-88d23e3c9b14', 'Oliver', 'COYOTE', 'Has a sharp sense of hearing.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('bd3af3cc-4a42-47d1-9db7-1cfb174c5af1', 'Luna', 'DOLPHIN', 'Loves to perform tricks.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('c3a21db5-82d4-45c2-9fa9-3f7e5d14b3b6', 'Milo', 'GIANT_PANDA', 'Eats bamboo all day.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('ff5e1cb0-3147-438d-8c68-57b5a6e3c2f8', 'Nina', 'GRAY_WOLF', 'Alpha of the pack.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('da0b1f29-1e6b-4971-91b4-9b8a0db4d1a4', 'Oscar', 'HIPPOPOTAMUS', 'Enjoys wallowing in the mud.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('47b971d2-0ae5-403d-928f-1fd9a7f8a7e5', 'Rosie', 'KANGAROO', 'Great at boxing.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('0f42cddb-3f98-4a5e-9d6e-abe59b2d4d6d', 'Simba', 'LION', 'King of the jungle.', true, NULL);
INSERT INTO animal (uuid, name, type, comment, available, owner_uuid)
values ('4eb33ab8-1e6a-4967-9b8d-6e8f2c8e5f5a', 'Zoe', 'MEERKAT', 'Always on the lookout.', true, NULL);
