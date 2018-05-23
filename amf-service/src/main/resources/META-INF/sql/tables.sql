create table AMFTrackEventEntry (
	amfTrackEventEntryId LONG not null primary key,
	createDate DATE null,
	userId LONG,
	type_ INTEGER,
	ipAddress VARCHAR(75) null
);