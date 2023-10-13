package com.example.in_app_purchase_projekt


import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.plcoding.catdev.R
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
    onAccountIconClick: ()-> Unit,
    onHeadPicIconClick: ()-> Unit,

    ) {

    TopAppBar(
        modifier = Modifier.border( width = 2.dp,
            color = colorResource(id =R.color.Vorwerk_green),
            shape = RoundedCornerShape(2.dp)
        ),
        title = {


                    Box(
                        modifier = Modifier.wrapContentSize(Alignment.CenterStart),


                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(
                                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Vorwerk_Logo.svg/1600px-Vorwerk_Logo.svg.png",
                            ),
                            contentDescription = "Vorwerk_Logo",
                            Modifier.clickable { onHeadPicIconClick }
                            // contentScale = ContentScale.Crop
                        )
                    }
                    Box(
                        modifier = Modifier.wrapContentSize(Alignment.CenterEnd)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .wrapContentSize(Alignment.CenterEnd),
                        ) {
                        IconButton(
                            modifier = Modifier
                                .size(30.dp),//avoid the oval shape
                            onClick = { println("working") }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "Search_Bar",
                                tint = colorResource(id = R.color.Vorwerk_anthracite)
                            )
                        }
                        IconButton(
                            modifier = Modifier
                                .size(37.dp),//avoid the oval shape

                            //  shape = CircleShape,
                            // contentPadding = PaddingValues(0.dp),  //avoid the little icon
                            // colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(id =R.color.Vorwerk_anthracite)),
                            /** colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id =R.color.Vorwerk_green)),**/
                            onClick = onAccountIconClick
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = "Account_Change_Icon",
                                tint = colorResource(id = R.color.Vorwerk_anthracite),
                            )
                        }
                    }
            }
        },

        backgroundColor = colorResource(id =R.color.Vorwerk_white),
        contentColor = colorResource(id =R.color.Vorwerk_anthracite),
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        }
    )
}