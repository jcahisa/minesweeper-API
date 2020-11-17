# minesweeper-API

Duplicate config.yml as config-local.yml and modify with your settings

API:

## Users 
    GET     /user/{userName}                              -> Get user by user Name
    POST    /user/{userName}                              -> Create new user by username
    GET     /user/{userId}/activeGames                    -> Get all active Games for a user
    POST    /user/{userId}/createGame                     -> Create a new Game for the user
    GET     /user/all                                     -> Get all users

## Games
    GET     /game/{gameId}                                -> Get Game by Id
    PUT     /game/{gamedId}/cell/{row}/{col}/toggleFlag   -> Toggle flag for a specif cell
    PUT     /game/{gamedId}/cell/{row}/{col}/uncoverCell  -> Uncover a cell
