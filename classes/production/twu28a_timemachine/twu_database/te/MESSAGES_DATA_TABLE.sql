Truncate TABLE MESSAGES;
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (1,'UserNamePasswordCannotBeBlank','Username is a required field.  Password is a required field.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (2,'UserNamePasswordMismatch','The credentials you provided cannot be determined to be authentic.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (3,'NoExistingTimesheets','You don''t have any saved timesheets.  ');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (4,'Alteast2CharsForSearch','Enter atleast two characters.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (5,'NoMatchingActivity','No matching activity found.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (6,'TimesheetnameBlank','Name field cannot be left blank.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (7,'DuplicateFavTimesheet','Duplicate name. Please try another name.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (8,'CountryCannotBeUnspecified','Country is required.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (9,'StateCannotBeUnspecified','State is required.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (10,'ActivityCannotBeUnspecified','Activity is required.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (11,'WeekCannotBeUnspecified','Week ending date is required.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (12,'DuplicateTimesheetForWeek','Week ending date is already associated with a Time Report.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (13,'TaskCommentCannotBeUnspecified','Task Comment is required.');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (14,'HoursLessThan40','Your total billed hours for the week are less than 40. Do you want to continue submitting this timesheet?');
Insert into MESSAGES (ID,MESSAGE_ID,MESSAGE) values (15,'PublicHolidayConfirmation','"Date" was a public holiday in "Country". Are you sure you want to enter hours for it?');
