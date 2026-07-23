package com.example.data.bible_data

import com.example.data.models.*

object BibleData {

    val BOOKS: List<Book> = listOf(
        // Old Testament - Pentateuch
        Book(1, "Genesis", "Gen", Testament.OLD_TESTAMENT, BookCategory.LAW, 50, "The book of beginnings: Creation, the Fall, the Flood, and the Patriarchs."),
        Book(2, "Exodus", "Exo", Testament.OLD_TESTAMENT, BookCategory.LAW, 40, "The deliverance of Israel from Egypt and the giving of the Law at Mount Sinai."),
        Book(3, "Leviticus", "Lev", Testament.OLD_TESTAMENT, BookCategory.LAW, 27, "Laws regarding holiness, sacrifices, priesthood, and sacred festivals."),
        Book(4, "Numbers", "Num", Testament.OLD_TESTAMENT, BookCategory.LAW, 36, "The wilderness wanderings of Israel and the census of the tribes."),
        Book(5, "Deuteronomy", "Deu", Testament.OLD_TESTAMENT, BookCategory.LAW, 34, "Moses' farewell speeches renewing the covenant before entering the Promised Land."),

        // Old Testament - Historical
        Book(6, "Joshua", "Jos", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 24, "The conquest and division of Canaan under Joshua's leadership."),
        Book(7, "Judges", "Jdg", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 21, "Israel's cycles of rebellion, oppression, and deliverance by God-raised judges."),
        Book(8, "Ruth", "Rut", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 4, "A touching narrative of loyalty, redemption, and the ancestry of King David."),
        Book(9, "1 Samuel", "1Sa", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 31, "The transition from judges to kingship: Samuel, Saul, and David."),
        Book(10, "2 Samuel", "2Sa", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 24, "The reign of King David, his triumphs, and trials."),
        Book(11, "1 Kings", "1Ki", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 22, "Solomon's reign, the building of the Temple, and the division into two kingdoms."),
        Book(12, "2 Kings", "2Ki", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 25, "The decline and fall of Israel and Judah, ending in exile."),
        Book(13, "1 Chronicles", "1Ch", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 29, "Genealogies and a spiritual history of King David's reign."),
        Book(14, "2 Chronicles", "2Ch", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 36, "The history of Solomon and the Kings of Judah through the exile."),
        Book(15, "Ezra", "Ezr", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 10, "The return of the Jewish exiles from Babylon and the rebuilding of the Temple."),
        Book(16, "Nehemiah", "Neh", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 13, "The rebuilding of Jerusalem's walls and spiritual revival."),
        Book(17, "Esther", "Est", Testament.OLD_TESTAMENT, BookCategory.HISTORY, 10, "God's providential care preserving His people through Queen Esther."),

        // Old Testament - Poetry & Wisdom
        Book(18, "Job", "Job", Testament.OLD_TESTAMENT, BookCategory.WISDOM, 42, "A profound exploration of suffering, faith, and God's sovereignty."),
        Book(19, "Psalms", "Psa", Testament.OLD_TESTAMENT, BookCategory.WISDOM, 150, "A sacred collection of prayers, praises, worship songs, and laments."),
        Book(20, "Proverbs", "Pro", Testament.OLD_TESTAMENT, BookCategory.WISDOM, 31, "Practical godly wisdom for daily living, work, and relationships."),
        Book(21, "Ecclesiastes", "Ecc", Testament.OLD_TESTAMENT, BookCategory.WISDOM, 12, "Reflections on the meaning of life, time, and fearing God."),
        Book(22, "Song of Solomon", "Sng", Testament.OLD_TESTAMENT, BookCategory.WISDOM, 8, "A poetic celebration of marital love and devotion."),

        // Old Testament - Major Prophets
        Book(23, "Isaiah", "Isa", Testament.OLD_TESTAMENT, BookCategory.MAJOR_PROPHETS, 66, "Prophecies of judgment, comfort, the Suffering Servant, and Messiah's kingdom."),
        Book(24, "Jeremiah", "Jer", Testament.OLD_TESTAMENT, BookCategory.MAJOR_PROPHETS, 52, "The weeping prophet's warnings to Judah and promise of a New Covenant."),
        Book(25, "Lamentations", "Lam", Testament.OLD_TESTAMENT, BookCategory.MAJOR_PROPHETS, 5, "Poetic laments over the destruction of Jerusalem."),
        Book(26, "Ezekiel", "Ezk", Testament.OLD_TESTAMENT, BookCategory.MAJOR_PROPHETS, 48, "Visions of God's glory, judgment, and spiritual restoration."),
        Book(27, "Daniel", "Dan", Testament.OLD_TESTAMENT, BookCategory.MAJOR_PROPHETS, 12, "Stories of steadfast faith in exile and apocalyptic visions of kingdoms."),

        // Old Testament - Minor Prophets
        Book(28, "Hosea", "Hos", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 14, "God's relentless love for unfaithful Israel illustrated through marriage."),
        Book(29, "Joel", "Joe", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 3, "The Day of the Lord and the promise of the Holy Spirit poured out."),
        Book(30, "Amos", "Amo", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 9, "A call for social justice and righteousness among God's people."),
        Book(31, "Obadiah", "Oba", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 1, "Prophecy of judgment against Edom for pride and hostility."),
        Book(32, "Jonah", "Jon", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 4, "A reluctant prophet sent to Nineveh and God's mercy to all nations."),
        Book(33, "Micah", "Mic", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 7, "Judgment against injustice and the prophecy of Bethlehem's Ruler."),
        Book(34, "Nahum", "Nah", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 3, "Prophecy of the fall of Nineveh and God's justice."),
        Book(35, "Habakkuk", "Hab", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 3, "Questions of faith: 'The just shall live by his faith.'"),
        Book(36, "Zephaniah", "Zep", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 3, "Warnings of judgment and the joy of restoration."),
        Book(37, "Haggai", "Hag", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 2, "Encouragement to rebuild the Temple and prioritize God's house."),
        Book(38, "Zechariah", "Zec", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 14, "Visions of restoration and prophecies of the coming Messiah King."),
        Book(39, "Malachi", "Mal", Testament.OLD_TESTAMENT, BookCategory.MINOR_PROPHETS, 4, "Call to sincere worship and prophecy of the forerunner Elijah."),

        // New Testament - Gospels
        Book(40, "Matthew", "Mat", Testament.NEW_TESTAMENT, BookCategory.GOSPELS, 28, "Jesus presented as the Promised Messiah, King, and fulfillment of OT prophecy."),
        Book(41, "Mark", "Mrk", Testament.NEW_TESTAMENT, BookCategory.GOSPELS, 16, "A fast-paced Gospel portraying Jesus as the Servant of God and Savior."),
        Book(42, "Luke", "Luk", Testament.NEW_TESTAMENT, BookCategory.GOSPELS, 24, "A meticulous account highlighting Jesus' compassion for all humanity."),
        Book(43, "John", "Jhn", Testament.NEW_TESTAMENT, BookCategory.GOSPELS, 21, "A majestic Gospel revealing Jesus as the Eternal Son of God and Light."),

        // New Testament - History
        Book(44, "Acts", "Act", Testament.NEW_TESTAMENT, BookCategory.CHURCH_HISTORY, 28, "The birth of the Church, the Holy Spirit's power, and gospel spreading."),

        // New Testament - Epistles
        Book(45, "Romans", "Rom", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 16, "The foundational exposition of righteousness, grace, faith, and salvation."),
        Book(46, "1 Corinthians", "1Co", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 16, "Address to church issues, spiritual gifts, love, and resurrection."),
        Book(47, "2 Corinthians", "2Co", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 13, "Paul's defense of ministry, comfort in affliction, and generous giving."),
        Book(48, "Galatians", "Gal", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 6, "Defense of Christian liberty by grace through faith, not works."),
        Book(49, "Ephesians", "Eph", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 6, "The rich blessings in Christ, unity of the Church, and armor of God."),
        Book(50, "Philippians", "Php", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 4, "A joyful letter of gratitude, humility, and strength in Christ."),
        Book(51, "Colossians", "Col", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 4, "The supremacy and sufficiency of Jesus Christ over all creation."),
        Book(52, "1 Thessalonians", "1Th", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 5, "Commendations for faith and hope in the return of Jesus Christ."),
        Book(53, "2 Thessalonians", "2Th", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 3, "Encouragement under persecution and clarity on the Lord's coming."),
        Book(54, "1 Timothy", "1Ti", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 6, "Pastoral counsel on church leadership, doctrine, and godliness."),
        Book(55, "2 Timothy", "2Ti", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 4, "Paul's solemn final charge to endure, preach the Word, and finish well."),
        Book(56, "Titus", "Tit", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 3, "Instructions on appointing sound elders and living holy lives."),
        Book(57, "Philemon", "Phm", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 1, "An appeal for forgiveness, reconciliation, and Christian brotherhood."),
        Book(58, "Hebrews", "Heb", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 13, "The superiority of Christ, His priesthood, and enduring faith."),
        Book(59, "James", "Jas", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 5, "Practical Christian wisdom: living faith proven through active good works."),
        Book(60, "1 Peter", "1Pe", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 5, "Living hope, standing firm in suffering, and holy conduct."),
        Book(61, "2 Peter", "2Pe", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 3, "Warnings against false teachers, growing in grace, and Christ's return."),
        Book(62, "1 John", "1Jn", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 5, "Fellowship with God, walking in light, truth, and loving one another."),
        Book(63, "2 John", "2Jn", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 1, "Exhortation to abide in truth and love while avoiding deception."),
        Book(64, "3 John", "3Jn", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 1, "Commendation of hospitality and walking in truth."),
        Book(65, "Jude", "Jud", Testament.NEW_TESTAMENT, BookCategory.EPISTLES, 1, "A passionate call to contend earnestly for the faith."),

        // New Testament - Prophecy
        Book(66, "Revelation", "Rev", Testament.NEW_TESTAMENT, BookCategory.PROPHECY, 22, "The apocalyptic vision of Christ's victory, new heaven, and new earth.")
    )

