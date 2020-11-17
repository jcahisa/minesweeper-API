# DETAILED API - Users  

## Get User by user Name

Get the details of user. It's main goal is to identify if a user already exists in the database

**URL** : `/user/{userName}`

**Method** : `GET`

### Success Response

**Code** : `200 OK`

**Content examples**

For a User with userName gojoego on the local database.

```json
{
    "id": "526fc40a-2456-4c0c-898b-e04179082886",
    "userName": "gojoego"
}
```

### Failure Response

If the user does not exist

**Code** : `404 NOT FOUND`

## Create User
Create new user on the system. Only userName is stored in the database

**URL** : `/user/{userName}`

**Method** : `POST`

### Success Response

**Code** : `200 OK`

**Content examples**

For a User with userName gojoego.

```json
{
    "id": "526fc40a-2456-4c0c-898b-e04179082886",
    "userName": "gojoego"
}
```

## Create new Game for user
Create a new game for the user with the specified parameters.

**URL** : `/user/{userId}/createGame`

**Method** : `POST`
 
### Success Response

**Code** : `200 OK`

**Content examples**

```json
{
    "id": "65f89c9c-46bf-4006-a728-94d7aa3df984",
    "userId": "526fc40a-2456-4c0c-898b-e04179082886",
    "startTime": 1605615131470,
    "endTime": null,
    "status": "ACTIVE",
    "gameBoard": {
        "rows": 10,
        "columns": 10,
        "cells": [
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 2,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 3,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ],
            [
                {
                    "content": "BOMB",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": false,
                    "uncovered": false,
                    "bomb": true
                },
                {
                    "content": "HINT",
                    "status": "COVERED",
                    "surroundingBombs": 2,
                    "empty": false,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                },
                {
                    "content": "EMPTY",
                    "status": "COVERED",
                    "surroundingBombs": 0,
                    "empty": true,
                    "uncovered": false,
                    "bomb": false
                }
            ]
        ]
    }
}
```

### Failure Response

If the user does not exist

**Code** : `404 NOT FOUND`

## Get all active Games for User 
Get all active Games for a User

**URL** : `/user/{userId}/activeGames`

**Method** : `GET`

### Success Response

**Code** : `200 OK`

**Content examples**

```json
[
    {
        "id": "65f89c9c-46bf-4006-a728-94d7aa3df984",
        "userId": "526fc40a-2456-4c0c-898b-e04179082886",
        "startTime": 1605615131470,
        "endTime": null,
        "status": "ACTIVE",
        "gameBoard": null
    }
]
```

## Get all users 
Get all Users

**URL** : `/user/all`

**Method** : `GET`

### Success Response

**Code** : `200 OK`

# DETAILED API - Games

## Get Game by Id
Get Game by Id

**URL** : `/game/{gameId}`

**Method** : `GET`

### Success Response

**Code** : `200 OK`

## Toggle flag for cell
Modify the flag status for a cell. The cell should be covered.

**URL** : `/game/{gamedId}/cell/{row}/{col}/toggleFlag`

**Method** : `PUT`

### Success Response

**Code** : `200 OK`


## Uncover cell
Unconver a cell. You need to verify the Game status code of the response to identify win or lose conditions

**URL** : `/game/{gamedId}/cell/{row}/{col}/uncoverCell`

**Method** : `PUT`

### Success Response

**Code** : `200 OK`