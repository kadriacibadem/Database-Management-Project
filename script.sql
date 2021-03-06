USE [master]
GO
/****** Object:  Database [DatabaseManagementProject]    Script Date: 31.12.2021 01:13:26 ******/
CREATE DATABASE [DatabaseManagementProject]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DatabaseManagementProject', FILENAME = N'D:\SQL SERVER 2019\MSSQL15.SQLEXPRESS\MSSQL\DATA\DatabaseManagementProject.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DatabaseManagementProject_log', FILENAME = N'D:\SQL SERVER 2019\MSSQL15.SQLEXPRESS\MSSQL\DATA\DatabaseManagementProject_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DatabaseManagementProject] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DatabaseManagementProject].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DatabaseManagementProject] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET ARITHABORT OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DatabaseManagementProject] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DatabaseManagementProject] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DatabaseManagementProject] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DatabaseManagementProject] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DatabaseManagementProject] SET  MULTI_USER 
GO
ALTER DATABASE [DatabaseManagementProject] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DatabaseManagementProject] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DatabaseManagementProject] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DatabaseManagementProject] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DatabaseManagementProject] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DatabaseManagementProject] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DatabaseManagementProject] SET QUERY_STORE = OFF
GO
USE [DatabaseManagementProject]
GO
USE [DatabaseManagementProject]
GO
/****** Object:  Sequence [dbo].[hibernate_sequence]    Script Date: 31.12.2021 01:13:26 ******/
CREATE SEQUENCE [dbo].[hibernate_sequence] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 1
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[ChronicDisease]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChronicDisease](
	[chronicDiseaseId] [int] IDENTITY(1,1) NOT NULL,
	[covidId] [int] NOT NULL,
	[chronicDisease] [varchar](20) NOT NULL,
 CONSTRAINT [PK_ChronicDisease] PRIMARY KEY CLUSTERED 
(
	[chronicDiseaseId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[staffId] [int] NOT NULL,
	[covidId] [int] NOT NULL,
 CONSTRAINT [PK_Contact] PRIMARY KEY CLUSTERED 
(
	[staffId] ASC,
	[covidId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Covid]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Covid](
	[covidId] [int] IDENTITY(1,1) NOT NULL,
	[staffId] [int] NOT NULL,
	[covidPositiveDate] [date] NOT NULL,
	[covidNegativeDate] [date] NOT NULL,
 CONSTRAINT [PK_Covid] PRIMARY KEY CLUSTERED 
(
	[covidId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CovidSymptom]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CovidSymptom](
	[covidSymptomId] [int] IDENTITY(1,1) NOT NULL,
	[covidId] [int] NOT NULL,
	[symptom] [varchar](20) NOT NULL,
 CONSTRAINT [PK_CovidSymptom] PRIMARY KEY CLUSTERED 
(
	[covidSymptomId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Disease]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Disease](
	[diseaseId] [int] IDENTITY(1,1) NOT NULL,
	[staffId] [int] NOT NULL,
	[diseaseName] [varchar](20) NOT NULL,
	[diseaseDate] [date] NOT NULL,
 CONSTRAINT [PK_Disease] PRIMARY KEY CLUSTERED 
(
	[diseaseId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hobbies]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hobbies](
	[hobbiesId] [int] IDENTITY(1,1) NOT NULL,
	[staffId] [int] NOT NULL,
	[hobby] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Hobbies] PRIMARY KEY CLUSTERED 
(
	[hobbiesId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe](
	[recipeId] [int] IDENTITY(1,1) NOT NULL,
	[diseaseId] [int] NOT NULL,
	[medicine] [varchar](20) NOT NULL,
	[dosage] [int] NOT NULL,
 CONSTRAINT [PK_Recipe] PRIMARY KEY CLUSTERED 
(
	[recipeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Staff]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[staffId] [int] IDENTITY(1,1) NOT NULL,
	[tcNo] [char](11) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[surname] [varchar](40) NOT NULL,
	[bloodGroup] [char](3) NOT NULL,
	[city] [varchar](20) NOT NULL,
	[position] [varchar](20) NOT NULL,
	[salary] [int] NOT NULL,
	[educationStatus] [varchar](20) NOT NULL,
 CONSTRAINT [PK__staff__3213E83FFA9D15BD] PRIMARY KEY CLUSTERED 
(
	[staffId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_Staff_TcNo] UNIQUE NONCLUSTERED 
(
	[tcNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Symptoms]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Symptoms](
	[symptomsId] [int] NOT NULL,
	[diseaseId] [int] NOT NULL,
	[symptom] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Symptoms] PRIMARY KEY CLUSTERED 
(
	[symptomsId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vaccine]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vaccine](
	[vaccineId] [int] IDENTITY(1,1) NOT NULL,
	[staffId] [int] NOT NULL,
	[vaccineName] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Vaccine] PRIMARY KEY CLUSTERED 
(
	[vaccineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WorkingTime]    Script Date: 31.12.2021 01:13:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WorkingTime](
	[workingTimeId] [int] IDENTITY(1,1) NOT NULL,
	[staffId] [int] NOT NULL,
	[day] [char](9) NOT NULL,
	[enterTime] [time](7) NOT NULL,
	[exitTime] [time](7) NOT NULL,
 CONSTRAINT [PK_WorkingTime] PRIMARY KEY CLUSTERED 
(
	[workingTimeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [IX_CovidSymptom]    Script Date: 31.12.2021 01:13:26 ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_CovidSymptom] ON [dbo].[CovidSymptom]
(
	[covidSymptomId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChronicDisease]  WITH CHECK ADD  CONSTRAINT [FK_ChronicDisease_Covid] FOREIGN KEY([covidId])
REFERENCES [dbo].[Covid] ([covidId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChronicDisease] CHECK CONSTRAINT [FK_ChronicDisease_Covid]
GO
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Contact_Covid] FOREIGN KEY([covidId])
REFERENCES [dbo].[Covid] ([covidId])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Contact_Covid]
GO
ALTER TABLE [dbo].[Contact]  WITH CHECK ADD  CONSTRAINT [FK_Contact_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
GO
ALTER TABLE [dbo].[Contact] CHECK CONSTRAINT [FK_Contact_Staff]
GO
ALTER TABLE [dbo].[Covid]  WITH CHECK ADD  CONSTRAINT [FK_Covid_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Covid] CHECK CONSTRAINT [FK_Covid_Staff]
GO
ALTER TABLE [dbo].[CovidSymptom]  WITH CHECK ADD  CONSTRAINT [FK_CovidSymptom_Covid] FOREIGN KEY([covidId])
REFERENCES [dbo].[Covid] ([covidId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CovidSymptom] CHECK CONSTRAINT [FK_CovidSymptom_Covid]
GO
ALTER TABLE [dbo].[Disease]  WITH CHECK ADD  CONSTRAINT [FK_Disease_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Disease] CHECK CONSTRAINT [FK_Disease_Staff]
GO
ALTER TABLE [dbo].[Hobbies]  WITH CHECK ADD  CONSTRAINT [FK_Hobbies_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Hobbies] CHECK CONSTRAINT [FK_Hobbies_Staff]
GO
ALTER TABLE [dbo].[Recipe]  WITH CHECK ADD  CONSTRAINT [FK_Recipe_Disease] FOREIGN KEY([diseaseId])
REFERENCES [dbo].[Disease] ([diseaseId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Recipe] CHECK CONSTRAINT [FK_Recipe_Disease]
GO
ALTER TABLE [dbo].[Symptoms]  WITH CHECK ADD  CONSTRAINT [FK_Symptoms_Disease] FOREIGN KEY([diseaseId])
REFERENCES [dbo].[Disease] ([diseaseId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Symptoms] CHECK CONSTRAINT [FK_Symptoms_Disease]
GO
ALTER TABLE [dbo].[Vaccine]  WITH CHECK ADD  CONSTRAINT [FK_Vaccine_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Vaccine] CHECK CONSTRAINT [FK_Vaccine_Staff]
GO
ALTER TABLE [dbo].[WorkingTime]  WITH CHECK ADD  CONSTRAINT [FK_WorkingTime_Staff] FOREIGN KEY([staffId])
REFERENCES [dbo].[Staff] ([staffId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[WorkingTime] CHECK CONSTRAINT [FK_WorkingTime_Staff]
GO
USE [master]
GO
ALTER DATABASE [DatabaseManagementProject] SET  READ_WRITE 
GO
