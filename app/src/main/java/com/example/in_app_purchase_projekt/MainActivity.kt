package com.example.in_app_purchase_projekt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.plcoding.catdev.R
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {


                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val coroutineScope = rememberCoroutineScope()
                val scrollState = rememberScrollState()
                var scrollToPositionTop by remember { mutableStateOf(0F) }
                var scrollToPositionNewRecipe by remember { mutableStateOf(550F) }
                var scrollToPositionPopularRecipe by remember { mutableStateOf(1400F) }
                var scrollToPositionCookidooAbo by remember { mutableStateOf(2300F) }
                var scrollToPositionVorwerkCoins by remember { mutableStateOf(4000F) }
                var scrollToPositionRecipeList by remember { mutableStateOf(4000F) }


                Scaffold(


                    scaffoldState = scaffoldState,
                    content = {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(scrollState)
                        ) {


                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .wrapContentSize(Alignment.Center),
                                /** .border( width = 2.dp,
                                color = colorResource(id =R.color.Vorwerk_green),
                                shape = RoundedCornerShape(2.dp)
                                ),**/
                                shape = RectangleShape,

                                // elevation = 8.dp
                            ) {
                                HeadImageAndText(
                                    painter = rememberAsyncImagePainter("https://assets.tmecosys.com/image/upload/t_web1440x450@2x/cdn/contentful/UuQRy6JEESKrqRDZHBWge/a17da48ce5e79b925564cacca661c47e/shutterstock_526855693-min.jpg"),
                                    contentDescription = "test",
                                    text = "Jetzt Cookidoo® testen",
                                    modifier = Modifier.onGloballyPositioned { coordinates ->
                                        scrollToPositionTop = coordinates.positionInRoot().y
                                    }
                                )

                            }

                            /**   Text(text = "Willkommen in Cookidoo®", fontSize = 34.sp,textAlign = TextAlign.Center,
                            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),color = colorResource(id =R.color.Vorwerk_anthracite))**/


                            Headline(
                                text = "Neueste Rezepte:",
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .onGloballyPositioned { coordinates ->
                                        scrollToPositionNewRecipe = coordinates.positionInRoot().y
                                    }
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState())
                            ) {
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/95DCB95C-8E62-4775-AADD-BBE88E5BBBFF/Derivates/97E0B493-63F7-4844-A70A-DC55D009DF66"),
                                    contentDescription = "new_recipe_1",
                                    text = "Maronistrudel mit Schwammerln und Nüssen"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/A1F5C3EC-82BD-42F0-96AB-04082DDB7DF4/Derivates/BA02543F-9356-47C8-943B-7E4CAEFCF4C6"),
                                    contentDescription = "new_recipe_2",
                                    text = "Maronisuppe mit Pilztascherl"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/FF87CEAD-3D51-422C-9307-89A0BEEDE1D0/Derivates/17230421-999B-42EA-987D-F45D0A949290"),
                                    contentDescription = "new_recipe_3",
                                    text = "Maroniweckerl"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/a7887fed-67ef-4f72-9012-709ff82cb699/Derivates/aecb50ee-16bd-4cde-b931-74c8419ea087"),
                                    contentDescription = "new_recipe_4",
                                    text = "Ahornsirup Pudding"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/57945fa3ed3929f93c98de0ec97511ac/Derivates/43c781ad494c657c6696131c7d4943fbbbc31888"),
                                    contentDescription = "new_recipe_5",
                                    text = "Blumenkohl Korma"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/ba95a8a2541a090bffd9e976cdc04122/Derivates/060c80f5fc0b7adc59a1b914a62a632a2d415fb3"),
                                    contentDescription = "new_recipe_6",
                                    text = "Indischer Gemüsereis"
                                )
                                hyperlink(
                                    str = "Mehr sehen",
                                    GivenUrl = "https://cookidoo.de/search/de-DE?context=recipes&countries=de&accessories=includingFriend,includingBladeCoverWithPeeler,includingCutter&sortby=publishedAt&exclude=r16687"
                                )

                            }
                            Headline(
                                text = "Beliebte Rezepte:",
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .onGloballyPositioned { coordinates ->
                                        scrollToPositionPopularRecipe =
                                            coordinates.positionInRoot().y
                                    }
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState())
                            ) {
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/2ed6e5b295acabe8edc6210b3ebc669b/Derivates/a11d5081e829c38aba91b6e9f7ff34045beb5727"),
                                    contentDescription = "popular_recipe_1",
                                    text = "Reis Bowl mit gekochten Eiern"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/970af4dab19164a6c4e62fc3cea06365/Derivates/b1443fb6ac37bb5a95aa5827412744374ffe03aa"),
                                    contentDescription = "popular_recipe_2",
                                    text = "Overnight Müsli"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/1195bcbc-122c-4337-96ef-4a888ac5981a/Derivates/be664610-f054-4c89-a217-29b469b57cef"),
                                    contentDescription = "popular_recipe_3",
                                    text = "Kartoffel Möhren Eintopf mit Bratwurstbällchen und Möhren Kohlrabi Salat"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/835C44F2-41A8-48D6-AD71-EFF1EE0B6878/Derivates/5aee77b5-aa57-49c3-bbf5-c5366a208a4a"),
                                    contentDescription = "popular_recipe_4",
                                    text = "Süßkartoffel Chorizo Eintopf"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/B3296F17-ACC5-4093-B868-D907693BBB85/Derivates/F99BFC6E-ADE7-4F80-8988-8BD07CC6A256"),
                                    contentDescription = "popular_recipe_5",
                                    text = "Dattel Curry Dip"
                                )
                                RecipeAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web276x230_2x_webp/img/recipe/ras/Assets/45035BE5-8F42-4A5A-AFD1-E6C6731FE5DC/Derivates/786b90e4-ac3b-4aca-82db-c912c14a7c92"),
                                    contentDescription = "popular_recipe_6",
                                    text = "Pizzateig"
                                )

                                hyperlink(
                                    str = "Mehr sehen",
                                    GivenUrl = "https://cookidoo.de/search/de-DE?context=recipes&countries=de&accessories=includingFriend,includingBladeCoverWithPeeler,includingCutter&sortby=rating&exclude=r16687"
                                )

                            }
                            Headline(
                                text = "Cookidoo Abo:",
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .onGloballyPositioned { coordinates ->
                                        scrollToPositionCookidooAbo = coordinates.positionInRoot().y
                                    }
                            )
                            MediumHeadline(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "Vorteile deines Cookidoo®-Abos"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Weltweit über 80.000 Rezepte - da ist für jeden etwas dabei"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Immer neue Inspiration durch neue Rezepte, Themenseiten und Artikel"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Plane deine Mahlzeiten mit Wochenplaner und Rezeptlisten"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Easy Einkauf dank Einkaufliste und Online-Lieferservice"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Egal ob Einsteiger oder Meisterkoch mit Cookidoo® und der Guided-Cooking-Funktion von Thermomix® gelingen auch anspruchsvolle Rezepte perfekt"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Rezepte immer und überall griffbereit auf deinem Smartphone, Tablet, Thermomix® TM6 oder PC"
                            )
                            normalText(
                                modifier = Modifier.align(alignment = Alignment.Start),
                                text = "• Rezepte direkt synchronisieren mit deinem Thermomix® TM6 oder Thermomix® TM5 Cook-Key®"
                            )

                            Button(
                                onClick = { println("working") },
                                shape = RoundedCornerShape(25), // = 50% percent
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(
                                        id = R.color.Vorwerk_green
                                    )
                                ),
                                modifier = Modifier
                                    .align(alignment = Alignment.End)
                                    .padding(18.dp), elevation = ButtonDefaults.elevation(
                                    defaultElevation = 10.dp,
                                    pressedElevation = 15.dp,
                                    disabledElevation = 0.dp
                                )
                            ) {
                                Text(
                                    text = "Jetzt Ausprobieren",
                                    color = colorResource(id = R.color.Vorwerk_white)
                                )
                            }
                            Headline(
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .onGloballyPositioned { coordinates ->
                                        scrollToPositionVorwerkCoins =
                                            coordinates.positionInRoot().y
                                    },
                                text = "Vorwerk Coins"
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState())
                            ) {
                                CoinsAndText(
                                    painter = rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRz4A5ZvZEe3hN1e4ypiam-CZcuJFWpfRW4ZA&usqp=CAU"),
                                    contentDescription = "Small_Amount_Coins",
                                    text = "100 Vorwerk Coins"
                                )
                                CoinsAndText(
                                    painter = rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5Wop3W1_1Nn92oLdVklWX8NaS0QgcBRAvaQ&usqp=CAU"),
                                    contentDescription = "Medium_Amount_Coins",
                                    text = "500 Vorwerk Coins"
                                )
                                CoinsAndText(
                                    painter = rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9RhKYtcTjRuWF1zCkbkOiV7SOgCVHABFWJQ&usqp=CAU"),
                                    contentDescription = "Big_Amount_Coins",
                                    text = "1000 Vorwerk Coins"
                                )
                            }
                            Headline(
                                modifier = Modifier
                                    .align(alignment = Alignment.Start)
                                    .onGloballyPositioned { coordinates ->
                                        scrollToPositionRecipeList = coordinates.positionInRoot().y
                                    },
                                text = "Rezept Liste"
                            )
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .wrapContentSize(Alignment.Center),
                                shape = RectangleShape,
                            ) {
                                EndImageAndText(
                                    painter = rememberAsyncImagePainter(model = "https://assets.tmecosys.com/image/upload/t_web1440x450@2x/cdn/contentful/4RcBqZuFZKSu8qci2sWigS/0fa487d8f59211d842872765b7df7792/Recipes_Pattern_Small.jpg"),
                                    contentDescription = "Link_For_All_Recipes",
                                    text = "Durch alle Rezepte stöbern"
                                )
                            }
                        }
                    },
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            },
                            onAccountIconClick = {
                                setContent { AccountLogin() }
                                println("working")
                            },
                            onHeadPicIconClick = {
                                coroutineScope.launch {
                                    scrollState.animateScrollTo(scrollToPositionTop.roundToInt())
                                    println("working")
                                }
                            }
                        )

                    },

                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "neueste_rezepte",
                                    title = "Neueste Rezepte",
                                    contentDescription = "Look at new recipes",
                                    icon = R.drawable.double_arrow,
                                ),
                                MenuItem(
                                    id = "beliebte_rezepte",
                                    title = "Beliebte Rezepte",
                                    contentDescription = "Look at popular recipes",
                                    icon = R.drawable.double_arrow,

                                    ),
                                MenuItem(
                                    id = "cookidoo_abo",
                                    title = "Cookidoo Abo",
                                    contentDescription = "Subscribe to cookidoo",
                                    icon = R.drawable.double_arrow,
                                ),
                                MenuItem(
                                    id = "vorwerk_coins",
                                    title = "Vorwerk Coins",
                                    contentDescription = "Get vorwerk coins",
                                    icon = R.drawable.double_arrow,
                                ),
                                MenuItem(
                                    id = "rezept_liste",
                                    title = "Rezept Liste",
                                    contentDescription = "Look at all available recipes",
                                    icon = R.drawable.double_arrow,
                                ),
                            ),

                            onItemClick = {
                                println("Clicked on ${it.title}")
                                if (it.title == "Neueste Rezepte") {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(scrollToPositionNewRecipe.roundToInt())

                                    }
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                                println("Clicked on ${it.title}")
                                if (it.title == "Beliebte Rezepte") {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(scrollToPositionPopularRecipe.roundToInt())

                                    }
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                                println("Clicked on ${it.title}")
                                if (it.title == "Cookidoo Abo") {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(scrollToPositionCookidooAbo.roundToInt())

                                    }
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                                println("Clicked on ${it.title}")
                                if (it.title == "Vorwerk Coins") {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(scrollToPositionVorwerkCoins.roundToInt())

                                    }
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                                println("Clicked on ${it.title}")
                                if (it.title == "Rezept Liste") {
                                    coroutineScope.launch {
                                        scrollState.animateScrollTo(scrollToPositionRecipeList.roundToInt())

                                    }
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                            }

                        )

                    }

                )


            }

    }
}
@Composable
fun HeadImageAndText(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    val shape =  RoundedCornerShape(4.dp)
    val height = 150.dp
    val brightness = -50f
    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(White, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
    modifier = Modifier
        .fillMaxSize()
        .clip(shape)
        )
        Column {

            Text(
                text = text,
                color = colorResource(id = R.color.Vorwerk_white),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = { println("working") },
                shape = RoundedCornerShape(25), // = 50% percent
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Vorwerk_green)),
                modifier = Modifier
                    .padding(18.dp), elevation = ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(text = "Jetzt Ausprobieren", color = colorResource(id = R.color.Vorwerk_white))
            }
        }

    }
}
@Composable
fun RecipeAndText(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    val shape = RoundedCornerShape(8.dp)
    Spacer(modifier = Modifier.width(8.dp))
    Surface(
elevation = 10.dp) {
        Box(
            modifier = modifier
                .width(90.dp)
                .height(180.dp)
                .background(White, shape = shape)
                .clickable { println("working") },

            ) {
            Column {


                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                        .clip(shape)
                )

                Text(
                    text = text,
                    color = colorResource(id = R.color.Vorwerk_anthracite),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        lineBreak = LineBreak.Heading
                    )
                )
            }
        }
    }

}

