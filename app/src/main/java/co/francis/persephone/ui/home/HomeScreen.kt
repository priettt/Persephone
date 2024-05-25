package co.francis.persephone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import co.francis.persephone.R

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    onAddPlantClick: () -> Unit,
) {
    val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddPlantClick() },
                content = { Icon(Icons.Default.Add, "Add a plant") }
            )
        },
    ) { innerPadding ->
        HomeScreenContent(Modifier.padding(innerPadding), uiState.value.plants)
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    plants: List<Plant>,
) {
    Column(modifier) {
        Text(
            text = "My plants",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(plants) {
                PlantCard(plant = it)
            }
        }
    }
}

@Composable
fun PlantCard(plant: Plant) {
    Column {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = plant.resourceId),
            contentDescription = "A picture of a ${plant.name}"
        )
        Text(
            text = plant.name,
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    HomeScreenContent(
        plants = listOf(
            Plant("Aloe Vera", R.drawable.plantita),
            Plant("Ficus", R.drawable.plantita),
            Plant("Rose", R.drawable.plantita),
            Plant("Sansiveria", R.drawable.plantita),
        )
    )
}
