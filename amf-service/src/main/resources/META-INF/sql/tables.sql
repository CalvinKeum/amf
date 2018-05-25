create table AMFTrackEventEntry (
	amfTrackEventEntryId LONG not null primary key,
	createDate DATE null,
	userId LONG,
	userName VARCHAR(75) null,
	type_ INTEGER,
	ipAddress VARCHAR(75) null
);