@Composable
fun MediumHeadline(
    modifier: Modifier,
    text: String
) {
    Text(text = text, fontSize = 20.sp,textAlign = TextAlign.Start,
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.Vorwerk_anthracite))
}

@Composable
fun normalText(
    modifier: Modifier,
    text: String
) {
    Text(text = text, fontSize = 14.sp,textAlign = TextAlign.Start,
        modifier = Modifier.padding(2.dp),
        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.Vorwerk_anthracite))
}

@Composable
fun Headline(
    modifier: Modifier,
    text: String
) {
    Text(text = text, fontSize = 28.sp,textAlign = TextAlign.Center,
        modifier = Modifier.padding(16.dp),
        fontWeight = FontWeight.Bold, color = colorResource(id = R.color.Vorwerk_anthracite))
}

@Composable
fun hyperlink(
    GivenUrl: String,
    str: String
){

    val annotatedLinkString: AnnotatedString = buildAnnotatedString {

        val startIndex = str.indexOf(str)
        val endIndex = startIndex + 10
        append(str)
        addStyle(
            style = SpanStyle(
                color = colorResource(id = R.color.Vorwerk_green),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = GivenUrl,
            start = startIndex,
            end = endIndex
        )

    }

    val uriHandler = LocalUriHandler.current
    val shape = RoundedCornerShape(8.dp)


    Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .width(120.dp)
                .height(180.dp)
                .background(White, shape = shape)
                .clickable { println("working") },

            ) {
            ClickableText(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.TopCenter),
                text = annotatedLinkString,

                        onClick = {
                    annotatedLinkString
                        .getStringAnnotations("URL", it, it)
                        .firstOrNull()?.let { stringAnnotation ->
                            uriHandler.openUri(stringAnnotation.item)
                        }
                }
            )
        }

}