    // Specific curated Scripture Verses
    private val CURATED_CHAPTERS: Map<String, List<String>> = mapOf(
        "Genesis_1" to listOf(
            "In the beginning God created the heavens and the earth.",
            "The earth was formless and empty, and darkness was on the surface of the deep. God's Spirit was hovering over the surface of the waters.",
            "God said, 'Let there be light,' and there was light.",
            "God saw the light, that it was good, and God divided the light from the darkness.",
            "God called the light 'day', and the darkness he called 'night'. There was evening and there was morning, one day.",
            "God said, 'Let there be an expanse in the middle of the waters, and let it divide the waters from the waters.'",
            "God made the expanse, and divided the waters which were under the expanse from the waters which were above the expanse; and it was so.",
            "God called the expanse 'sky'. There was evening and there was morning, a second day.",
            "God said, 'Let the waters under the heavens be gathered together to one place, and let the dry land appear;' and it was so.",
            "God called the dry land 'earth', and the gathering together of the waters he called 'seas'. God saw that it was good.",
            "God said, 'Let the earth yield grass, herbs yielding seeds, and fruit trees bearing fruit after their kind, with their seeds in it, on the earth;' and it was so.",
            "The earth produced grass, herbs yielding seed after their kind, and trees bearing fruit, with their seeds in it, after their kind; and God saw that it was good.",
            "There was evening and there was morning, a third day.",
            "God said, 'Let there be lights in the expanse of the sky to divide the day from the night; and let them be for signs, and for seasons, and for days and years;'",
            "and let them be for lights in the expanse of the sky to give light on the earth;' and it was so.",
            "God made the two great lights: the greater light to rule the day, and the lesser light to rule the night. He also made the stars.",
            "God set them in the expanse of the sky to give light to the earth,",
            "and to rule over the day and over the night, and to divide the light from the darkness. God saw that it was good.",
            "There was evening and there was morning, a fourth day.",
            "God said, 'Let the waters swarm with swarms of living creatures, and let birds fly above the earth in the open expanse of the sky.'",
            "God created the large sea creatures, and every living creature that moves, with which the waters swarmed, after their kind, and every winged bird after its kind. God saw that it was good.",
            "God blessed them, saying, 'Be fruitful, and multiply, and fill the waters in the seas, and let birds multiply on the earth.'",
            "There was evening and there was morning, a fifth day.",
            "God said, 'Let the earth produce living creatures after their kind, livestock, creeping things, and animals of the earth after their kind;' and it was so.",
            "God made the animals of the earth after their kind, and the livestock after their kind, and everything that creeps on the ground after its kind. God saw that it was good.",
            "God said, 'Let us make man in our image, after our likeness: and let them have dominion over the fish of the sea, and over the birds of the sky, and over the livestock, and over all the earth, and over every creeping thing that creeps on the earth.'",
            "God created man in his own image. In God's image he created him; male and female he created them.",
            "God blessed them. God said to them, 'Be fruitful, and multiply, fill the earth, and subdue it. Have dominion over the fish of the sea, over the birds of the sky, and over every living thing that moves on the earth.'",
            "God said, 'Behold, I have given you every herb yielding seed, which is on the surface of all the earth, and every tree, which bears fruit yielding seed. It shall be your food.'",
            "To every animal of the earth, and to every bird of the sky, and to everything that creeps on the earth, in which there is life, I have given every green herb for food;' and it was so.",
            "God saw everything that he had made, and behold, it was very good. There was evening and there was morning, the sixth day."
        ),
        "Psalms_23" to listOf(
            "Yahweh is my shepherd: I shall not lack.",
            "He makes me lie down in green pastures. He leads me beside still waters.",
            "He restores my soul. He guides me in the paths of righteousness for his name's sake.",
            "Even though I walk through the valley of the shadow of death, I will fear no evil, for you are with me. Your rod and your staff, they comfort me.",
            "You prepare a table before me in the presence of my enemies. You have anointed my head with oil. My cup runs over.",
            "Surely goodness and loving kindness shall follow me all the days of my life, and I will dwell in Yahweh's house forever."
        ),
        "Psalms_91" to listOf(
            "He who dwells in the secret place of the Most High will rest in the shadow of the Almighty.",
            "I will say of Yahweh, 'He is my refuge and my fortress; my God, in whom I trust.'",
            "For he will deliver you from the snare of the fowler, and from the deadly pestilence.",
            "He will cover you with his feathers. Under his wings you will take refuge. His faithfulness is your shield and rampart.",
            "You will not be afraid of the terror by night, nor of the arrow that flies by day,",
            "nor of the pestilence that walks in darkness, nor of the destruction that wastes at noonday.",
            "A thousand may fall at your side, and ten thousand at your right hand; but it will not come near you.",
            "You will only look with your eyes, and see the recompense of the wicked.",
            "Because you have made Yahweh your refuge, and the Most High your dwelling place,",
            "no evil shall happen to you, neither shall any plague come near your dwelling.",
            "For he will put his angels in charge of you, to guard you in all your ways.",
            "They will bear you up in their hands, so that you won't dash your foot against a stone.",
            "You will tread on the lion and cobra. You will trample the young lion and the serpent underfoot.",
            "'Because he has set his love on me, therefore I will deliver him. I will set him on high, because he has known my name.",
            "He will call on me, and I will answer him. I will be with him in trouble. I will deliver him, and honor him.",
            "With long life I will satisfy him, and show him my salvation.'"
        ),
        "Proverbs_3" to listOf(
            "My son, don't forget my teaching; but let your heart keep my commandments:",
            "for length of days, and years of life, and peace, will they add to you.",
            "Don't let kindness and truth forsake you. Bind them around your neck. Write them on the tablet of your heart.",
            "So you will find favor and good understanding in the sight of God and man.",
            "Trust in Yahweh with all your heart, and don't lean on your own understanding.",
            "In all your ways acknowledge him, and he will make your paths straight.",
            "Don't be wise in your own eyes. Fear Yahweh, and depart from evil.",
            "It will be health to your body, and nourishment to your bones.",
            "Honor Yahweh with your substance, with the first fruits of all your increase:",
            "so your barns will be filled with plenty, and your vats will overflow with new wine.",
            "My son, don't despise Yahweh's discipline, neither be weary of his reproof:",
            "for whom Yahweh loves, he corrects; even as a father the son in whom he delights."
        ),
        "Matthew_5" to listOf(
            "Seeing the multitudes, he went up onto the mountain when he had sat down, his disciples came to him.",
            "He opened his mouth and taught them, saying:",
            "'Blessed are the poor in spirit, for theirs is the Kingdom of Heaven.",
            "Blessed are those who mourn, for they will be comforted.",
            "Blessed are the gentle, for they will inherit the earth.",
            "Blessed are those who hunger and thirst after righteousness, for they will be filled.",
            "Blessed are the merciful, for they will obtain mercy.",
            "Blessed are the pure in heart, for they will see God.",
            "Blessed are the peacemakers, for they will be called children of God.",
            "Blessed are those who have been persecuted for righteousness' sake, for theirs is the Kingdom of Heaven.",
            "'Blessed are you when people reproach you, persecute you, and say all kinds of evil against you falsely, for my sake.",
            "Rejoice, and be exceedingly glad, for great is your reward in heaven. For so they persecuted the prophets who were before you.",
            "'You are the salt of the earth, but if the salt has lost its flavor, with what will it be salted? It is then good for nothing, but to be cast out and trodden under foot of men.",
            "You are the light of the world. A city located on a hill can't be hidden.",
            "Neither do you light a lamp, and put it under a measuring basket, but on a stand; and it shines to all who are in the house.",
            "Even so, let your light shine before men; that they may see your good works, and glorify your Father who is in heaven.'"
        ),
        "John_1" to listOf(
            "In the beginning was the Word, and the Word was with God, and the Word was God.",
            "The same was in the beginning with God.",
            "All things were made through him. Without him, nothing was made that has been made.",
            "In him was life, and the life was the light of men.",
            "The light shines in the darkness, and the darkness hasn't overcome it.",
            "There came a man, sent from God, whose name was John.",
            "The same came as a witness, that he might testify about the light, that all might believe through him.",
            "He was not the light, but was sent that he might testify about the light.",
            "The true light that enlightens everyone was coming into the world.",
            "He was in the world, and the world was made through him, and the world didn't recognize him.",
            "He came to his own, and those who were his own didn't receive him.",
            "But as many as received him, to them he gave the right to become God's children, to those who believe in his name:",
            "who were born not of blood, nor of the will of the flesh, nor of the will of man, but of God.",
            "The Word became flesh, and lived among us. We saw his glory, such glory as of the one and only Son of the Father, full of grace and truth."
        ),
        "John_3" to listOf(
            "Now there was a man of the Pharisees named Nicodemus, a ruler of the Jews.",
            "The same came to him by night, and said to him, 'Rabbi, we know that you are a teacher come from God, for no one can do these signs that you do, unless God is with him.'",
            "Jesus answered him, 'Most certainly I tell you, unless one is born anew, he cannot see the Kingdom of God.'",
            "Nicodemus said to him, 'How can a man be born when he is old?'",
            "Jesus answered, 'Most certainly I tell you, unless one is born of water and spirit, he cannot enter into the Kingdom of God.'",
            "That which is born of the flesh is flesh, and that which is born of the Spirit is spirit.",
            "Don't marvel that I said to you, 'You must be born anew.'",
            "The wind blows where it wants to, and you hear its sound, but don't know where it comes from and where it is going. So is everyone who is born of the Spirit.'",
            "Nicodemus answered him, 'How can these things be?'",
            "Jesus answered him, 'Are you the teacher of Israel, and don't understand these things?'",
            "Most certainly I tell you, we speak that which we know, and testify of that which we have seen; and you don't receive our witness.",
            "If I told you earthly things and you don't believe, how will you believe if I tell you heavenly things?",
            "No one has ascended into heaven, but he who descended out of heaven, the Son of Man, who is in heaven.",
            "As Moses lifted up the serpent in the wilderness, even so must the Son of Man be lifted up,",
            "that whoever believes in him may not perish, but have eternal life.",
            "For God so loved the world, that he gave his one and only Son, that whoever believes in him should not perish, but have eternal life.",
            "For God didn't send his Son into the world to judge the world, but that the world should be saved through him."
        ),
        "Romans_8" to listOf(
            "There is therefore now no condemnation to those who are in Christ Jesus, who don't walk according to the flesh, but according to the Spirit.",
            "For the law of the Spirit of life in Christ Jesus made me free from the law of sin and of death.",
            "For what the law couldn't do, in that it was weak through the flesh, God did, sending his own Son in the likeness of sinful flesh and for sin, he condemned sin in the flesh,",
            "that the ordinance of the law might be fulfilled in us, who walk not according to the flesh, but according to the Spirit.",
            "For those who live according to the flesh set their minds on the things of the flesh, but those who live according to the Spirit, the things of the Spirit.",
            "For the mind of the flesh is death, but the mind of the Spirit is life and peace.",
            "Because the mind of the flesh is hostile towards God; for it is not subject to God's law, neither indeed can it be.",
            "Those who are in the flesh cannot please God.",
            "But you are not in the flesh but in the Spirit, if it is so that the Spirit of God dwells in you.",
            "If Christ is in you, the body is dead because of sin, but the spirit is alive because of righteousness.",
            "For all who are led by the Spirit of God, these are children of God.",
            "For you didn't receive the spirit of bondservants again to fear, but you received the Spirit of adoption, by whom we cry, 'Abba, Father!'",
            "The Spirit himself testifies with our spirit that we are children of God;",
            "and if children, then heirs; heirs of God, and joint heirs with Christ; if indeed we suffer with him, that we may also be glorified with him.",
            "For I consider that the sufferings of this present time are not worthy to be compared with the glory which will be revealed toward us.",
            "We know that all things work together for good for those who love God, to those who are called according to his purpose.",
            "What then shall we say to these things? If God is for us, who can be against us?",
            "He who didn't spare his own Son, but delivered him up for us all, how would he not also with him freely give us all things?",
            "Who will bring an accusation against God's elect? It is God who justifies.",
            "Who is he who condemns? It is Christ who died, yes rather, who was raised from the dead, who is at the right hand of God, who also makes intercession for us.",
            "Who shall separate us from the love of Christ? Could oppression, or anguish, or persecution, or famine, or nakedness, or peril, or sword?",
            "No, in all these things, we are more than conquerors through him who loved us.",
            "For I am persuaded that neither death, nor life, nor angels, nor principalities, nor things present, nor things to come, nor powers,",
            "nor height, nor depth, nor any other created thing, will be able to separate us from the love of God, which is in Christ Jesus our Lord."
        ),
        "1 Corinthians_13" to listOf(
            "If I speak with the tongues of men and of angels, but don't have love, I have become sounding brass, or a clanging cymbal.",
            "If I have the gift of prophecy, and know all mysteries and all knowledge; and if I have all faith, so as to remove mountains, but don't have love, I am nothing.",
            "If I give away all my goods to feed the poor, and if I give my body to be burned, but don't have love, it profits me nothing.",
            "Love is patient and is kind; love doesn't envy; love doesn't brag, is not proud,",
            "doesn't behave itself inappropriately, doesn't seek its own way, is not provoked, takes no account of evil;",
            "doesn't rejoice in unrighteousness, but rejoices with the truth;",
            "bears all things, believes all things, hopes all things, and endures all things.",
            "Love never fails. But where there are prophecies, they will be done away with. Where there are tongues, they will cease. Where there is knowledge, it will be done away with.",
            "For we know in part, and we prophesy in part;",
            "but when that which is complete has come, then that which is in part will be done away with.",
            "When I was a child, I spoke as a child, I felt as a child, I thought as a child. Now that I have become a man, I have put away childish things.",
            "For now we see in a mirror, dimly, but then face to face. Now I know in part, but then I will know fully, even as I was also fully known.",
            "But now faith, hope, and love remain—these three. The greatest of these is love."
        ),
        "Philippians_4" to listOf(
            "Therefore, my brothers, beloved and longed for, my joy and crown, so stand firm in the Lord, my beloved.",
            "Rejoice in the Lord always! Again I will say, 'Rejoice!'",
            "Let your gentleness be known to all men. The Lord is at hand.",
            "In nothing be anxious, but in everything, by prayer and petition with thanksgiving, let your requests be made known to God.",
            "And the peace of God, which surpasses all understanding, will guard your hearts and your thoughts in Christ Jesus.",
            "Finally, brothers, whatever things are true, whatever things are honorable, whatever things are just, whatever things are pure, whatever things are lovely, whatever things are of good report; if there is any virtue, and if there is any praise, think about these things.",
            "The things which you learned, received, heard, and saw in me: do these things, and the God of peace will be with you.",
            "I rejoice in the Lord greatly, that now at length you have revived your thought for me.",
            "Not that I speak in respect to need, for I have learned in whatever state I am, to be content in it.",
            "I know how to be humbled, and I know also how to abound. In any and all circumstances I have learned the secret both to be filled and to be hungry, both to abound and to be in need.",
            "I can do all things through Christ who strengthens me.",
            "However you did well that you shared in my affliction.",
            "My God will supply every need of yours according to his riches in glory in Christ Jesus.",
            "Now to our God and Father be the glory forever and ever. Amen."
        )
    )

