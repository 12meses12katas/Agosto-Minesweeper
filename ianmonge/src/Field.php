<?php

class Field
{
    /**
     * Board of the field.
     * 
     * @var array
     */
    protected $board = array();
    
    /**
     * Number of columns.
     * 
     * @var integer
     */
    protected $colsNum = 0;

    /**
     * Number of rows.
     * 
     * @var integer
     */
    protected $rowsNum = 0;
    
    /**
     * Contructs a field with the indicated size.
     *
     * @param integer $rowsNum
     * @param integer $colsNum 
     */
    public function __construct( $rowsNum, $colsNum )
    {
        $this->rowsNum = $rowsNum;
        $this->colsNum = $colsNum;
        
        for( $row = 0; $row < $this->rowsNum; $row++ )
        {
            for( $col = 0; $col < $this->colsNum; $col++ )
            {
                $this->board[ $row ][ $col ] = new SquareSimple;
            }
        }
    }
    
    /**
     * Sets a square bomb in an indicated position.
     *
     * @param integer $row
     * @param integer $col
     */
    public function setSquareBomb( $row, $col )
    {
        $this->board[ $row ][ $col ] = new SquareBomb();
        
        $this->updateSquaresNear( $row, $col );
    }
    
    protected function updateSquaresNear( $row, $col )
    {
        for( $r = $row-1; $r < $row+2; $r++ )
        {
            for( $c = $col-1; $c < $col+2; $c++ )
            {
                $this->updateSquare( $r, $c );
            }
        }
    }
    
    protected function updateSquare( $row, $col )
    {
        // If the square exists.
        if ( 
                array_key_exists( $row, $this->board )
            &&  array_key_exists( $col, $this->board[ $row ] )
        )
        {
            $square = $this->board[ $row ][ $col ];
            
            // If the square is not a bomb.
            if ( $square instanceof SquareSimple )
            {
                $square->incrementNumOfBombs();
            }
        }
    }
    
    /**
     * Prints the solution of the field.
     */
    public function printSolution()
    {}
}