@Composable
fun CoinsAndText(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    val shape = RoundedCornerShape(8.dp)
    Spacer(modifier = Modifier.width(8.dp))
    Surface(
        elevation = 10.dp) {
        Box(
            modifier = modifier
                .width(90.dp)
                .height(180.dp)
                .background(White, shape = shape)
                .clickable { println("working") },

            ) {
            Column {


                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(80.dp)
                        .clip(shape)
                )

                Text(
                    text = text,
                    color = colorResource(id = R.color.Vorwerk_anthracite),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        lineBreak = LineBreak.Heading
                    )
                )
            }
        }
    }
}

@Composable
fun EndImageAndText(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    text: String
) {
    val shape = RoundedCornerShape(4.dp)
    val height = 150.dp
    val brightness = -100f
    val uriHandler = LocalUriHandler.current
    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(White, shape = shape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )
        Column {

            Text(
                text = text,
                color = colorResource(id = R.color.Vorwerk_white),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                    uriHandler.openUri("https://cookidoo.de/search/de-DE?countries=de&context=recipes")
                },
                shape = RoundedCornerShape(25), // = 50% percent
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Vorwerk_white)),
                modifier = Modifier
                    .padding(18.dp), elevation = ButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(
                    text = "Jetzt Entdecken",
                    color = colorResource(id = R.color.Vorwerk_anthracite)
                )
            }
        }

    }
}

