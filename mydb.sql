-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2020 at 04:56 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `productid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `email`, `productid`) VALUES
(1, 'aakashshah367@gmail.com', 1),
(2, 'd@shah.com', 4);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` varchar(10) NOT NULL,
  `imageurl` varchar(500) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `imageurl`, `description`) VALUES
(1, 'PTron Avento Classic Bluetooth Headset', '61 $', 'https://rukminim1.flixcart.com/image/416/416/kflftzk0-0/headphone/r/1/2/avento-classic-ptron-original-imafwygywzdu5fyz.jpeg?q=70', ' If you want to listen to your favourite music albums and playlists in good sound, then this headset by boAt will be an ideal choice for you. It offers thumping bass, so the songs in your music library will sound rich and power-packed. Its weight is not heavy, and hence you can always keep it with you while travelling. What\'s more, the cable\'s optimal length makes it easy to use.'),
(2, 'boAt Bassheads 103 Blue Wired Headset', '50 $', 'https://rukminim1.flixcart.com/image/416/416/jzn0tjk0/headphone/n/6/a/boat-bassheads-103-blue-original-imafjm236xnhke5e.jpeg?q=70', ' If you want to listen to your favourite music albums and playlists in good sound, then this headset by boAt will be an ideal choice for you. It offers thumping bass, so the songs in your music library will sound rich and power-packed. Its weight is not heavy, and hence you can always keep it with you while travelling. What\'s more, the cable\'s optimal length makes it easy to use.'),
(3, 'boAt Bassheads 242 Wired Headset', '120 $', 'https://rukminim1.flixcart.com/image/416/416/khf63680/headphone/r/j/1/bassheads-242-boat-original-imafxgfm68yrykgq.jpeg?q=70', 'Get ready to redefine fitness fashion and utility with the boAt Bassheads 242, its time to get your sport on. It carries ear hooks that are crafted from silicon to maximize comfort and a secure fit that allows you to maximize your workouts. Coated with IPX 4 sweat and water protection, the Bassheads 242 emphasizes on all around ability with 10mm drivers that reproduces a quality sound. Move around freely with the superior coated cable that reaches comfortably from your pocket till your ears. Connect to a number of devices with ease using the 3.5mm straight jack, because there\'s no stress, only sweetness when you\'re riding the waves on this boAt. You can tune in and out with the pause/play button that can also take calls (With In-line Mic.) and control volume in-between exercise reputations. Lead your fight to fitness in style with the boAt Bassheads 242, its time to get your sport on!'),
(4, 'Zebronics ZEB-THUNDER Bluetooth Headset ', '80 $', 'https://rukminim1.flixcart.com/image/416/416/k5vcya80pkrrdj/headphone/r/e/j/zebronics-zeb-thunder-original-imafbkpg9cy99dfs.jpeg?q=70', 'Custom oversized 40mm dynamic drivers produce Hi-Fi audio producing exceptional stereo sound quality. pTron Soundster Lite passive canceling headphones reproduce your music with extended high frequencies that reach up to 20 kHz for extraordinary clarity and detail. Get an ultra-fast and virtually unbreakable connection between Soundster Lite wireless headphones and your mobile device. Compatible with smartphones, tablets, laptop computers, and more. 12 hours of music playback time on a single charge of 2 hours. Get infinite playtime via the 3.5mm audio port. Take or make calls seamlessly on your wireless over-ear headphones via the built-in mic. The multi-function buttons allow you to manage calls and music efficiently. The spacious soft earmuffs give an excellent fit, ensure a high level of wearing comfort, even during longer sessions. The advanced Bluetooth 5.0 wireless technology is widely compatible with all the Bluetooth enabled smartphones, tablets, laptops/computers, and other Bluetooth enabled multi-media devices.'),
(5, 'JBL C150SI Wired Headset', '720 $', 'https://rukminim1.flixcart.com/image/416/416/k3ncakw0pkrrdj/headphone/dynamic/z/a/r/jbl-c150siured-original-imafhyzxbgwa3czq.jpeg?q=70', 'Stay entertained even during those long commute hours with this pair of JBL earphones. These lightweight earphones feature a premium metallic finish that makes them look stylish and sturdy. You can also make, receive or end calls quickly with its one-button universal remote.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `password`, `address`) VALUES
(1, 'jbj', '', '1', '1', ''),
(2, 'jbj', '', '', '', ''),
(3, 'kelvin', 'parmar', 'k@g.com', '12', 'anand'),
(4, 'aakash', 'shah', 'aakashshah367@gmail.com', '12345', 'aassaass'),
(5, 'darshil', 'shah', 'd@shah.com', '12345', 'darshiladdress');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
