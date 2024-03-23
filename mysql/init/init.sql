-- 创建 demo 数据库
CREATE DATABASE IF NOT EXISTS demo;

-- 切换到 demo 数据库
USE demo;

-- 创建 user 表
CREATE TABLE IF NOT EXISTS user (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
    );

-- 插入四条数据
INSERT INTO user (name) VALUES ('Alice'), ('Bob'), ('Charlie'), ('David');
