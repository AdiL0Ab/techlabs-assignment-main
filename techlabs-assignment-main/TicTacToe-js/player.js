class Player{
    constructor(name, symbol){
        this.name = name;
        this.symbol = symbol;
    }

    static addPlayer(name, symbol){
        return new Player(name, symbol);
    }
}

module.exports = Player