#include <iostream>
#include <map>
using namespace std;

char calculateWinner(char p1, char p2);
bool validateChar(char c);
char acceptInput(int player_num);

map<char, string> Winner = {
    {'r', "Rock breaks scissor"},
    {'p', "Paper covers rock"},
    {'s', "Scissor cut paper"},
};

map<string, char> calculatorMap = {
    {"rs", 'r'},
    {"pr", 'p'},
    {"sp", 's'},
    {"sr", 'r'},
    {"rp", 'p'},
    {"ps", 's'},
};

int main()
{
    char p1, p2;
    p1 = acceptInput(1);
    p2 = acceptInput(2);
    char winner = calculateWinner(tolower(p1), tolower(p2));
    cout << Winner[winner];
    return 0;
}

char acceptInput(int player_num)
{
    char player;
    cout << "Player " << player_num << ": ";
    cin >> player;
    while (validateChar(player) == false)
    {
        cout << "Invalid input, please enter your choice again\n";
        cout << "Player " << player_num << ": ";
        cin >> player;
    }

    return player;
}

bool validateChar(char c)
{
    char possible_choice[6] = {'r', 'R', 'p', 'P', 's', 'S'};
    bool isValid = false;
    for (auto ch : possible_choice)
    {
        if (c == ch)
        {
            isValid = true;
        }
    }

    return isValid;
}

char calculateWinner(char p1, char p2)
{
    string choice = "";
    choice += p1;
    choice += p2;
    return calculatorMap[choice];
}