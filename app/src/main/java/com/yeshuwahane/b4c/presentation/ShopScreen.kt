package com.yeshuwahane.b4c.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeshuwahane.b4c.R
import com.yeshuwahane.b4c.domain.Product




@Composable
fun ShopScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff323030))
//            .verticalScroll(rememberScrollState())
    ) {

        item {
            TopBar()

            Spacer(modifier = Modifier.height(16.dp))

            PromoCardPager()

            Spacer(modifier = Modifier.height(24.dp))

            CategoryRow()

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "New products",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 24.sp,
                    color = Color.White
                )


                Text(
                    "See all",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 16.sp,
                    color = Color.White

                )
            }


            Spacer(modifier = Modifier.height(16.dp))
        }

        val product1 = listOf(
            Product(
                productName = "Clencera",
                description = "French clay and algae-powered cleanser",
                price = "Rs. 355.20",
                oldPrice = "Rs. 444.00",
                rating = 5,
                reviews = 249,
                imageRes = R.drawable.product_image,
            ),
            Product(
                productName = "Light",
                description = "French clay and algae-powered cleanser",
                price = "Rs. 355.20",
                oldPrice = "Rs. 444.00",
                rating = 5,
                reviews = 249,
                imageRes = R.drawable.product_image,
            ),
            // Add more products here
        )



        items(product1){

                ProductCard(it)

                Spacer(modifier = Modifier.height(15.dp))
            }




    }
}
