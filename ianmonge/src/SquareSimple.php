<?php

require_once PATH_BASE . '/SquareAbstract.php';

/**
 * Class of a simple square that isn't a bomb.
 */
class SquareSimple extends SquareAbstract
{
    /**
     * Number of bombs near the square.
     *
     * @var integer
     */
    protected $numBombs = 0;

    /**
     * Returns the number of bombs near the square.
     * 
     * @return integer
     */
    public function getNumOfBombs()
    {
        return $this->numBombs;
    }

    /**
     * Increment the number of bombs near the square.
     */
    public function incrementNumOfBombs()
    {
        $this->numBombs++;
    }
    
    /**
     * Returns the representation of the square.
     */
    public function __toString()
    {
        return (string) $this->numBombs;
    }
}