@Composable
    fun AccountLogin(

) {

    val shape = RoundedCornerShape(4.dp)
    var EmailText by remember { mutableStateOf("") }
    val brightness = -50f
    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Column {
        TopAppBar(
            modifier = Modifier.border(
                width = 2.dp,
                color = colorResource(id = R.color.Vorwerk_green),
                shape = RoundedCornerShape(2.dp)
            ),
            elevation = 4.dp,
            title = {
                Box(
                    modifier = Modifier.wrapContentSize(Alignment.CenterStart),


                    ) {

                    Image(
                        painter = rememberAsyncImagePainter(
                            "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Vorwerk_Logo.svg/1600px-Vorwerk_Logo.svg.png",
                        ),
                        contentDescription = "Vorwerk_Logo",
                        // contentScale = ContentScale.Crop
                    )
                }
            },
            backgroundColor = colorResource(id = R.color.Vorwerk_white),
            contentColor = colorResource(id = R.color.Vorwerk_anthracite),
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Return_To_Main"
                    )
                }
            },
        )

        Box(

            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(White, shape = shape),
            contentAlignment = Alignment.Center

        ) {


            Image(
                painter = rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3OAEUJ53ccm3-3L5DcwRuCptJHVR634chvw&usqp=CAU"),
                contentDescription = "test",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
                modifier = Modifier
                    .blur(15.dp)
                    .fillMaxSize()
                    .clip(shape)
            )

            Column(modifier = Modifier.align(Center)) {
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = "Anmelden",
                    color = colorResource(id = R.color.Vorwerk_white),
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .width(300.dp)
                        .padding(top = 8.dp) // adding some space to the label
                        .background(
                            colorResource(id = R.color.Vorwerk_white),
                            // rounded corner to match with the OutlinedTextField
                            shape = RoundedCornerShape(4.dp)
                        )
                ) {
                    Column(modifier = Modifier.align(Center)) {

                        Spacer(modifier = Modifier.height(10.dp))
                        TextField(
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .padding(top = 8.dp),
                            value = EmailText,
                            onValueChange = { EmailText = it },
                            label = { Text("Deine E-Mail-Adresse") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        TextField(
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .padding(top = 8.dp),
                            value = EmailText,
                            onValueChange = { EmailText = it },
                            label = { Text("Dein Passwort") }
                        )

                        Button(
                            onClick = { println("working") },
                            shape = RoundedCornerShape(25), // = 50% percent
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Vorwerk_green)),
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .width(280.dp)
                                .padding(18.dp), elevation = ButtonDefaults.elevation(
                                defaultElevation = 10.dp,
                                pressedElevation = 15.dp,
                                disabledElevation = 0.dp
                            )
                        ) {
                            Text(
                                text = "Jetzt Ausprobieren",
                                color = colorResource(id = R.color.Vorwerk_white)
                            )
                        }
                    }
                }
            }
        }


    }
}

