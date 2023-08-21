calculatorMap = new Map();
Winner = new Map();

function populate() {
  // Populate the calculator map
  calculatorMap.set("rs", "r");
  calculatorMap.set("rp", "p");
  calculatorMap.set("sp", "s");

  // Populate the winner map
  Winner.set("r", "Rock breaks scissor");
  Winner.set("p", "Paper covers rock");
  Winner.set("s", "Scissor cuts paper");
}

function welcome() {
    console.log("\t\t Rock Paper Scissor Game");
    console.log("\t\t Developed in JavaScript by dagimg-dot");
}

function calculateWinner(p1, p2) {
  return calculatorMap.get(p1 + p2) ||  calculatorMap.get(p2 + p1);
}

function main() {
  populate();
  welcome();
  const p1 = "s"; // acceptInput(1)
  const p2 = "p"; // acceptInput(2)
  const winner = calculateWinner(p1.toLowerCase(), p2.toLowerCase());
  console.log(Winner.get(winner));
}

// Call the main method
main();
