package list_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter
import model.Product
import screens.ProductDetails

@Composable
fun ProductItem(
    product: Product
) {

    val img = product.img
    val name = product.name
    val price = product.price
    val description = product.description
    val navigation = LocalNavigator.currentOrThrow

    Column(modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
           Image(
               painter = rememberImagePainter(img!!),
               contentDescription = null,
               modifier = Modifier.width(100.dp).height(100.dp).padding(0.dp,0.dp,10.dp,0.dp),
               contentScale = ContentScale.Inside
           )
            Text(text = name!!, fontSize = 14.sp)
        }
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp)
        ) {
            Text(
                text = price!!,
                fontSize = 16.sp,
                color = Color.Red,
                modifier = Modifier.padding(110.dp, 5.dp)
            )
            Text(
                "Á vista no Pix",
                fontSize = 12.sp,
                modifier = Modifier.padding(110.dp, 0.dp, 0.dp, 10.dp)
            )
            Button(
                onClick = {
              navigation.push(ProductDetails(
                  id="ProductDetails",
                  name = name!!,
                  img = img!!,
                  price = price,
                  description = description!!

              ))
                },
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(20.dp,5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Red
                ),
                border = BorderStroke(2.dp,Color.Red)
            ){

                Text(text = "Promoção termina em:15D")

            }
        }
    }

}