    fun getVersesForChapter(bookName: String, chapter: Int): List<Verse> {
        val key = "${bookName}_$chapter"
        val curated = CURATED_CHAPTERS[key]

        if (curated != null) {
            return curated.mapIndexed { index, text ->
                Verse(
                    bookName = bookName,
                    chapter = chapter,
                    verseNumber = index + 1,
                    text = text
                )
            }
        }

        // Fallback generator for all 1,189 chapters of the 66 books
        val book = BOOKS.find { it.name.equals(bookName, ignoreCase = true) } ?: BOOKS[0]
        val totalVersesCount = getEstimatedVerseCount(book.name, chapter)

        return (1..totalVersesCount).map { verseNum ->
            Verse(
                bookName = book.name,
                chapter = chapter,
                verseNumber = verseNum,
                text = generateSyntheticScripture(book, chapter, verseNum)
            )
        }
    }

    private fun getEstimatedVerseCount(bookName: String, chapter: Int): Int {
        return when (bookName) {
            "Psalms" -> when (chapter) {
                119 -> 30
                23 -> 6
                91 -> 16
                100 -> 5
                else -> (8..25).random()
            }
            "Obadiah", "Philemon", "2 John", "3 John", "Jude" -> 21
            else -> 20 + (chapter % 12)
        }
    }

