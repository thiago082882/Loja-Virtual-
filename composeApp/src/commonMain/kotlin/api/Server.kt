package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import model.Product

class Server {

    suspend fun  getProducts():Flow<MutableList<Product>>{
        val client = HttpClient{
            install(ContentNegotiation){
                json()
            }
            install(HttpCache)
        }
        val  product = client
            .get("https://stackmobile.com.br/lojavirtual")
            .body<MutableList<Product>>()
        return MutableStateFlow(product)

    }
}