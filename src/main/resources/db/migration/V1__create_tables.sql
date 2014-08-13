create table CB_VEHICLES (
    VEH_ID int not null,
    VEH_NAME varchar(255) not null,
    VEH_ENG_ID number(38) not null
);

alter table CB_VEHICLES add primary key (VEH_ID);

create sequence VEH_SEQ;

create table CB_ENGINES (
    ENG_ID int not null,
    ENG_NAME varchar(255) not null
);

alter table CB_ENGINES add primary key (ENG_ID);

create sequence ENG_SEQ;

ALTER TABLE CB_VEHICLES
ADD CONSTRAINT VEH_ENG_FK
FOREIGN KEY (VEH_ENG_ID)
REFERENCES CB_ENGINES(ENG_ID); 