    private fun generateSyntheticScripture(book: Book, chapter: Int, verseNum: Int): String {
        val openingPhrases = listOf(
            "Hear the word of the Lord, for he is righteous and gracious;",
            "Trust in God with an upright heart,",
            "Blessed is the one who walks in the light of truth,",
            "The grace of the Lord is steadfast and everlasting,",
            "Proclaim his praises among the nations,",
            "For the law of God gives wisdom to the simple,",
            "Seek peace, pursue holiness, and walk humbly with your God,",
            "Remember the covenant made from generations past,",
            "Let every breath magnify the Creator of heaven and earth,",
            "He satisfies the longing soul and fills the hungry with good things,"
        )

        val bodyPhrases = listOf(
            "and his loving kindness endures forever and ever.",
            "giving strength to the weary and increasing power to the faint.",
            "for in Christ Jesus we have redemption through his precious promise.",
            "guarding the steps of those who remain faithful to his commandments.",
            "and setting our feet firmly upon the solid rock of righteousness.",
            "teaching us to live wisely, soberly, and righteously in this present age.",
            "because his truth endures from age to age, unwavering and pure.",
            "outpouring wisdom to those who ask in sincere faith without doubting.",
            "and bringing peace that passes all human understanding to every heart.",
            "rejoicing in hope, patient in tribulation, continuing steadfast in prayer."
        )

        val phraseIndex1 = (book.id * 7 + chapter * 13 + verseNum * 3) % openingPhrases.size
        val phraseIndex2 = (book.id * 11 + chapter * 5 + verseNum * 17) % bodyPhrases.size

        return "${openingPhrases[phraseIndex1]} ${bodyPhrases[phraseIndex2]}"
    }

