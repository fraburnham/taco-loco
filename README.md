# Test Application

## Building and Running

### Building

The jar can be built using the appropriate `mvnw` for your OS.

```shell script
$ ./mvnw clean && ./mvnw package
```

### Running

In an appropriate environment the jar can be started using

```shell script
$ cd target/ && java -jar detroit-labs-test-0.0.1-SNAPSHOT.jar
```

The version may change in the future. Be sure to use the latest jar in `target/`.

## API

### `POST /order`

#### Request

* The request body will specify the quantity in this order of each type of taco. 
* Tacos with zero counts may be omitted. 
* The total number of tacos ordered **must** be non zero.
* Each count **must** be zero or positive. No order may have a negative quantity.

```json
{
  "veggieCount": <int>,
  "beefOrChickenCount": <int>,
  "chorizoCount": <int>
}
```

#### Response

* The response will have the order total in cents and a status code of 200 if the request was valid.
* If the request violates the constraints above the service will respond with a 400 and an error message meant to be read by a developer (format otherwise unspecified).

```json
{
  "totalCents": <int>
}
```