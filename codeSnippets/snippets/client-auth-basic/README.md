# Client basic authentication

A sample project demonstrating how to authenticate a client using basic [authentication](https://ktor.io/docs/auth.html).

## Running

Before running this sample, start the [auth-basic](../auth-basic) server sample with a resource protected using basic authentication:

```bash
# macOS/Linux
./gradlew :auth-basic:run

# Windows
gradlew.bat :auth-basic:run
```

Then, run this client sample:

```bash
# macOS/Linux
./gradlew :client-auth-basic:run

# Windows
gradlew.bat :client-auth-basic:run
```

A server should respond with the 'Hello, jetbrains!' message.