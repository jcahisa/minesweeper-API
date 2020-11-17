# minesweeper-API

Duplicate config.yml as config-local.yml and modify with your settings

# API - HIGH LEVEL VIEW

## Users

* [Get User by user Name](doc/minesweeper-API.md#get-user-by-user-name): `GET /user/{userName}` 
* [Create User](doc/minesweeper-API.md#create-user)                    : `POST    /user/{userName}` 
* [Get all active Games for User](doc/minesweeper-API.md#get-all-active-games-for-user):  `GET     /user/{userId}/activeGames` 
* [Create new Game for user](doc/minesweeper-API.md#create-new-game-for-user):     `POST    /user/{userId}/createGame` 
* [Get all users](doc/minesweeper-API.md#get-all-users):                     `GET     /user/all` 

## Games
* [Get Game by Id](doc/minesweeper-API.md#get-game-by-id): `GET     /game/{gameId}`
* [Toggle flag for cell](doc/minesweeper-API.md#toggle-flag-for-cell): `PUT     /game/{gamedId}/cell/{row}/{col}/toggleFlag`
* [Uncover cell](doc/minesweeper-API.md#uncover-cell): `PUT     /game/{gamedId}/cell/{row}/{col}/uncoverCell`
    