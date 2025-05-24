package com.yeshuwahane.b4c.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeshuwahane.b4c.R
import com.yeshuwahane.b4c.domain.Product



@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    val backgroundRes = R.drawable.card_grey_bg_png
    val shapeOverlayRes = R.drawable.card_black_shape

    var isFavorite by remember { mutableStateOf(false) }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val cardHeight = maxHeight
        val cardWidth = maxWidth

        // Background card shape
        Image(
            painter = painterResource(id = backgroundRes),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        // Heart icon with circular border
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(38.dp)
                .align(Alignment.TopStart)
                .clip(CircleShape)
                .border(1.5.dp, Color.Black, CircleShape)
                .background(Color.Black)
                .clickable { isFavorite = !isFavorite },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favorite",
                tint = Color(0xffebceef),
                modifier = Modifier.size(26.dp)
            )
        }

        // Best Seller Tag
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp)
                .background(Color.Black, CircleShape)
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = product.tagText,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF90EA31)
            )
        }

        // Product Image
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .height(100.dp)
        )

        // Overlay shape
        Image(
            painter = painterResource(id = shapeOverlayRes),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.BottomCenter)
        )

        // Product details
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 25.dp, bottom = 35.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
            ) {
                Text(
                    text = product.productName,
                    color = Color(0xFF90EA31),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                if (product.inStock) {
                    Text(
                        "In stock",
                        color = Color(0xFF90EA31),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Text(text = product.description, color = Color.White, fontSize = 12.sp)
            Text(
                "Skin Tightness • Dry & Dehydrated Skin",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = product.price, color = Color(0xFFB5AFFF), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = product.oldPrice,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(product.rating) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${product.reviews} reviews",
                    fontSize = 14.sp,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        // Cart Icon
        // Cart Icon
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp, bottom = 12.dp)
                .size(60.dp)
                .clip(CircleShape)
                .border(2.dp, Color(0xFF90EA31), CircleShape)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cart3),
                contentDescription = "Cart",
                modifier = Modifier.size(25.dp)
            )
        }

    }
}
