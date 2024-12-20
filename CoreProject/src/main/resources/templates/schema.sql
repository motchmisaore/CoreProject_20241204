--ユーザーの役割。管理者か一般か
CREATE TABLE IF NOT EXISTS roles (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

--登録者のデータ
CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	furigana VARCHAR(50) NOT NULL,
	belongs VARCHAR(255) NOT NULL,
	phone_number VARCHAR(50) NOT NULL,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	role_id INT NOT NULL,
	enabled BOOLEAN NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	FOREIGN KEY (role_id) REFERENCES roles (id)
);

--サイトの利用方法を説明
CREATE TABLE IF NOT EXISTS howto (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	howtouse_text VARCHAR(3000)
);

--登録データ
CREATE TABLE IF NOT EXISTS SampleDatas (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	id_for_search VARCHAR(4) NOT NULL,
	columns1 VARCHAR(255) NOT NULL,
	columns2 VARCHAR(255) NOT NULL,
	columns3 VARCHAR(255) NOT NULL,
	columns4 VARCHAR(255) NOT NULL,
	columns5 VARCHAR(255) NOT NULL,
	-- statusはtrueを予約できる状態とする
	status BOOLEAN NOT NULL,
	resistered_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

--予約用テーブル
CREATE TABLE IF NOT EXISTS reservations (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_id INT NOT NULL,
    user_id INT NOT NULL,
    checkin_date DATE NOT NULL,
    checkout_date DATE NOT NULL,
    number_of_people INT NOT NULL,
    amount INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (data_id) REFERENCES datas (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

--所属
CREATE TABLE IF NOT EXISTS belongs (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	belongs_name VARCHAR(255)
);
