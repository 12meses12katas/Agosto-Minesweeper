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
    {}
    
    /**
     * Sets a square in an indicated position.
     *
     * @param integer $row
     * @param integer $col
     * @param SquareAbstract $square 
     */
    public function setSquare( $row, $col, SquareAbstract $square )
    {}
    
    /**
     * Prints the solution of the field.
     */
    public function printSolution()
    {}
}