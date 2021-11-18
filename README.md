# PetStore Application

## Packaging and running the application

If you want to build an _??ber-jar_, execute the following command:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it is not an _??ber-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Creating a native executable

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Or to use Mandrel distribution:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:20.3-java11

You can then execute your native executable with:

    ./build/petstore-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.


## Test API using curl
### Addi/View/Update/Delete Pets
Create new pet

    curl --location --request POST 'localhost:8080/v1/pets/create' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'pet_name=Chuti'
    --data-urlencode 'pet_type=Cat' \
    --data-urlencode 'pet_age=4' \
    
Get pet by ID

    curl --location --request GET 'localhost:8080/v1/pets/1'

Update pet by ID

    curl --location --request PUT 'localhost:8080/v1/pets/update' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'pet_type=Dog' \
    --data-urlencode 'pet_age=6' \
    --data-urlencode 'pet_name=Kalu' \
    --data-urlencode 'pet_id=2'

Delete pet by ID

    curl --location --request DELETE 'localhost:8080/v1/pets/1' 

### Add/View/Update/Delete Pet Types
Create new pet type

    curl --location --request POST 'localhost:8080/v1/pettype/create' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'pet_type=Cat' 

Get pet type by ID

    curl --location --request GET 'localhost:8080/v1/pettype/1'

Update pet by ID

    curl --location --request PUT 'localhost:8080/v1/pettype/update' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'pet_type_id=1' \
    --data-urlencode 'pet_type=Cat'
    

Delete pet by ID

    curl --location --request DELETE 'localhost:8080/v1/pettype/1' 

### Search for Pets

Get pet by ID

    curl --location --request GET 'localhost:8080/v1/pets/1'

Get pet by name

    curl --location --request GET 'localhost:8080/v1/pets/name/kalu'

Get pet by type

    curl --location --request GET 'localhost:8080/v1/pets/type/Cat'

Get pet by age

    curl --location --request GET 'localhost:8080/v1/pets/age/6'

## Run Test Suites
Test suites (Junit/RestAssured) are available in test/java/org/acme/

    PetResourceTest.java
    PetTypeResourceTest.java

Run

    ./gradlew test

## Docker Deploying

Create docker image

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

Run image

    docker run -i --rm -p 8080:8080 rdila/petstore:unspecified

Deploy on docker compose

    cd deploy
    docker-compose up -d

View dashboard at  http://localhost:3000/dashboards
