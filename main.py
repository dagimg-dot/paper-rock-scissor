calculatorDict = {
    "rs": ['r', "Rock breaks scissor"],
    "rp": ['p', "Paper covers rock"],
    "ps": ['s', "Scissor cuts paper"],
}

isPlayingAgain = False


def main():
    try:
        if(isPlayingAgain == False):
            welcome()
        p1 = acceptInput(1)
        p2 = acceptInput(2)
        winner = calculateWinner(p1.lower(), p2.lower())
        if winner == None:
            print("There is no winner in this round")
            playAgain()
        conc = p1 + p2 if winner[1] == False else p2 + p1
        print(
            f"The winner is {calculatorDict[conc][1].split(' ')[0]}, because {calculatorDict[conc][1]}")
        playAgain()
    except KeyboardInterrupt:
        print("\nInterrupted by Player !!")


def welcome():
    print("\t\t Rock Paper Scissor Game")
    print("\t\t Developed in Python by dagimg-dot")


def playAgain():
    play = input("Do you want to play again ? (Y/N) : ")
    if play == 'y' or play == 'Y':
        global isPlayingAgain
        isPlayingAgain = True
        main()
    else:
        exit(0)


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
    try:
        return [calculatorDict[p1 + p2][0], False]
    except KeyError:
        try:
            return [calculatorDict[p2 + p1][0], True]
        except KeyError:
            return None


# Call the main method
main()
