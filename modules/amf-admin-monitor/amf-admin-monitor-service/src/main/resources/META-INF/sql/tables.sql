create table AMF_AdminMonitor (
	monitorId LONG not null primary key,
	dateTime DATE null,
	eventType VARCHAR(75) null,
	userId LONG,
	ipAddress VARCHAR(75) null
);