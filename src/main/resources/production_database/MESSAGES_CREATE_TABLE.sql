declare
  countOfTable int;
begin
  select count(*) into countOfTable from user_tables where table_name = upper('messages');
  if countOfTable = 0 then
     execute immediate 'CREATE TABLE TE_TST1.MESSAGES(
                        ID NUMBER NOT NULL,
                        MESSAGE_ID VARCHAR(50),
                        MESSAGE VARCHAR(200) NOT NULL
                        )';
  end if;
end;