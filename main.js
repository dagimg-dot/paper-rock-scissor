calculatorMap = new Map();
Winner = new Map();

function populate() {
  // Populate the calculator map
  calculatorMap.set("rs", "r");
  calculatorMap.set("pr", "p");
  calculatorMap.set("sp", "s");
  calculatorMap.set("sr", "r");
  calculatorMap.set("rp", "p");
  calculatorMap.set("ps", "s");

  // Populate the winner map

  Winner.set("r", "Rock breaks scissor");
  Winner.set("p", "Paper covers rock");
  Winner.set("s", "Scissor cuts paper");
}

function calculateWinner(p1, p2) {
  return calculatorMap.get(p1 + p2);
}

function main() {
  populate();
  const p1 = "r"; // acceptInput(1)
  const p2 = "s"; // acceptInput(2)
  const winner = calculateWinner(p1.toLowerCase(), p2.toLowerCase());
  console.log(Winner.get(winner));
}

// Call the main method
main();
