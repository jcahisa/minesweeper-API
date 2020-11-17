# API - DETAILED

## Users

### Get User by user Name

Get the details of user. It's main goal is to identify if a user already exists in the database

**URL** : `/user/{userName}`

**Method** : `GET`

###### Success Response

**Code** : `200 OK`

**Content examples**

For a User with userName gojoego on the local database.

```json
{
    "id": "526fc40a-2456-4c0c-898b-e04179082886",
    "userName": "gojoego"
}
```

###### Success Response

If the user does not exist

**Code** : `404 NOT FOUND`


### Create User
* [Create User](doc/minesweeper-API.md#create-user)                    : `POST    /user/{userName}`

### Get all active Games for User 
* [Get all active Games for User](doc/minesweeper-API.md#get-all-active-games-for-user):  `GET     /user/{userId}/activeGames`

### Create new Game for user 
* [Create new Game for user](doc/minesweeper-API.md#create-new-game-for-user):     `POST    /user/{userId}/createGame`

### Get all users 
* [Get all users](doc/minesweeper-API.md#get-all-users):                     `GET     /user/all` 

## Games

### Get Game by Id
* [Get Game by Id](doc/minesweeper-API.md#get-game-by-id): `GET     /game/{gameId}`

### Toggle flag for cell
* [Toggle flag for cell](doc/minesweeper-API.md#toggle-flag-for-cell): `PUT     /game/{gamedId}/cell/{row}/{col}/toggleFlag`


### Uncover cell
* [Uncover cell](doc/minesweeper-API.md#uncover-cell): `PUT     /game/{gamedId}/cell/{row}/{col}/uncoverCell`