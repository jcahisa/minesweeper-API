# minesweeper-API

Duplicate config.yml as config-local.yml and modify with your settings

# API - HIGH LEVEL VIEW

## Users 
    Get User by user Name              GET     /user/{userName}
    Create User                        POST    /user/{userName} 
    Get all active Games for User      GET     /user/{userId}/activeGames 
    Create a new Game for the user     POST    /user/{userId}/createGame 
    Get all users                      GET     /user/all 

## Games
    Get Game by Id                     GET     /game/{gameId} 
    Toggle flag for a specif cell      PUT     /game/{gamedId}/cell/{row}/{col}/toggleFlag 
    Uncover a cell                     PUT     /game/{gamedId}/cell/{row}/{col}/uncoverCell
    