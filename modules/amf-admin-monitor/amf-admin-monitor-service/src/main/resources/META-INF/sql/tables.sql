create table AMF_adminMonitor (
	monitorId LONG not null primary key,
	dateTime DATE null,
	eventType VARCHAR(75) null,
	userId LONG,
	ipAddress LONG
);