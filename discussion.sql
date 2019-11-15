USE [douban]
GO

/****** Object:  Table [dbo].[discussion]    Script Date: 2019/11/15 10:14:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[discussion](
	[did] [int] NOT NULL,
	[dtitle] [nvarchar](30) NULL,
	[dtime] [date] NULL,
	[dcontent] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[did] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


