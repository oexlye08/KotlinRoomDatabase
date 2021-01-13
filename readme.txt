entity = table database
DAO (Data access object) = bertanggung jawab untuk menentukan metode yang mengakses database, ini adalah tempat kita menulis kueri kita
DATABASE = berisi penyimpanan database dan berfungsi sebagai titik akses utama untuk koneksi yang mendasari ke data aplikasi Anda

Data = database
User (entity) = table Users
UserDao = Berisi metode yang digunakan untuk mengakses database (SELECT * FROM user_table ORDER BY id ASC)
UserDatabase = Berisi pemegang database dan berfungsi sebagai titik akses utama untuk koneksi yang mendasari ke aplikasi Anda, data relasional
UserRepository = repository class abstract untuk akses ke beberapa sumber data. repositori bukan bagian dari pustaka komponen arsitektur, tetapi merupakan praktik terbaik yang disarankan untuk pemisahan kode dan arsitektur
UserViewModel = peran viewModel adalah untuk mem private data ke UI dan bertahan dari perubahan konfigurasi. viewModel bertindak sebagai pusat komunikasi antara repositori dan UI


Resource manager > Navigation