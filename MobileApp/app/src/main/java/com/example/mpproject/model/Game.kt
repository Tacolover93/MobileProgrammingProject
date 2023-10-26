package com.example.mpproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
    This is the base object to represent individual games.
    Each game should at minimum have:
        - id                (int?)
        - title             (string)
        - completed         (boolean)
        - completedDate     (long?)
        - system            (string)
    Best Effort should be made to acquire these, but they should not be necessary:
        - art               (TODO: ??? nullable string or blob?)
        - description       (string?)
        - publisher         (string?)
        - publishDate       (long?)
    Users should be able to add the following to their game entries (WIP):
        - photos            (TODO: ??? ArrayList? of images saved like Art)
        - notes             (string?)
        - rating            (int?)
 */

@Entity(tableName = "game_table")
class Game(

                        /*   Minimum Game Requirements   */

    // Games should be able to share a title and maintain an individual identifier for console
    // differentiation. ID will be auto-assigned when a new game is added to game database.
    @PrimaryKey(autoGenerate = true) val id: Int?,

    // All games need a title.
    @ColumnInfo(name = "title") var title: String,

    // All games need a completion marker.
    @ColumnInfo(defaultValue = "0", name = "completed") var completed: Boolean,

    // All games need to record when a game is marked Completed.
    @ColumnInfo(name = "completeDate") var completedDate: Long?,

    // All games have a system and it should be defined.
    @ColumnInfo(name = "system") var system: String,


                        /*   Best Effort Game Requirements (scraping)   */

    // All games have cover art and look better with cover art, but users may choose not to define.
    // TODO: Currently defined as string for filepath, may change.
    @ColumnInfo(name = "art") var art: String?,

    // All games have an official description published with the game, users may not care.
    @ColumnInfo(name = "description") var description: String?,

    // All games have a publisher and a publishing date, users may not care to define themselves.
    @ColumnInfo(name = "publisher") var publisher: String?,
    @ColumnInfo(name = "publishDate") var publishDate: Long?,


                        /*   User-Defined Game Requirements   */

    // All games can have a spot for the user to take notes.
    @ColumnInfo(name = "notes") var notes: String?,

    // All games can have screenshots or photos related to it that the user may want to save.
    // TODO: Currently defined as an arraylist of strings for filepath, may change.
    @ColumnInfo(name = "photos") var photos: ArrayList<String>?,

    // Users should be able to rate the game
    @ColumnInfo(name = "rating") var rating: Int?,
)