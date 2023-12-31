class Song(var title: String, val artist: String, var duration: Int) {
    //Method for formated song duration:
    fun getFormattedDuration(): String {
        val min = duration / 60
        val sec = duration % 60

        return "$min minutes $sec seconds"
    }

    //Method to check if song longer than duration:
    fun isLongerThan(minutes: Int):Boolean {
        return duration > minutes * 60
    }

    //Print Song:
    fun printSong() {
        println("Song: $title by $artist")
        println("Duration: ${getFormattedDuration()}")
        println("\n")
    }

    //Get Info Method:
    fun getInfo(): String {
        return "$title by $artist, ${getFormattedDuration()}"
    }

    fun addToDuration(sec: Int) {
        duration += sec
    }

    fun changeTitle(newTitle: String) {
        title = newTitle
    }

    //Compare:
    fun equals(other:Song): Boolean {
        return (title == other.title) && (artist == other.artist)
    }

    //Copy with New Duration:
    fun copyWithNewDuration(newDur: Int): Song {
        return Song(title, artist, newDur)
    }

    //Generate Random Song:
    companion object {
        fun generateRandomSong(): Song {
            val artists = listOf("A1", "A2", "A3")
            val titles = listOf("T1", "T2", "T3")

            val randomArtist = artists.random()
            val randomTitle = titles.random()
            val randomDuration = (60..300).random()

            return Song(randomTitle, randomArtist, randomDuration)
        }

        fun createSongList(vararg songs: Song):List<Song> {
            return songs.toList()
        }
    }

    // LIST METHODS:
    fun shufflePlaylist(playlist: List<Song>): List<Song> {
        return playlist.shuffled()
    }

    // Method to filter songs in a playlist by minimum duration
    fun filterByDuration(playlist: List<Song>, minDuration: Int): List<Song> {
        return playlist.filter { it.duration >= minDuration }
    }



}

fun main() {
    val s1 = Song("Children of the Elder God", "Poets of the Fall", 220)
    val s2 = Song("Stay On Me", "A-ha", 189)

    s1.printSong()
    s2.printSong()

    var compare = s1.equals(s2)
    println(compare)

    //Getting info in single string:
    s1.getInfo()
    s2.getInfo()

    //Change Title:
    s1.changeTitle("Take Control")
    s1.printSong()

    s2.addToDuration(15)
    s2.printSong()

    val newSong = s1.copyWithNewDuration(180)
    newSong.printSong()

    val randSong = Song.generateRandomSong()
    randSong.printSong()

    val playlist = Song.createSongList(s1, s2, newSong, randSong)
    println("\nPlaylist:")
    playlist.forEach{it.printSong()}

    val shufflePlayList = s1.shufflePlaylist(playlist)
    println("\nPlaylist:")
    shufflePlayList.forEach{it.printSong()}


    val filteredPlayList = s1.filterByDuration(playlist, 200)
    println("\nPlaylist:")
    filteredPlayList.forEach{it.printSong()}
}

main()