const Game = require("./game");
let symbol1 = "❌";
let symbol2 = "⭕";
try {
    //game play 1
    let g1 = Game.addGame("Bishal", symbol1, "Rahul", symbol2);
    console.log(g1.play(0));
    console.log(g1.play(0));
    console.log(g1.play(4));
    console.log(g1.play(8));
    console.log(g1.play(2));
    console.log(g1.play(6));
    console.log(g1.play(7));
    console.log(g1.play(3)); //game over
    console.log(g1.play(1));

    //game play 2
    let g2 = Game.addGame("Abhishek", symbol2, "Vishnu", symbol1);
    console.log(g2.play(0));
    console.log(g2.play(0));
    console.log(g2.play(4));
    console.log(g2.play(8));
    console.log(g2.play(2));
    console.log(g2.play(6));
    console.log(g2.play(7));
    console.log(g2.play(3)); //game over
    console.log(g2.play(1));

} catch (error) {
    console.log(error.message);
}