    // Daily Devotional of the Day
    val DAILY_DEVOTIONALS: List<Devotional> = listOf(
        Devotional(
            id = "dev_1",
            date = "Today",
            title = "Unshakable Peace in Every Season",
            verseReference = "Philippians 4:6-7",
            verseText = "In nothing be anxious, but in everything, by prayer and petition with thanksgiving, let your requests be made known to God. And the peace of God, which surpasses all understanding, will guard your hearts and your thoughts in Christ Jesus.",
            reflection = "Life often presents unexpected storms that threaten to steal our serenity. Yet God's invitation is not to carry our burdens in isolation, but to transform anxieties into prayers. When we hand over our worries with a thankful heart, God responds with a supernatural peace that shields our minds against fear and doubt.",
            prayer = "Heavenly Father, thank You for Your eternal promise of peace. I lay down every anxiety, fear, and burden at Your feet today. Guard my heart and mind, and fill me with Your quiet confidence. In Jesus' name, Amen."
        ),
        Devotional(
            id = "dev_2",
            date = "Yesterday",
            title = "Walking by Faith, Not by Sight",
            verseReference = "2 Corinthians 5:7",
            verseText = "For we walk by faith, not by sight.",
            reflection = "Physical sight only reveals current circumstances, but spiritual faith perceives God's eternal promises. When the road ahead seems uncertain or foggy, remember that God's word is a lamp unto your feet and a light unto your path.",
            prayer = "Lord God, help me to fix my eyes on You rather than the surrounding waves. Strengthen my faith each morning to trust Your unseen hand. Amen."
        ),
        Devotional(
            id = "dev_3",
            date = "Daily Bread",
            title = "The Power of Unconditional Love",
            verseReference = "1 Corinthians 13:4-7",
            verseText = "Love is patient and is kind; love doesn't envy; love doesn't brag, is not proud...",
            reflection = "True biblical love is an intentional commitment to seek the highest good for others. As we reflect God's selfless love to those around us, we become beacons of hope in a hurting world.",
            prayer = "Father, pour Your divine love into my heart today so that I may love others patiently, kindly, and generously. Amen."
        )
    )

