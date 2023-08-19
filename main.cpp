#include <iostream>
#include <map>
using namespace std;

char calculateWinner(char p1, char p2);

struct Choice
{
    const char ROCK = 'r';
    const char PAPER = 'p';
    const char SCISSOR = 's';
};

int main()
{
    char p1, p2;
    cout << "Player 1: ";
    cin >> p1;
    cout << "Player 2: ";
    cin >> p2;
    char winner = calculateWinner(tolower(p1), tolower(p2));
    cout << winner;
    return 0;
}

char calculateWinner(char p1, char p2)
{
    Choice choice;

    if (p1 == choice.ROCK && p2 == choice.SCISSOR)
    {
        return p1;
    }
    else if (p1 == choice.SCISSOR && p2 == choice.ROCK)
    {
        return p2;
    }
    else if (p1 == choice.PAPER && p2 == choice.ROCK)
    {
        return p1;
    }
    else if (p2 == choice.PAPER && p1 == choice.ROCK)
    {
        return p2;
    }
    else if (p1 == choice.SCISSOR && p2 == choice.PAPER)
    {
        return p1;
    }
    else if (p1 == choice.PAPER && p2 == choice.SCISSOR)
    {
        return p2;
    }
    return 'n';
}