INSERT INTO role VALUES (1, 0);
INSERT INTO role VALUES (2, 1);

INSERT INTO account
VALUES (1, 'admin@admin.com', 'admin', 'admin', 'password', 'admin');

INSERT INTO account
VALUES (2, 'joshlynn79@gmail.com', 'Josh', 'Lynn', 'password', 'lynnjoshua');

INSERT INTO account_roles (account_id, roles_id) VALUES (1, 1);
# INSERT INTO account_roles (account_id, roles_id) VALUES (1, 2);
# INSERT INTO account_roles (account_id, roles_id) VALUES (2, 2);

INSERT INTO note (id, content, owner_id) VALUES (1, 'Test1 - User Admin owns this note', 1);
INSERT INTO note (id, content, owner_id) VALUES (2, 'Test2 - User Admin owns this note', 1);
INSERT INTO note (id, content, owner_id) VALUES (3, 'Test3 - User Admin owns this note', 1);
INSERT INTO note (id, content, owner_id) VALUES (4, 'Test4 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (5, 'Test5 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (6, 'Test6 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (7, 'Test7 - User Admin owns this note', 1);
INSERT INTO note (id, content, owner_id) VALUES (8, 'Test8 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (9, 'Test9 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (10, 'Test10 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (11, 'Test11 - User Admin owns this note', 1);
INSERT INTO note (id, content, owner_id) VALUES (12, 'Test12 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (13, 'Test13 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (14, 'Test14 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (15, 'Test15 - User Josh owns this note', 2);
INSERT INTO note (id, content, owner_id) VALUES (16, 'Test16 - User Josh owns this note', 2);

INSERT INTO account_notes (account_id, notes_id) VALUES (1, 1);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 2);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 3);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 4);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 5);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 6);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 7);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 8);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 9);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 10);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 11);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 12);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 13);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 14);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 15);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 16);

INSERT INTO account_notes (account_id, notes_id) VALUES (1, 12);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 13);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 14);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 15);
INSERT INTO account_notes (account_id, notes_id) VALUES (1, 16);

INSERT INTO account_notes (account_id, notes_id) VALUES (2, 1);
INSERT INTO account_notes (account_id, notes_id) VALUES (2, 2);




