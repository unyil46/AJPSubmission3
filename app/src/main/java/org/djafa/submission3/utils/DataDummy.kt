package org.djafa.submission3.utils

import org.djafa.submission3.data.source.local.entity.MoviesEntity
import org.djafa.submission3.data.source.remote.response.MovieResponse

object DataDummy {
    fun generateDummyMovies(): ArrayList<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()
        movies.add(
            MoviesEntity(
                "337404",
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "https://image.tmdb.org/t/p/w500/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "8.6"
            )
        )
        movies.add(
            MoviesEntity(
                "423108",
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                "https://image.tmdb.org/t/p/w500/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                "8.2"
            )
        )
        movies.add(
            MoviesEntity(
                "637649",
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                "https://image.tmdb.org/t/p/w500/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "7.8"
            )
        )
        movies.add(
            MoviesEntity(
                "717192",
                "Ferry",
                "Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life.",
                "https://image.tmdb.org/t/p/w500/w6n1pu9thpCVHILejsuhKf3tNCV.jpg",
                "6.9"
            )
        )
        movies.add(
            MoviesEntity(
                "460465",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://image.tmdb.org/t/p/w500/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "7.5"
            )
        )
        movies.add(
            MoviesEntity(
                "804435",
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "https://image.tmdb.org/t/p/w500/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "5.9"
            )
        )
        movies.add(
            MoviesEntity(
                "726429",
                "Xtremo",
                "Two years after the murder of his son and father, a retired hitman sets in motion a carefully crafted revenge plan against the killer: his own brother.",
                "https://image.tmdb.org/t/p/w500/cwUhVcDeMYYeu8fq5q1OPOoSbZ7.jpg",
                "7.3"
            )
        )
        movies.add(
            MoviesEntity(
                "503736",
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "https://image.tmdb.org/t/p/w500/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "6.5"
            )
        )
        movies.add(
            MoviesEntity(
                "817451",
                "Endangered Species",
                "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
                "https://image.tmdb.org/t/p/w500/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg",
                "6.5"
            )
        )
        movies.add(
            MoviesEntity(
                "399566",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "8.0"
            )
        )
        movies.add(
            MoviesEntity(
                "567189",
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "7.2"
            )
        )
        return movies
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                "337404",
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "https://image.tmdb.org/t/p/w500/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "8.6"
            )
        )
        movies.add(
            MovieResponse(
                "423108",
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                "https://image.tmdb.org/t/p/w500/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                "8.2"
            )
        )
        movies.add(
            MovieResponse(
                "637649",
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                "https://image.tmdb.org/t/p/w500/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                "7.8"
            )
        )
        movies.add(
            MovieResponse(
                "717192",
                "Ferry",
                "Before he built a drug empire, Ferry Bouman returns to his hometown on a revenge mission that finds his loyalty tested — and a love that alters his life.",
                "https://image.tmdb.org/t/p/w500/w6n1pu9thpCVHILejsuhKf3tNCV.jpg",
                "6.9"
            )
        )
        movies.add(
            MovieResponse(
                "460465",
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://image.tmdb.org/t/p/w500/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "7.5"
            )
        )
        movies.add(
            MovieResponse(
                "804435",
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "https://image.tmdb.org/t/p/w500/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "5.9"
            )
        )
        movies.add(
            MovieResponse(
                "726429",
                "Xtremo",
                "Two years after the murder of his son and father, a retired hitman sets in motion a carefully crafted revenge plan against the killer: his own brother.",
                "https://image.tmdb.org/t/p/w500/cwUhVcDeMYYeu8fq5q1OPOoSbZ7.jpg",
                "7.3"
            )
        )
        movies.add(
            MovieResponse(
                "503736",
                "Army of the Dead",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "https://image.tmdb.org/t/p/w500/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                "6.5"
            )
        )
        movies.add(
            MovieResponse(
                "817451",
                "Endangered Species",
                "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
                "https://image.tmdb.org/t/p/w500/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg",
                "6.5"
            )
        )
        movies.add(
            MovieResponse(
                "399566",
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "8.0"
            )
        )
        movies.add(
            MovieResponse(
                "567189",
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "7.2"
            )
        )
        return movies
    }

    fun generateDummyTvShows(): ArrayList<MoviesEntity> {
        val tvshows = ArrayList<MoviesEntity>()
        tvshows.add(
            MoviesEntity(
                "84958",
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "https://image.tmdb.org/t/p/w500/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MoviesEntity(
                "103768",
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                "https://image.tmdb.org/t/p/w500/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MoviesEntity(
                "63174",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "8.5"
            )
        )
        tvshows.add(
            MoviesEntity(
                "60735",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "7.7"
            )
        )
        tvshows.add(
            MoviesEntity(
                "71712",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "8.6"
            )
        )
        tvshows.add(
            MoviesEntity(
                "88396",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "7.8"
            )
        )
        tvshows.add(
            MoviesEntity(
                "1416",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "8.2"
            )
        )
        tvshows.add(
            MoviesEntity(
                "91557",
                "Ragnarok",
                "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                "https://image.tmdb.org/t/p/w500/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MoviesEntity(
                "96677",
                "Lupin",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "https://image.tmdb.org/t/p/w500/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "7.9"
            )
        )
        tvshows.add(
            MoviesEntity(
                "76669",
                "Elite",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                "https://image.tmdb.org/t/p/w500/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "8.2"
            )
        )
        tvshows.add(
            MoviesEntity(
                "95057",
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "https://image.tmdb.org/t/p/w500/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "8.3"
            )
        )
        return tvshows
    }

    fun generateRemoteDummyTvShows(): List<MovieResponse> {
        val tvshows = ArrayList<MovieResponse>()
        tvshows.add(
            MovieResponse(
                "84958",
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "https://image.tmdb.org/t/p/w500/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MovieResponse(
                "103768",
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
                "https://image.tmdb.org/t/p/w500/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MovieResponse(
                "63174",
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "8.5"
            )
        )
        tvshows.add(
            MovieResponse(
                "60735",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "7.7"
            )
        )
        tvshows.add(
            MovieResponse(
                "71712",
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "8.6"
            )
        )
        tvshows.add(
            MovieResponse(
                "88396",
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "7.8"
            )
        )
        tvshows.add(
            MovieResponse(
                "1416",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "8.2"
            )
        )
        tvshows.add(
            MovieResponse(
                "91557",
                "Ragnarok",
                "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                "https://image.tmdb.org/t/p/w500/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                "8.1"
            )
        )
        tvshows.add(
            MovieResponse(
                "96677",
                "Lupin",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "https://image.tmdb.org/t/p/w500/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "7.9"
            )
        )
        tvshows.add(
            MovieResponse(
                "76669",
                "Elite",
                "When three working class kids enroll in the most exclusive school in Spain, the clash between the wealthy and the poor students leads to tragedy.",
                "https://image.tmdb.org/t/p/w500/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "8.2"
            )
        )
        tvshows.add(
            MovieResponse(
                "95057",
                "Superman & Lois",
                "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                "https://image.tmdb.org/t/p/w500/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                "8.3"
            )
        )
        return tvshows

    }
}