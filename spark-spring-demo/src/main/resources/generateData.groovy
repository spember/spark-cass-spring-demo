//List<String> symbols = ["FOOO", "PVTL", "HELO", "WRLD", "SPQR", "RNDM", "THRC"]
Map<String, Map> symbols = [
        "FOOO": [currentVolume: 10000],
        "PVTL": [currentVolume: 100000],
        "HELO": [currentVolume: 15000],
        "WRLD": [currentVolume: 10000],
        "SPQR": [currentVolume: 400000],
        "RNDM": [currentVolume: 150000],
        "THRC": [currentVolume: 100000]
]

Random random = new Random()


Integer performDailyRoll() {
    Random random = new Random()
    int roll = random.nextInt(100)
    if (roll <= 60) {
        rollPrice(-5, 7)
    }
    else if (roll <= 90) {
        rollPrice(8, 18)
    } else if (roll <= 97) {
        rollPrice(19, 35)
    } else {
        rollPrice(35,55)
    }
}

Integer rollPrice(int low, int high) {
    Random random = new Random()
    random.nextInt(high-low) + low;
}

symbols.keySet().each {
    symbols[it].currentPrice = random.nextInt(200) + 10
}

def outputFile = new File("./ticker.csv")
outputFile.write("")

// for 120 days, for each sym
for (int i = 120; i >=0; i--) {
    Date today = new Date()-i
    symbols.keySet().each { String sym ->
        int dailyDirection = random.nextInt(100) > 39 ? 1 : -1

        int volume = symbols[sym].currentVolume  + (symbols[sym].currentVolume * ((-25 + random.nextInt(50))/100))
        symbols[sym].currentVolume = volume
        //int volume = random.nextInt(symbols[sym].currentVolume*3)+ symbols[sym].currentVolume/2 //somewhere within half the currentVolume to 300%
        String time = today.format("yyyy-MM-dd")
        Integer change = dailyDirection * performDailyRoll()
        Double lastPrice = symbols[sym].currentPrice
        Double amtChange = Math.round((lastPrice * (change/100.0))*100)/100
        Double newPrice = Math.round((lastPrice + amtChange)*100)/100
        //println "LastPrice ${lastPrice} with change ${change}. new Price ${newPrice}"
        symbols[sym].currentPrice = newPrice
        //println "${sym} at '${time} is at ${currentPrice[sym]} change of ${change} percent"
        outputFile << "${sym}|${time}|${newPrice}|${lastPrice}|${amtChange}|${change/100.0}|${volume}\n"
    }
}


println "Done!"
