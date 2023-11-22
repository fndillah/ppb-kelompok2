package com.example.catatankeuangan.ui

//import androidx.compose.foundation.lazy.GridCells
//import androidx.compose.foundation.lazy.LazyVerticalGrid
//import androidx.fragment.app.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.catatankeuangan.data.BottomMenuContent
import com.example.catatankeuangan.data.Transaction
import com.example.catatankeuangan.features.TransactionScreen
import com.example.catatankeuangan.ui.theme.AquaBlue
import com.example.catatankeuangan.ui.theme.ButtonGreen
import com.example.catatankeuangan.ui.theme.DarkerButtonGreen
import com.example.catatankeuangan.ui.theme.DeepBlue
import com.example.catatankeuangan.ui.theme.LightRed
import com.example.catatankeuangan.ui.theme.TextWhite

@ExperimentalFoundationApi
//@Preview(widthDp = 700, heightDp = 1400)
@Composable
fun HomeScreen() {
//    val viewModel: TransactionViewModel = viewModel()
    // this is the most outer box having all the views inside it
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            TransactionScreen()


        }

    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonGreen,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0,
    navController: NavHostController
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                navController = navController
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonGreen,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    navController: NavHostController,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
            println("Item clicked: ${item.route}") // Add this line
            navController.navigate("${item.route}")
        }
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
fun GreetingSection(
    name: String = ", Kel 2",
    navController: NavHostController = rememberNavController()
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Manage Expense $name",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "It's time to manage your money",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonGreen
                        else DarkerButtonGreen
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun suggestionSection(
    totalBalance: Long,
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Rp. $totalBalance",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = if (totalBalance > 100000) "how wasteful you are" else "cool management",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
    }
}

interface TransactionActions {
    fun onDelete(transactionId: String)
    fun onEdit(transaction: Transaction)
}

@ExperimentalFoundationApi
@Composable
fun CourseSection(transcs: List<Transaction>, transactionActions: TransactionActions) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Latest Transaction",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp,bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(transcs.size) {
                TransactionItem(transc = transcs[it], transactionActions = transactionActions)
            }
        }
    }
}

@Composable
fun TransactionItem(
    transc: Transaction,
    transactionActions: TransactionActions
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(5f)
            .clip(RoundedCornerShape(10.dp))
            .background(ButtonGreen)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(
                text = transc.description ,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 26.sp,

            )
            Text(
                text = "Rp "+ transc.amount.toString() ,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 26.sp,

            )
        }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(all = 1.dp)
            ) {
                Text(
                    text = "Edit",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            transactionActions.onEdit(transc)
                        }
                        //                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(LightRed)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )

                Text(
                    text = "Delete",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            transactionActions.onDelete(transc.id)
                        }
                        //                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonGreen)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )
            }
        }
    }
}

