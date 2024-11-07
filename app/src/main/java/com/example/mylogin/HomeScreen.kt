import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylogin.R
import androidx.compose.ui.Alignment

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCF4EB))
            .padding(16.dp)
    ) {
        // Logo and Notification in Row
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_tasteloop),
                contentDescription = "TasteLoop Logo",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(48.dp),
                contentScale = ContentScale.Fit
            )
        }

        // Title Section
        Text(
            text = "Hai, Surya sudah makan hari ini?",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Menu Hari Ini Section
        Image(
            painter = painterResource(id = R.drawable.sample_meal),
            contentDescription = "Menu Hari Ini",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        // Gunakan Row agar teks dan tombol sejajar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Salad\nKalori: 999, Protein: 999",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Button(onClick = { /* Tindakan Lihat Detail */ }) {
                Text(text = "Lihat Detail")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menu Besok Section
        Image(
            painter = painterResource(id = R.drawable.sample_meal),
            contentDescription = "Menu Besok",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Teks dan tombol di kanan kiri
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Salad\nKalori: 999, Protein: 999",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Button(onClick = { /* Tindakan Ubah Paket */ }) {
                Text(text = "Lihat Detail")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Subscription Info Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Teks dan tombol di kanan kiri
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Subscription Active\n5 Hari Tersisa",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Button(onClick = { /* Tindakan Ubah Paket */ }) {
                Text(text = "Ubah Paket")
            }
        }
    }
}
