calculatorDict = {
    "rs": 'r',
    "pr": 'p',
    "sp": 's',
    "sr": 'r',
    "rp": 'p',
    "ps": 's',
}


def main():
    p1 = acceptInput(1)
    p2 = acceptInput(2)
    winner = calculateWinner(p1, p2)
    print(f"The winner is {winner}")


def acceptInput(player_num):
    player = input(f"Player {player_num}: ")
    while validateChar(player) == False:
        print("Invalid input, please enter your choice again")
        player = input(f"Player {player_num}: ")

    return player


def validateChar(c):
    if c in ['r', 'R', 'p', 'P', 's', 'S']:
        return True
    return False


def calculateWinner(p1, p2):
    choice = p1 + p2
    return calculatorDict[choice]


# Call the main method
main()
