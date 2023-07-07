package com.example.gamespy

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gamespy.data.ViewModel
import com.example.gamespy.data.entity.relation.InfoWithPlaces

@Composable
fun ListScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        val viewModel: ViewModel = viewModel()
        val itemsOfGroup = viewModel.readAlldata.observeAsState(listOf()).value

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            val uniqueNames = itemsOfGroup.distinctBy { it.info.nameInfo }
            Text(
                text = stringResource(R.string.textInfo),
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            ListInfoAndPlaces(cartView = viewModel, uniqueNames = uniqueNames, navController)

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListInfoAndPlaces(
    cartView: ViewModel,
    uniqueNames: List<InfoWithPlaces>,
    navController: NavController,
) {
    LazyColumn {
        items(uniqueNames) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        val route = Destination.DetailsOfPlaces.createRoute(item.info.nameInfo)
                        navController.navigate(route)

                    },
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.Gray
            ) {
                ListItem(
                    text = { Text(text = item.info.nameInfo) },
                    icon = {
                        IconButton(onClick = {
                            cartView.deleteInfo(item.info)
                            cartView.deletePlace(item.places)
                        }) {
                            Icon(
                                Icons.Default.Delete, contentDescription = null
                            )
                        }
                    },
                )
            }
        }
    }

}










