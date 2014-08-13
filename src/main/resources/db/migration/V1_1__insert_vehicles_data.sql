insert into CB_ENGINES(eng_id, eng_name) values(nextval('ENG_SEQ'), 'OM502');
insert into CB_ENGINES(eng_id, eng_name) values(nextval('ENG_SEQ'), 'OM255');
insert into CB_ENGINES(eng_id, eng_name) values(nextval('ENG_SEQ'), 'OM276');

insert into CB_VEHICLES(veh_id, veh_name, veh_eng_id)
  values(nextval('VEH_SEQ'), 'W205', (select eng_id from cb_engines where eng_name='OM502'));
insert into CB_VEHICLES(veh_id, veh_name, veh_eng_id)
  values(nextval('VEH_SEQ'), 'X205', (select eng_id from cb_engines where eng_name='OM502'));