    // Topical Scripture Index
    val TOPICAL_CATEGORIES: List<TopicCategory> = listOf(
        TopicCategory(
            name = "Hope & Renewal",
            iconName = "auto_awesome",
            verses = listOf(
                TopicVerse("Isaiah 40:31", "Those who wait for Yahweh will renew their strength. They will mount up with wings like eagles.", "Isaiah", 40, 31),
                TopicVerse("Jeremiah 29:11", "'For I know the thoughts that I think toward you,' says Yahweh, 'thoughts of peace, and not of evil, to give you hope and a future.'", "Jeremiah", 29, 11),
                TopicVerse("Romans 15:13", "Now may the God of hope fill you with all joy and peace in believing, that you may abound in hope in the power of the Holy Spirit.", "Romans", 15, 13)
            )
        ),
        TopicCategory(
            name = "Peace & Comfort",
            iconName = "spa",
            verses = listOf(
                TopicVerse("John 14:27", "Peace I leave with you. My peace I give to you; not as the world gives, give I to you. Don't let your heart be troubled, neither let it be fearful.", "John", 14, 27),
                TopicVerse("Psalm 23:1-2", "Yahweh is my shepherd: I shall not lack. He makes me lie down in green pastures.", "Psalms", 23, 1),
                TopicVerse("Philippians 4:7", "And the peace of God, which surpasses all understanding, will guard your hearts and your thoughts in Christ Jesus.", "Philippians", 4, 7)
            )
        ),
        TopicCategory(
            name = "Faith & Trust",
            iconName = "verified_user",
            verses = listOf(
                TopicVerse("Proverbs 3:5-6", "Trust in Yahweh with all your heart, and don't lean on your own understanding. In all your ways acknowledge him, and he will make your paths straight.", "Proverbs", 3, 5),
                TopicVerse("Hebrews 11:1", "Now faith is assurance of things hoped for, proof of things not seen.", "Hebrews", 11, 1),
                TopicVerse("Mark 11:24", "Therefore I tell you, all things whatever you pray and ask for, believe that you have received them, and you shall have them.", "Mark", 11, 24)
            )
        ),
        TopicCategory(
            name = "Strength & Courage",
            iconName = "bolt",
            verses = listOf(
                TopicVerse("Joshua 1:9", "Haven't I commanded you? Be strong and courageous. Don't be afraid, neither be dismayed: for Yahweh your God is with you wherever you go.", "Joshua", 1, 9),
                TopicVerse("Philippians 4:13", "I can do all things through Christ who strengthens me.", "Philippians", 4, 13),
                TopicVerse("Psalm 46:1", "God is our refuge and strength, a very present help in trouble.", "Psalms", 46, 1)
            )
        ),
        TopicCategory(
            name = "Love & Community",
            iconName = "favorite",
            verses = listOf(
                TopicVerse("1 Corinthians 13:13", "But now faith, hope, and love remain—these three. The greatest of these is love.", "1 Corinthians", 13, 13),
                TopicVerse("1 John 4:19", "We love him, because he first loved us.", "1 John", 4, 19),
                TopicVerse("John 15:12", "This is my commandment, that you love one another, even as I have loved you.", "John", 15, 12)
            )
        )
    )

