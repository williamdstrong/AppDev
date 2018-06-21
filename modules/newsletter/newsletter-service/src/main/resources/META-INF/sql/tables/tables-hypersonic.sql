create table AMF_ArticleAuthor (
	articleAuthorId bigint not null primary key,
	articlePk bigint,
	authorPk bigint
);

create table AMF_Author (
	authorId bigint not null primary key,
	name varchar(75) null,
	articleAuthorTable bigint
);

create table AMF_Issue (
	issueId bigint not null primary key,
	issueNumber int,
	journalFolderId bigint
);
