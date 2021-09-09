package sdui_frontend

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*


val client = HttpClient(CIO) {
    defaultRequest {
        host = "sdui-test-database.herokuapp.com"
        url {
            protocol = URLProtocol.HTTPS
        }
        contentType(ContentType.Application.Json)
    }

    install(JsonFeature) {
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            //   isLenient = true
            ignoreUnknownKeys = true
        })
    }

  /*  install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println("CLIENT => $message")
            }
        }
        level = LogLevel.ALL
    }
   */
}

