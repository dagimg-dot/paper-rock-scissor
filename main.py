Winner = {
    'r': "Rock breaks scissor",
    'p': "Paper covers rock",
    's': "Scissor cuts paper",
}

calculatorDict = {
    "rs": 'r',
    "rp": 'p',
    "ps": 's',
}

isPlayingAgain = False


def main():
    if(isPlayingAgain == False):
        welcome()
    p1 = acceptInput(1)
    p2 = acceptInput(2)
    winner = calculateWinner(p1.lower(), p2.lower())
    if winner == None:
        print("There is no winner in this round")
    else:
        print(
            f"The winner is {Winner[winner].split(' ')[0]}, because {Winner[winner]}")
    playAgain()


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
        return calculatorDict[p1 + p2]
    except KeyError:
        try:
            return calculatorDict[p2 + p1]
        except:
            return None


# Call the main method
main()
