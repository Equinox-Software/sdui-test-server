package sdui_frontend

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
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

    //  expectSuccess=false

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

    /*  HttpResponseValidator {
          validateResponse { response: HttpResponse ->
              val statusCode = response.status.value

              println("HTTP status: $statusCode")

              when (statusCode) {
                  in 300..399 -> throw RedirectResponseException(response,response.receive())
                  in 400..499 -> throw ClientRequestException(response,response.receive()) //(BackendError(response.status.value, response.receive())
                  in 500..599 -> throw ServerResponseException(response,response.receive())
              }



              if (statusCode >= 600) {
                  throw ResponseException(response,response.receive())
              }
          }

          handleResponseException { cause: Throwable ->
              throw cause
          }}

     */
}

suspend fun <T> HttpClient.requestAndCatch(
    block: suspend HttpClient.() -> T,
    errorHandler: suspend ResponseException.() -> T
): T = runCatching { block() }
    .getOrElse {
        when (it) {
            is ResponseException -> it.errorHandler()
            else -> throw it
        }
    }


