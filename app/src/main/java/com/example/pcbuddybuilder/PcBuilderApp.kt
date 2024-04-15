package com.example.pcbuddybuilder


import android.app.Application

class PcBuilderApp : Application() {
    val allProducts: List<Product> by lazy {
        // Initialize and return your product list here
        listOf(

            Product("Core i7 Bundle", "70,000 PKR", 4.9f, R.drawable.pcc2, 2, "Sales", "Osama", "16GB RAM + 128GB SSD + 1TB HARDRIVE", "MSI"),
            Product("Core i7 + 16GB RAM,128GB SSD", "90,000 PKR", 4.0f, R.drawable.pc3, 5, "Sales", "Usmannn", "16GB RAM + 128GB SSD + 1TB HARDRIVE", "MSI"),


                    //Processors
            Product("Core i5", "30,000 PKR", 3.5f, R.drawable.c1, 10,"Processors","Ali","16GB RAM + 128GB SSD + 1TB HARDRIVE","NVIDIA"),
            Product("Intel Xeon", "35,000 PKR", 2.5f, R.drawable.c2, 24,"Processors","Ahmed","16GB RAM + 128GB SSD + 1TB HARDRIVE","MSI"),
            Product("Core i7", "45,000 PKR", 4.5f, R.drawable.c3, 20,"Processors","Jack","16GB RAM + 128GB SSD + 1TB HARDRIVE","MSI"),
            Product("Core i5 8th Gen", "36,000 PKR", 5.0f, R.drawable.c4, 6,"Processors","Popye","16GB RAM + 128GB SSD + 1TB HARDRIVE","NVIDIA"),


        //GPUS

            Product("MSI GTX 1080 ", "66,000 PKR", 5.0f, R.drawable.g1, 2,"GPU","Muhaddis","16GB RAM + 128GB SSD + 1TB HARDRIVE","MSI"),
            Product("NVIDIA GTX 970 ", "45,000 PKR", 5.0f, R.drawable.g2, 1,"GPU","John","16GB RAM + 128GB SSD + 1TB HARDRIVE","MSI")

        )
    }
}
