#include <iostream>
#include <map>
using namespace std;

char calculateWinner(char p1, char p2);

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
    cout << "Player 1: ";
    cin >> p1;
    cout << "Player 2: ";
    cin >> p2;
    char winner = calculateWinner(tolower(p1), tolower(p2));
    cout << Winner[winner];
    return 0;
}

char calculateWinner(char p1, char p2)
{
    string choice = "";
    choice += p1;
    choice += p2;
    return calculatorMap[choice];
}