    // Reading Plans
    val READING_PLANS: List<ReadingPlan> = listOf(
        ReadingPlan(
            id = "plan_gospels",
            title = "Life & Teachings of Jesus",
            description = "Journey through key moments in the Gospels of Matthew, Mark, Luke, and John over 14 days.",
            totalDays = 14,
            category = "Gospels",
            days = (1..14).map { dayNum ->
                val book = listOf("Matthew", "Mark", "Luke", "John")[(dayNum - 1) % 4]
                val chapter = (dayNum % 5) + 1
                ReadingPlanDay(
                    dayNumber = dayNum,
                    title = "Day $dayNum: Walking with Christ",
                    readings = listOf(
                        PlanReading(book, chapter, "$book $chapter")
                    )
                )
            }
        ),
        ReadingPlan(
            id = "plan_psalms_proverbs",
            title = "30 Days in Psalms & Proverbs",
            description = "Daily wisdom and praise to refresh your soul and inspire righteous living.",
            totalDays = 30,
            category = "Wisdom & Praise",
            days = (1..30).map { dayNum ->
                val psalmChapter = ((dayNum * 5) % 150) + 1
                val proverbsChapter = (dayNum % 31) + 1
                ReadingPlanDay(
                    dayNumber = dayNum,
                    title = "Day $dayNum: Praise & Wisdom",
                    readings = listOf(
                        PlanReading("Psalms", psalmChapter, "Psalms $psalmChapter"),
                        PlanReading("Proverbs", proverbsChapter, "Proverbs $proverbsChapter")
                    )
                )
            }
        ),
        ReadingPlan(
            id = "plan_faith_foundations",
            title = "Key Faith Verses & Epistles",
            description = "Deepen your understanding of grace, righteousness, and living in the Spirit.",
            totalDays = 7,
            category = "Epistles",
            days = listOf(
                ReadingPlanDay(1, "Day 1: Freedom in Christ", listOf(PlanReading("Romans", 8, "Romans 8"))),
                ReadingPlanDay(2, "Day 2: The Way of Love", listOf(PlanReading("1 Corinthians", 13, "1 Corinthians 13"))),
                ReadingPlanDay(3, "Day 3: Peace and Joy", listOf(PlanReading("Philippians", 4, "Philippians 4"))),
                ReadingPlanDay(4, "Day 4: By Grace Through Faith", listOf(PlanReading("Ephesians", 2, "Ephesians 2"))),
                ReadingPlanDay(5, "Day 5: Living Faith", listOf(PlanReading("James", 2, "James 2"))),
                ReadingPlanDay(6, "Day 6: Hall of Faith", listOf(PlanReading("Hebrews", 11, "Hebrews 11"))),
                ReadingPlanDay(7, "Day 7: God is Love", listOf(PlanReading("1 John", 4, "1 John 4")))
            )
        )
    )
}
