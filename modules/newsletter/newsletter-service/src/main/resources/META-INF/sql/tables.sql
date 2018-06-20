create table AMF_ArticleAuthor (
	articleAuthorId LONG not null primary key,
	articlePk LONG,
	authorPk LONG
);

create table AMF_Author (
	authorId LONG not null primary key,
	name VARCHAR(75) null,
	articleAuthorTable LONG
);

create table AMF_Issue (
	issueId LONG not null primary key,
	issueNumber INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	issueDate DATE null
);