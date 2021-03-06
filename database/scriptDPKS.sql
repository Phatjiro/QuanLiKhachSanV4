USE [master]
GO
IF EXISTS (select * from sysdatabases where name='DPKS')
		drop database DPKS
GO
/****** Object:  Database [DPKS]    Script Date: 05/05/2022 8:11:18 SA ******/
CREATE DATABASE [DPKS]
 CONTAINMENT = NONE
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DPKS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DPKS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DPKS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DPKS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DPKS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DPKS] SET ARITHABORT OFF 
GO
ALTER DATABASE [DPKS] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DPKS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DPKS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DPKS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DPKS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DPKS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DPKS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DPKS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DPKS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DPKS] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DPKS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DPKS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DPKS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DPKS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DPKS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DPKS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DPKS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DPKS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DPKS] SET  MULTI_USER 
GO
ALTER DATABASE [DPKS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DPKS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DPKS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DPKS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [DPKS]
GO
/****** Object:  Table [dbo].[DatDichVu]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatDichVu](
	[maDatDV] [int] IDENTITY(1,1) NOT NULL,
	[maKH] [int] NULL,
	[maDV] [int] NULL,
	[soLuongDV] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maDatDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DatPhong]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DatPhong](
	[ngayDatPhong] [datetime] NULL,
	[maPhong] [varchar](50) NOT NULL,
	[maKH] [int] NULL,
 CONSTRAINT [PF_DatPhong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDV] [int] IDENTITY(1,1) NOT NULL,
	[tenDV] [nvarchar](100) NOT NULL,
	[donGia] [float] NOT NULL,
	[maLoaiDV] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [int] IDENTITY(1,1) NOT NULL,
	[tienPhong] [float] NOT NULL,
	[tienDichVu] [float] NOT NULL,
	[tongTien] [float] NOT NULL,
	[ngayNhanPhong] [datetime] NOT NULL,
	[ngayTraPhong] [datetime] NOT NULL,
	[maNV] [varchar](10) NULL,
	[maKH] [int] NULL,
	[maPhong] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [int] IDENTITY(1,1) NOT NULL,
	[hoTen] [nvarchar](100) NOT NULL,
	[soDT] [varchar](20) NOT NULL,
	[soCMND] [varchar](20) NOT NULL,
	[diaChi] [nvarchar](200) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiDV]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiDV](
	[maLoaiDV] [varchar](50) NOT NULL,
	[tenLoaiDV] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [varchar](50) NOT NULL,
	[tenLoaiPhong] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanPhong]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanPhong](
	[ngayNhanPhong] [datetime] NULL,
	[maPhong] [varchar](50) NOT NULL,
	[maKH] [int] NULL,
 CONSTRAINT [PF_NhanPhong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](10) NOT NULL,
	[hoTen] [nvarchar](100) NOT NULL,
	[soDT] [varchar](20) NOT NULL,
	[soCMND] [varchar](20) NOT NULL,
	[diaChi] [nvarchar](200) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[isQuanLi] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [varchar](50) NOT NULL,
	[giaPhong] [float] NOT NULL,
	[dienTich] [float] NOT NULL,
	[soGiuong] [int] NOT NULL,
	[trangThaiPhong] [nvarchar](100) NOT NULL,
	[maLoaiPhong] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 05/05/2022 8:11:18 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenDN] [varchar](50) NOT NULL,
	[matKhau] [varchar](50) NOT NULL,
	[maNV] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[tenDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[DichVu] ON 

INSERT [dbo].[DichVu] ([maDV], [tenDV], [donGia], [maLoaiDV]) VALUES (1, N'Buffet ăn', 500000, N'an')
INSERT [dbo].[DichVu] ([maDV], [tenDV], [donGia], [maLoaiDV]) VALUES (2, N'Buffet uống', 200000, N'uong')
SET IDENTITY_INSERT [dbo].[DichVu] OFF
INSERT [dbo].[LoaiDV] ([maLoaiDV], [tenLoaiDV]) VALUES (N'an', N'Buffet ăn')
INSERT [dbo].[LoaiDV] ([maLoaiDV], [tenLoaiDV]) VALUES (N'uong', N'Buffet uống')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'deluxe', N'Phòng Deluxe')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'standard', N'Phòng Standard')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'suite', N'Phòng Suite')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'superior', N'Phòng Superior')
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [soDT], [soCMND], [diaChi], [gioiTinh], [isQuanLi]) VALUES (N'19483821', N'NguyenVanPhat', N'0938649707', N'012345678910', N'BinhThanh', 0, 1)
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [soDT], [soCMND], [diaChi], [gioiTinh], [isQuanLi]) VALUES (N'19483822', N'DoanAnhTin', N'0938649707', N'012345678910', N'BinhThanh', 0, 0)
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [soDT], [soCMND], [diaChi], [gioiTinh], [isQuanLi]) VALUES (N'19483823', N'NguyenVietBac', N'0938649707', N'012345678910', N'BinhThanh', 0, 0)
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [soDT], [soCMND], [diaChi], [gioiTinh], [isQuanLi]) VALUES (N'19483824', N'LeQuangDat', N'0938649707', N'012345678910', N'BinhThanh', 0, 0)
INSERT [dbo].[NhanVien] ([maNV], [hoTen], [soDT], [soCMND], [diaChi], [gioiTinh], [isQuanLi]) VALUES (N'19483825', N'PhamHoangNgocQuan', N'0938649707', N'012345678910', N'BinhThanh', 0, 0)
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P001', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P002', 600000, 20, 2, N'pt', N'superior')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P003', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P004', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P005', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P006', 600000, 20, 2, N'pt', N'superior')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P007', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P008', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P009', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P010', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P011', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P012', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P013', 600000, 20, 2, N'pt', N'superior')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P014', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P015', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P016', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P017', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P018', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P019', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P020', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P021', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P022', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P023', 600000, 20, 2, N'pt', N'superior')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P024', 800000, 20, 2, N'pt', N'deluxe')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P025', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P026', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P027', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P028', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P029', 500000, 20, 2, N'pt', N'standard')
INSERT [dbo].[Phong] ([maPhong], [giaPhong], [dienTich], [soGiuong], [trangThaiPhong], [maLoaiPhong]) VALUES (N'P030', 1000000, 20, 2, N'pt', N'suite')
INSERT [dbo].[TaiKhoan] ([tenDN], [matKhau], [maNV]) VALUES (N'user1', N'123456', N'19483821')
INSERT [dbo].[TaiKhoan] ([tenDN], [matKhau], [maNV]) VALUES (N'user2', N'123456', N'19483822')
INSERT [dbo].[TaiKhoan] ([tenDN], [matKhau], [maNV]) VALUES (N'user3', N'123456', N'19483823')
INSERT [dbo].[TaiKhoan] ([tenDN], [matKhau], [maNV]) VALUES (N'user4', N'123456', N'19483824')
INSERT [dbo].[TaiKhoan] ([tenDN], [matKhau], [maNV]) VALUES (N'user5', N'123456', N'19483825')
ALTER TABLE [dbo].[DatDichVu]  WITH CHECK ADD  CONSTRAINT [FK_DatDichVu_DichVu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDV])
GO
ALTER TABLE [dbo].[DatDichVu] CHECK CONSTRAINT [FK_DatDichVu_DichVu]
GO
ALTER TABLE [dbo].[DatDichVu]  WITH CHECK ADD  CONSTRAINT [FK_DatDichVu_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DatDichVu] CHECK CONSTRAINT [FK_DatDichVu_KhachHang]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_Phong]
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD  CONSTRAINT [FK_DichVu_LoaiDichVu] FOREIGN KEY([maLoaiDV])
REFERENCES [dbo].[LoaiDV] ([maLoaiDV])
GO
ALTER TABLE [dbo].[DichVu] CHECK CONSTRAINT [FK_DichVu_LoaiDichVu]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Phong]
GO
ALTER TABLE [dbo].[NhanPhong]  WITH CHECK ADD  CONSTRAINT [FK_NhanPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[NhanPhong] CHECK CONSTRAINT [FK_NhanPhong_KhachHang]
GO
ALTER TABLE [dbo].[NhanPhong]  WITH CHECK ADD  CONSTRAINT [FK_NhanPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[NhanPhong] CHECK CONSTRAINT [FK_NhanPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [DPKS] SET  READ_WRITE 
GO
