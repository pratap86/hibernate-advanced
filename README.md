# hibernate-advanced
Inheritance Mapping Strategies: 4
1. Single Table
* maps all entities in inheritance tree to a single database table.
** A discriminator column indicates the type/class of data in row
* table has columns for all fields in the inheritance tree
* each row will use only subset of the fields
* Unused fields are null
Annotations for Inheritance mapping:
1. @Inheritance(SINGLE_TABLE, TABLE_PER_CLASS, JOINED, Default is SINGLE_TABLE)
2. @DiscriminatorColumn - used in super class, and this is optional, default is DTYPE
3. @DiscriminatorValue - used in sub class, and this is also optional, default is class name

2. Table per class
** for concrete class, only related fields, no extra columns are involved here.
3. Joined Table
* For the inheritance tree,  all classes are mapped to a table
* super class contains all the fields, common to all
* subclass contains only fields specific to the subclass
* inheritance is modeled with a foreign key
* Hibernate will join the data based on the primary key and foreign key
4. Mapped Super class
