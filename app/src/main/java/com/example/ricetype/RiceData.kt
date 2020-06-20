package com.example.ricetype

object RiceData {

    //List Names
    private val berasNames = arrayOf(
        "Beras Pandan Wangi",
        "Rojolele",
        "Beras IR64",
        "Beras IR42",
        "Beras Merah",
        "Beras Hitam",
        "Beras Cokelat",
        "Beras Ketan",
        "Beras Jepang",
        "Beras Mentik Wangi Susu"
    )

    //List Detail
    private val berasDetails = arrayOf(
        //Beras Pandan Wangi
        "Padi Pandan Wangi atau Padi Pandanwangi adalah salah satu varietas dari padi bulu yang ditanam di Cisalak, " +
                "Cibeber, Cianjur, Jawa Barat. Karena nasinya yang beraroma pandan, " +
                "maka padi dan beras ini sejak tahun 1973 terkenal dengan sebutan ",
        //Rojolele
        "Rojolele adalah kultivar padi lokal unggulan Indonesia yang berasal dari Klaten, Jawa Tengah." +
                "Kultivar rojolele resmi dirilis oleh Kementerian Pertanian Indonesia pada tahun 2003." +
                "Rojolele merupakan salah satu padi asal Indonesia yang digunakan sebagai induk persilangan " +
                "program penelitian di IRRI.",
        //Beras IR64
        "Beras IR 64 atau Setra Ramos merupakan salah satu jenis beras yang paling sering ditemui " +
                "karena harganya yang relatif sangat terjangkau dibanding beras-beras premium lainnya. " +
                "Rasa dan teksturnya juga dianggap sangat cocok dengan selera masyarakat perkotaan.\n" +
                "\n" +
                "Ciri khas Setra Ramos ialah bentuknya yang agak panjang. Setra Ramos memiliki tekstur pulen " +
                "ketika sudah dimasak menjadi nasi. Namun demikian, jika sudah berumur terlalu lama, beras ini " +
                "bisa menghasilkan tekstur nasi yang pera dan mudah basi. Selain itu, beras ini nggak memiliki " +
                "aroma khas apapun, sehingga jika beraroma pandan ketika sudah dimasak, hampir dapat dipastikan" +
                " sudah ditambahkan bahan kimia lain.",
        //Beras IR42
        "Beras IR 42 biasanya sering disebut juga beras pera, " +
                "bentuknya tidak bulat, mirip dengan IR 64 namun ukurannya lebih kecil. " +
                "Beras ini jika dimasak nasinya tidak pulen, namun pera sehingga cocok untuk" +
                " keperluan khusus seperti membuat nasi goreng, nasi uduk, lontong, ketupat dan lain sebagainya.",
        //Beras Merah
        "Beras merah mengandung zat besi dan vitamin B6. " +
                "Berdasarkan jurnal yang dipublikasikan International Journal of Food Science and Nutrition, " +
                "mereka yang mengonsumsi beras merah memiliki kadar gula darah lebih rendah. " +
                "Per 100 gram beras merah mengandung tujuh gram protein dan dua gram serat.",
        //Beras Hitam
        "Beras hitam menjadi yang termahal karena kandungan gizinya sangat baik. " +
                "Terdapat vitamin E yang cukup tinggi, sehingga baik untuk meningkatkan sistem kekebalan tubuh, " +
                "menangkal radikal bebas, dan memperbaiki kerusakan. ",
        //Beras Cokelat
        "Beras cokelat mengalami proses penggilingan, tapi hanya sebatas menghilangkan lapisan terluarnya. " +
                "Beras cokelat punya tekstur lebih keras saat dimasak dibanding putih. " +
                "Per 100 gram beras cokelat mengandung 3,2 gram serat dan 7,2 gram protein.",
        //Beras Ketan
        "Beras ketan (Oryza sativa var. glutinosa) adalah sebuah jenis beras yang utamanya tumbuh di Asia Tenggara dan Asia Timur",
        //Beras Jepang
        "Beras Jepang merujuk kepada beras yang diambil dari tanaman Japonica rice dan diolah menjadi nasi biasa (uruchimai) " +
                "dan nasi gluten (mochigome). Nasi Jepang biasa, atau uruchimai (粳米), " +
                "adalah makanan pokok orang Jepang dan nasi gluten, yang dikenal di Jepang sebagai mochigome (もち米), " +
                "dipakai untuk membuat mochi (餅) dan hidangan khusus seperti sekihan.",
        //Beras Mentik Wangi Susu
        "Beras Menthik Wangi Susu adalah beras yang mempunyai karakteristik gabungan antara Beras Menthik Wangi " +
                "dan Beras Menthik Susu. " +
                "Beras Menthik Wangi dikenal dengan wangi khasnya. " +
                "Sedangkan Menthik Susu dikenal dengan warnanya yang putih seperti ketan dan rasa serta pulennya. \n"
    )

    //List Images
    private val berasImages = intArrayOf(
        R.drawable.beraspandanwangi,
        R.drawable.rojolele,
        R.drawable.berasir64,
        R.drawable.berasir42,
        R.drawable.berasmerah,
        R.drawable.berashitam,
        R.drawable.berascokelat,
        R.drawable.berasketan,
        R.drawable.berasjepang,
        R.drawable.berasmentikwangisusu
    )

    //Proses GetData
    val listData: ArrayList<Rice>
        get() {
            val list = arrayListOf<Rice>()
            for (position in berasNames.indices) {
                val beras = Rice()
                beras.name = berasNames[position]
                beras.detail = berasDetails[position]
                beras.photo = berasImages[position]
                list.add(beras)
            }
            return list
        }


}