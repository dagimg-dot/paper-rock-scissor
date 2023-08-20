calculatorDict = {
    "rs": 'r',
    "pr": 'p',
    "sp": 's',
    "sr": 'r',
    "rp": 'p',
    "ps": 's',
}


def main():
    p1 = input("Player 1: ")
    p2 = input("Player 2: ")
    winner = calculateWinner(p1, p2)
    print(f"The winner is {winner}")


def calculateWinner(p1, p2):
    choice = p1 + p2
    return calculatorDict[choice]


# Call the main method
main()
