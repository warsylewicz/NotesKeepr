INSERT INTO role (id, role_type) VALUES (1, 0);
INSERT INTO role (id, role_type) VALUES (2, 1);

INSERT INTO account (id, email, first_name, last_name, password, user_name)
VALUES (1, 'admin@admin.com', 'Admin', 'User', 'password', 'admin');

INSERT INTO account (id, email, first_name, last_name, password, user_name)
VALUES (2, 'joshlynn79@gmail.com', 'Josh', 'Lynn', 'password', 'lynnjoshua');

INSERT INTO account (id, email, first_name, last_name, password, user_name)
VALUES (3, 'fredflintstone@gmail.com', 'Fred', 'Flintstone', 'password', 'fred');

INSERT INTO account (id, email, first_name, last_name, password, user_name)
VALUES (4, 'barneyrubble@gmail.com', 'Barney', 'Rubble', 'password', 'barney');

INSERT INTO account (id, email, first_name, last_name, password, user_name)
VALUES (5, 'wilmaflintstone@gmail.com', 'Wilma', 'Flintstone', 'password', 'wilma');

INSERT INTO account_roles (accounts_id, roles_id) VALUES (1, 1);
INSERT INTO account_roles (accounts_id, roles_id) VALUES (1, 2);
INSERT INTO account_roles (accounts_id, roles_id) VALUES (2, 2);
INSERT INTO account_roles (accounts_id, roles_id) VALUES (3, 2);
INSERT INTO account_roles (accounts_id, roles_id) VALUES (4, 2);
INSERT INTO account_roles (accounts_id, roles_id) VALUES (5, 2);

INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (1, 'Note 1', 'Test1 - User Admin owns this note', 1, (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (2, 'Note 2', 'Test2 - User Admin owns this note', 1, (STR_TO_DATE('5/16/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (3, 'Note 3', 'Test3 - User Admin owns this note', 1, (STR_TO_DATE('5/23/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (4, 'Note 4', 'Test4 - User Josh owns this note', 2, (STR_TO_DATE('4/15/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (5, 'Note 5', 'Test5 - User Josh owns this note', 2, (STR_TO_DATE('5/14/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (6, 'Note 6', 'Test6 - User Josh owns this note', 2, (STR_TO_DATE('5/12/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (7, 'Note 7', 'Test7 - User Admin owns this note', 1, (STR_TO_DATE('5/15/2012 8:06:27 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (8, 'Note 8', 'Test8 - User Josh owns this note', 2, (STR_TO_DATE('5/15/2012 8:06:25 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (9, 'Note 9', 'Test9 - User Josh owns this note', 2, (STR_TO_DATE('2/15/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (10, 'Note 10', 'Test10 - User Josh owns this note', 2, (STR_TO_DATE('6/15/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (11, 'Note 11', 'Test11 - User Admin owns this note', 1, (STR_TO_DATE('5/30/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (12, 'Note 12', 'Test12 - User Josh owns this note', 2, (STR_TO_DATE('5/28/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (13, 'Note 13', 'Test13 - User Josh owns this note', 2, (STR_TO_DATE('5/01/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (14, 'Note 14', 'Test14 - User Josh owns this note', 2, (STR_TO_DATE('5/05/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (15, 'Note 15', 'Test15 - User Josh owns this note', 2, (STR_TO_DATE('5/29/2012 8:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));
INSERT INTO note (id, title, content, owner_id, date_modified, date_created) VALUES (16, 'Note 16', 'Test16 - User Josh owns this note', 2, (STR_TO_DATE('5/15/2012 6:06:26 AM', '%c/%e/%Y %r')), (STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r')));

INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 1);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 2);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 3);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 4);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 5);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 6);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 7);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 8);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 9);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 10);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 11);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 12);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 13);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 14);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 15);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 16);

INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 12);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 13);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 14);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 15);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (1, 16);

INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 1);
INSERT INTO account_notes (collaborators_id, notes_id) VALUES (2, 2);

# INSERT INTO accountids (note_id, collaborators) VALUES (12, 1);
# INSERT INTO accountids (note_id, collaborators) VALUES (13, 1);
# INSERT INTO accountids (note_id, collaborators) VALUES (14, 1);
# INSERT INTO accountids (note_id, collaborators) VALUES (15, 1);
# INSERT INTO accountids (note_id, collaborators) VALUES (16, 1);
#
# INSERT INTO accountids (note_id, collaborators) VALUES (1, 2);
# INSERT INTO accountids (note_id, collaborators) VALUES (2, 2);







