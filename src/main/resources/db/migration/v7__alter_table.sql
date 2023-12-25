alter table category
rename user_name to title;
alter  table category
drop column name;

alter  table category
drop column last_name;

alter  table category
drop column phone_number;

alter  table category
add column type bool;