CREATE DATABASE  IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	8.0.21

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `bnumber` decimal(10,0) NOT NULL,
  `source` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `month` varchar(50) DEFAULT NULL,
  `date` decimal(10,0) DEFAULT NULL,
  `seats` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`bnumber`)
) ;


--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ;
-- Dump completed on 2020-11-25 16:38:34
