package nextstep.shoppingcart.ui.product.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.Cart

@Composable
fun ProductCard(product: Product, onClickCard: () -> Unit) {

    var items by remember { mutableStateOf(Cart.items) }

    Column(
        modifier = Modifier
            .clickable(onClick = onClickCard)
            .fillMaxSize()
    ) {
        InteractiveProductImage(
            product = product,
            items = items,
            modifier = Modifier,
            onClickPlus = { items = Cart.addOne(product) },
            onClickMinus = { items = Cart.removeOne(product) },
            onClickFab = { items = Cart.addOne(product) }
        )

        Text(
            modifier = Modifier
                .padding(vertical = 3.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = product.name
        )

        Text(
            modifier = Modifier,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.bodyMedium,
            text = stringResource(id = R.string.formatted_price, product.price)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    ProductCard(
        product = Product(
            id = 1231,
            imgUrl = "https://picsum.photos/seed/1/200",
            name = "Mariana Webster",
            price = 8348
        ),
        onClickCard = {}
    )
}