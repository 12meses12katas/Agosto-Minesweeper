/*
 * Autor: Andres F. Cardenas "Andrewnix"
 * Mail: akardenasjimenez@gmail.com
 * Date: 26 august 2011
 *
 * This is the game minesweeper on text mode, is very fun!!!,
 * Write on C++.
*/

#include <iostream>

using namespace std;

class Square
{
    public:
        Square();
        ~Square();

        void setMineContainer(unsigned int mine);
        unsigned int getMineContainer() const {return mineContainer;}

        void setNumMineAdjacent(unsigned int numMines);
        unsigned int getNumMineAdjacent() const {return numMineAdjacent;}

        void setSelectorMine(bool select);
        bool getSelectorMine() const {return selectorMine;}

    private:
        unsigned int mineContainer; // this variable holds only two values, 1 or 0, if the value is 0 no mine if value is 1 yes mine
        unsigned int numMineAdjacent; // this variable store the number of mines adjacent
        bool selectorMine; // this variable indicate if the square is selected or no
};

Square::Square()
{
    mineContainer = 0;
    numMineAdjacent = 0;
    selectorMine = false;
}

Square::~Square()
{

}

void Square::setMineContainer(unsigned int mine)
{
    mineContainer = mine;
}

void Square::setNumMineAdjacent(unsigned int numMines)
{
    numMineAdjacent = numMines;
}

void Square::setSelectorMine(bool select)
{
    selectorMine = select;
}
