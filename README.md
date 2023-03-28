
# apache client timeouts

## How to use

In one terminal:

```
nc -lk 8666
```

This will just open netcat to listen on a port. It will never send any data
to the client, just accept a connection.

The in another terminal, run 
```
./gradlew run
```