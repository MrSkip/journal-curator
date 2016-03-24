# journal-curator
Create the program that can work with informations about students visiting and progress.
The program must provide the work with the next data:

- Group;
- Student;
- Visiting;
- Progress;
- Subject;
- Department.

On the start the program must show window-logo with the college, and changed it`s to a window with all groups
with the support of search for spesiality in the table that can`t edit (not less than 10 records).
From the main window the user must have access to other tables.
#The program must cover:

- Add, edit, delete record from all tables - use double click on the cell;
- Show all subjects in selected group;
- Show all curators in selected group;
- Show all students in selected group;
- Show full information about student in a report;
- Show students with active reprimand;
- Show students with benefit in group and department;
- Show teenagers in department;
- Show information about students visiting for week and month;
- Show students for prevention in selected group;
- Show students progress for week and month;
- Show students with negative mark.

# The main features:
- MySQL
- Spring
- Transaction
- RESTful
- JPA (enable caching, annotations with query (native and jpql))
- All classes entity inherit from the BaseEntity for logging
- Classes of service inherit from AccessDAO for provide base query to all service like delete, getAll, update etc/
- Are controller classes inherit from RestBase class for provide to client a basic access on delete, update etc/
