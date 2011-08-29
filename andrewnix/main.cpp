/*
 * Autor: Andres F. Cardenas "Andrewnix"
 * Mail: akardenasjimenez@gmail.com
 * Date: 26 august 2011
 *
 * This is the game minesweeper on text mode, is very fun!!!,
 * Write on C++.
*/

#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>
#include "mineSweeper.hpp"

using namespace std;

int main()
{
    unsigned int width;
    unsigned int height;
    unsigned int total;
    unsigned int counterMines = 0;

    srand( time( 0 ) );

    cout << "Set the dimensions (width x height): ";
    cin >> width >> height;

    total = width * height;

    Square square[width][height];

    // on this loop, assign of objects Square to array
    for(unsigned int i = 0; i < height; i++)
    {
        for(unsigned int j = 0; j < width; j++)
        {
            square[j][i] = Square();
        }
    }

    // on this loop, assign the mines to the squares
    for(unsigned int i = 0; i < height; i++)
    {
        for(unsigned int j = 0; j < width; j++)
        {
            // assign value random to variable "value"
            unsigned int value = 0 + rand() % 2;
            square[j][i].setMineContainer(value);

            if(square[j][i].getMineContainer() == 1)
            {
                square[j][i].setNumMineAdjacent(9);
            }
        }
    }

    // this loop, assign the number of mines adjacents in the objects Square of the array
    for(unsigned int i = 0; i < height; i++)
    {
        for(unsigned int j = 0; j < width; j++)
        {
            // topside
            if ( j != 0 && j < (width-1) && i == 0 )
            {
                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration topside

            counterMines = 0;

            // bottom
            if ( j != 0 && j < (width-1) && i == (height-1) )
            {
                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration bottom

            counterMines = 0;

            // right
            if ( i != 0 && i < (height-1) && j == (width-1) )
            {
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration right

            // left
            if ( i != 0 && i < (height-1) && j == 0 )
            {
                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration left

            counterMines = 0;

            // center
            if ( j != 0 && j < (width-1) && i != 0 && i < (height-1) )
            {
                if (square[j-1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration center

            counterMines = 0;

            // top left corner
            if (j == 0 && i == 0)
            {
                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j+1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration top left corner

            counterMines = 0;

            // lower right corner
            if (j == (width - 1) && i == (height - 1))
            {
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration lower right corner

            counterMines = 0;

            // top right corner
            if (j == (width - 1) && i == 0)
            {
                if (square[j-1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                if (square[j-1][i+1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }
                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration top right corner

            counterMines = 0;

            // lower left corner
            if (j == 0 && i == (height -1))
            {
                if (square[j][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }

                if (square[j+1][i].getMineContainer() == 1)
                {
                    counterMines += 1;
                }

                if (square[j+1][i-1].getMineContainer() == 1)
                {
                    counterMines += 1;
                }

                square[j][i].setNumMineAdjacent(counterMines);
            } // end configuration lower left corner

            counterMines = 0;
        }
    }

    // on this loop, paint the minesweeper
    for(unsigned int i = 0; i < height; i++)
    {
        for(unsigned int j = 0; j < width; j++)
        {
            cout << " . ";
        }
        cout << endl;
    }

    unsigned int attempts = 0;
    int num;
    int place = 0;

    // the loop "while" asks the user input, so you can Let's play minesweeper
    while(attempts < total)
    {
        cout << "\nField # ";
        cin >> num;
        num = num - 1;

        // this loop "for", found and assign true to the object "Square"
        for(unsigned int i = 0; i < height; i++)
        {
            for(unsigned int j = 0; j < width; j++)
            {
                if(place == num)
                {
                    square[j][i].setSelectorMine(true);
                }
                place++;
            }
        }

        // this loop "for" paint the minesweeper in the output
        for(unsigned int i = 0; i < height; i++)
        {
            for(unsigned int j = 0; j < width; j++)
            {
                if(square[j][i].getSelectorMine() == false)
                {
                    cout << " . ";
                }

                else if (square[j][i].getSelectorMine() == true &&
                         square[j][i].getMineContainer() == 1)
                {
                    cout << " * ";
                }

                else if (square[j][i].getSelectorMine() == true &&
                         square[j][i].getMineContainer() != 1)
                {
                    cout << " " << square[j][i].getNumMineAdjacent() << " ";
                }
            }
            cout << endl;
        }

        place = 0;
        attempts++;
    }

    return 0;
}
