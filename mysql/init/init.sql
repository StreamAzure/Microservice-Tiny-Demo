CREATE DATABASE IF NOT EXISTS demo;
USE demo;
CREATE TABLE IF NOT EXISTS user (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
    );

INSERT INTO user (name) VALUES ('Alice'), ('Bob'), ('Charlie'), ('David');

-- 创建station表
CREATE TABLE station (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255)
);

-- 插入简单数据
INSERT INTO station (name, location) VALUES ('Central Station', '123 Main Street');
INSERT INTO station (name, location) VALUES ('South Station', '456 South Avenue');
INSERT INTO station (name, location) VALUES ('North Terminal', '789 North Boulevard');