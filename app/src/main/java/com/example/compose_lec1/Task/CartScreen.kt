package com.example.compose_lec1.Task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_lec1.R

class CartActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CartScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("سلة المشتريات", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = {
                    // ✅ تم الإصلاح: الآن الضغط هنا يفتح الـ Sheet
                    IconButton(onClick = { showSheet = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.delete),
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = { CartBottomBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("3 منتجات", color = Color.Gray, fontSize = 14.sp)
                    Checkbox(checked = false, onCheckedChange = {})
                }
            }

            items(2) {
                CartProductItem()
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            containerColor = Color.White,
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            dragHandle = { BottomSheetDefaults.DragHandle(width = 50.dp, color = Color.LightGray) }
        ) {
            DeleteConfirmationSheetContent(
                onCancel = { showSheet = false },
                onConfirm = { showSheet = false }
            )
        }
    }
}

@Composable
fun CartProductItem() {
    var quantity by remember { mutableIntStateOf(1) }
    var isChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFBFBFB)),
        // إضافة Border خفيف جداً ليشبه التصميم
        border = BorderStroke(0.5.dp, Color.LightGray.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,

        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color(0xFFEFE6DE), RoundedCornerShape(8.dp)) // خلفية خفيفة للأزرار
                    .padding(4.dp)
            ) {
                IconButton(onClick = { quantity++ }, modifier = Modifier.size(24.dp)) {
                    Icon(painterResource(id = R.drawable.plas), contentDescription = null, tint = Color(0xFF9E8069))
                }
                Text(
                    text = "$quantity",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                IconButton(onClick = { if (quantity > 1) quantity-- }, modifier = Modifier.size(24.dp)) {
                    Icon(painterResource(id = R.drawable.decriment), contentDescription = null, tint = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // 2. السعر ومعلومات الحذاء (في المنتصف)
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "حذاء رياضي",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(text = "42", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                    Text(text = " : المقاس ", color = Color.Gray, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(Color.Black, CircleShape)
                    )
                    Text(text = " : اللون ", color = Color.Gray, fontSize = 14.sp)
                }

                Text(
                    text = "$18",
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black, // في الصورة السعر لونه أسود وواضح
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 3. صورة المنتج
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.shose),
                    contentDescription = null,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFF3F3F3)), // خلفية الصورة فاتحة
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 4. Checkbox (على اليمين تماماً)
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF9E8069))
            )
        }
    }
}
@Composable
fun CartBottomBar() {
    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "$36", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
            Text(text = "التكلفة", color = Color.Black, fontWeight = FontWeight.Medium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9E8069)),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text("شراء", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Composable
fun DeleteConfirmationSheetContent(onCancel: () -> Unit, onConfirm: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text("هل انت متأكد من انك تريد حذف العنصر ؟", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(Modifier.width(8.dp))
            Icon(painterResource(id = R.drawable.broken), contentDescription = null, tint = Color.Red, modifier = Modifier.size(20.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        // بطاقة المنتج المصغرة داخل الشيت
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
            border = BorderStroke(0.5.dp, Color.LightGray),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.End, modifier = Modifier.weight(1f)) {
                    Text("حذاء رياضي", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("نايكي", color = Color.Gray, fontSize = 12.sp)
                    Text("$18", fontWeight = FontWeight.Bold, color = Color(0xFF9E8069))
                }
                Spacer(Modifier.width(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.shose),
                    contentDescription = null,
                    modifier = Modifier.size(65.dp).clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            OutlinedButton(
                onClick = onConfirm,
                modifier = Modifier.weight(1f).height(50.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xFF9E8069))
            ) {
                Text("نعم", color = Color.Black)
            }
            Button(
                onClick = onCancel,
                modifier = Modifier.weight(1f).height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9E8069)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("لا شكراً", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
    }
}