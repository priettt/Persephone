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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column {
        Text(
            text = "Home",
            fontSize = 40.sp,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            val plants: List<Plant> = PlantsRepository().getPlants()
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
            contentDescription = "A test plant"
        )
        Text(
            text = plant.name,
            Modifier.align(Alignment.CenterHorizontally),
            fontSize = 14.sp
        )
    }
}
