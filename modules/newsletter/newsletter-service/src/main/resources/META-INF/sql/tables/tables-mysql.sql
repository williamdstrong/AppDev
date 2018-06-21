create table AMF_ArticleAuthor (
	articleAuthorId bigint not null primary key,
	articlePk bigint,
	authorPk bigint
) engine InnoDB;

create table AMF_Author (
	authorId bigint not null primary key,
	name varchar(75) null,
	articleAuthorTable bigint
) engine InnoDB;

create table AMF_Issue (
	issueId bigint not null primary key,
	issueNumber integer,
	journalFolderId bigint
) engine InnoDB;
